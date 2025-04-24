package com.example.ac2.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MedicamentoDao {

    @Insert
    void inserir(Medicamento medicamento);

    @Update
    void atualizar(Medicamento medicamento);

    @Delete
    void excluir(Medicamento medicamento);

    @Query("SELECT * FROM medicamentos")
    default List<Medicamento> listarTodos() {
        return null;
    }

    @Query( "SELECT * FROM medicamentos WHERE id = :id")
    Medicamento buscarPorId(int id);
}