package br.com.meli.wave4.imobiliaria.controller;

import br.com.meli.wave4.imobiliaria.entity.Casa;
import br.com.meli.wave4.imobiliaria.entity.Comodo;
import br.com.meli.wave4.imobiliaria.service.CasaCompletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.OptionalDouble;


@RestController
public class CasaCompleta {

    @Autowired
    CasaCompletaService casaCompletaService;

    @GetMapping("/area/{nomeDaCasa}")
    public Optional<Comodo> obtemMetragemImovel(@PathVariable String nomeDaCasa){
        return CasaCompletaService.buscarMetragemImovel(nomeDaCasa);
    }

    @GetMapping("/valor/{nomeDaCasa}")
    public OptionalDouble obtemValorImovel(@PathVariable String nomeDaCasa){
        return  CasaCompletaService.calcularValorImovel(nomeDaCasa);
    }

    @GetMapping("/maiorComodo/{nomeDaCasa}")
    public Comodo maiorQuarto(@PathVariable String nomeDaCasa){
        return CasaCompletaService.obtemMaiorComodo(nomeDaCasa);
    }

    @GetMapping("/areaComodo/{nomeDaCasa}")
    public Optional<Casa> metrosPorComodo(@PathVariable String nomeDaCasa) {
        return CasaCompletaService.buscarImovel(nomeDaCasa);
    }

}
