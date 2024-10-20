package com.projeto.simpleCrud.dao.interfaces;

import java.util.List;

import com.projeto.simpleCrud.entity.Aluno;

public interface AlunoDAOInterface {
    
    void save(Aluno aluno);

    Aluno findById(int id);

    List<Aluno> findAll();

    List<Aluno> findByCurso(String curso);

    void update(Aluno aluno);

    void delete(int id);

    int deleteAll();
}
