package com.example.ud03_1_secretapp_v2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController

class MessageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_message, container, false)

        var buttNext= view.findViewById<Button>(R.id.button_next)

        buttNext.setOnClickListener {
            val message= view.findViewById<EditText>(R.id.edit_text).text.toString()
            var actions=MessageFragmentDirections.actionMessageFragment2ToEncryptFragment(message)
            it.findNavController().navigate(actions)
        }
        return view
    }

}