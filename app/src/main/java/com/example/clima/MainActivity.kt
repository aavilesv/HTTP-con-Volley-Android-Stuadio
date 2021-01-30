package com.example.clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import java.lang.Exception


// como enviar datos con una clase  unión de clase y vista que sería el activity
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        var tcuidad:TextView?=null
        var tgrados:TextView?=null
        var testatos:TextView?=null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tcuidad= findViewById(R.id.txciudad)
        tgrados= findViewById(R.id.txtgrados)
        testatos= findViewById(R.id.txtestado)
        // aqui recibe los datos del otra vista
        val cuidad=intent.getStringExtra("com.example.clima.cuidades.CUIDAD")
        if (Network.hayred(this )){
            // ejecutar el http
            //b269db0a925e2caee998ddd108f13e35
            //3658394 quito
            //solicitudvolley("https://api.openweathermap.org/data/2.5/weather?id=3658394&appid=b269db0a925e2caee998ddd108f13e35")


            val queue= Volley.newRequestQueue(this)
            val solicitud= StringRequest(Request.Method.GET,"https://api.openweathermap.org/data/2.5/weather?id="+cuidad+"&appid=b269db0a925e2caee998ddd108f13e35&units=metric&lang=es", Response.Listener<String>{
                response ->
                try {
                    val gson=Gson()
                    val ciudad =gson.fromJson(response,Ciudad::class.java)
                    tcuidad?.text=ciudad.name
                    tgrados?.text=ciudad.main?.temp.toString()+"°"
                    testatos?.text =ciudad.weather?.get(0)?.description.toString()
                    Log.d("mirador",ciudad.weather?.get(0)?.description.toString())

                }catch (e: Exception){

                }
            }, Response.ErrorListener { })
            queue.add(solicitud)
        }else{
            //
        }

        // como ya inicializaste los datos ya están



        //Toast.makeText(this,cuidad,Toast.LENGTH_LONG).show()
        //val ciudad =Ciudad("Cuidad de Milagro",40,"Soleado")
        //val ciudadq=Ciudad("Cuidad de Quito",10,"Cielo despejado")


    }

    // metodo para volley
    private fun estado(tcuidad:TextView):String{
        return tcuidad.toString()
    }
    private fun testatos(testatos:TextView):String{
        return testatos.toString()
    }
    private fun solicitudvolley(url: String){
        val queue= Volley.newRequestQueue(this)
        val solicitud= StringRequest(Request.Method.GET,url, Response.Listener<String>{
            response ->
            try {
                val gson=Gson()
                val ciudad =gson.fromJson(response,Ciudad::class.java)
              // tcuidad?.text=ciudad.name
             //   tgrados?.Text=ciudad.main.temp.toString()+"°"
               // testatos.Text =ciudad.weather?.get(0)?.description.toString()
                Log.d("mirador",ciudad.weather?.get(0)?.description.toString())

            }catch (e: Exception){

            }
        }, Response.ErrorListener { })
        queue.add(solicitud)

    }


}