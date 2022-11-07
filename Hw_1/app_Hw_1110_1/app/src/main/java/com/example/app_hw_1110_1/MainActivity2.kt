package com.example.app_hw_1110_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var sugar="無糖"
        var ice="去冰"
        val set_drink=findViewById<EditText>(R.id.drink_name)
        var rg_sugar=findViewById<RadioGroup>(R.id.rg_sugar)
        val rg_ice=findViewById<RadioGroup>(R.id.rg_ice)

        rg_sugar.setOnCheckedChangeListener(
            object: RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                when (p1){
                    R.id.btn_sugar_half->sugar="半糖"
                    R.id.btn_sugar_no->sugar="無糖"
                    R.id.btn_sugar_low->sugar="少糖"
                    R.id.btn_sugar_normal->sugar="全糖"
                }

            }

        })
        rg_ice.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                when(p1){
                    R.id.btn_ice_no->ice="去冰"
                    R.id.btn_ice_low->ice="微冰"
                    R.id.btn_ice_normal->ice="正常冰"
                }
            }
        })
        val send_btn=findViewById<Button>(R.id.btn_send)
        send_btn.setOnClickListener {
            var drink = set_drink.text.toString()
            var i=Intent()
            var b =Bundle()
            b?.putString("drink", drink)
            b?.putString("sugar", sugar)
            b?.putString("ice", ice)

            i.putExtras(b)
            setResult(101,i)
            finish()
        }
    }
}
