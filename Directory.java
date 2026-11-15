package entity;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private String path;
    private List<FileInfo> files = new ArrayList<>();

    public Directory(String path) {
        this.path = path;
    }

    public void addFile(String name, long size) {
        files.add(new FileInfo(name, size));
    }

    public boolean removeFile(String name) {
        return files.removeIf(file -> file.getName().equals(name));
    }

    public List<FileInfo> getFiles() {
        return files;
    }

    public String getPath() {
        return path;
    }


    public class FileInfo {

        private String name;
        private long size;

        public FileInfo(String name, long size) {
            this.name = name;
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public long getSize() {
            return size;
        }

        @Override
        public String toString() {
            return "File: {" + "name: '" + name + '\'' + ", size: " + size + '}';
        }
    }
}