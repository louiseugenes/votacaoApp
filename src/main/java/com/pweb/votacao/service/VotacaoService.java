package com.pweb.votacao.service;

import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class VotacaoService {

    // Centralizamos os dados aqui
    private Map<String, Integer> candidatos = new LinkedHashMap<>();

    public VotacaoService() {
        candidatos.put("Alice Silva", 0);
        candidatos.put("Bruno Costa", 0);
    }

    public Map<String, Integer> listarTodos() {
        return candidatos;
    }

    public void registrarVoto(String nome) {
        if (candidatos.containsKey(nome)) {
            candidatos.put(nome, candidatos.get(nome) + 1);
        }
    }

    public void adicionarCandidato(String nome) {
        // Evita duplicados e inicia com 0 votos
        if (!nome.isBlank() && !candidatos.containsKey(nome)) {
            candidatos.put(nome, 0);
        }
    }
}
