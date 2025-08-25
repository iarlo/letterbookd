package com.github.iarlo.livraria.service;

import java.io.File;
import java.io.FileWriter;

public class ArquivosService {

    public final String caminho;

    public ArquivosService(String caminho) {
        this.caminho = caminho;
    }

    public void criarArquivo(String tituloDoLivro, String autorDoLivro, String descricaoDoLivro) {
        File pasta = new File(caminho);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        File arquivo = new File(pasta, tituloDoLivro + ".txt");
        try {
            if (arquivo.createNewFile()) {
                try (FileWriter writer = new FileWriter(arquivo)) {
                    writer.write(String.format("%s%n%s%n%s%n", tituloDoLivro, autorDoLivro, descricaoDoLivro));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
