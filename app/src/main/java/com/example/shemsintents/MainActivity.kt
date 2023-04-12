package com.example.shemsintents

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Button


class MainActivity : AppCompatActivity() {
    lateinit var btnSMS:Button
    lateinit var btnEmail:Button
    lateinit var btnCamera:Button
    lateinit var btnShare:Button
    lateinit var btnMpesa:Button
    lateinit var btnCall:Button
    lateinit var btnWebsite:Button
    lateinit var btnMap:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSMS = findViewById(R.id.mBTnSMS)
        btnEmail = findViewById(R.id.mBTnSMS)
        btnCamera = findViewById(R.id.mBTnSMS)
        btnShare = findViewById(R.id.mBTnSMS)
        btnMpesa = findViewById(R.id.mBTnSMS)
        btnCall= findViewById(R.id.mBTnSMS)
        btnWebsite = findViewById(R.id.mBTnSMS)
        btnMap = findViewById(R.id.mBtnMap)
        btnSMS.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0707610611")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hi there.....")
            startActivity(intent)
        }
        btnEmail.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }
        btnCamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }
        btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app  https.www!")
            startActivity(shareIntent)
        }
        btnMpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }

        }
        btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf<String>(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }
        btnWebsite.setOnClickListener {
            val tembea = Intent(this@MainActivity, WebsiteActivity::class.java)
            startActivity(tembea)
        }
        btnMap.setOnClickListener {
            val ramani = Intent(this, MapsActivity::class.java)
            startActivity(ramani)
        }
    }
}