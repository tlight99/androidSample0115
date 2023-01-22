package com.kyle.sample0115

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        // supportActionBar!!.setIcon(R.drawable.pici_icon)

        var voteCount = IntArray(9)
        for (i in 0..8)
            voteCount[i] = 0

        var image = arrayOfNulls<ImageView>(9) // 9개의 이미지를 버튼 객체로 배열화 한다.
        var imageId = arrayOf(R.id.imgView1, R.id.imgView2, R.id.imgView3, R.id.imgView4, R.id.imgView5, R.id.imgView6, R.id.imgView7,R.id.imgView8,R.id.imgView9)

        var imgName = arrayOf("동물1", "동물2", "동물3","동물4","동물5","동물6","동물7","동물8","동물9",)

        for(i in imageId.indices){ // indices는 코틀린 for문에서 배열화된 list요소를 처리하는 명령어( ex) arrayOf )
            image[i] = findViewById<ImageView>(imageId[i])
            image[i]!!.setOnClickListener{
                voteCount[i]++
                Toast.makeText(applicationContext, imgName[i] + ": 총 " + voteCount[i] + "번 선택", Toast.LENGTH_SHORT).show()
            }
        }

        var btnFinish = findViewById<Button>(R.id.btnResult)
        btnFinish.setOnClickListener {
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("VoteCount", voteCount)
            intent.putExtra("ImageName", imgName)
            startActivity(intent)
        }
    }
}