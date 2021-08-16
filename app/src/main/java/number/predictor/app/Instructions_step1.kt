package number.predictor.app

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import number.predictor.app.R

class Instructions_step1 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.instructions_step1)

        val fabNext  = findViewById<Button>(R.id.buttonNext1)
        val textViewInstructions1 = findViewById<TextView>(R.id.textViewInstructions1)
        val textViewInstructions2 = findViewById<TextView>(R.id.textViewInstructions2)

        App_Globals.textFontSize = (textViewInstructions1.textSize)

        textViewInstructions1.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_NONE)

        textViewInstructions1.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.textFontSize / resources.displayMetrics.scaledDensity)
        textViewInstructions2.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.textFontSize / resources.displayMetrics.scaledDensity)
        fabNext.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)

        println(App_Globals.textFontSize)

        App_Globals.gameTotal = 0
        fabNext.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Instructions_step2::class.java), 1)
        }
    }

    override fun onBackPressed(){
        App_Globals.transferActivity(this, Intent(this, Homescreen::class.java), 2)
    }
}