package com.example.user.aula1;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_01;
    private EditText et_01;
    private EditText et_02;
    private Button btn_01;
    private Button btn_02;
    private View.OnClickListener clickListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        tv_01  = findViewById(R.id.tv_01);
        et_01  = findViewById(R.id.et_01);
        et_02  = findViewById(R.id.et_02);
        btn_01 = findViewById(R.id.btn_01);
        btn_02 = findViewById(R.id.btn_02);

        //Implementando ambos os botões
        clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int idBtn = view.getId(); //Armazena o ID do botão clicado

                switch (idBtn){
                    case R.id.btn_01:
                        //Codigo do botão 1
                        String eText1 = et_01.getText().toString(); //Pegando o texto da primeira caixa de texto
                        String eText2 = et_02.getText().toString(); //Pegando o texto da segunda caixa de texto

                        if (eText1.isEmpty() || eText2.isEmpty()) {

                            //cria metodo para exibir mensagem
                            mostrarMsg("Login", "Usuário ou senha em branco!");
                        } else {

                            if (eText1.equalsIgnoreCase("amora") && eText2.equals("dog") ) {

                                //cria uma "intenção" para abrir inicialização da tela com os professores
                                Intent intent  = new Intent(MainActivity.this,Home.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                //Envia para a proxima tela o nome do aluno
                                Bundle bundle = new Bundle();
                                bundle.putString("nome_aluno",eText1);
                                intent.putExtras(bundle);
                                //Inicia a nova tela
                                startActivity(intent);
                                //Mata a tela atual
                                finish();
                            } else {
                                mostrarMsg("Login","Usuário ou senha inválidos.");
                            }

                        }

                        break;

                    case R.id.btn_02:
                        //Codigo do botao 2

                        //limpa os campos editaveis
                        et_01.setText("");
                        et_02.setText("");
                        break;
                }
            }
        };

        // Implementando o primeiro botão
        btn_01.setOnClickListener(clickListener);

        //Implementando o segundo botão
        btn_02.setOnClickListener(clickListener);




    }

    //metodo para criar a caixa de dialogo
    private void mostrarMsg(String titulo, String msg) {
        //construindo o construtor da caixa
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        //atribuindo um título para a caixa de diálogo
        builder.setIcon(R.drawable.ic_error_outline_black_24dp);
        builder.setTitle(titulo);
        builder.setMessage(msg);
        builder.setPositiveButton("OK",null);

        //Exibindo a caixa de dialogo
        AlertDialog dialog = builder.create();
        dialog.show();

    }


}
