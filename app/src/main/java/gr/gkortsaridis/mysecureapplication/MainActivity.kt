package gr.gkortsaridis.mysecureapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    /**
     * USEFUL LINKS
     * APKTOOOL: https://ibotpeaches.github.io/Apktool/install/ apktool d application.apk
     * JADX    : https://github.com/skylot/jadx - jadx -d out classes.dex
     */

    private val input: EditText get() = findViewById(R.id.input)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun encryptAndSend(view: View){
        Log.i("INPUT", input.text.toString())

        val intent = Intent(this, SecretActivity::class.java)
        try{
            val encryptedString = AESUtils.encrypt(input.text.toString())
            intent.putExtra("SECRET",encryptedString)

            startActivity(intent)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}
