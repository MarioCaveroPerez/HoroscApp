package com.example.horoscapp.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavArgs
import androidx.navigation.navArgs
import com.example.horoscapp.R
import com.example.horoscapp.databinding.ActivityHoroscopeDetailBinding
import com.example.horoscapp.databinding.ActivityMainBinding
import com.example.horoscapp.ui.detail.HoroscopeDetailState.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HorosocopeDetailViewModel by viewModels()
    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUI()
    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        is Error -> errorState()
                        Loading -> loadingState()
                        is Success -> successState()
                    }
                }
            }
        }
    }

    private fun loadingState() {
    }

    private fun errorState() {
    }

    private fun successState() {
    }
}