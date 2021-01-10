package it.keepon.provaquiz01

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.ListView
import androidx.constraintlayout.widget.ConstraintLayout
import com.ncorti.slidetoact.SlideToActView

class ErrorActivity01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error01)

        val alert = Dialog(this)

        alert.setContentView(R.layout.activity_03)


        alert.show()



        val slider = alert.findViewById<SlideToActView>(R.id.slider01)

        slider.onSlideCompleteListener = object : SlideToActView.OnSlideCompleteListener {

            override fun onSlideComplete(view: SlideToActView) {
                alert.dismiss()
            }

        }


    }
}