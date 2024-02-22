package com.example.dialogbutton

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.dialogbutton.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding?=null
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnAlert?.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            // Set the title and message for the dialog
            builder.setTitle("Alert Dialog")
                .setMessage("This is an example of an AlertDialog")

            builder.setCancelable(true) // tapping outside will dismiss the alert dialog

            // Add a button to dismiss the dialog
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }

            // Add negative button
            builder.setNegativeButton("Cancel") { dialog, _ ->
                // Do something when negative button is clicked
                dialog.dismiss()
            }

            // Add neutral button
            builder.setNeutralButton("Remind Me Later") { dialog, _ ->
                // Do something when neutral button is clicked
                Toast.makeText(this, "Remind u later", Toast.LENGTH_SHORT).show()
            }



            // Create and show the AlertDialog
            builder.create().show()
        }

        binding?.btnSnack?.setOnClickListener {
            // Create and display a Snackbar
           val location: View = findViewById(R.id.view)
            Snackbar.make(location, "Snackbar message", Snackbar.LENGTH_SHORT)
                .setAction("Undo") {
                    location.setBackgroundColor(R.color.black)
                }
                .show()
        }
    }
}