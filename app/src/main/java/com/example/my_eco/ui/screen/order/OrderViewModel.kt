package com.example.my_eco.ui.screen.order
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor() : ViewModel(){

    private val _influencerName = MutableStateFlow("")
    val influencerName: StateFlow<String> = _influencerName

    private val _customerName = MutableStateFlow("")
    val customerName: StateFlow<String> = _customerName

    private val _phoneNumber = MutableStateFlow("")
    val phoneNumber: StateFlow<String> = _phoneNumber

    private val _productOrService = MutableStateFlow("")
    val productOrService: StateFlow<String> = _productOrService

    private val _location = MutableStateFlow("")
    val location: StateFlow<String> = _location

    private val _instagramAccount = MutableStateFlow("")
    val instagramAccount: StateFlow<String> = _instagramAccount

    private val _tiktokAccount = MutableStateFlow("")
    val tiktokAccount: StateFlow<String> = _tiktokAccount


    // Field data dari semua halaman
    private val _priceAgreement = MutableStateFlow("")
    val priceAgreement: StateFlow<String> = _priceAgreement

    private val _feedCount = MutableStateFlow("")
    val feedCount: StateFlow<String> = _feedCount

    private val _storyCount = MutableStateFlow("")
    val storyCount: StateFlow<String> = _storyCount

    private val _tiktokCount = MutableStateFlow("")
    val tiktokCount: StateFlow<String> = _tiktokCount

    private val _youtubeCount = MutableStateFlow("")
    val youtubeCount: StateFlow<String> = _youtubeCount

    private val _additionalInfo = MutableStateFlow("")
    val additionalInfo: StateFlow<String> = _additionalInfo

    private val _startDate = MutableStateFlow("")
    val startDate: StateFlow<String> = _startDate

    private val _endDate = MutableStateFlow("")
    val endDate: StateFlow<String> = _endDate

    // Fungsi untuk memperbarui data
    fun updateInfluencerName(value: String) {
        _influencerName.value = value
    }

    fun updateCustomerName(value: String) {
        _customerName.value = value
    }

    fun updatePhoneNumber(value: String) {
        _phoneNumber.value = value
    }

    fun updateProductOrService(value: String) {
        _productOrService.value = value
    }

    fun updateLocation(value: String) {
        _location.value = value
    }

    fun updateInstagramAccount(value: String) {
        _instagramAccount.value = value
    }

    fun updateTiktokAccount(value: String) {
        _tiktokAccount.value = value
    }

    fun updatePriceAgreement(value: String) {
        _priceAgreement.value = value
    }

    fun updateFeedCount(value: String) {
        _feedCount.value = value
    }

    fun updateStoryCount(value: String) {
        _storyCount.value = value
    }

    fun updateTiktokCount(value: String) {
        _tiktokCount.value = value
    }

    fun updateYoutubeCount(value: String) {
        _youtubeCount.value = value
    }

    fun updateAdditionalInfo(value: String) {
        _additionalInfo.value = value
    }

    fun updateStartDate(value: String) {
        _startDate.value = value
    }

    fun updateEndDate(value: String) {
        _endDate.value = value
    }
}