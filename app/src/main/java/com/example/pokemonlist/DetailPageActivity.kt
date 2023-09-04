package com.example.pokemonlist

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokemonlist.databinding.ActivityDetailPageBinding

class DetailPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPageBinding

    companion object{
        const val KEY_POKEMON = "key_pokemon"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataPokemon = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Pokemon>(KEY_POKEMON, Pokemon::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Pokemon>(KEY_POKEMON)
        }

        if (dataPokemon != null) {
            binding.imgDetail.setImageResource(dataPokemon.photo)
            binding.tvTitle.text = dataPokemon.name
            binding.tvDetailType.text = dataPokemon.type
            binding.tvDesc.text = dataPokemon.desc
        }

    }
}