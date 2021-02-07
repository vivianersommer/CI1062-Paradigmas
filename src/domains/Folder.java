package domains;

import java.util.List;

public class Folder {

    private String name;

    private List<Folder> folders;

    private List<File> files;

    public Folder() {
    }

    public Folder(String name, List<Folder> folders, List<File> files) {
        this.name = name;
        this.folders = folders;
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
