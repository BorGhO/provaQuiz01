package it.keepon.provaquiz01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class Activity06 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_06)

        val nav = findViewById<BottomNavigationView>(R.id.navLay01)
        val frame = findViewById<FrameLayout>(R.id.frameLay01)

        val game = game_frag()
        val web = web_frag()
        val android = android_frag()



        nav.setOnNavigationItemSelectedListener {

            item ->
                when(item.itemId) {

                    R.id.itemGame ->{


                        val fragmentChanger = supportFragmentManager.beginTransaction()
                        fragmentChanger.replace(R.id.frameLay01, game)
                        fragmentChanger.commit()

                        true
                    }

                    R.id.itemWeb ->{
                        val fragmentChanger = supportFragmentManager.beginTransaction()
                        fragmentChanger.replace(R.id.frameLay01, web)
                        fragmentChanger.commit()
                         true
                    }

                    R.id.itemAndroid->{
                        val fragmentChanger = supportFragmentManager.beginTransaction()
                        fragmentChanger.replace(R.id.frameLay01, android)
                        fragmentChanger.commit()
                         true
                    }
                    else -> false
                }
        }

    }
}