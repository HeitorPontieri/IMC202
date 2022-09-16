package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import br.senai.sp.jandira.imc20.databinding.ActivityBmiBinding
import br.senai.sp.jandira.imc20.databinding.ActivityResultBmiBinding
import br.senai.sp.jandira.imc20.utils.getBmi
import br.senai.sp.jandira.imc20.utils.getStatusBmi

class ResultBmiActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBmiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()

        binding = ActivityResultBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recuperar valores que estão na intent
        val weight = intent.getDoubleExtra("weight", 0.0)
        val height = intent.getDoubleExtra("height", 0.0)

        val resultBmiCalculate = getBmi(weight, height)

        binding.textViewResult.text = String.format("%.2f", resultBmiCalculate)
        binding.textViewStatus.text = getStatusBmi(resultBmiCalculate)
    }
}