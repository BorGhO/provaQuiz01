package it.keepon.provaquiz01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.AutoCompleteTextView
import android.widget.Button

class Activity02 : AppCompatActivity() {

   // lateinit var user_code: AutoCompleteTextView
    lateinit var run_btn: Button
    lateinit var webView01: WebView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_02)


       // user_code = findViewById(R.id.user_code)
        run_btn = findViewById(R.id.run_btn)
        webView01 = findViewById(R.id.webView01)

        val messaggio = intent.getStringExtra("coso") ?: "nulla"
        webView01.loadData(messaggio, "text/html; charset=UTF-8", null)           //, "text/html: charset=utf-8"

    }

    private fun Run() {




    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater

        inflater.inflate(R.menu.code_menu, menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item?.itemId){

            R.id.en_js -> {


                webView01.settings.javaScriptEnabled
            }


        }



        return super.onOptionsItemSelected(item)
    }



}