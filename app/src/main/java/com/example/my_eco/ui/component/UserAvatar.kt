package com.example.my_eco.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation

@Composable
fun UserAvatar(avatarUrl: String) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(data = avatarUrl).apply(block = fun ImageRequest.Builder.() {
            crossfade(true)
            transformations(CircleCropTransformation())
        }).build()
    )
    Image(
        painter = painter,
        contentDescription = "User avatar",
        modifier = Modifier.size(48.dp)
    )
}

