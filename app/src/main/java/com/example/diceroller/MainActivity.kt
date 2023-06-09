package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            /* val toast = Toast.makeText(this,"Dice Rolled!",Toast.LENGTH_SHORT)
            toast.show() */

            /* val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text = "6" */

            rollDice()
            rollSecondDice()
        }
        //we are showing random number in first look of the application
        rollDice()
        rollSecondDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        /* val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString() */
        /* Burayı text olarak yazdırırken kullanmıştık foto ekleyince gerek kalmadı */

        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

    }

    private fun rollSecondDice(){
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView2)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int){
    fun roll() : Int{
        return(1..numSides).random()
    }
}