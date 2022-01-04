package br.com.meli.wave4.imobiliaria.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Comodo {

    private String nomeComodo;
    private double larguraComodo;
    private double comprimentoComodo;

    public double getTamanho(){
        return larguraComodo*comprimentoComodo;
    }

}
