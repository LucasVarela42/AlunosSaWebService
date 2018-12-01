package br.edu.ifsc.alunossaserver.util;

import br.edu.ifsc.alunossaserver.model.EmpresaCerta;

import java.util.Random;

public class EmpresaCertaGenerator {
    private EmpresaCerta empresaCerta;

    public EmpresaCertaGenerator() {
    }

    public EmpresaCerta gerarEmpresaAleatoria(){
        String nomeRandom = "Empresa"+ new Random().nextInt(100);
        double precoRandom = new Random().nextInt(10000) + 1000;

        empresaCerta = new EmpresaCerta(nomeRandom, precoRandom);
        return empresaCerta;
    }
}
