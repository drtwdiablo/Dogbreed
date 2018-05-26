package com.example.dogbreed

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_signUp.setOnClickListener {
            signUp(et_email.text.toString(), et_password.text.toString())
        }
    }

    private fun signUp(email: String, password: String){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(this, "Registration successful", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, Login::class.java))
            } else {
                Toast.makeText(this, "Registration failed", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, Register::class.java))
            }
        }
    }
}
