package br.com.meli.wave4.imobiliaria.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Casa {

    private String nomeCasa;
    private String endereco;
    private List<Comodo> listcomodo;

}
