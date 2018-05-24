package com.kasparpeterson.testingexample.bad

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.kasparpeterson.testingexample.R
import kotlinx.android.synthetic.main.layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        sign_up_button.setOnClickListener {
            signUp()
        }
    }

    private fun signUp() {
        if (!isUsernameValid()) {
            Toast.makeText(this, R.string.error_username_invalid, Toast.LENGTH_LONG).show()
        } else if (!isPasswordValid()) {
            Toast.makeText(this, R.string.error_password_invalid, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, R.string.sign_up_successful, Toast.LENGTH_LONG).show()
        }
    }

    private fun isUsernameValid(): Boolean {
        val name = username_edit_text.text.toString()
        return name.length in 6..11
    }

    private fun isPasswordValid(): Boolean {
        val pass = password_edit_text.text.toString()
        return pass.length in 6..11 && containsUpper(pass) && containsDigit(pass)
    }

    private fun containsUpper(string: String): Boolean {
        return string.any { it.isUpperCase() }
    }

    private fun containsDigit(string: String): Boolean {
        return string.any { it.isDigit() }
    }
}
