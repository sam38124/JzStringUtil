package com.example.translationsample
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.jztranslation.getUrls
import com.example.jztranslation.translate

class MainActivity : AppCompatActivity() {
var handler= Handler()
    var text="测试手机：Nubia Z9 mini，Android 7.1，Mokee Rom\n" +
            "\n" +
            "手机texthttps://blog.csdn.net/ys743276112/article/details/71547134系统语言顺序：hi-IN,en-US,zh-CN,zh-HK\n" +
            "\n" +
            "App 国际化：values,values-zh\n" +
            "\n" +
            "结果是："
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      findViewById<TextView>(R.id.tit).text=text.getUrls()!!.get(0)
        Thread{
            var a="hello".translate("en",this)
            handler.post{findViewById<TextView>(R.id.tit).text=a}
        }.start()
    }

}
