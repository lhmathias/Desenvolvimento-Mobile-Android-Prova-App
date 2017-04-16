package com.impacta.maxwel_isaac.prova_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by maxwel on 16/04/2017.
 */

public class CadastroProdutoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_produto);

        Button botaoSalvarProduto = (Button)findViewById(R.id.botaoSalvarProduto);
        botaoSalvarProduto.setOnClickListener(onClickSalvarProduto());
    }

    private View.OnClickListener onClickSalvarProduto(){
        return new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(CadastroProdutoActivity.this, TelaInicialActivity.class);
                startActivity(intent);
            }
        };
    }
}
