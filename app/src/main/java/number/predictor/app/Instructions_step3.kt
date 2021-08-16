package number.predictor.app

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import number.predictor.app.R

class Instructions_step3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.instructions_step3)

        val fabNext  = findViewById<Button>(R.id.buttonNext3)
        val textViewInstructions1 = findViewById<TextView>(R.id.textViewInstructions1)

        textViewInstructions1.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.textFontSize / resources.displayMetrics.scaledDensity)
        fabNext.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)

        App_Globals.gameTotal = 0
        fabNext.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Pre_game::class.java), 1)
        }
    }

    override fun onBackPressed(){
        App_Globals.transferActivity(this, Intent(this, Instructions_step2::class.java), 2)
    }
}