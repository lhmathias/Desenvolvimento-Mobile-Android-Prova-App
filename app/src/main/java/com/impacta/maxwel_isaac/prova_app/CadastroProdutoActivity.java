package com.impacta.maxwel_isaac.prova_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by maxwel on 16/04/2017.
 */

public class CadastroProdutoActivity extends AppCompatActivity {

    private String nome;
    private String valor;
    private String categoria;
    private boolean favorito;

    private EditText nomeProduto;
    private EditText valorProduto;
    private EditText categoriaProduto;
    private CheckBox favoritoCheckBox;
    private Button botaoSalvarProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_produto);

        nomeProduto         = (EditText) findViewById(R.id.nomeProduto);
        valorProduto        = (EditText) findViewById(R.id.ValorProduto);
        categoriaProduto    = (EditText) findViewById(R.id.categoriaProduto);
        favoritoCheckBox    = (CheckBox) findViewById(R.id.favoritoCheckBox);
        botaoSalvarProduto  = (Button)findViewById(R.id.botaoSalvarProduto);

        botaoSalvarProduto.setOnClickListener(onClickSalvarProduto());
    }

    private View.OnClickListener onClickSalvarProduto(){
        return new View.OnClickListener() {
            public void onClick(View v) {

                nome        = nomeProduto.getText().toString();
                valor       = valorProduto.getText().toString();
                categoria   = categoriaProduto.getText().toString();

                if (favoritoCheckBox.isChecked()) {
                    favorito = true;
                } else {
                    favorito = false;
                }

                Intent devolve = new Intent();
                devolve.putExtra("nomeProduto",nome);
                devolve.putExtra("valorProduto",valor);
                devolve.putExtra("categoriaProduto",categoria);
                devolve.putExtra("favoritoCheckBox",favorito);

                setResult(RESULT_OK, devolve);
                finish();
            }
        };
    }
}
