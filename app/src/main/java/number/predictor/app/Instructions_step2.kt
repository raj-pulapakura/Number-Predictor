package number.predictor.app

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import number.predictor.app.R

class Instructions_step2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.instructions_step2)

        val fabNext  = findViewById<Button>(R.id.buttonNext2)
        val textViewInstructions1 = findViewById<TextView>(R.id.textViewInstructions1)
        val textViewInstructions2 = findViewById<TextView>(R.id.textViewInstructions2)
        val textViewInstructions3 = findViewById<TextView>(R.id.textViewInstructions3)

        textViewInstructions1.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.textFontSize / resources.displayMetrics.scaledDensity)
        textViewInstructions2.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.textFontSize / resources.displayMetrics.scaledDensity)
        textViewInstructions3.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.textFontSize / resources.displayMetrics.scaledDensity)
        fabNext.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)

        App_Globals.gameTotal = 0
        fabNext.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Instructions_step3::class.java), 1)
        }
    }

    override fun onBackPressed(){
        App_Globals.transferActivity(this, Intent(this, Instructions_step1::class.java), 2)
    }
}