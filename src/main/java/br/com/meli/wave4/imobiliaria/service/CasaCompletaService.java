package br.com.meli.wave4.imobiliaria.service;

import br.com.meli.wave4.imobiliaria.entity.Casa;
import br.com.meli.wave4.imobiliaria.entity.Comodo;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.DoubleStream;

@Service
public class CasaCompletaService {

    private static List<Casa> imovelList = new ArrayList<>();

    public Casa cadastra(Casa imovel) {
        imovelList.add(imovel);
        return imovel;
    }

    public static Optional<Casa> buscarImovel(String nomeCasa) {
        Optional<Casa> cs = imovelList.stream().filter(c -> c.getNomeCasa().equals(nomeCasa)).findFirst();
        cs.orElse(null);
        return cs;
    }

    public static Optional<Comodo> buscarMetragemImovel(String nomeCasa) {
        Optional<Comodo> cm = Optional.of(new Comodo());
        cm.stream().filter(comodo -> comodo.getNomeComodo().equals(nomeCasa)).
                flatMapToDouble(comodo ->
                        DoubleStream.of(comodo.getComprimentoComodo() * comodo.getLarguraComodo())).findFirst();
        return cm;
    }

    public static OptionalDouble calcularValorImovel(String nomeCasa) {
        Optional<Comodo> cm = buscarMetragemImovel(nomeCasa);
        return cm.stream().mapToDouble(c -> (c.getLarguraComodo() * c.getComprimentoComodo() * 800)).findFirst();
    }

    public static Comodo obtemMaiorComodo(String nomeCasa) {
        Optional<Comodo> cm = Optional.of(new Comodo());
      return cm.stream().filter(comodo -> comodo.getNomeComodo()
                .equals(nomeCasa))
                .max(Comparator.comparing(Comodo::getTamanho)).orElse(null);
    }

}
