package com.example.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import com.example.horoscapp.ui.detail.HoroscopeDetailState.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


class HorosocopeDetailViewModel @Inject constructor(): ViewModel(){

    private var _state = MutableStateFlow<HoroscopeDetailState>(Loading)
    val state: StateFlow<HoroscopeDetailState> = _state
}