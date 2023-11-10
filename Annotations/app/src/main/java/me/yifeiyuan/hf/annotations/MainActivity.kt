package me.yifeiyuan.hf.annotations

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        layoutInflater.setFactory2(MyFactory2())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        val toReplace = findViewById<TextView>(R.id.toReplace)

        val tag = toReplace.getTag();

        Log.d(TAG, "onResume: " + tag)

        val button = findViewById<Button>(R.id.button)   // MaterialButton
        Log.d(TAG, "onResume: " + button)
    }


    class MyFactory2 : LayoutInflater.Factory2 {
        override fun onCreateView(
            parent: View?,
            name: String,
            context: Context,
            attributeSet: AttributeSet
        ): View? {

            Log.d(
                TAG,
                "onCreateView() called with: parent = $parent, name = $name, context = $context, attributeSet = $attributeSet"
            )

            if (name == "TextView") {
                //http://schemas.android.com/apk/res-auto
                val value = attributeSet.getAttributeValue(
                    "http://schemas.android.com/apk/res/android",
                    "tag"
                )
                Log.d(TAG, "onCreateView: " + value)
                if (value != null && value.toString().contains("case")) {
                    return MyTextView(context, attributeSet).apply {
                        testFeature()
                    }
                }
            }

            if (context is AppCompatActivity) {
                return context.delegate.createView(parent,name,context,attributeSet)
            }

            return null
        }

        override fun onCreateView(
            name: String,
            context: Context,
            attributeSet: AttributeSet
        ): View? {
            Log.d(
                TAG,
                "onCreateView() called with: name = $name, context = $context, attributeSet = $attributeSet"
            )
            if (name == "TextView") {
                return MyTextView(context, attributeSet)
            }
            return null
        }
    }
}