package com.example.pokemonlist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokemonlist.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.linkTextview.setOnClickListener{
            goToGithub()
        }
    }

    fun goToGithub() {
        val url = "https://github.com/azkifairuz"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}