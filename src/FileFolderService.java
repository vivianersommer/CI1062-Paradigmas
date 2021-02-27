import java.util.List;

public class FileFolderService {

    public static void executePrintFileNameText(List<Folder> allFolders) {
        System.out.println("\n##### Start -> printFileNameText #####");
        printFileNameText(allFolders);
        System.out.println("##### Finish -> printFileNameText #####\n");
    }

    public static void executePrintFolderAndFileNames(List<Folder> allFolders) {
        System.out.println("\n##### Start -> printFolderAndFileNames #####");
        printFolderAndFileNames(allFolders, 0);
        System.out.println("##### Finish -> printFolderAndFileNames #####");
    }

    private static void printFolderAndFileNames(List<Folder> folders, int tab) {

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

    private static void printFileNameText(List<Folder> folders) {

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

    private static String generateTab(int tab) {

        StringBuilder espacamento = new StringBuilder();

        for (int i = 0; i < tab; i++) {

            espacamento.append(espacamento).append("\t");

        }

        return String.valueOf(espacamento);
    }

}
