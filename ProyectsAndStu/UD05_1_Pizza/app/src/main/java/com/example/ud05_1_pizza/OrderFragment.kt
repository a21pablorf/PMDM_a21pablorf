package com.example.ud05_1_pizza

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view=inflater.inflate(R.layout.fragment_order, container, false)

        val toolbar= view.findViewById<MaterialToolbar>(R.id.toolbar)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        val fabNext=view.findViewById<FloatingActionButton>(R.id.fab_btn)
        fabNext.setOnClickListener {
            val grupo=view.findViewById<RadioGroup>(R.id.btn_group_pizza_type)
            val pizzaType=grupo.checkedRadioButtonId
            var msg=""
            if (pizzaType==-1){
                msg="Debes seleccionar un tipo de pizza"
            }
            else{
                msg=when (pizzaType){
                    R.id.pizza_Margarita -> "Margarita"
                    else -> "Diavola"
                }
                Toast.makeText(activity,msg,Toast.LENGTH_LONG).show()

                val parmesano=view.findViewById<Chip>(R.id.chip_Parmesano)
                if (parmesano.isChecked) msg+=" con parmesano"
                val mozzarella=view.findViewById<Chip>(R.id.chip_Mozzarella)
                if (parmesano.isChecked) msg+=" con mozzarella"
            }
            val snackbar =Snackbar.make(fabNext,msg,Snackbar.LENGTH_SHORT)
            snackbar.setAction("Undo"){
                grupo.clearCheck()
            }
            snackbar.show()
        }
        return view
    }
}