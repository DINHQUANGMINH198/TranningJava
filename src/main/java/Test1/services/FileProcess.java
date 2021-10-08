package Test1.services;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class FileProcess {
    private  File file;
    private  int lines;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public FileProcess() {
    }
    public FileProcess(File file, int lines) {
        this.file = file;
        this.lines = lines;
    }

    public void readFromLast() throws Exception {
        int readLines = 0;
        StringBuilder builder = new StringBuilder();
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            long fileLength = file.length() - 1;
            // System.out.println(fileLength);
            // đặt con trỏ ở cuối tệp
            randomAccessFile.seek(fileLength);

            for (long pointer = fileLength; pointer >= 0; pointer--) {
                randomAccessFile.seek(pointer);
                char c;
                // đọc từng kí tự  từ cuối , từng dòng , cho đến khi đủ số dòng cần đọc
                c = (char) randomAccessFile.read();
                if (c == '\n') {
                    readLines++;
                    if (readLines == lines)
                        break;
                }
                builder.append(c);
                fileLength = fileLength - pointer;
            }
            //  đảo lại kí tự từng dòng do đọc từ cuối
            builder.reverse();
            System.out.println(builder.toString());
        } catch (FileNotFoundException e) {
                System.out.println(e);
                System.out.println("Sai duong dan r...");
        }

    }
}
