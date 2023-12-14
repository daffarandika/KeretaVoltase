import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class FileManager {

  private File file;

  public FileManager(String filename)  {
    this.file = new File(filename);
  }

  public void createFile() {
    try {
      this.file.createNewFile();
    } catch (IOException e) {
      System.err.println("gagal membuat file");
      e.printStackTrace();
    }
  }

  public void writeToFile(String input) {
    try {
      FileWriter myWriter = new FileWriter(this.file.getName());
      myWriter.write(input);
      myWriter.close();
    } catch (IOException e) {
      System.out.println("gagal menyimpan ke file");
      e.printStackTrace();
    }
  }
  
  public void appendToFile(String input) {
    try {
      FileWriter myWriter = new FileWriter(this.file.getName(), true);
      myWriter.write(input);
      myWriter.close();
    } catch (IOException e) {
      System.out.println("gagal menyimpan ke file");
      e.printStackTrace();
    }
  }

  public File getFile() {
    return this.file;
  }
}

