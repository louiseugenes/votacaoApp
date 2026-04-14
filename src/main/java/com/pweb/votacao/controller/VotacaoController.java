package com.pweb.votacao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class VotacaoController {

    private final Map<String, Integer> votosCandidatos = new LinkedHashMap<>();

    public VotacaoController() {
        votosCandidatos.put("Alice Silva", 0);
        votosCandidatos.put("Bruno Costa", 0);
        votosCandidatos.put("Carla Souza", 0);
        votosCandidatos.put("Daniel Oliveira", 0);
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("msg", "Resultados Parciais - Eleição 2026");
        model.addAttribute("votosCandidatos", votosCandidatos);
        return "index";
    }

    @PostMapping("/votar")
    public String votar(@RequestParam String candidato) {
        votosCandidatos.computeIfPresent(candidato, (k, v) -> v + 1);
        return "redirect:/";
    }
}