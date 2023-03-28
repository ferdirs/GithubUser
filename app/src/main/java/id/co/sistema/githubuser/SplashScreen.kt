package id.co.sistema.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        GlobalScope.launch{
            delayScreen()
        }
    }

    suspend fun delayScreen(){
        delay(3000)
        startActivity(Intent(applicationContext, MainActivity::class.java))
    }

}