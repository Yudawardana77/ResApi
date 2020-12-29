package com.appslokal.app.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.appslokal.app.R
import com.appslokal.app.databinding.ActivityMainBinding
import com.appslokal.app.ui.auth.AppsLokalAuth
import com.appslokal.app.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()


    }

    private fun init() {
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> navgate(R.id.homeFragment)
                R.id.ic_news -> navgate(R.id.newsFragment)
                R.id.ic_favorite -> navgate(R.id.favoriteFragment)
                R.id.ic_profile -> navgate(R.id.profileFragment)
                else -> false
            }
        }
    }

    private fun navgate(id: Int): Boolean {
        findNavController(R.id.navHost).navigate(id)
        return true
    }
}