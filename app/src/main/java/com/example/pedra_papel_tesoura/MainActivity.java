package com.example.pedra_papel_tesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada("Papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }
    public void selecionadoPedra(View view){
      this.opcaoSelecionada("Pedra");
    }
    public void opcaoSelecionada (String escolhaUsuario){
        ImageView imageResultado= findViewById(R.id.imgResultado);
        TextView textResultado= findViewById(R.id.textResultado);

        int numero=new Random().nextInt(3);

        String[]opcoes={"Pedra","Papel","Tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp){
            case "Pedra":
                    imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "Tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
            case "Papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
        }

        if((escolhaApp=="Tesoura" && escolhaUsuario=="Papel")
          || (escolhaApp=="Papel" && escolhaUsuario=="Pedra")
          ||(escolhaApp=="Pedra" && escolhaUsuario=="Tesoura")
        )
        {
            textResultado.setText("Você perdeu");
        }else if((escolhaUsuario=="Tesoura" && escolhaApp=="Papel")
                || (escolhaUsuario=="Papel" && escolhaApp=="Pedra")
                ||(escolhaUsuario=="Pedra" && escolhaApp=="Tesoura")

        ){
            textResultado.setText("Você Ganhou");
        }else{
            textResultado.setText("Empate");
        }



    }
}