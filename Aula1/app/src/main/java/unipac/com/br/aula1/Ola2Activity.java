package unipac.com.br.aula1;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Ola2Activity extends AppCompatActivity {
    Button chamarSms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ola2);

        ActivityCompat.requestPermissions(this,new String[]{ Manifest.permission.SEND_SMS},1);

        TextView apresentar = (TextView) findViewById(R.id.apresentar);
        chamarSms = (Button) findViewById(R.id.sms);

        //Bundle extras = getIntent().getExtras();
       // if (extras != null) {
       //     String number = extras.getString("number");
        //    String message = extras.getString("message");

        Intent i = getIntent();
        Bundle bundle = i.getBundleExtra("meusdados");
        String nome  = null;
        Integer numero = 0;

        if(bundle != null) {
            nome  = bundle.getString("nome");
            numero =  bundle.getInt("numero");
        }

        apresentar.setText("O nome é" + nome + "O numero é" + numero);


        chamarSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("9999999999", null, "mensage", null, null);

                Toast.makeText(getBaseContext(), "SMS Enviado", Toast.LENGTH_LONG);

            }
        });
    }
}
