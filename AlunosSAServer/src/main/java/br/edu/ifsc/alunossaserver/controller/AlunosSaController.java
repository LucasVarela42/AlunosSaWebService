package br.edu.ifsc.alunossaserver.controller;

import br.edu.ifsc.alunossaserver.model.Banco;
import br.edu.ifsc.alunossaserver.model.EmpresaCerta;
import br.edu.ifsc.alunossaserver.util.BancoGenerator;
import br.edu.ifsc.alunossaserver.util.EmpresaCertaGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class AlunosSaController {

    @GetMapping(path = "empresas", produces = "application/JSON")
    public EmpresaCerta getEmpresaAleatoria() {
        EmpresaCerta empresa = new EmpresaCertaGenerator().gerarEmpresaAleatoria();
        return empresa;
    }

    @GetMapping(path = "bancos", produces = "application/JSON")
    public Banco getBancoAleatorio() {
        Banco conta = new BancoGenerator().gerarBancoAleatorio();
        return conta;
    }
}
