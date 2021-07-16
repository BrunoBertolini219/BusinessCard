package br.com.brunoccbertolini.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import br.com.brunoccbertolini.businesscard.App
import br.com.brunoccbertolini.businesscard.R
import br.com.brunoccbertolini.businesscard.data.BusinessCard
import br.com.brunoccbertolini.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCard : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnSave.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilName.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                telefone = binding.tilPhone.editText?.text.toString(),
                empresa = binding.tilCompany.editText?.text.toString(),
                fundoPersonalizado = binding.tilColour.editText?.text.toString()
            )

            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()

            finish()
        }
    }
}