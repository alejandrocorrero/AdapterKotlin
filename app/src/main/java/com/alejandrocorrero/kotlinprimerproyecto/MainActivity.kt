package com.alejandrocorrero.kotlinprimerproyecto

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val items = arrayListOf(Item("test"), Item("test1"), Item("test2"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPrueba.setOnClickListener({ Toast.makeText(this, "Prueba", Toast.LENGTH_SHORT).show() })
        btnPrueba.text = String.format(Locale.ENGLISH, "test")
        rvPrueba.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        /* rvPrueba.adapter = MainActivityAdapter(items, {
             Toast.makeText(this, it.prueba, Toast.LENGTH_SHORT).show()
         }, {
             Toast.makeText(this, it.prueba + "LARGO", Toast.LENGTH_SHORT).show()
             true
         })*/
        rvPrueba.adapter = MainActivityAdapter(items, clickItem(), clickLargo())
    }

    private fun clickLargo(): (Item) -> Boolean {
        return {
            Toast.makeText(this, it.prueba + "LARGO", Toast.LENGTH_SHORT).show()
            true
        }
    }

    private fun clickItem(): (Item) -> Unit {
        return {
            Toast.makeText(this, it.prueba, Toast.LENGTH_SHORT).show()
        }
    }
}

