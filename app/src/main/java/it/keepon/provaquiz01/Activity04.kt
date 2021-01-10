package it.keepon.provaquiz01

import android.app.Dialog
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Activity04 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_04)


        val items = ArrayList<CustomClass01>()

        items.add(CustomClass01("CosoTitolo1", "Dai 1", R.drawable.dd01))
        items.add(CustomClass01("CosoTitolo2", "Dai 2", R.drawable.lm01))
        items.add(CustomClass01("CosoTitolo3", "Dai 3", R.drawable.dd01))
        items.add(CustomClass01("CosoTitolo4", "Dai 4", R.drawable.lm01))
        items.add(CustomClass01("CosoTitolo5", "Dai 5", R.drawable.dd01))
        items.add(CustomClass01("CosoTitolo6", "Dai 6", R.drawable.lm01))


        val adapter = CustomAdapter01(this, items)

        val list = findViewById<ListView>(R.id.list_view)

        list.adapter = adapter


        list.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->

            val alert = Dialog(this)
            alert.setContentView(R.layout.custom_alert)

            val title = alert.findViewById<TextView>(R.id.titleAlert)
            val desc = alert.findViewById<TextView>(R.id.descAlert)
            val image = alert.findViewById<ImageView>(R.id.alertImage)
            val hide = alert.findViewById<Button>(R.id.closeAlert01)

            val item = adapter.getItem(position)

            if (item != null) {
                title.text = item.title
                desc.text = item.desc
                image.setImageResource(item.image)


            }

            alert.show()

            hide.setOnClickListener{

                alert.dismiss()
                println("coso")
            }


        }
    }
}