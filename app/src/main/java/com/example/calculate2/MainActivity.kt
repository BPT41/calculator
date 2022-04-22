package com.example.calculate2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.contracts.Returns

class MainActivity : AppCompatActivity() {
    private lateinit var mEditNum1: EditText
    private lateinit var mEditNum2: EditText
    private lateinit var mTextResult: TextView
    private lateinit var mTextOp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditNum1 = findViewById(R.id.editText1)
        mEditNum2 = findViewById(R.id.editText2)
        mTextResult = findViewById(R.id.TextView_result)
        mTextOp = findViewById(R.id.textView_op)

        findViewById<Button>(R.id.button_plus).apply {
            setOnClickListener {
                calculate(this.text.toString())
            }
        }
        findViewById<Button>(R.id.button_minus).apply {
            setOnClickListener {
                calculate(this.text.toString())
            }
        }
        findViewById<Button>(R.id.button_multiply).apply {
            setOnClickListener {
                calculate(this.text.toString())
            }
        }
        findViewById<Button>(R.id.button_divide).apply {
            setOnClickListener {
                calculate(this.text.toString())
            }
        }
    }

    private fun calculate(op: String) {
        mTextOp.text = op
        val n1 = mEditNum1.text.trim().toString()
        val n2 = mEditNum2.text.trim().toString()
        if (n1.isEmpty() || n2.isEmpty()) {
            mTextResult.text = ""
            return
        }

        val num1 = n1.toDouble()
        val num2 = n2.toDouble()
        var r = when (op) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "x" -> num1 * num2
            else -> num1 / num2
        }
        mTextResult.text = if (r % 1 == 0.000) "${r.toInt()}" else "$r"
    }
}

