package it.keepon.provaquiz01

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.*
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

//il : qui intende dire che si sta facendo un'estensione della classe seguente, quindi RecyclerAdapter01 estende RecyclerView.Adapter
class RecycleAdapter01 (data:ArrayList<RecycleClass01>, var context: Context) : RecyclerView.Adapter<RecycleAdapter01.ViewHolder>(){





    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){   //qui si estende la proprità ViewHolder di Recy, che è il contenitore degli elementi

        internal var title:TextView
        internal var image:ImageView
        internal var card: CardView


        init{

            title = itemView.findViewById(R.id.recycleText01)
            image = itemView.findViewById(R.id.recycleImage01)
            card = itemView.findViewById(R.id.recycle_card01)
        }
    }




    internal var data:List<RecycleClass01>

    init{

        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {     //va fatto l'override di tutti i metodi di RecyclerView.Adapter

        val layout = LayoutInflater.from(context).inflate(R.layout.custom_item01, parent, false)

        return ViewHolder(layout)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = data[position].title
        holder.image.setImageResource(data[position].image)



       if (position % 2 == 0)
           holder.card.setCardBackgroundColor(ContextCompat.getColor(context, R.color.purple_500))

       holder.card.setOnClickListener{

            val alert = Dialog(context)
            alert.setContentView((R.layout.custom_alert))
            alert.window!!.setType(WindowManager.LayoutParams.TYPE_TOAST)   //per qualche motivo ci vuole toast qui
            alert.setTitle("Recycler 2")
            val text = alert.findViewById<TextView>(R.id.titleAlert)
            val desc = alert.findViewById<TextView>(R.id.descAlert)
            val image = alert.findViewById<ImageView>(R.id.alertImage)
            val button = alert.findViewById<Button>(R.id.closeAlert01)

            text.text = data[position].title
            desc.text = itemCount.toString()
            image.setImageResource( data[position].image)



            alert.show()
            button.setOnClickListener{alert.dismiss()}

            button.setOnLongClickListener {
                //Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "119", null))
                val intent2 = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", data[position].phone , null))
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(context, intent2, null)
                alert.dismiss()
                true
            }



           text.setOnClickListener{
               parla(text.text.toString())
           }
           desc.setOnClickListener{
               parla(desc.text.toString())
           }


       }
    }


    override fun getItemCount(): Int{

        return data.size
    }

    fun parla (daDire:String){

        println(daDire)

        lateinit var toSpeech : TextToSpeech

        toSpeech = TextToSpeech(context, TextToSpeech.OnInitListener { status ->

            if (status == TextToSpeech.SUCCESS){

                toSpeech.language = Locale.ITALIAN
                toSpeech.speak(daDire, TextToSpeech.QUEUE_FLUSH, null, null)

            }


        })


    }


}

