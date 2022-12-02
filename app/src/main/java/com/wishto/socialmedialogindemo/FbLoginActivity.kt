package com.wishto.socialmedialogindemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton

class FbLoginActivity : AppCompatActivity() {

    lateinit var btnFacebookLogin: LoginButton
    lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fb)

        callbackManager = CallbackManager.Factory.create()

        btnFacebookLogin = findViewById(R.id.btnFacebookLogin)

        btnFacebookLogin.registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
            override fun onSuccess(loginResult: LoginResult?) {
                goMainScreen()
            }

            override fun onCancel() {
                Toast.makeText(applicationContext, R.string.cancel_login, Toast.LENGTH_SHORT).show()
            }

            override fun onError(error: FacebookException) {
                Toast.makeText(applicationContext, R.string.error_login, Toast.LENGTH_SHORT).show()
                Log.d("onError", "" + error)
            }
        })
    }

    private fun goMainScreen() {
        val intent = Intent(this, FbLoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

/*
    fun openSomeActivityForResult() {
        val intent = Intent(this, SomeActivity::class.java)
        resultLauncher.launch(intent)
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
        }
    }*/

}
