package com.pweb.votacao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VotacaoControlller {
  /*
    @GetMapping("/")
    public String index(Model model) {
        ///model.addAttribute("listaCampanhas", campanhas.keySet());
        return "index";
    }*/

    private Map<String, Integer> votosCandidatos = new LinkedHashMap<>();
    // Construtor para inicializar os candidatos com 0 votos na primeira vez
    public VotacaoControlller() {
        votosCandidatos.put("Alice Silva", 0);
        votosCandidatos.put("Bruno Costa", 0);
        votosCandidatos.put("Carla Souza", 0);
        votosCandidatos.put("Daniel Oliveira", 0);
    }

    @GetMapping("/")
    public String index(Model model) {
        /*
        String mensagemBoasVindas = "Bem-vindo ao Sistema de Votação!";
        model.addAttribute("msg", mensagemBoasVindas);
        java.util.List<String> candidatos = java.util.List.of("Alice", "Bob", "Charlie");
        model.addAttribute("listaCandidatos", candidatos);
        return "index";*/
        // 1. Enviamos a mensagem de título para a tag <h1>
      /*  model.addAttribute("msg", "Resultados Parciais - Eleição 2026");

        Map<String, Integer> votos = new LinkedHashMap<>();
        votos.put("Alice Silva", 154);
        votos.put("Bruno Costa", 89);
        votos.put("Carla Souza", 210);
        votos.put("Daniel Oliveira", 45);
        // 3. Adicionamos o mapa ao Model com a chave "votosCandidatos"
        // É este nome que o th:each no HTML irá procurar
        model.addAttribute("votosCandidatos", votos);
*/
        model.addAttribute("msg", "Resultados Parciais - Eleição 2026");

        // Passamos o mapa que está guardado no atributo da classe
        model.addAttribute("votosCandidatos", votosCandidatos);



        return "index";
    }

    // Novo método para processar o voto
    @PostMapping("/votar")
    public String votar(@RequestParam String candidato) {
        // Verificamos se o candidato existe e incrementamos o voto
        if (votosCandidatos.containsKey(candidato)) {
            int votosAtuais = votosCandidatos.get(candidato);
            votosCandidatos.put(candidato, votosAtuais + 1);
        }

        // Redireciona de volta para a página inicial para atualizar a contagem na tela
        return "redirect:/";
    }


}
