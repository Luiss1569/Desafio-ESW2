package br.unifei.imc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grupo {

    private List<Aluno> alunos;
    private Double nota;

    public Grupo() {
        this.alunos = new ArrayList<>();
        this.nota = null;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(final List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(final Double nota) {
        this.nota = nota;
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }
}
