package number.predictor.app

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import number.predictor.app.R

class  Card2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card2)

        val buttonCard2Yes = findViewById<Button>(R.id.buttonCard2Yes)
        val buttonCard2No = findViewById<Button>(R.id.buttonCard2No)
        val fabHome = findViewById<FloatingActionButton>(R.id.fabHome)

        buttonCard2Yes.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)
        buttonCard2No.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)

        buttonCard2Yes.setOnClickListener{
            App_Globals.gameTotal += 2
            App_Globals.transferActivity(this, Intent(this, Card3::class.java), 1)
        }

        buttonCard2No.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Card3::class.java), 1)
        }
        fabHome.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Homescreen::class.java), 2)
        }
    }

    override fun onBackPressed() {
        App_Globals.transferActivity(this, Intent(this, Card1::class.java), 2)
        App_Globals.gameTotal -= 1
    }
}