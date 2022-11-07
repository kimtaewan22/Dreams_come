package com.example.communityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.communityapp.databinding.ActivitySignInBinding
import com.example.communityapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {
    private var backKeyPressedTime : Long = 0

    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        // sign in 버튼을 눌렀을 때 시행.
        binding.signinBtn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()


            if (email.isNotEmpty() && pass.isNotEmpty()){

                    firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, "이메일이나 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()

                        }
                    }

            }else {
                Toast.makeText(this, "Empty Fields Are not Allowed!", Toast.LENGTH_SHORT ).show()
            }
        }

        // 비밀번호 리셋 버튼을 눌렀을 때 실행.
        binding.resetpass.setOnClickListener {

        }


    }

    //뒤로 가기 버튼을 눌렀을 때 실행되는 함수.
    override fun onBackPressed() {
    //super.onBackPressed()
    if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
        backKeyPressedTime = System.currentTimeMillis()
        Toast.makeText(this, "뒤로가기 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()
        return
    }
    // 2초 이내에 뒤로가기 버튼을 한번 더 클릭시 finish() / 즉 ,앱 종료
    if(System.currentTimeMillis() <= backKeyPressedTime + 2000) {
        finish()
        }
    }

// 주의점*** onstart를 구현했을 경우 기존에 로그인 한적이 있다면 계속 메인 액티비티로 이동하게 될 것이다.
//    override fun onStart() {
//        super.onStart()
//
//        if(firebaseAuth.currentUser != null) {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//
//    }
}