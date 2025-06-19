package vcmsa.ci.songapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedActivity {

}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Lateinit views
        lateinit var etTitle: EditText
        lateinit var etArtist: EditText
        lateinit var etRating: EditText
        lateinit var etComment: EditText
        lateinit var btnAdd: Button
        lateinit var btnDetailed: Button
        lateinit var btnExit: Button

        @SuppressLint("MissingSuperCall")
        fun onCreate(savedInstanceState: Bundle?) {
            setContentView(R.layout.activity_main)

            // Bind views
            etTitle = findViewById(R.id.etTitle)
            etArtist = findViewById(R.id.etArtist)
            etRating = findViewById(R.id.etRating)
            etComment = findViewById(R.id.etComment)
            btnAdd = findViewById(R.id.btnAdd)
            btnDetailed = findViewById(R.id.btnDetailed)
            btnExit = findViewById(R.id.btnExit)

            // “Add to Playlist” handler
            btnAdd.setOnClickListener {
                val title = etTitle.text.toString()
                val artist = etArtist.text.toString()
                val rating = etRating.text.toString().toIntOrNull() ?: -1
                val comment = etComment.text.toString()


                // Navigate to Detailed View screen
                btnDetailed.setOnClickListener {
                    val intent = Intent(this, DetailedActivity::class.java)
                    startActivity(intent)
                }

                // Exit button
                btnExit.setOnClickListener {
                    finishAffinity() // close all activities
                }
            }

            /** Helper to display error in an AlertDialog */
            fun showError(message: String) =
                AlertDialog.Builder(this)
                    .setTitle("Oops")
                    .setMessage(message)
                    .setPositiveButton("OK", null)
                    .show()

            fun clearInputs() {
                etTitle.text.clear()
                etArtist.text.clear()
                etRating.text.clear()
                etComment.text.clear()
                etTitle.requestFocus()
            }
        }
    }
}