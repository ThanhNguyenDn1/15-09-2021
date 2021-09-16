package org.chickenhook.binderfuzzy

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.chickenhook.binderfuzzy.reflectionbrowser.RecentsActivity
import org.chickenhook.binderfuzzy.reflectionbrowser.ReflectionBrowser
import android.content.SharedPreferences
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_new?.setOnClickListener {
            val intent = Intent(this, ReflectionBrowser::class.java)
            startActivity(intent)
        }
        main_recent?.setOnClickListener {
            val prefs = getSharedPreferences(
                "PremiumApp",
                MODE_PRIVATE
            )
            val isPremium = prefs.getBoolean("premium", false)
            if(isPremium){
                val intent = Intent(this, RecentsActivity::class.java)
                startActivity(intent)
            }else Toast.makeText(applicationContext, "You need to update to premium verison", Toast.LENGTH_SHORT).show()

        }
        support?.setOnClickListener {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=8UH5MBVYM3J36"))
            startActivity(browserIntent)
        }
        github?.setOnClickListener {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ChickenHook/BinderFuzzy"))
            startActivity(browserIntent)
        }
    }

    fun sub(view: View) {
        startActivity(Intent(applicationContext, ShopActivity::class.java))
    }
}
