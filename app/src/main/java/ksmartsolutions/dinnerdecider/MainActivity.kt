package ksmartsolutions.dinnerdecider

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val foodList = mutableListOf("Chinese", "Burger", "Pizza", "Sticks")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        selectedFoodTextView.text = foodList[Random().nextInt(foodList.size)]



        decideButton.setOnClickListener {
            val index = Random().nextInt(foodList.size)
            selectedFoodTextView.text = foodList[index]
        }



        addFoodButton.setOnClickListener {
            val foodName = addFoodEditText.text.toString()
            if(!foodName.isBlank()) {
                if(!isExistInList(foodList, foodName)) {
                    foodList.add(foodName)
                    Toast.makeText(applicationContext, "This food is added successfully", Toast.LENGTH_SHORT).show()
                }
                else Toast.makeText(applicationContext, "This food is already exists", Toast.LENGTH_SHORT).show()
            }
            addFoodEditText.text.clear()
        }

        addFoodEditText.setOnKeyListener { _, keyCode, event ->
            if(event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val foodName = addFoodEditText.text.toString()
                if(!foodName.isBlank()) {
                    if(!isExistInList(foodList, foodName)) {
                        foodList.add(foodName)
                        Toast.makeText(applicationContext, "This food is added successfully", Toast.LENGTH_SHORT).show()
                    }
                    else Toast.makeText(applicationContext, "This food is already exists", Toast.LENGTH_SHORT).show()
                }
                addFoodEditText.text.clear()
            }
            false
        }
    }

    private fun isExistInList(list: MutableList<String>, item: String): Boolean {
        for(it in list) {
            if (it.toLowerCase() == item.toLowerCase())
                return true
        }
        return false
    }
}
