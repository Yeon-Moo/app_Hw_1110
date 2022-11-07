package com.example.app_hw_1110_3

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import android.view.View
import android.view.ViewGroup


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("請選擇功能")
            dialog.setMessage("請根據下方按鈕選擇要顯示的物件")
            dialog.setNeutralButton("取消", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(
                        this@MainActivity,
                        "dialog關閉",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
            dialog.setNegativeButton("自定義toast", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    showToast()
                }
            })
            dialog.setPositiveButton("顯示list", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    showListDialog()
                }
            })
            dialog.show()

        }
    }

    private fun showListDialog() {

        val list = arrayOf("message1", "message2", "message3", "message4", "message5")
        val dialog_list = AlertDialog.Builder(this@MainActivity)
        dialog_list.setTitle("使用list呈現")
        dialog_list.setItems(list, object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Toast.makeText(this@MainActivity, "你選得是" + list[p1], Toast.LENGTH_LONG).show()
            }
        })
        dialog_list.show()

    }

    private fun showToast() {
        val toast = Toast(this@MainActivity)
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.duration = Toast.LENGTH_LONG
        val layout = layoutInflater.inflate(
            R.layout.custom_toast,
            findViewById<View>(R.id.custom_toast_root) as ViewGroup?
        )
        toast.view = layout
        toast.show()
    }

}

