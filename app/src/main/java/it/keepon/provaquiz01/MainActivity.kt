package it.keepon.provaquiz01

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.widget.*
import maes.tech.intentanim.CustomIntent.customType
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var questionText : TextView
    lateinit var solutionText : TextView
    lateinit var scriviText : EditText
    var scrumbled : Int = -1

    val testo = listOf<String>("primo", "secondo", "terzo")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var handler = Handler()

        var prog = findViewById<ProgressBar>(R.id.progressBar01)



        handler.postDelayed({

            prog.visibility =  GONE
            Toast.makeText(this, "5 secondi", Toast.LENGTH_LONG).show()

        }, 5000)

        questionText = findViewById(R.id.question)
        solutionText = findViewById(R.id.solution)
        scriviText = findViewById(R.id.scrivi)

        populateQuestion()

        val messaggio = intent.getStringExtra("effettiIntent") ?: ""

        scriviText.setText(messaggio)

        customType(this, messaggio)
    }


    fun populateQuestion(){

        scrumbled = Random(System.nanoTime()).nextInt(testo.size)

        val charArr = (testo[scrumbled]).toCharArray()

        charArr.shuffle()

       var scrumString = ""
        for (coso in charArr)
            scrumString += coso


            //.shuffle(Random(System.nanoTime())).joinToString()
        println(testo[scrumbled] +" "+scrumString)


        solutionText.visibility = View.INVISIBLE
        questionText.text = scrumString
        scriviText.text.clear()
    }

    fun checkScrumbled (){

        var scrivi = scriviText.text ?: ""

        scrivi = scrivi.toString()
        val tex = testo[scrumbled]

        if(scrivi == tex){

            solutionText.visibility = View.VISIBLE
            solutionText.text = tex

        }else

            Toast.makeText(this, "Sbagliato!", Toast.LENGTH_LONG).show()


    }


    fun clickButt(view: View){

        val butt = findViewById<Button>(view.id)




        when (view.id) {

            R.id.buttChange -> {
                println("change")
                populateQuestion()
            }

            R.id.buttCheck -> {
                println("check")
                checkScrumbled()
            }

            R.id.buttShow -> {
                println("show")
                solutionText.text = testo[scrumbled]
                solutionText.visibility = View.VISIBLE
            }

        }

    }

    fun toAct02(view: View){

        toAct02Again()
    }

    fun toAct02Again(){

        val intentBox = findViewById<AutoCompleteTextView>(R.id.intentBox)

        var message = intentBox.text ?: ""



        if (message.isEmpty()) {
            Toast.makeText(this, "Zio scrivi qualcosa", Toast.LENGTH_LONG).show()

            intentBox.setText( "<html><body><h1>Welcome Android-Kotlin.com</h1></body></html>")

        }
        else {
            val intent = Intent(this, Activity02::class.java).apply {
                putExtra("coso", message.toString())
            }
            startActivity(intent)

        }
    }

    fun openTerza(){

        val intent = Intent(this, Activity03::class.java)

        startActivity(intent)

    }

    fun openQuarta(){

        val intent = Intent(this, Activity04::class.java)

        startActivity(intent)

    }


    fun openQuinta(){

        val intent = Intent(this, Activity05::class.java)

        startActivity(intent)

    }

    fun openError01(){

        val intent = Intent(this, ErrorActivity01::class.java)

        startActivity(intent)

    }

    fun openRecycle01(){

        val intent = Intent(this, RecycleActivity01::class.java)

        startActivity(intent)

    }

    fun openSesta(){

        val intent = Intent(this, Activity06::class.java)

        startActivity(intent)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater

        inflater.inflate(R.menu.main_menu, menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item?.itemId){

            R.id.run_menu -> {

                toAct02Again()
                //return true
            }

            R.id.add_html_code ->{

                scriviText.setText("<html><body><h1>Coso2</h1></body></html>")
            }
            R.id.Clear ->{
                scriviText.text.clear()

            }
            R.id.close ->{

                finish()

            }

            R.id.terzaActivity -> {

                openTerza()
            }

            R.id.quartaActivity ->{

                openQuarta()
            }

            R.id.quintaActivity ->{

                openQuinta()
            }

            R.id.errorActivity01 ->{

                openError01()
            }
            R.id.recycleActivity01 -> {
                openRecycle01()
            }

            R.id.sestaActivity ->{

                openSesta()
            }
        }



        return super.onOptionsItemSelected(item)
    }

}



