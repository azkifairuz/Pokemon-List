package com.example.pokemonlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val name: String,
    val type: String,
    val desc: String,
    val photo: Int,
):Parcelable
