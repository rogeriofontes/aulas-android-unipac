package aula03.unipac.com.br.aula03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import aula03.unipac.com.br.aula03.adapter.AlunoAdaper;
import br.com.unipac.aula3.domain.Aluno;

public class MainActivity extends AppCompatActivity {
    List<Aluno> alunoList = null;
    EditText nameEdt, emailEdt;
    Button salvarBtn;
    ListView listaAlunosLv;
    AlunoAdaper alunoAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdt = (EditText) findViewById(R.id.nameEdt);
        emailEdt = (EditText) findViewById(R.id.emailEdt);
        salvarBtn = (Button) findViewById(R.id.salvarBtn);
        listaAlunosLv = (ListView) findViewById(R.id.listaAlunosLv);

        alunoList = new ArrayList<>();

        salvarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Aluno aluno = new Aluno();
                aluno.setNome(nameEdt.getText().toString());
                aluno.setEmail(emailEdt.getText().toString());

                alunoList.add(aluno);

            }
        });

        alunoAdaper = new AlunoAdaper(alunoList, this);
        listaAlunosLv.setAdapter(alunoAdaper);
    }
}
