package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

// This app is a simulation of a dice roll
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }

        // Do a dice roll when the app starts so is more intuitive for the user
        rollDice()
    }

    /** Creates a numSides sided Dice
     * Creates a variable for the result of the roll
     * Creates a variable of the ImageView type to show the results*/
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)

        //** drawableResource is a variable that stores the when result
        // This saves writing setImageResource many times
        // Also, the "when" needs an else now to be exhaustive*/
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageResource to the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }

        class Dice(private val numSides: Int) {
            fun roll(): Int {
                return (1..numSides).random()
            }
        }

}