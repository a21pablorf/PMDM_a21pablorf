package com.example.ud06_3_guessgame

import androidx.lifecycle.ViewModel
class GameViewModel: ViewModel() {
    val words= listOf<String>("Barco","Arbol","Queso","Ordenador","Util","Noche")

    var secretWord=words.random().uppercase()


}