package com.example.pokemonlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPokemon: RecyclerView
    private val list = ArrayList<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPokemon = findViewById(R.id.rv_pokemons)
        rvPokemon.setHasFixedSize(true)
        list.addAll(getListPokemons())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvPokemon.layoutManager = GridLayoutManager(this,2)
        val listHeroAdapter = ListPokemonAdapter(list)
        rvPokemon.adapter = listHeroAdapter
    }

    private fun getListPokemons(): ArrayList<Pokemon> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataType = resources.getStringArray(R.array.pokemon_types)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPokemon = ArrayList<Pokemon>()
        for (i in dataName.indices) {
            val hero = Pokemon(dataName[i],dataType[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listPokemon.add(hero)
        }
        return listPokemon
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.to_about -> {
                val goToAbout = Intent (this@MainActivity,AboutActivity::class.java)
                startActivity(goToAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

