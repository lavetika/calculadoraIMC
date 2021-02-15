package castro.diana.asignacion4_calculadoraimc_castro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var resultado: Float = 0f
    var altura: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peso: EditText = findViewById(R.id.peso) as EditText
        val estatura: EditText = findViewById(R.id.estatura) as EditText
        val calcular: Button = findViewById(R.id.calcular) as Button
        val imc: TextView = findViewById(R.id.imc) as TextView
        val rango: TextView = findViewById(R.id.rango) as TextView

        calcular.setOnClickListener {
            altura = (estatura.text.toString().toFloat() * estatura.text.toString().toFloat())
            resultado = (peso.text.toString().toFloat() / altura)
            imc.setText(resultado.toString())

            when(resultado){
               in 0.0..18.4 -> {
                    rango.setText("Bajo peso")
                    rango.setBackgroundResource(R.color.greenish)
                }
                in 18.5..24.9 -> {
                    rango.setText("Normal")
                    rango.setBackgroundResource(R.color.green)
                }
                in 25.0..29.9->{
                    rango.setText("Sobrepeso")
                    rango.setBackgroundResource(R.color.yellow)
                }
                in 30.0..34.9->{
                    rango.setText("Obesidad grado 1")
                    rango.setBackgroundResource(R.color.orange)
                }
                in 35.0..39.9->{
                    rango.setText("Obesidad grado 2")
                    rango.setBackgroundResource(R.color.red)
                }
                in 40.0..100.0->{
                    rango.setText("Obesidad grado 3")
                    rango.setBackgroundResource(R.color.brown)
                }
                else -> {
                    rango.setBackgroundResource(R.color.white)
                }
            }

        }
    }

}