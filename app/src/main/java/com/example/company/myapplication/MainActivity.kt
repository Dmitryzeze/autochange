package com.example.company.myapplication

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var count = 1
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("welcome to hell")
            builder.setMessage("Are you want to set the app background color to RED?")
            builder.setPositiveButton("yes") { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    "Ok, we change the app background.",
                    Toast.LENGTH_SHORT
                ).show()
                screen.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
            }
            builder.setNegativeButton("no") { _, _ ->
                Toast.makeText(applicationContext, "You are not agree.", Toast.LENGTH_SHORT).show()
                screen.setBackgroundColor(ContextCompat.getColor(this, R.color.white))

                builder.setNegativeButton("No") { dialog, which ->
                    Toast.makeText(applicationContext, "You are not agree.", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            builder.setNeutralButton("Cancel") { dialog, which ->
                Toast.makeText(applicationContext, "You cancelled the dialog.", Toast.LENGTH_SHORT)
                    .show()
            }


            val dialog: AlertDialog = builder.create()


            dialog.show()

        }
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

                var newString = ""
                if (p0.toString().contains("question")) {

                    Log.d("tag", "$p0")
                    newString = p0.toString().replace("question", "answer")
                    editText.setText(newString)
                    textView.text = count++.toString()
                    Log.d("tag", "$p0")

                }


                if (p0.toString().contains("request")) {
                    newString = p0.toString().replace("request", "response")
                    editText.setText(newString)
                    textView.text = count++.toString()
                }

                if (p0.toString().contains("problem")) {
                    newString = p0.toString().replace("problem", "task")
                    editText.setText(newString)
                    textView.text = count++.toString()
                }
                editText.setSelection(editText.length())

            }

        })

        // Write your code here

    }
}
