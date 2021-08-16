package number.predictor.app

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import number.predictor.app.R

class Pre_game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pre_game)

        val buttonGo = findViewById<TextView>(R.id.buttonGo)

        buttonGo.setOnClickListener{
            App_Globals.transferActivity(this, Intent(this, Card1::class.java), 1)
        }

        buttonGo.setTextSize(TypedValue.COMPLEX_UNIT_SP, App_Globals.buttonFontSize / resources.displayMetrics.scaledDensity)


    }

    override fun onBackPressed(){
        App_Globals.transferActivity(this, Intent(this, Homescreen::class.java), 2)
    }
}