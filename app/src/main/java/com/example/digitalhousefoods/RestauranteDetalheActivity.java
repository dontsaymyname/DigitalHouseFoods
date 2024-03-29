package com.example.digitalhousefoods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digitalhousefoods.adapters.DetalheAdapter;
import com.example.digitalhousefoods.entidades.Pratos;
import com.example.digitalhousefoods.entidades.Restaurante;
import com.example.digitalhousefoods.interfaces.PratosListener;

import java.util.ArrayList;
import java.util.List;

public class RestauranteDetalheActivity extends AppCompatActivity implements PratosListener {

    private ImageView fotoRestaurante;
    private TextView nomeRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_detalhe);

        fotoRestaurante = findViewById(R.id.detalhe_foto_restaurante);
        nomeRestaurante = findViewById(R.id.detalhe_nome_restaurante_txt);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        Restaurante restaurante = (Restaurante) bundle.getSerializable("RESTAURANTE");

        nomeRestaurante.setText(restaurante.getNameRestaurant());
        fotoRestaurante.setImageResource(restaurante.getImageRestaurant());

        List<Pratos> listaPratos = new ArrayList<>();
        Pratos prato1 = new Pratos();
        prato1.setNomePrato("Salada com molho Gengibre");
        prato1.setFotoPrato(R.drawable.restaurant2);
        prato1.setDescricaoPrato("Salada leve com brotos de decoração e molho gengibre para adicionar um gosto mais exótico ao prato.");
        listaPratos.add(prato1);
        listaPratos.add(prato1);
        listaPratos.add(prato1);
        listaPratos.add(prato1);
        listaPratos.add(prato1);
        listaPratos.add(prato1);
        listaPratos.add(prato1);
        listaPratos.add(prato1);
        listaPratos.add(prato1);
        listaPratos.add(prato1);



        DetalheAdapter detalheAdapter = new DetalheAdapter(listaPratos, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        RecyclerView recyclerView = findViewById(R.id.detalhe_recycler_view);
        recyclerView.setAdapter(detalheAdapter);
        recyclerView.setLayoutManager(layoutManager);



    }

    @Override
    public void onPratoClicado(Pratos pratos) {

        Intent intent = new Intent(this, PratoDetalheActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("PRATOS", pratos);

        intent.putExtras(bundle);

        startActivity(intent);
    }
}
