package com.gustavoluccanicolas.bookstore.entidades.enums;

import java.util.Objects;

public enum Genero {
    ACAO("Ação"),
    ROMANCE("Romance"),
    FICCAO("Ficção"),
    AVENTURA("Aventura"),
    INFANTIL("Infantil"),
    TERROR("Terror"),
    HQ("HQ"),
    BIOGRAFIA("Biografia");

    private final String descricao;

    public String getDescricao() {
        return descricao;
    }

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public static Genero createFrom(String genero) throws Exception{
        if (Objects.isNull(genero)) {
            return null;
        }
        canCreateFrom(genero);
        return Genero.valueOf(genero);
    }

    public static void canCreateFrom(String genero) throws Exception {
        if (Objects.nonNull(genero)) {
            try {
                Genero.valueOf(genero);
            } catch (Exception e) {
                throw new Exception("O genero informado não está definido (valor inválido)");
            }
        }
    }



}
