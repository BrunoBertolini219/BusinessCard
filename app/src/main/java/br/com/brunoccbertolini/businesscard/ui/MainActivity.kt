package br.com.brunoccbertolini.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.brunoccbertolini.businesscard.App
import br.com.brunoccbertolini.businesscard.R
import br.com.brunoccbertolini.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter: BusinessCardAdapter by lazy { BusinessCardAdapter() }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        viewBinding.rvBusiness.layoutManager = LinearLayoutManager(this)
        viewBinding.rvBusiness.adapter = adapter
        getAllBusinessCard()
        insertListener()

    }

    private fun insertListener() {
        viewBinding.fabAdd.setOnClickListener {
            val intent = Intent (this@MainActivity, AddBusinessCard::class.java)
            startActivity(intent)
        }
    }

    private fun getAllBusinessCard(){
        mainViewModel.getAll().observe(this, Observer { businessCards ->
            adapter.submitList(businessCards)
        })
    }
}