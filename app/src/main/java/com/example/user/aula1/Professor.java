package com.example.user.aula1;

public class Professor {

    private String nome;
    private int foto;
    private int[] dias_semana;


    //Getter e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int[] getDias_semana() {
        return dias_semana;
    }

    public void setDias_semana(int[] dias_semana) {
        this.dias_semana = dias_semana;
    }
}
