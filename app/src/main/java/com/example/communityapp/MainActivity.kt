package com.example.communityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    // 기존의 뒤로가기 버튼의 기능 제거.
    private var backKeyPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


//    override fun onBackPressed() {
//        //super.onBackPressed()
//        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
//            backKeyPressedTime = System.currentTimeMillis()
//            Toast.makeText(this, "뒤로가기 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()
//            return
//        }
//        // 2초 이내에 뒤로가기 버튼을 한번 더 클릭시 finish() / 즉 ,앱 종료
//        if(System.currentTimeMillis() <= backKeyPressedTime + 2000) {
//            val intent1 = Intent(this, SignInActivity::class.java)
//            finishAffinity()
//            startActivity(intent1)
//
//        }
//    }
}