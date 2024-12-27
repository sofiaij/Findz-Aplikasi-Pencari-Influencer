package com.example.my_eco.data.repository

import com.example.my_eco.data.model.Message
import com.example.my_eco.data.model.RecentMessage
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class MessageRepository @Inject constructor(
    private val firestore: FirebaseFirestore
){
    fun getMessages(chatId: String, onMessagesChanged: (List<Message>) -> Unit) {
        firestore.collection("chats")
            .document(chatId)
            .collection("messages")
            .orderBy("timestamp")
            .addSnapshotListener { snapshot, exception ->
                if (exception != null) {
                    return@addSnapshotListener
                }
                val messages = snapshot?.toObjects(Message::class.java) ?: emptyList()
                onMessagesChanged(messages)
            }
    }

    suspend fun sendMessage(chatId: String, message: Message) {
        firestore.collection("chats")
            .document(chatId)
            .collection("messages")
            .add(message)
            .await()
    }

    suspend fun getRecentMessages(): Map<String, RecentMessage> {
        val result = mutableMapOf<String, RecentMessage>()
        val chats = firestore.collection("chats").get().await()

        for (chat in chats) {
            val chatId = chat.id
            val lastMessage = firestore.collection("chats")
                .document(chatId)
                .collection("messages")
                .orderBy("timestamp", Query.Direction.DESCENDING)
                .limit(1)
                .get()
                .await()
                .documents
                .firstOrNull()

            lastMessage?.let {
                val text = it.getString("text") ?: ""
                val timestamp = it.getLong("timestamp") ?: 0L
                val unreadCount = chat.getLong("unreadCount")?.toInt() ?: 0 // Adjust based on your schema

                result[chatId] = RecentMessage(
                    text = text,
                    timestamp = timestamp,
                    unreadCount = unreadCount
                )
            }
        }
        return result
    }



}