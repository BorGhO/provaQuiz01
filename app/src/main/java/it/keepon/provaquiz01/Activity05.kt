package it.keepon.provaquiz01

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.widget.VideoView

class Activity05 : AppCompatActivity() {

    lateinit var  image_gallery : ImageView
    lateinit var video_gallery    : VideoView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_05)

        image_gallery = findViewById<ImageView>(R.id.galleriaView)
        video_gallery = findViewById<VideoView>(R.id.videoView05)


        val cameraButt = findViewById<Button>(R.id.cameraButt)

        cameraButt.setOnClickListener {

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 111) //il requestCode è tipo la stringa di riconoscimento dell'immagine
        }


        val galleriaButt = findViewById<Button>(R.id.galleriaButt)

        galleriaButt.setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 112) //il requestCode è tipo la stringa di riconoscimento dell'immagine
        }

        val callButt = findViewById<Button>(R.id.callButt)

        callButt.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "119", null))
            startActivity(intent)
        }


        val smsButt = findViewById<Button>(R.id.smsButt)

        smsButt.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + 119))

            intent.putExtra("sms_body", "Bella Bomber")

            startActivity(intent)


        }


        val playStoreButt = findViewById<Button>(R.id.playStoreButt)

        playStoreButt.setOnClickListener {

            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName"))        //per far aprire il playstore di un'altra app scrivere il suo package name, come per esempio com.android.chrome
                startActivity(intent)
            }catch(error:android.content.ActivityNotFoundException){

                val intent =  Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName"))
                startActivity(intent)
            }
        }


        val viewURLButt = findViewById<Button>(R.id.videoURLButt)

        viewURLButt.setOnClickListener {


            val video_url: String = "https://www.radiantmediaplayer.com/media/big-buck-bunny-360p.mp4"        //nota che per fare questo bisogna anche aggiungere nel manifest il permission per andare in internet

            println(video_url)
            val video_uri = Uri.parse(video_url)

            video_gallery.setVideoURI(video_uri)

            video_gallery.start()




        }

    }
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == 111){
                if (data != null) {
                    val image = data?.extras?.get("data") as Bitmap
                    image_gallery.setImageBitmap(image)
                }else
                    Toast.makeText(this, "Non hai fatto nessuna foto zio", Toast.LENGTH_LONG).show()    //questo non funziona
            }

            if (requestCode == 112){

                if (data != null){

                    val imageUri = data.data
                    image_gallery.setImageURI(imageUri)


                }else
                    Toast.makeText(this, "Non hai scelto nessuna foto zio", Toast.LENGTH_LONG).show()    //questo non funziona


            }
        }
}