package curso.kotlin.appgastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import curso.kotlin.appgastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)

    }

    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString() != ""
            && binding.editPriceValue.text.toString() != ""
            && binding.editAutonomy.text.toString() != ""
            && binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_Calculate) {
            calcute()
        }

    }

    private fun calcute() {
        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPriceValue.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        } else {
            Toast.makeText(this, R.string.validation_fill_all_fields, Toast.LENGTH_SHORT).show()
        }
    }
}