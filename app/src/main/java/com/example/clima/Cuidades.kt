package com.example.clima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.Toast

class Cuidades : AppCompatActivity() {
    //
    val TAG= "com.example.clima.cuidades.CUIDAD"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuidades)
        val bcuidad = findViewById<Button>(R.id.btncuidad)
        val bcuidadotra = findViewById<Button>(R.id.btncuidadotra)
        val btnnuevo = findViewById<Button>(R.id.btnnuevo)


        btnnuevo.setOnClickListener(View.OnClickListener {
            // de esta forma se llama a otro formulario
            // val intent = Intent(this,MainActivity::class.java)
            //  startActivity(intent) CUANDO HAGA UN CLICK
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG,"1796236")
            startActivity(intent)

        })


        bcuidad.setOnClickListener(View.OnClickListener {
            // de esta forma se llama a otro formulario
            // val intent = Intent(this,MainActivity::class.java)
            //  startActivity(intent) CUANDO HAGA UN CLICK
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG,"3117735")
            startActivity(intent)

        })
        bcuidadotra.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            //puteextra es el que envia los datos
            intent.putExtra(TAG,"3658394")
            startActivity(intent)

            // esa forma se presenta un mnensaje
            // Toast.makeText(this,"Ciudad de Quito",Toast.LENGTH_LONG).show()
        })
    }
}
//b269db0a925e2caee998ddd108f13e35