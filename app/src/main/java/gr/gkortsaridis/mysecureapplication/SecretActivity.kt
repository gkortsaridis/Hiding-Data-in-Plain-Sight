package gr.gkortsaridis.mysecureapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecretActivity : AppCompatActivity() {

    private val result: TextView get() = findViewById(R.id.result)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secret)

        val secret = intent.extras?.getString("SECRET")
        val decryptedString = secret?.let { AESUtils.decrypt(it) }
        result.text = "Encrypted: $secret \nDecrypted: $decryptedString"
    }
}
