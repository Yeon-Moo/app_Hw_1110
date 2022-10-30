package com.example.app_hw_1110_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.btn_order)
        val tv_meal=findViewById<TextView>(R.id.tv_meal)

        btn.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                startActivityForResult(
                    Intent(this@MainActivity, MainActivity2::class.java),
                    1)
            }
        })
    }

    override fun onActivityResult(
        requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val tv_meal=findViewById<TextView>(R.id.tv_meal)
        if(data==null)return
        if(requestCode==1){
            if(resultCode==101){
                    var b:Bundle = data.extras!!
                    var str1=b.getString("drink")
                    var str2=b.getString("sugar")
                    var str3=b.getString("ice")
                    tv_meal.text=String.format("飲料: %s\n\n甜度: " +
                            "%s\n\n冰塊: %s\n\n",str1,str2,str3)
                }
            }



    }
}