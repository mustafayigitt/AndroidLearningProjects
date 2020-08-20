package com.mustafayigit.databindinexample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.mustafayigit.databindinexample.R
import com.mustafayigit.databindinexample.data.User
import com.mustafayigit.databindinexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) //activity

        // for fragment or view layout
        // binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_main, container, false)
        val user = getUserFromRemote()

        binding.apply {
            this.user = user
            Glide.with(this@MainActivity)
                .load(user.photoUrl)
                .into(imgUserProfile)
        }
    }

    private fun getUserFromRemote() = User(
        "R2D2",
        "https://www.arttablo.com/upload/U-r2d2-star-wars-kanvas-tablo1452771026-800.jpg",
        66,
        "StarWars"
    )
}