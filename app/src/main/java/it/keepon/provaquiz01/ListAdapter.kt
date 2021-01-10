package it.keepon.provaquiz01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter (context: Context, data:ArrayList<CustomClass02>):ArrayAdapter<CustomClass02>(context, 0, data)

{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView

        itemView = LayoutInflater.from(context).inflate(R.layout.custom_item, parent, false)

        val item = getItem(position)

        if(item != null) {
            val title = itemView.findViewById<TextView>(R.id.textCoso01)
            val desc = itemView.findViewById<TextView>(R.id.textCoso02)
            val img01 = itemView.findViewById<ImageView>(R.id.image06)
            val img02 = itemView.findViewById<ImageView>(R.id.image07)

            title.text = item.item_title
            desc.text = item.item_desc
            img01.setImageResource(item.image_one)
            img02.setImageResource(item.image_two)

        }


        return itemView



    }

}