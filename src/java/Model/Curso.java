package Model;

import java.util.HashSet;
import java.util.Set;

public class Curso implements java.io.Serializable {
    private Integer id;
    private String nome;
    private Set<Turma> turmas = new HashSet<>(0);

    public Curso() {}

    public Curso(String nome, Set<Turma> turmas) {
        this.nome = nome;
        this.turmas = turmas;
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

    public Set<Turma> getTurmas() {
        return this.turmas;
    }

    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nome=" + nome + ", turmas=" + turmas + '}';
    }
}
