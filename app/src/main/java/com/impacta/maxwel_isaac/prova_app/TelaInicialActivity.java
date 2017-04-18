package com.impacta.maxwel_isaac.prova_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.R.drawable;

/**
 * Created by maxwe on 16/04/2017.
 */
public class TelaInicialActivity extends AppCompatActivity {
    private TextView nomeProduto;
    private TextView valorProduto;
    private TextView categoriaProduto;
    private ImageView imagemFavorito;
    private Button botaoCadastroProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        nomeProduto         = (TextView) findViewById(R.id.nomeProduto);
        valorProduto        = (TextView) findViewById(R.id.valorProduto);
        categoriaProduto    = (TextView) findViewById(R.id.CategoriaProduto);
        imagemFavorito  = (ImageView) findViewById(R.id.imagemFavorito);

        botaoCadastroProduto = (Button)findViewById(R.id.botaoCadasto);
        botaoCadastroProduto.setOnClickListener(onClickCadastro());
    }

    private View.OnClickListener onClickCadastro() {
        return new View.OnClickListener() {
            public void onClick(View v) {

                nomeProduto.setText("");
                valorProduto.setText("");
                categoriaProduto.setText("");

                nomeProduto.setVisibility(View.INVISIBLE);
                valorProduto.setVisibility(View.INVISIBLE);
                categoriaProduto.setVisibility(View.INVISIBLE);
                imagemFavorito.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(TelaInicialActivity.this, CadastroProdutoActivity.class);
                startActivityForResult(intent,1);
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == -1){
            String nome  = data.getStringExtra("nomeProduto");
            String valor     = data.getStringExtra("valorProduto");
            String categoria =  data.getStringExtra("categoriaProduto");
            Boolean favorito =  data.getExtras().getBoolean("favoritoCheckBox");

            nomeProduto.setVisibility(View.VISIBLE);
            valorProduto.setVisibility(View.VISIBLE);
            categoriaProduto.setVisibility(View.VISIBLE);
            imagemFavorito.setVisibility(View.VISIBLE);

            nomeProduto.setText(nome);
            valorProduto.setText(valor);
            categoriaProduto.setText(categoria);

            if(favorito){
                imagemFavorito.setImageResource(drawable.btn_star_big_on);
            }else{
                imagemFavorito.setImageResource(drawable.btn_star_big_off);
            }
        }
    }
}