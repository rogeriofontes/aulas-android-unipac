package unipac.com.br.calculocombustivel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText gasolinaEdt, alcoolEdt;
    Button calcularBtn;
    TextView resultadoTV;

    double gasolina = 0;
    double alcool = 0;
    double resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gasolinaEdt = (EditText) findViewById(R.id.gasolinaEdt);
        alcoolEdt = (EditText) findViewById(R.id.alcoolEdt);
        calcularBtn = (Button) findViewById(R.id.calcularBtn);
        resultadoTV = (TextView) findViewById(R.id.resultadoTV);

        calcularBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gasolinaTxt = gasolinaEdt.getText().toString();
                String alcoolTxt = alcoolEdt.getText().toString();

                if (isNumber(gasolinaTxt) && isNumber(alcoolTxt)) {
                    gasolina = Double.parseDouble(gasolinaTxt);
                    alcool = Double.parseDouble(alcoolTxt);

                    if (resultado > alcool) {
                        Toast.makeText(MainActivity.this, "Compensa usar Alcool", Toast.LENGTH_LONG).show();
                        resultadoTV.setText("Compensa usar Alcool");
                    } else if (resultado < alcool) {
                        Toast.makeText(MainActivity.this, "Compensa usar Gasolina", Toast.LENGTH_LONG).show();
                        resultadoTV.setText("Compensa usar Gasolina");
                    }
                }
            }
        });

    }

    public static boolean isNumber(String string) {
        return string.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}

/*
Para fazer o cálculo é bastante simples: basta pegar o preço do litro da gasolina e multiplicar por 0,7. Se o resultado for maior que o preço do litro do etanol, então vale a pena o etanol; já se for menor, opte pela gasolina.
 */