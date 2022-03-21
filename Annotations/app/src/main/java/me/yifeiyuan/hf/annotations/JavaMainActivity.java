package me.yifeiyuan.hf.annotations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class JavaMainActivity extends AppCompatActivity {

    private static final String TAG = "JavaMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_main);

        JavaRuntimeAnnotation javaRuntimeAnnotation = JavaRuntimeAnnotationImpl.class.getAnnotation(JavaRuntimeAnnotation.class);
        Log.d(TAG, "onCreate javaRuntimeAnnotation: "+javaRuntimeAnnotation.stringValue()); // JavaRuntimeAnnotationImpl
        Log.d(TAG, "onCreate javaRuntimeAnnotation: "+javaRuntimeAnnotation.intValue()); // 1

        // 运行的时候  JavaClassAnnotation 和 JavaSourceAnnotation 都找不到，都为 null
        //      Caused by: java.lang.NullPointerException: Attempt to invoke interface method 'java.lang.String me.yifeiyuan.hf.annotations.JavaClassAnnotation.stringValue()' on a null object reference
//        JavaClassAnnotation JavaClassAnnotation = JavaClassAnnotationImpl.class.getAnnotation(JavaClassAnnotation.class);
//        Log.d(TAG, "onCreate JavaClassAnnotation: "+JavaClassAnnotation.stringValue());
//        Log.d(TAG, "onCreate JavaClassAnnotation: "+JavaClassAnnotation.intValue());

        //      Caused by: java.lang.NullPointerException: Attempt to invoke interface method 'java.lang.String me.yifeiyuan.hf.annotations.JavaSourceAnnotation.stringValue()' on a null object reference
//        JavaSourceAnnotation JavaSourceAnnotation = JavaSourceAnnotationImpl.class.getAnnotation(JavaSourceAnnotation.class);
//        Log.d(TAG, "onCreate JavaSourceAnnotation: "+JavaSourceAnnotation.stringValue());
//        Log.d(TAG, "onCreate JavaSourceAnnotation: "+JavaSourceAnnotation.intValue());

    }
}