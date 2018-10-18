package sqlite.unipac.com.br.aulaformhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button salvar;
    MainHelper helper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salvar = (Button) findViewById(R.id.salvar);

        helper = new MainHelper(this);

        salvar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                Pessoa pessoa = helper.getPessoa();
                //Banco dados
               Toast.makeText(MainActivity.this, "Pessoa: " + pessoa.toString(), Toast.LENGTH_LONG).show();
           }
        });
    }
}
