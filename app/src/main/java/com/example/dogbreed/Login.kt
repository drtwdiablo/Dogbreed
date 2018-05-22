package com.example.dogbreed

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val currentUser = mAuth.currentUser

        tv_signUp.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        btn_signIn.setOnClickListener {
            signIn()
        }
    }

    private fun signIn(){
        val email = et_email.text.toString()
        val password = et_password.text.toString()

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(this, "Sign In Successful", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Sign In Failed", Toast.LENGTH_LONG).show()
                finish()
                startActivity(Intent(this, Login::class.java))
            }
        }
    }
}
