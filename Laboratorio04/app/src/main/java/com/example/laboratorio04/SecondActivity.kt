package com.example.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

const val TAG = "track lifestyle"

private var name = ""
private var email = ""
private var phone = ""

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        if( intent != null ){
            intent.extras?.apply {
                name = getString(MainActivity.USER_NAME).toString()
                email = getString(MainActivity.USER_EMAIL).toString()
                phone = getString(MainActivity.USER_PHONE).toString()

                Log.d(TAG,name + email + phone)

                findViewById<TextView>(R.id.name_content_confirm_text_view).apply {
                    text = name
                }

                findViewById<TextView>(R.id.email_content_confirm_text_view).apply {
                    text = email
                }

                findViewById<TextView>(R.id.phone_content_confirm_text_view).apply {
                    text = phone
                }
            }
        }

        var shareText = name + email + phone

        findViewById<Button>(R.id.share_button).apply {
            setOnClickListener{
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, shareText)
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }

    }

}