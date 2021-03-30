package com.techoniq.shoptrandz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.techoniq.shoptrandz.R
import org.jetbrains.anko.startActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_activity)

        setTimerAndRedirect()
    }

    private fun setTimerAndRedirect() {
        Handler().postDelayed({
            startActivity<CategoriesActivity>()
            finish()
        }, 2000)
    }
}
