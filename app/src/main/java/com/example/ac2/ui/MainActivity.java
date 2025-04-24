package com.example.ac2.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ac2.R;
import com.example.ac2.database.AppDatabase;
import com.example.ac2.database.Medicamento;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MedicamentoAdapter adapter;
    private FloatingActionButton fabAddMedicamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewMedicamentos);
        fabAddMedicamento = findViewById(R.id.fabAddMedicamento);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MedicamentoAdapter(this);
        recyclerView.setAdapter(adapter);

        fabAddMedicamento.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(intent);
        });

        carregarMedicamentos();
    }

    private void carregarMedicamentos() {
        AppDatabase db = AppDatabase.getInstance(this);
        List<Medicamento> medicamentos = db.medicamentoDao().listarTodos();
        adapter.setMedicamentos(medicamentos);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarMedicamentos();
    }
}