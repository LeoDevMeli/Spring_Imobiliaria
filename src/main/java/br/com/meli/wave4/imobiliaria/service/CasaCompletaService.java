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
        return cm.stream().mapToDouble(c -> (c.getLarguraComodo() * c.getComprimentoComodo()*800)).findFirst();
    }

    //Busca maior quarto
    public static Comodo obtemMaiorComodo(String nomeCasa) {
     /*   QuartoServices quartoServices = new QuartoServices();
        for(Imovel imovel: imovelList){
            if(imovel.getNome().equals(nome)){
                return quartoServices.comparaQuartos(imovel);
            }
        }*/
        return null;
    }

    public static List<Comodo> quartoList = new ArrayList<>();
    public Comodo comparaQuartos(Casa casa) {
        OptionalDouble cs = casa.getListcomodo().stream().flatMapToDouble(c -> DoubleStream.of(c.getComprimentoComodo() * c.getLarguraComodo())).findFirst();
        quartoList = casa.getListcomodo();
        return quartoList.stream()
                .max(Comparator.comparing(Comodo::getTamanho)).get();
    }

}
