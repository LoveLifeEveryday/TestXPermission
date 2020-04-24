package com.xcynice.textpermission

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.xpermissions.xcynice.XPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnMultiPermission.setOnClickListener {
            XPermission.request(
                this,
                // 这里的权限可以是单个或者多个，权限之间用逗号『，』隔开即可
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CONTACTS
                // allGranted 是一个 boolean 类型的变量，若为 true ,则所有权限申请通过
                // deniedList 是一个 List 类型的变量，表示用户拒绝权限列表
            ) { allGranted, deniedList ->
                if (allGranted) {
                    Toast.makeText(this, "All permissions are granted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You denied $deniedList", Toast.LENGTH_SHORT).show()
                }
            }
        }
        btnOnePermission.setOnClickListener {
            XPermission.request(this, Manifest.permission.CAMERA) { allGranted, deniedList ->
                if (allGranted) {
                    Toast.makeText(this, "All permissions are granted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You denied $deniedList", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}
