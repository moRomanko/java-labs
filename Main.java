import entity.Directory;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Directory directory =  new Directory("D:/Files");

        directory.addFile("oldvers.doc", 1000);
        directory.addFile( "report.docx", 1500);
        directory.addFile("photo.jpg", 500);
        directory.addFile("movie.mp4", 10000);

        directory.removeFile("oldvers.doc");

        directory.getFiles().sort(
                new Comparator<Directory.FileInfo>() {
                    @Override
                    public int compare(Directory.FileInfo f1, Directory.FileInfo f2) {
                        return Long.compare(f1.getSize(), f2.getSize());
                    }
                });

        System.out.println("\nSorted:");

        directory.getFiles().forEach(System.out::println);
    }
}