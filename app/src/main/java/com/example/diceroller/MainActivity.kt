package com.example.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button);

        rollButton.setOnClickListener { Roll() }
    }

    private fun Roll() {
        val dice = Dice(6)
        val diceRoll = dice.Roll()
        val dataImage: ImageView = findViewById(R.id.imageView);
        dataImage.setImageResource(R.drawable.dice_2);

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }
        dataImage.setImageResource(drawableResource)


    }
}

class Dice(val numSides: Int) {
    fun Roll(): Int {
        return (1..numSides).random()
    }
}
