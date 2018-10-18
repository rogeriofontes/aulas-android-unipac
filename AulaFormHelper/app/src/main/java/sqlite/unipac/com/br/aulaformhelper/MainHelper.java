package sqlite.unipac.com.br.aulaformhelper;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class MainHelper {
    Activity activity = null;
    Pessoa pessoa;
    EditText nome, email;

    public MainHelper(Activity activity) {
        this.activity = activity;
        nome = (EditText) this.activity.findViewById(R.id.nome);
        email = (EditText) this.activity.findViewById(R.id.email);
    }

    public Pessoa getPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome.getText().toString());
        pessoa.setEmail(email.getText().toString());
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        nome.setText(pessoa.getNome());
        email.setText(pessoa.getEmail());
        this.pessoa = pessoa;
    }
}
