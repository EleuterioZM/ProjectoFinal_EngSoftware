package Model;

import java.util.HashSet;
import java.util.Set;

public class Turma implements java.io.Serializable {
    private Integer id;
    private String nome;
    private Curso curso;
    private Set<Estudante> estudantes = new HashSet<>(0);

    public Turma() {}

    public Turma(String nome, Curso curso, Set<Estudante> estudantes) {
        this.nome = nome;
        this.curso = curso;
        this.estudantes = estudantes;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Set<Estudante> getEstudantes() {
        return this.estudantes;
    }

    public void setEstudantes(Set<Estudante> estudantes) {
        this.estudantes = estudantes;
    }
}
