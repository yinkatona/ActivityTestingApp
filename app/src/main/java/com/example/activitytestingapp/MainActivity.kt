package com.example.activitytestingapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(){

   private var displayTextView = 1



    companion object {
        const val TAG = "Main Activity"
        const val KEY_TEXT = "KEY_TEXT"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate called")

        val displayButton: Button = findViewById(R.id.addButton)
        val textResult: TextView = findViewById(R.id.displayTextView)

        displayButton.setOnClickListener {
           val originalValue = textResult.text.toString().toInt()
            val newValue = originalValue * 2
            textResult.text = newValue.toString()

            Snackbar.make(textResult,"Value $originalValue changed to $newValue",
                Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val viewResult: TextView = findViewById(R.id.displayTextView)
        outState.putString(KEY_TEXT, viewResult.text.toString() )
        Log.d(TAG, "onSaveInstance called")

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val viewResult: TextView = findViewById(R.id.displayTextView)
        viewResult.text = savedInstanceState.getString(KEY_TEXT)
        Log.d(TAG, "onRestoreInstanceState called")
    }

    override fun onStart() {
        super.onStart()
        Log.d( TAG,"onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy called")
    }

}



