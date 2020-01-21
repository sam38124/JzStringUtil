package com.example.jztranslation

import android.content.Context
import android.os.Build
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.*
import java.util.regex.Pattern


 fun String.translate(
            langFrom: String, langTo: String
        ): String {
            return try {
                val url = "https://translate.googleapis.com/translate_a/single?" +
                        "client=gtx&" +
                        "sl=" + langFrom +
                        "&tl=" + langTo +
                        "&dt=t&q=" + URLEncoder.encode(this, "UTF-8")
                val obj = URL(url)
                val con = obj.openConnection() as HttpURLConnection
                con.setRequestProperty("User-Agent", "Mozilla/5.0")
                val `in` = BufferedReader(
                    InputStreamReader(con.inputStream)
                )
                var inputLine: String?
                val response = StringBuffer()
                while (`in`.readLine().also { inputLine = it } != null) {
                    response.append(inputLine)
                }
                `in`.close()
                if (response.toString().contains("\"")) {
                }
                val jsonArray = JSONArray(response.toString())
                if (jsonArray.length() == 0) {
                    return "Translation error"
                }
                val jsonArray2 = jsonArray[0] as JSONArray
                if (jsonArray2.length() == 0) {
                    "Translation error"
                } else (jsonArray2[0] as JSONArray)[0].toString()
            } catch (e: Exception) {
                e.fillInStackTrace()
                "Translation error"
            }
        }

fun String.translate(
    langFrom: String
,context: Context): String {
    return try {
        var locale: Locale? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = context.resources.configuration.locales[0]
        } else {
            locale = context.resources.configuration.locale
        }
        val url = "https://translate.googleapis.com/translate_a/single?" +
                "client=gtx&" +
                "sl=" + langFrom +
                "&tl=" + locale.toString() +
                "&dt=t&q=" + URLEncoder.encode(this, "UTF-8")
        val obj = URL(url)
        val con = obj.openConnection() as HttpURLConnection
        con.setRequestProperty("User-Agent", "Mozilla/5.0")
        val `in` = BufferedReader(
            InputStreamReader(con.inputStream)
        )
        var inputLine: String?
        val response = StringBuffer()
        while (`in`.readLine().also { inputLine = it } != null) {
            response.append(inputLine)
        }
        `in`.close()
        if (response.toString().contains("\"")) {
        }
        val jsonArray = JSONArray(response.toString())
        if (jsonArray.length() == 0) {
            return "Translation error"
        }
        val jsonArray2 = jsonArray[0] as JSONArray
        if (jsonArray2.length() == 0) {
            "Translation error"
        } else (jsonArray2[0] as JSONArray)[0].toString()
    } catch (e: Exception) {
        e.fillInStackTrace()
        "Translation error"
    }
}
fun String.getUrls(): ArrayList<String>? {
    val link = ArrayList<String>()
    var string = this
    //把中文替换为#
    string = string.replace("http", " http")
    string = string.replace("[\u4E00-\u9FA5]".toRegex(), "#").replace(" ".toRegex(), "#")
        .replace("\n".toRegex(), "#").replace("\t", "#")
    val url = string.split("#").toTypedArray()
    //转换为小写
    if (url != null && url.size > 0) {
        var tempurl: String
        for (a in url) {
            tempurl=a
            if (a.isEmpty()) {
                continue
            }
            var urL=tempurl;
            tempurl = tempurl.toLowerCase()
            val regex = ("^((https|http|rtsp|mms)?://)"
                    + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
                    + "|" // 允许IP和DOMAIN（域名）
                    + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.
                    + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名
                    + "[a-z]{2,6})" // first level domain- .com or .museum
                    + "(:[0-9]{1,4})?" // 端口- :80
                    + "((/?)|" // a slash isn't required if there is no file name
                    + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$")
            val p = Pattern.compile(regex)
            val matcher = p.matcher(tempurl)
            if (matcher.find()) {
                link.add(urL)
            }
        }
    }
    return link
}
fun String.autoTranslate(context: Context): String {
    return try {
        var locale: Locale? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = context.resources.configuration.locales[0]
        } else {
            locale = context.resources.configuration.locale
        }
        val url = "https://translate.googleapis.com/translate_a/single?" +
                "client=gtx&" +
                "sl=auto"+
                "&tl=" + locale.toString() +
                "&dt=t&q=" + URLEncoder.encode(this, "UTF-8")
        val obj = URL(url)
        val con = obj.openConnection() as HttpURLConnection
        con.setRequestProperty("User-Agent", "Mozilla/5.0")
        val `in` = BufferedReader(
            InputStreamReader(con.inputStream)
        )
        var inputLine: String?
        val response = StringBuffer()
        while (`in`.readLine().also { inputLine = it } != null) {
            response.append(inputLine)
        }
        `in`.close()
        if (response.toString().contains("\"")) {
        }
        val jsonArray = JSONArray(response.toString())
        if (jsonArray.length() == 0) {
            return "Translation error"
        }
        val jsonArray2 = jsonArray[0] as JSONArray
        if (jsonArray2.length() == 0) {
            "Translation error"
        } else (jsonArray2[0] as JSONArray)[0].toString()
    } catch (e: Exception) {
        e.fillInStackTrace()
        "Translation error"
    }
}
