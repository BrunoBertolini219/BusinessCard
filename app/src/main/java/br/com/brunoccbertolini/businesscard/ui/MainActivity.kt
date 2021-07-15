package br.com.brunoccbertolini.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.brunoccbertolini.businesscard.R
import br.com.brunoccbertolini.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        insertListener()

    }

    private fun insertListener() {
        viewBinding.fabAdd.setOnClickListener {
            val intent = Intent (this@MainActivity, AddBusinessCard::class.java)
            startActivity(intent)
        }
    }
}