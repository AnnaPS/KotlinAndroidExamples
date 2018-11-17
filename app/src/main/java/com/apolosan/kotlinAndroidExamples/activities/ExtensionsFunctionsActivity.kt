package com.apolosan.kotlinAndroidExamples.activities


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.apolosan.kotlinAndroidExamples.MainActivity
import com.apolosan.kotlinAndroidExamples.R
import com.apolosan.kotlinAndroidExamples.extensions.*
import com.apolosan.kotlinAndroidExamples.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_extensions_functions.*
import kotlinx.android.synthetic.main.activity_intent_extra.*

class ExtensionsFunctionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extensions_functions)


        buttonToast.setOnClickListener{toastResourceId(R.string.button_toast)}

        buttonSnackBar.setOnClickListener{snackBar("I love Extension Functions",action = "Undo"){toast("You clicked to undo button")}}

        buttonLoadByUrl.setOnClickListener{imageViewLoadedByUrl.loadUrl("https://koenig-media.raywenderlich.com/uploads/2016/07/Kotlin-feature.png")}

        buttonGoToActivity.setOnClickListener{goToActivity<MainActivity>{putExtra("id", 1)}}

    }
}
