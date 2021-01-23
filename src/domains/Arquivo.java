package domains;

import java.util.UUID;

public class Arquivo {

    private UUID id;

    private String nome;

    private String extensao;

    private TipoArquivo tipoArquivo;

    private Double tamanho;


    public Arquivo() {

    }

    public Arquivo(UUID id, String nome, String extensao, TipoArquivo tipoArquivo, Double tamanho) {
        this.id = id;
        this.nome = nome;
        this.extensao = extensao;
        this.tipoArquivo = tipoArquivo;
        this.tamanho = tamanho;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public TipoArquivo getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(TipoArquivo tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }
}
