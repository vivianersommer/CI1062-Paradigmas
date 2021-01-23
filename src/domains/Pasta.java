package domains;

import java.util.List;
import java.util.UUID;

public class Pasta {

    private UUID id;

    private String name;

    private List<Pasta> pastas;

    private List<Arquivo> arquivos;

    public Pasta() {
    }

    public Pasta(UUID id, String name, List<Pasta> pastas, List<Arquivo> arquivos) {
        this.id = id;
        this.name = name;
        this.pastas = pastas;
        this.arquivos = arquivos;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pasta> getPastas() {
        return pastas;
    }

    public void setPastas(List<Pasta> pastas) {
        this.pastas = pastas;
    }

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }
}
