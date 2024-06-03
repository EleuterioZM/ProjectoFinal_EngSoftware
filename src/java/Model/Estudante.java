package Model;

import java.util.HashSet;
import java.util.Set;

public class Estudante implements java.io.Serializable {
    private Integer nrMatricula;
    private Turma turma;
    private String nome;
    private String apelido;
    private String endereco;
    private String contacto;
    private Set realizas = new HashSet(0);

    public Estudante() {}

    public Estudante(Turma turma, String nome, String apelido, String endereco, String contacto, Set realizas) {
        this.turma = turma;
        this.nome = nome;
        this.apelido = apelido;
        this.endereco = endereco;
        this.contacto = contacto;
        this.realizas = realizas;
    }

    public Integer getNrMatricula() {
        return this.nrMatricula;
    }

    public void setNrMatricula(Integer nrMatricula) {
        this.nrMatricula = nrMatricula;
    }

    public Turma getTurma() {
        return this.turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return this.apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContacto() {
        return this.contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Set getRealizas() {
        return this.realizas;
    }

    public void setRealizas(Set realizas) {
        this.realizas = realizas;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "nrMatricula=" + nrMatricula +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", endereco='" + endereco + '\'' +
                ", contacto='" + contacto + '\'' +
                ", turma=" + (turma != null ? turma.getId() : "null") +
                ", curso=" + (turma != null && turma.getCurso() != null ? turma.getCurso().getId() : "null") +
                '}';
    }
}
