package main;

import domains.Arquivo;
import domains.Pasta;
import domains.TipoArquivo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Arquivo arquivo1 = new Arquivo(UUID.randomUUID(), "Arquivo 1", ".pdf", TipoArquivo.PDF, 200D);
        Arquivo arquivo2 = new Arquivo(UUID.randomUUID(), "Arquivo 2", ".txt", TipoArquivo.TEXTO, 1000D);
        Arquivo arquivo3 = new Arquivo(UUID.randomUUID(), "Arquivo 3", ".jpg", TipoArquivo.IMAGEM, 30000D);
        Arquivo arquivo4 = new Arquivo(UUID.randomUUID(), "Arquivo 4", ".txt", TipoArquivo.TEXTO, 10D);
        Arquivo arquivo5 = new Arquivo(UUID.randomUUID(), "Arquivo 5", ".pdf", TipoArquivo.PDF, 100D);
        Arquivo arquivo6 = new Arquivo(UUID.randomUUID(), "Arquivo 6", ".txt", TipoArquivo.TEXTO, 5767D);


        List<Arquivo> listaArquivos1 = new ArrayList<>();
        listaArquivos1.add(arquivo1);
        listaArquivos1.add(arquivo2);
        listaArquivos1.add(arquivo3);

        List<Arquivo> listaArquivos2 = new ArrayList<>();
        listaArquivos2.add(arquivo4);

        List<Arquivo> listaArquivos3 = new ArrayList<>();
        listaArquivos3.add(arquivo5);

        List<Arquivo> listaArquivos4 = new ArrayList<>();
        listaArquivos3.add(arquivo6);


        Pasta pasta1 = new Pasta(UUID.randomUUID(), "Pasta 1", null, null);   //  pasta sem arquivos
        Pasta pasta2 = new Pasta(UUID.randomUUID(), "Pasta 2", null, null);   //  pasta sem arquivos

        Pasta pasta3 = new Pasta(UUID.randomUUID(), "Pasta 3", null, listaArquivos1); //  pasta com 3 arquivos

        Pasta pasta4 = new Pasta(UUID.randomUUID(), "Pasta 4", null, listaArquivos2); //  pasta com 1 arquivo
        Pasta pasta5 = new Pasta(UUID.randomUUID(), "Pasta 5", null, listaArquivos3); //  pasta com 1 arquivo


        List<Pasta> pastaVazia = new ArrayList<>();
        pastaVazia.add(pasta2);


        List<Pasta> pastaComArquivos = new ArrayList<>();
        pastaComArquivos.add(pasta5);


        Pasta pasta6 = new Pasta(UUID.randomUUID(), "Pasta 6", pastaComArquivos, listaArquivos4); //  pasta com 1 pasta dentro
        Pasta pasta7 = new Pasta(UUID.randomUUID(), "Pasta 7", pastaVazia, listaArquivos4); //  pasta com 1 pasta dentro

        List<Pasta> allPastas = new ArrayList<>();
        allPastas.add(pasta1);
        allPastas.add(pasta3);
        allPastas.add(pasta4);
        allPastas.add(pasta6);
        allPastas.add(pasta7);

        System.out.println("\n##### Start -> imprimeNomePastasArquivos #####");
        imprimeNomePastasArquivos(allPastas, 0);
        System.out.println("##### Finish -> imprimeNomePastasArquivos #####");

        System.out.println("\n##### Start -> imprimeNomeArquivosTexto #####");
        imprimeNomeArquivosTexto(allPastas);
        System.out.println("##### Finish -> imprimeNomeArquivosTexto #####\n");

    }

    public static void imprimeNomePastasArquivos(List<Pasta> pastas, int tab) {

        if (pastas != null && !pastas.isEmpty()) {

            pastas.forEach(pasta -> {

                System.out.println(generateTab(tab) + pasta.getName());

                printArquivoNome(pasta, tab + 1);

                if (pasta.getPastas() != null && !pasta.getPastas().isEmpty()) {

                    imprimeNomePastasArquivos(pasta.getPastas(), tab + 1);

                }
            });
        }
    }

    private static void printArquivoNome(Pasta pasta, int tab) {

        if (pasta.getArquivos() != null && !pasta.getArquivos().isEmpty()) {

            pasta.getArquivos().forEach(arquivo -> {

                System.out.println(generateTab(tab) + arquivo.getNome());

            });

        }

    }

    public static void imprimeNomeArquivosTexto(List<Pasta> pastas) {

        if (pastas != null && !pastas.isEmpty()) {

            pastas.forEach(pasta -> {

                if (pasta.getArquivos() != null && !pasta.getArquivos().isEmpty()) {

                    pasta.getArquivos().forEach(arquivo -> {

                        if (arquivo.getTipoArquivo().equals(TipoArquivo.TEXTO)) {
                            System.out.println(generateTab(0) + arquivo.getNome());
                        }

                    });

                }

                if (pasta.getPastas() != null && !pasta.getPastas().isEmpty()) {
                    imprimeNomeArquivosTexto(pasta.getPastas());
                }

            });

        }
    }

    public static String generateTab(int tab) {

        StringBuilder espacamento = new StringBuilder();

        for (int i = 0; i < tab; i++) {

            espacamento.append(espacamento).append("\t");

        }

        return String.valueOf(espacamento);
    }
}
