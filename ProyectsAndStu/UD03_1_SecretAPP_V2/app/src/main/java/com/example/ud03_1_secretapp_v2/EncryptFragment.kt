package com.example.ud03_1_secretapp_v2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class EncryptFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mensaje=EncryptFragmentArgs.fromBundle(requireArguments()).messsage
        val view= inflater.inflate(R.layout.fragment_encrypt, container, false)

        val texto= view.findViewById<TextView>(R.id.encrypt_textValue)

        texto.text=cifrado(mensaje)

        return view
    }

    fun cifrado(texto: String): String{
        var cifrado: List<Int>
        cifrado=texto.map { it.uppercaseChar()
            .code.minus(61)
            .mod(26).plus(64)

        }

        return cifrado.map { it.toChar() }.toString()
    }

}