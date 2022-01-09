package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneButton.setOnClickListener {addNickname(it)}
        binding.hideButton.setOnClickListener {hideShowBio(it)}

//        findViewById<Button>(R.id.done_button).setOnClickListener {addNickname(it)}
//        findViewById<Button>(R.id.hide_button).setOnClickListener {hideShowBio(it)}
    }

    private fun addNickname(view: View) {
        binding.nicknameText.text = binding.nicknameEdit.text
        binding.nicknameEdit.visibility = View.GONE
        binding.doneButton.visibility = View.GONE
        binding.nicknameText.visibility = View.VISIBLE

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun hideShowBio(view: View) {
        val bio = findViewById<TextView>(R.id.bio_text)

        when(bio.visibility) {
            View.GONE -> bio.visibility = View.VISIBLE
            View.VISIBLE -> bio.visibility = View.GONE
        }
    }
}