package my.edu.tarc.mybmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Declaration of Variables
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val textviewBMI: TextView = findViewById(R.id.textViewBMI)
        val textviewStatus: TextView = findViewById(R.id.textViewStatus)
        val imageviewBMI: ImageView = findViewById(R.id.imageViewBMI)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById(R.id.buttonReset)

        buttonCalculate.setOnClickListener {
            if (editTextWeight.text.isEmpty()){
                editTextWeight.setError(getString(R.string.error_input))
                return@setOnClickListener //terminate program execution here
            }

            if (editTextHeight.text.isEmpty()){
                editTextHeight.setError(getString(R.string.error_input))
                return@setOnClickListener //terminate program execution
            }
            val weight: Float = editTextWeight.text.toString().toFloat()
            val height = editTextHeight.text.toString().toFloat()
            val bmi = weight/ (height/100).pow(2)
            if(bmi < 18.5){ //underweight
                textviewBMI.text = String.format("%s: %.2f", getString(R.string.bmi), bmi)
                textviewStatus.text = getString(R.string.under)
                imageviewBMI.setImageResource(R.drawable.under)
            }
            else if (bmi >= 18.5 && bmi <= 24.9){ //normal
                textviewBMI.text = String.format("%s: %.2f", getString(R.string.bmi), bmi)
                textviewStatus.text = getString(R.string.normal)
                imageviewBMI.setImageResource(R.drawable.normal)
            }
            else if (bmi > 25) { //overweight
                textviewBMI.text = String.format("%s: %.2f", getString(R.string.bmi), bmi)
                textviewStatus.text = getString(R.string.over)
                imageviewBMI.setImageResource(R.drawable.over)
            }
        }

        buttonReset.setOnClickListener {
            editTextWeight.text.clear()
            editTextHeight.text.clear()
            textviewBMI.text = getString(R.string.bmi)
            textviewStatus.text = getString(R.string.status)
            imageviewBMI.setImageResource(R.drawable.empty)
        }
    }
}