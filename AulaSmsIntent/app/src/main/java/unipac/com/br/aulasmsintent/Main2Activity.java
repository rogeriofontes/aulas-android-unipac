package unipac.com.br.aulasmsintent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button chamarSms;
    String username  = null;
    String message = null;
    String numero = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActivityCompat.requestPermissions(this,new String[]{ Manifest.permission.SEND_SMS},1);

        TextView apresentar = (TextView) findViewById(R.id.apresentar);
        chamarSms = (Button) findViewById(R.id.sms);

        Intent i = getIntent();
        Bundle bundle = i.getBundleExtra("meusdados");

        if(bundle != null) {
            username  = bundle.getString("username");
            message  = bundle.getString("message");
            numero =  bundle.getString("numero");
        }

        apresentar.setText(username+ "Mensagem para ser enviada:\n" + message + "para o numero:\n" + numero);

        chamarSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSmsMsgFnc(numero, "@" + username + "|" + message);
                Toast.makeText(getBaseContext(), "SMS Enviado para o número: " + numero, Toast.LENGTH_LONG);
            }
        });
    }

    /**
     * Check if we have SMS permission
     */
    public boolean isSmsPermissionGranted() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED;
    }

    void sendSmsMsgFnc(String mblNumVar, String smsMsgVar)
    {
        if (isSmsPermissionGranted())
        {
            try
            {
                SmsManager smsMgrVar = SmsManager.getDefault();
                smsMgrVar.sendTextMessage(mblNumVar, null, smsMsgVar, null, null);
                Toast.makeText(getApplicationContext(), "Message Sent",
                        Toast.LENGTH_LONG).show();
            }
            catch (Exception ErrVar)
            {
                Toast.makeText(getApplicationContext(),ErrVar.getMessage().toString(),
                        Toast.LENGTH_LONG).show();
                ErrVar.printStackTrace();
            }
        }
        else
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 10);
            }
        }

    }
}
