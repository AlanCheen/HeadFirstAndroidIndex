package me.yifeiyuan.hf.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ${getParam("string")}")  //string value
        Log.d(TAG, "onResume: ${getParam("int")}")      //1
        Log.d(TAG, "onResume: ${getParam("boolean")}")      //true
        Log.d(TAG, "onResume: ${getParam("else")}")     //null
        Log.d(TAG, "onResume: ${getParam("map")}")      //{key1=key1}

        Log.d(TAG, "onResume: -------------")

//        val valueString : Map<String, String> = getTypedParam<Map<String, String>>("else") //null
        Log.d(TAG, "onResume: ${getTypedParam<String>("string")}")
        Log.d(TAG, "onResume: ${getTypedParam<Int>("int")}")
        Log.d(TAG, "onResume: ${getTypedParam<Boolean>("boolean")}")
        Log.d(TAG, "onResume: ${getTypedParam<Map<String, String>>("map")}")//{key1=key1}
        Log.d(TAG, "onResume: ${getTypedParam<Map<String, Int>>("map")}")//{key1=key1}  不会崩溃
        Log.d(TAG, "onResume: ${getTypedParam<Map<Int, Int>>("map")}")//{key1=key1}  不会崩溃
//        Log.d(TAG, "onResume: ${getTypedParam<List<String>>("map")}")//     Caused by: java.lang.ClassCastException: java.util.LinkedHashMap cannot be cast to java.util.List
        Log.d(TAG, "onResume: ${getTypedParam<String>("else")}")

    }

    /**
     * as?
     */
    fun <T> getTypedParam(key: String): T {
        return getParam(key) as T
    }

    fun getParam(key: String): Any? {
        return when (key) {

            "string" -> {
                "string value"
            }
            "int" -> {
                1
            }
            "boolean" -> {
                true
            }
            "map" -> {
                mutableMapOf<String, String>().apply {
                    this["key1"] = "key1"
                }
            }
            else -> null
        }
    }
}