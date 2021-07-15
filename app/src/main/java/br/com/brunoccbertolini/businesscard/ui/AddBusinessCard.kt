package br.com.brunoccbertolini.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.brunoccbertolini.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCard : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnSave.setOnClickListener {  }
    }
}