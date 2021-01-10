package it.keepon.provaquiz01

import android.app.ActionBar
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.ncorti.slidetoact.SlideToActView
import maes.tech.intentanim.CustomIntent.customType
import kotlin.random.Random


class Activity03 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_03)

        val messaggio = intent.getStringExtra("coso") ?: "nulla"
        customType(this, "bottom-to-up");


        val slider = findViewById<SlideToActView>(R.id.slider01)

        val constrLayout = findViewById<ConstraintLayout>(R.id.constr01)

        val list = findViewById<ListView>(R.id.list_items01)

        slider.onSlideCompleteListener = object : SlideToActView.OnSlideCompleteListener{

            override fun onSlideComplete(view: SlideToActView) {

                toaster()
                constrLayout.layoutParams.height = 0
                list.layoutParams.height = findViewById<LinearLayout>(R.id.layVert03).layoutParams.height
                /* val params: ActionBar.LayoutParams = constrLayout.getLayoutParams() as ActionBar.LayoutParams
                 params.height = 0
                 constrLayout.layoutParams = params*/

            }

        }


        val items = ArrayList<CustomClass02>()

        items.add(CustomClass02("coso01", "desc01", R.drawable.dd01, R.drawable.lm01))
        items.add(CustomClass02("coso02", "desc02", R.drawable.dd01, R.drawable.lm01))
        items.add(CustomClass02("coso03", "desc03", R.drawable.dd01, R.drawable.lm01))
        items.add(CustomClass02("coso04", "desc04", R.drawable.dd01, R.drawable.lm01))

        val adapter = ListAdapter(this, items)
        list.adapter = adapter


        list.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->

            val alert = Dialog(this)
            alert.setContentView(R.layout.custom_alert)

            val title = alert.findViewById<TextView>(R.id.titleAlert)
            val desc = alert.findViewById<TextView>(R.id.descAlert)
            val image = alert.findViewById<ImageView>(R.id.alertImage)
            val hide = alert.findViewById<Button>(R.id.closeAlert01)

            val item = adapter.getItem(position)




            if (item != null) {
                title.text = parent.id.toString()//item.item_title
                desc.text = id.toString()//item.item_desc
                image.setImageResource(item.image_one)



            }

            alert.show()

            hide.setOnClickListener{

                alert.dismiss()
                println("coso")
            }


        }



    }

    fun toaster(){

        Toast.makeText(this, "Slidato", Toast.LENGTH_LONG).show()
    }

    fun backToMain(view: View){



        val effettiIntent = listOf("left-to-right", "right-to-left", "bottom-to-up", "up-to-bottom", "fadein-to-fadeout", "rotateout-to-rotatein")
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("effettiIntent", effettiIntent[Random(System.nanoTime()).nextInt(effettiIntent.size)])
        }

        startActivity(intent)
    }


}

