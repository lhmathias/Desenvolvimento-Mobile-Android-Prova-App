package com.impacta.maxwel_isaac.prova_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        TextView texto  = (TextView) findViewById(R.id.mensagemInicio);
        texto.setText(R.string.mensagem_login_activity);

        TextView campoUsuario = (TextView) findViewById(R.id.campoUsuario);
        TextView campoSenha = (TextView) findViewById(R.id.campoSenha);

        String txtUsuario = campoUsuario.toString();
        String txtSenha = campoSenha.toString();

        Button botao = (Button)findViewById(R.id.botaoLogin);

        botao.setOnClickListener(onClickLogin());
    }

    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                TextView campoUsuario = (TextView) findViewById(R.id.campoUsuario);
                TextView campoSenha = (TextView) findViewById(R.id.campoSenha);

                String txtUsuario = campoUsuario.getText().toString();
                String txtSenha = campoSenha.getText().toString();

                //Toast.makeText(MainActivity.this, "Usuário: " + txtUsuario + "; Senha: " + txtSenha, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, TelaInicialActivity.class);

                Bundle params = new Bundle();
                params.putString("nome", txtUsuario);
                intent.putExtras(params);

                startActivity(intent);
            }
        };
    }
}
