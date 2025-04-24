package com.example.ac2.ui;



import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ac2.R;
import com.example.ac2.database.AppDatabase;
import com.example.ac2.database.Medicamento;

public class CadastroActivity extends AppCompatActivity {

    private EditText edtNomeMedicamento, edtDescricaoMedicamento, edtHorarioMedicamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNomeMedicamento = findViewById(R.id.edtNomeMedicamento);
        edtDescricaoMedicamento = findViewById(R.id.edtDescricaoMedicamento);
        edtHorarioMedicamento = findViewById(R.id.edtHorarioMedicamento);

        findViewById(R.id.btnSalvarMedicamento).setOnClickListener(this::salvarMedicamento);
    }

    private void salvarMedicamento(View view) {
        String nome = edtNomeMedicamento.getText().toString();
        String descricao = edtDescricaoMedicamento.getText().toString();
        String horario = edtHorarioMedicamento.getText().toString();

        if (nome.isEmpty() || horario.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos obrigatórios!", Toast.LENGTH_SHORT).show();
            return;
        }

        Medicamento medicamento = new Medicamento();
        medicamento.setNome(nome);
        medicamento.setDescricao(descricao);
        medicamento.setHorario(horario);
        medicamento.setConsumido(false);

        AppDatabase db = AppDatabase.getInstance(this);
        db.medicamentoDao().inserir(medicamento);

        Toast.makeText(this, "Medicamento salvo com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }
}