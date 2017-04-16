package com.impacta.maxwel_isaac.prova_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
/**
 * Created by maxwe on 16/04/2017.
 */
public class TelaInicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        Button botaoCadastroProduto = (Button)findViewById(R.id.botaoCadasto);
        botaoCadastroProduto.setOnClickListener(onClickCadastro());
    }

    private View.OnClickListener onClickCadastro() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicialActivity.this, CadastroProdutoActivity.class);
                startActivity(intent);
            }
        };
    }
}