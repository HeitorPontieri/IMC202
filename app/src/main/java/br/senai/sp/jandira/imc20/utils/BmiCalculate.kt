package br.senai.sp.jandira.imc20.utils

import kotlin.math.pow

//chamando/criando os métpdps da classe User
fun getBmi(weight: Double, height: Double):Double{
      return weight/height.pow(2)
}

//responsabilidade única (só faz uma coisa)
fun getStatusBmi(bmi: Double):String{
    //val = const (variável imutável)
    //var = mutável

    if(bmi<=18.5){
        return "Abaixo do peso"
    }else if(bmi >18.5 && bmi<=24.9){
        return "Peso ideal"
    }else if(bmi>=25 && bmi<30){
        return "Levemente acima do peso"
    }else if(bmi>=30 && bmi<35){
        return "Obesidade grau 1"
    }else if(bmi>=35 && bmi<40){
        return "Obesidade grau 2"
    }else if (bmi > 40){
        return "Obesidade grau 3"
    }
    else{
        return "ERROR"
    }

}