package com.example.dogbreed

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    val mDatabase = FirebaseDatabase.getInstance().getReference()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val currentUser = mAuth.currentUser
        btn_signUp.setOnClickListener(){
            signUp()
        }

    }

    private fun signUp(){

        val email = et_email.text.toString()
        val password = et_password.text.toString()

        println(email.toString() + " " + password.toString())

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->

            if(task.isSuccessful){
                Toast.makeText(this, "Registration successful", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, Login::class.java))
            } else {
                Toast.makeText(this, "Registration failed", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, Register::class.java))
            }
        })
    }
}
