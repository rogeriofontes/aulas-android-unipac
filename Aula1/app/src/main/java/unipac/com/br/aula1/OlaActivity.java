package unipac.com.br.aula1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OlaActivity extends AppCompatActivity {
    EditText meuTexto;
    Button salvar, chamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ola);

        Toast.makeText(this,"EStou no onCrate()", Toast.LENGTH_SHORT).show();

        meuTexto = (EditText) findViewById(R.id.meuTexto);
        salvar = (Button) findViewById(R.id.salvar);
        chamar = findViewById(R.id.chamar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoDoUsuario = meuTexto.getText().toString();
                Toast.makeText(OlaActivity.this, textoDoUsuario, Toast.LENGTH_LONG).show();
            }
        });

        chamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoDoUsuario = meuTexto.getText().toString();
                Intent i = new Intent(OlaActivity.this, Ola2Activity.class);

                Bundle b = new Bundle();

                b.putString("nome", textoDoUsuario);
                b.putInt("numero", 1);

                i.putExtra("meusdados", b);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"EStou no onStart()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this,"EStou no onResume()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this,"EStou no onPause)", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this,"EStou no onStop()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this,"EStou no onRestart()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this,"EStou no onDestroy()", Toast.LENGTH_SHORT).show();

    }
}
