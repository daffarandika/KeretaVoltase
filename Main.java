import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
  public static void main(String[] args) {

    FileManager keretaManager = new FileManager("data-kereta.txt");
    keretaManager.createFile();

    FileManager jadwalManager = new FileManager("data-jadwal.txt");
    jadwalManager.createFile();

    File keretaFile = keretaManager.getFile();
    File jadwalFile = jadwalManager.getFile();

    List<Kereta> daftarKereta = new ArrayList<>();
    List<Jadwal> jadwalHariIni = new ArrayList<>();

    try {

      Scanner keretaScanner = new Scanner(keretaFile);
      while (keretaScanner.hasNextLine()) {
        String line = keretaScanner.nextLine();
        daftarKereta.add(Helper.parseStringToKereta(line));
      }

      Scanner jadwalScanner = new Scanner(jadwalFile);
      while (jadwalScanner.hasNextLine()) {
        String line = jadwalScanner.nextLine();
        jadwalHariIni.add(Helper.parseStringToJadwal(line));
      }

    } catch (IOException e) {
      System.out.println("gagal membaca file");
      e.printStackTrace();
    }

    Session session = new Session(jadwalManager, keretaManager);
    session.login();

  }
}
