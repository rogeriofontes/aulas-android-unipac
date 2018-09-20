package aula03.unipac.com.br.aula03.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import aula03.unipac.com.br.aula03.R;
import br.com.unipac.aula3.domain.Aluno;

public class AlunoAdaper extends BaseAdapter {
    private List<Aluno> alunos = null;
    private Context context;

    public AlunoAdaper(List<Aluno> alunos, Context context) {
        this.alunos = alunos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int i) {
        return alunos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        Aluno aluno = getItem(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.aluno_item, null);

        TextView nometv = (TextView) view.findViewById(R.id.nomeTv);
        TextView emailtv = (TextView) view.findViewById(R.id.emailTv);

        nometv.setText(aluno.getNome());
        emailtv.setText(aluno.getEmail());

        return view;
    }
}
