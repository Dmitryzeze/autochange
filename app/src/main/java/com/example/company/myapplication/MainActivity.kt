package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var count = 1
        setContentView(R.layout.activity_main)
        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun afterTextChanged(p0: Editable?) {

                var newString = ""
                if (p0.toString().contains("question")){

                    Log.d("tag", "$p0")
                    newString = p0.toString().replace("question","answer")
                    editText.setText(newString)
                    Log.d("tag", "$p0")

                }


                if (p0.toString().contains("request")){
                    newString = p0.toString().replace("request","response")
                    editText.setText(newString)
                    textView.text = count++.toString()}

                if (p0.toString().contains("problem")){
                    newString = p0.toString().replace("problem","task")
                    editText.setText(newString)
                    textView.text = count++.toString()}
                editText.setSelection(editText.length())

            }

        })

        // Write your code here

    }
}
