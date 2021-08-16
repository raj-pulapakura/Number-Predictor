package number.predictor.app

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Card3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card3)

        val buttonCard3Yes = findViewById<Button>(R.id.buttonCard3Yes)
        val buttonCard3No = findViewById<Button>(R.id.buttonCard3No)
        val fabHome = findViewById<FloatingActionButton>(R.id.fabHome)

        buttonCard3Yes.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)
        buttonCard3No.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)

        buttonCard3Yes.setOnClickListener{
            App_Globals.gameTotal += 4
            App_Globals.transferActivity(this, Intent(this, Card4::class.java), 1)
        }

        buttonCard3No.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Card4::class.java), 1)
        }
        fabHome.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Homescreen::class.java), 2)
        }
    }

    override fun onBackPressed() {
        App_Globals.transferActivity(this, Intent(this, Card2::class.java), 2)
        App_Globals.gameTotal -= 2
    }
}