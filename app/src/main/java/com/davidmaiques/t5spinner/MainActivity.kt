package com.davidmaiques.t5spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.davidmaiques.t5spinner.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val datos = arrayOf("Opcion 1", "Opcion 2", "Opcion 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, datos)
        val spinner = binding.spnLista

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // NO ME AUTOCOMPLETA EL METODO SETONITEMSELECTEDLISTENER
//spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//            val seleccion = datos[position]
//            binding.lblMensaje.text = "Seleccionado: $seleccion"
//    }
//
//    override fun onNothingSelected(parent: AdapterView<*>) {
//        binding.lblMensaje.text = ""
//    }
//}

        // NO ME AUTOCOMPLETA EL METODO SETONITEMSELECTEDLISTENER
// Manejar la selección de elementos del Spinner
        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int,
                id: Long
            ) {
                val seleccion = datos[position]
                binding.lblMensaje.text = "Seleccionado: $seleccion"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
// Acciones a realizar si no se selecciona nada
                binding.lblMensaje.text = ""
            }
        })
    }
}