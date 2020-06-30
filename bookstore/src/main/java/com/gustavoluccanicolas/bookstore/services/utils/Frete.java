package com.gustavoluccanicolas.bookstore.services.utils;

public class Frete {

    public static Double getFrete(String uf){
        switch(uf){
            case "RS": return 10.00;
            case "SC": return 12.00;
            case "PR": return 14.00;
            case "SP": return 16.00;
            default: throw new IllegalArgumentException("Nao entregamos para este estado.");
        }
    }

}
