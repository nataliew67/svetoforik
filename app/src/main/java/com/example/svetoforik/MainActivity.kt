package com.example.svetoforik
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var redLight: ImageView
    private lateinit var yellowLight: ImageView
    private lateinit var greenLight: ImageView
    private lateinit var changeButt: Button
    private var currentLightIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        redLight = findViewById(R.id.red)
        yellowLight = findViewById(R.id.yellow)
        greenLight = findViewById(R.id.green)
        changeButt = findViewById(R.id.change)

        setInitialLightColor()

        changeButt.setOnClickListener {
            changeLight()
        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("currentLightIndex", currentLightIndex-1)
        super.onSaveInstanceState(outState)}

    private fun setInitialLightColor() {
        redLight.setBackgroundResource(R.drawable.red)
        yellowLight.setBackgroundResource(R.drawable.gray)
        greenLight.setBackgroundResource(R.drawable.gray)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        currentLightIndex = savedInstanceState.getInt("currentLightIndex")

        setInitialLightColor()
        changeLight()

    }
    private fun changeLight() {
        when (currentLightIndex) {
            0 -> {
                redLight.setBackgroundResource(R.drawable.gray)
                yellowLight.setBackgroundResource(R.drawable.yellow)
                greenLight.setBackgroundResource(R.drawable.gray)

                currentLightIndex = 1
            }
            1 -> {
                redLight.setBackgroundResource(R.drawable.gray)
                yellowLight.setBackgroundResource(R.drawable.gray)
                greenLight.setBackgroundResource(R.drawable.green)
                currentLightIndex = 2
            }
            2 -> {
                redLight.setBackgroundResource(R.drawable.gray)
                yellowLight.setBackgroundResource(R.drawable.yellow)
                greenLight.setBackgroundResource(R.drawable.gray)
                currentLightIndex = 3
            }

            3 -> {
                redLight.setBackgroundResource(R.drawable.red)
                yellowLight.setBackgroundResource(R.drawable.gray)
                greenLight.setBackgroundResource(R.drawable.gray)
                currentLightIndex = 0
            }



        }
    }
}