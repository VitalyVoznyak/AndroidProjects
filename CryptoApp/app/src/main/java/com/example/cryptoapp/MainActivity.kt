package com.example.cryptoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.loadData()
        viewModel.priceList.observe(this, Observer {
            
        })

    }


}