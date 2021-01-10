package it.keepon.provaquiz01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
                                                                        //questo estende la classe ArrayAdapter
class CustomAdapter01(context: Context,  data:ArrayList<CustomClass01>) : ArrayAdapter<CustomClass01> (context, 0, data){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        var itemView = convertView

        itemView = LayoutInflater.from(context).inflate(R.layout.custom_list, parent, false)

        val item = getItem(position)
        if (item != null) {

            val title = itemView.findViewById<TextView>(R.id.title01)
            title.text = item.title

            val descr = itemView.findViewById<TextView>(R.id.descr01)
            descr.text = item.desc

            val image = itemView.findViewById<ImageView>(R.id.imageDD)
            image.setImageResource(item.image)
        }
      //  return super.getView(position, convertView, parent)

        return itemView
    }



}