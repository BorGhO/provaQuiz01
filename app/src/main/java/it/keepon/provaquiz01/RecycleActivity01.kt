package it.keepon.provaquiz01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecycleActivity01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle01)


        val items = ArrayList<RecycleClass01>()

        items.add(RecycleClass01("primo", "666", R.drawable.dd01))
        items.add(RecycleClass01("secondo", "123", R.drawable.lm01))
        items.add(RecycleClass01("terzo", "666",R.drawable.dd01))
        items.add(RecycleClass01("quarto", "123",R.drawable.lm01))
        items.add(RecycleClass01("quinto", "666",R.drawable.dd01))
        items.add(RecycleClass01("sesto", "123",R.drawable.lm01))

        val recycle = findViewById<RecyclerView>(R.id.recycle01)    //recyclerView contenuto nel xml di questa activity

        val adapter = RecycleAdapter01(items, applicationContext)

        //i layout manager, ce ne sono di vario tipo, sono quelli che definiscono come distribuire graficamente gli elementi della lista
        recycle.layoutManager = GridLayoutManager(applicationContext, 3)    //spanCount è il numero di colonne

        recycle.adapter = adapter







    }
}