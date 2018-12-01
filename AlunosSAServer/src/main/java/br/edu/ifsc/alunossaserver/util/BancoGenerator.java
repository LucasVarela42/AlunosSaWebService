package br.edu.ifsc.alunossaserver.util;

import br.edu.ifsc.alunossaserver.model.Banco;

import java.util.Random;

public class BancoGenerator {
    private Banco banco;

    public BancoGenerator() {
    }

    public Banco gerarBancoAleatorio(){
        int numeroRandom = new Random().nextInt(20000) + 10000;
        double saldoRandom = new Random().nextInt(20000) + 1000;

        banco = new Banco(numeroRandom, saldoRandom);
        return banco;
    }
}
