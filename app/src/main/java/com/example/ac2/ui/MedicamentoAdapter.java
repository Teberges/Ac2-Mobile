package com.example.ac2.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ac2.R;
import com.example.ac2.database.Medicamento;

import java.util.ArrayList;
import java.util.List;

public class MedicamentoAdapter extends RecyclerView.Adapter<MedicamentoAdapter.ViewHolder> {

    private List<Medicamento> medicamentos = new ArrayList<>();
    private Context context;

    public MedicamentoAdapter(Context context) {
        this.context = context;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_medicamento, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Medicamento medicamento = medicamentos.get(position);
        holder.txtNome.setText(medicamento.getNome());
        holder.txtHorario.setText(medicamento.getHorario());
    }

    @Override
    public int getItemCount() {
        return medicamentos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNome, txtHorario;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txtNomeMedicamento);
            txtHorario = itemView.findViewById(R.id.txtHorarioMedicamento);
        }
    }
}