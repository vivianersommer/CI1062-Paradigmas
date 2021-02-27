public class File {

    private String name;

    private String extension;

    private FileType fileType;

    private Double size;


    public File() {

    }

    public File(String nome, String extensao, FileType fileType, Double tamanho) {
        this.name = nome;
        this.extension = extensao;
        this.fileType = fileType;
        this.size = tamanho;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
