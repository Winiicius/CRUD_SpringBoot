package com.projeto.simpleCrud.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.simpleCrud.dao.interfaces.AlunoDAOInterface;
import com.projeto.simpleCrud.entity.Aluno;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class AlunoDAO implements AlunoDAOInterface{

    private EntityManager entityManager;
    
    @Autowired
    public AlunoDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Aluno aluno) {
        entityManager.persist(aluno);
    }

    @Override
    public Aluno findById(int id) {
        return entityManager.find(Aluno.class, id);
    }

    @Override
    public List<Aluno> findAll(){
        TypedQuery<Aluno> alunos = entityManager.createQuery("FROM Aluno", Aluno.class);

        return alunos.getResultList();
    }

    @Override
    public List<Aluno> findByCurso(String email){
        TypedQuery<Aluno> alunos = entityManager.createQuery("FROM Aluno WHERE curso=:data", Aluno.class);
        alunos.setParameter("data", email);
        return alunos.getResultList();
    }

    @Override
    @Transactional
    public void update(Aluno aluno) {
        entityManager.merge(aluno);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Aluno aluno = findById(id);
        entityManager.remove(aluno);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numAlunosDeletados = entityManager.createQuery("DELETE FROM Aluno").executeUpdate();
        return numAlunosDeletados;
    }
}
