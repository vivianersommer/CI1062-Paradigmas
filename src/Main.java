import java.util.ArrayList;
import java.util.List;

public class Main extends FileFolderService {

    /*

        Aluna: Viviane da Rosa Sommer
        GRR: 20182564

        ***** Para um melhor entendimento das ligações criadas em main, foi criado o DesenhoObjetos.pnj *****

        Compilar e rodar na Orval:
            javac Main.java FileFolderService.java File.java Folder.java FileType.java
            java Main

        Arquivos:
            File.java - classe que representa um Arquivo
            Folder.java - classe que representa uma Pasta
            FileType.java - enum que contém os Tipos de Arquivo
            FileFolderService.java - classe que contém os métodos
                a) executePrintFileNameText - método que loga o início e fim de printFileNameText
                b) executePrintFolderAndFileNames - método que loga o início e fim de printFolderAndFileNames
                c) printFolderAndFileNames - método que imprime o nome dos Folder e chama printFileName para os Files
                d) printFileName - método que imprime o nome dos Files
                e) printFileNameText - método que imprime o nome dos Files do tipo TEXT
                f) generateTab - método que faz o cálculo do número de Tabs (para imprimir os Folder e Files alinhados)
            Main.java - classe que instancia Files e Folders para testar os métodos de FileFolderService
            Diagrama.drawio - desenho da ligação entre Folder,File e FileType
            DesenhoObjetos.pnj - desenho das ligações dos objetos instanciados em Main

     */

    public static void main(String[] args) {

        // cria 6 Arquivos de tipos, nomes , extensões e tamanhos diferentes
        File file1 = new File("File 1", ".pdf", FileType.PDF, 200D);
        File file2 = new File("File 2", ".txt", FileType.TEXT, 1000D);
        File file3 = new File("File 3", ".jpg", FileType.IMAGE, 30000D);
        File file4 = new File("File 4", ".txt", FileType.TEXT, 10D);
        File file5 = new File("File 5", ".pdf", FileType.PDF, 100D);
        File file6 = new File("File 6", ".txt", FileType.TEXT, 5767D);


        // cria uma lista com 3 arquivos
        List<File> files1 = new ArrayList<>();
        files1.add(file1);
        files1.add(file2);
        files1.add(file3);

        // cria uma lista com 1 arquivo
        List<File> files2 = new ArrayList<>();
        files2.add(file4);

        // cria uma lista com 1 arquivo
        List<File> files3 = new ArrayList<>();
        files3.add(file5);

        // cria 5 pastas contendo ou não arquivos
        Folder folder1 = new Folder("Folder 1", null, null);    //  pasta sem arquivos
        Folder folder2 = new Folder("Folder 2", null, null);    //  pasta sem arquivos
        Folder folder3 = new Folder("Folder 3", null, files1);       //  pasta com 3 arquivos
        Folder folder4 = new Folder("Folder 4", null, files2);       //  pasta com 1 arquivo
        Folder folder5 = new Folder("Folder 5", null, files3);       //  pasta com 1 arquivo

        //cria uma lista com 1 pasta (nesse caso, essa pasta não tem arquivos dentro dela)
        List<Folder> emptyFolder = new ArrayList<>();
        emptyFolder.add(folder2);

        //cria uma lista com 1 pasta (nesse caso, essa pasta tem arquivos dentro dela)
        List<Folder> folderWithFiles = new ArrayList<>();
        folderWithFiles.add(folder5);

        // cria uma lista com 1 arquivo
        List<File> files4 = new ArrayList<>();
        files4.add(file6);

        // cria pastas que contém outras pastas dentro delas
        Folder folder6 = new Folder("Folder 6", folderWithFiles, files4);    //  pasta com 1 pasta dentro
        Folder folder7 = new Folder("Folder 7", emptyFolder, null);        //  pasta com 1 pasta dentro

        // popula lista com todas as pastas que serão utilizadas para teste
        List<Folder> allFolders = new ArrayList<>();
        allFolders.add(folder1);
        allFolders.add(folder3);
        allFolders.add(folder4);
        allFolders.add(folder6);
        allFolders.add(folder7);

        // execução do método printFolderAndFileNames
        executePrintFolderAndFileNames(allFolders);

        // execução do método printFileNameText
        executePrintFileNameText(allFolders);

    }

}
