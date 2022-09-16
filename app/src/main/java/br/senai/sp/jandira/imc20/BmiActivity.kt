package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import br.senai.sp.jandira.imc20.databinding.ActivityBmiBinding
import br.senai.sp.jandira.imc20.databinding.ActivityMainBinding
import br.senai.sp.jandira.imc20.model.User
import kotlin.math.roundToInt

class BmiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()

        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadProfile()
        binding.buttonCalculate.setOnClickListener{
            bmiCalculate()
        }
    }

    private fun bmiCalculate() {
        val user = User()
        val openResult = Intent(this, ResultBmiActivity::class.java)
        val dados = getSharedPreferences("dados", MODE_PRIVATE)
        val edit = dados.edit()

        if(binding.editTextWeightCalculate.text.isEmpty()){
            val weight = dados.getFloat("weight", 0.0f)
            openResult.putExtra("weight", weight.toDouble())
        }
        else{
            user.weight = binding.editTextWeightCalculate.text.toString().toDouble().toInt()
            edit.putFloat("weight", user.weight.toFloat())
            openResult.putExtra("weight", binding.editTextWeightCalculate.text.toString().toDouble())
        }
        if (binding.editTextHeightCalculate.text.isEmpty()){
            val height = dados.getFloat("height", 0.0f)
            openResult.putExtra("height", dados.getFloat("height", 00F))
            openResult.putExtra("height", height.toDouble())
        }
        else{

            user.height = binding.editTextHeightCalculate.text.toString().toDouble()
            edit.putFloat("height", user.height.toFloat())
            openResult.putExtra("height", binding.editTextHeightCalculate.text.toString().toDouble())
        }

        startActivity(openResult)
        edit.commit()
    }


    private fun loadProfile() {
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        binding.textViewUsername.text = dados.getString("name", "")
        binding.textViewHigh.text = "Height: ${dados.getFloat("height", 0.00F)}"
        binding.textViewWeight.text = "Weight: ${dados.getFloat("weight", 0.0F)}"
        binding.textViewEmail.text = dados.getString("email", "")

    }
}