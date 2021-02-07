package main;

import domains.File;
import domains.FileType;
import domains.Folder;

import java.util.ArrayList;
import java.util.List;

public class Trabalho1 {

    // para um melhor entendimento das ligações criadas em main, foi criado o DesenhoObjetos.pnj

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

    private static void executePrintFileNameText(List<Folder> allFolders) {
        System.out.println("\n##### Start -> printFileNameText #####");
        printFileNameText(allFolders);
        System.out.println("##### Finish -> printFileNameText #####\n");
    }

    private static void executePrintFolderAndFileNames(List<Folder> allFolders) {
        System.out.println("\n##### Start -> printFolderAndFileNames #####");
        printFolderAndFileNames(allFolders, 0);
        System.out.println("##### Finish -> printFolderAndFileNames #####");
    }

    public static void printFolderAndFileNames(List<Folder> folders, int tab) {

        if (folders != null && !folders.isEmpty()) {

            folders.forEach(folder -> {

                System.out.println(generateTab(tab) + folder.getName());

                printFileName(folder, tab + 1);

                if (folder.getFolders() != null && !folder.getFolders().isEmpty()) {

                    printFolderAndFileNames(folder.getFolders(), tab + 1);

                }
            });
        }
    }

    private static void printFileName(Folder folder, int tab) {

        if (folder.getFiles() != null && !folder.getFiles().isEmpty()) {

            folder.getFiles().forEach(file -> {

                System.out.println(generateTab(tab) + file.getName());

            });

        }

    }

    public static void printFileNameText(List<Folder> folders) {

        if (folders != null && !folders.isEmpty()) {

            folders.forEach(folder -> {

                if (folder.getFiles() != null && !folder.getFiles().isEmpty()) {

                    folder.getFiles().forEach(file -> {

                        if (file.getFileType().equals(FileType.TEXT)) {
                            System.out.println(generateTab(0) + file.getName());
                        }

                    });

                }

                if (folder.getFolders() != null && !folder.getFolders().isEmpty()) {
                    printFileNameText(folder.getFolders());
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
