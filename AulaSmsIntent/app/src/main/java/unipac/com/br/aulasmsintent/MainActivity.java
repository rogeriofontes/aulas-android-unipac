package unipac.com.br.aulasmsintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usernameEdt, messageEdt, numeroEdt;
    Button chamarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,"EStou no onCrate()", Toast.LENGTH_SHORT).show();

        usernameEdt = (EditText) findViewById(R.id.usernameEdt);
        messageEdt = (EditText) findViewById(R.id.messageEdt);
        numeroEdt = (EditText) findViewById(R.id.numeroEdt);
        chamarBtn = (Button) findViewById(R.id.chamarBtn);

        chamarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEdt.getText().toString();
                String message = messageEdt.getText().toString();
                String numero = numeroEdt.getText().toString();

                Intent i = new Intent(MainActivity.this, Main2Activity.class);

                Bundle b = new Bundle();

                b.putString("username", username);
                b.putString("message", message);
                b.putString("numero", numero);

                i.putExtra("meusdados", b);
                startActivity(i);
            }
        });

    }
}
