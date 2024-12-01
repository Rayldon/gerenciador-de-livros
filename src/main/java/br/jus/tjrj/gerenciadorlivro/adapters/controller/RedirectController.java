package br.jus.tjrj.gerenciadorlivro.adapters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
    @GetMapping({"/cadastro-livro", "/cadastro-assunto", "/cadastro-autor"})
    public String redirectToIndex() {
        return "forward:/index.html";
    }
}
