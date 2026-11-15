import entity.Directory;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    @Test
    void constructorShouldSetPath() {
        Directory directory =  new Directory("D:/Files");
        assertEquals("D:/Files", directory.getPath());
    }

    @Test
    void addFileShouldAddFileToList() {
        Directory directory = new Directory("D:/Files");
        directory.addFile("report.docx", 1500);

        assertEquals(1, directory.getFiles().size());
        assertEquals("report.docx", directory.getFiles().get(0).getName());
    }

    @Test
    void removeExistingFileShouldReturnTrue() {
        Directory directory = new Directory("D:/Files");
        directory.addFile("report.docx", 1500);
        boolean result = directory.removeFile("report.docx");

        assertTrue(result);
        assertTrue(directory.getFiles().isEmpty());
    }

    @Test
    void removeMissingFileShouldReturnFalse() {
        Directory directory = new Directory("D:/Files");
        directory.addFile("report.docx", 1500);

        boolean result = directory.removeFile("movie.mp4");

        assertFalse(result);
        assertEquals(1, directory.getFiles().size());
    }

    @Test
    void fileInfoShouldStoreData() {
        Directory directory = new Directory("D:/Files");
        Directory.FileInfo file = directory.new FileInfo("photo.jpg", 500);

        assertEquals("photo.jpg", file.getName());
        assertEquals(500, file.getSize());
    }

    @Test
    void sortingShouldOrderFilesBySize() {
        Directory directory = new Directory("D:/Files");
        directory.addFile("movie.mp4", 10000);
        directory.addFile("photo.jpg", 500);
        directory.addFile("report.docx", 1500);

        directory.getFiles().sort(
                new Comparator<Directory.FileInfo>() {
                    @Override
                    public int compare(
                            Directory.FileInfo f1, Directory.FileInfo f2) {
                        return Long.compare(f1.getSize(), f2.getSize());
                    }
                });

        assertEquals("photo.jpg", directory.getFiles().get(0).getName());
        assertEquals("report.docx", directory.getFiles().get(1).getName());
        assertEquals("movie.mp4", directory.getFiles().get(2).getName());
    }
}