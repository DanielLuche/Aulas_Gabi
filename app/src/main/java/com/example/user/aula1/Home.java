package com.example.user.aula1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Home extends AppCompatActivity {

    private TextView tv_aluno;
    private TextView tv_dia1;
    private TextView tv_dia2;
    private TextView tv_dia3;
    private ListView list_prof;
    private String nome_aluno;
    private List<Professor> prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Cria um método para inicializar as variaveis
        iniVars();
    }

    //método para inicializar as variaveis
    private void iniVars() {

        //Resgata a "intenção" de chamar a proxima tela
        nome_aluno = getIntent().getExtras().getString("nome_aluno","Aluno");

        //Inicializa as variáveis
        tv_aluno = findViewById(R.id.home_tv_aluno);
        tv_aluno.setText("Bem-vinda, " + nome_aluno );

        tv_dia1 = findViewById(R.id.home_tv_dia1);

        tv_dia2 = findViewById(R.id.home_tv_dia2);

        tv_dia3 = findViewById(R.id.home_tv_dia3);

        //Criando a lista de professores
        list_prof = findViewById(R.id.home_list_prof);

        gerarListaProf();
        //Joga para o list view
        String[] from = {"imagem","nome"};
        int[] to = {R.id.celula_img_prof,R.id.celula_text_prof};

        SimpleAdapter adapter = new SimpleAdapter(
                this,listaSimples(),R.layout.celula_professor,from,to
        );

        list_prof.setAdapter(adapter);

    }

    private List <HashMap<String,String> > listaSimples() {
        List <HashMap<String,String> > simple_list = new ArrayList<>();
        for (int i = 0 ; i < prof.size(); i++ )
        {
            HashMap<String,String> aux = new HashMap<>();
            aux.put("imagem",String.valueOf(prof.get(i).getFoto()));
            aux.put("nome",prof.get(i).getNome());
            simple_list.add(aux);

        }
        return simple_list;
    }

    private void gerarListaProf() {
        prof = new ArrayList<>();
        //Lista com os professores
        Professor prof1 = new Professor();
        prof1.setNome("Mônica");
        prof1.setFoto(R.drawable.monica);
        prof1.setDias_semana(new int[]{2,4,6}); //SEG QUA SEX

        Professor prof2 = new Professor();
        prof2.setNome("Cebolinha");
        prof2.setFoto(R.drawable.cebolinha);
        prof2.setDias_semana(new int[]{3,5,7}); //TER QUI SAB

        Professor prof3 = new Professor();
        prof3.setNome("Magali");
        prof3.setFoto(R.drawable.magali);
        prof3.setDias_semana(new int[]{3,5,7}); //TER QUI SAB

        Professor prof4 = new Professor();
        prof4.setNome("Nimbus");
        prof4.setFoto(R.drawable.nimbus);
        prof4.setDias_semana(new int[]{2,4,6}); //SEG QUA SEX

        Professor prof5 = new Professor();
        prof5.setNome("Cascão");
        prof5.setFoto(R.drawable.cascao);
        prof5.setDias_semana(new int[]{2,3,4,5,6,7}); //SEG QUA SEX

        Professor prof6 = new Professor();
        prof6.setNome("Franjinha");
        prof6.setFoto(R.drawable.franjinha);
        prof6.setDias_semana(new int[]{2,3,4,5,6,7}); //SEG QUA SEX

        Professor prof7 = new Professor();
        prof7.setNome("Rosinha");
        prof7.setFoto(R.drawable.rosinha);
        prof7.setDias_semana(new int[]{2,4,6}); //SEG QUA SEX

        //Adicionando os professores no ArrayList

        prof.add(prof1);
        prof.add(prof2);
        prof.add(prof3);
        prof.add(prof4);
        prof.add(prof5);
        prof.add(prof6);
        prof.add(prof7);
    }

}
