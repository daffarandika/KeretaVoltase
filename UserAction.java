import java.util.*;
import java.io.File;
import java.io.IOException;

public class UserAction {
  List<Jadwal> daftarJadwal;
  FileManager fileManager;
  String username;

  public UserAction(String username, FileManager fileManager) {
    this.username = username;
    this.fileManager = fileManager;
    this.daftarJadwal = new ArrayList<>();
    try {
      File jadwalFile = fileManager.getFile();
      Scanner jadwalScanner = new Scanner(jadwalFile);
      while (jadwalScanner.hasNextLine()) {
        String line = jadwalScanner.nextLine();
        daftarJadwal.add(Helper.parseStringToJadwal(line));
      }

    } catch (IOException e) {
      System.out.println("gagal membaca file");
      e.printStackTrace();
    }
  }

  public void lihatJadwal() {
    System.out.println("JADWAL KERETA VOLTASE HARI INI");
    tawarkanPembelianTiket();
  }

  public void cetakInfoJadwal() {
    int index = 1;
    for (Jadwal jadwal : this.daftarJadwal) {
      System.out.print(index + ". ");
      System.out.println(
        jadwal.kereta.getNama() + " ("+ Helper.formatDate(jadwal.jam) + "): " + Helper.formatRupiah(jadwal.harga)
      );
      System.out.println("    " + jadwal.awal + " - " + jadwal.tujuan + "\n");
      index++;
    }
  }

  public void tawarkanPembelianTiket() {
    int pilihanJadwal;
    do {
      cetakInfoJadwal();
      System.out.println("\nINFO LEBIH LANJUT?\n");
      int index = 1;
      for (Jadwal jadwal : this.daftarJadwal) {
        System.out.println(index + ". Info lebih lanjut tentang jadwal ke-" + index);
        index++;
      }
      System.out.println("0. batal");
      System.out.print("Pilihan anda: ");
      Scanner scanner = new Scanner(System.in);
      if (scanner.hasNextInt()) {
        pilihanJadwal = scanner.nextInt();
      } else {
        pilihanJadwal = -1;
      }
      if (pilihanJadwal > 0 && pilihanJadwal < this.daftarJadwal.size()) {
        Kereta kereta = this.daftarJadwal.get(pilihanJadwal-1).kereta;
        kereta.cetakInfoGerbong();
        int pilihanGerbong;
        do {
          System.out.println("Pilih gerbong nomer berapa? ");
          System.out.print("Pilihan anda: ");
          Scanner scannerGerbong = new Scanner(System.in);
          if (scannerGerbong.hasNextInt()) {
            pilihanGerbong = scannerGerbong.nextInt();
          } else {
            pilihanGerbong = -1;
          }
          if (pilihanGerbong > 0 && pilihanGerbong <= kereta.daftarGerbong.size()) {
            int pilihanKursi;
            do {
              System.out.println("Mau duduk di kursi nomer berapa? ");
              Scanner scannerKursi = new Scanner(System.in);
              if (scannerKursi.hasNextInt()) {
                pilihanKursi = scannerKursi.nextInt();
              } else {
                pilihanKursi = -1;
              }
              if (pilihanKursi >= 1 & pilihanKursi <= 40) {
                pesanTiket(pilihanJadwal, pilihanGerbong, pilihanKursi);
                pilihanKursi = -1;
              } else {
                System.out.println("Pilihan anda tidak valid");
              }
            } while (pilihanKursi > 0);
            pilihanGerbong = -1;
          } else {
            System.out.println("Pilihan anda tidak valid");
          }
        } while (pilihanGerbong > 0);
      } else {
        pilihanJadwal = -1;
      }
    } while (pilihanJadwal > 0);
  }

  public void pesanTiket(int indexJadwal, int indexGerbong, int nomerKursi){
    Jadwal jadwal = this.daftarJadwal.get(indexJadwal-1);
    Gerbong gerbong = (jadwal.kereta.daftarGerbong.get(indexGerbong-1));
    int baris = Integer.parseInt(gerbong.findPosisiKursi(nomerKursi).split(":")[0]);
    int kolom = Integer.parseInt(gerbong.findPosisiKursi(nomerKursi).split(":")[1]);
    System.out.println("Kursi: " + baris + ":" + kolom);
    Kursi kursiYangDipesan = gerbong.daftarKursi[baris][kolom];
    kursiYangDipesan.setPenumpang(this.username);
    fileManager.writeToFile("");
    for (Jadwal jadwalToParse : daftarJadwal) {
      fileManager.appendToFile(Helper.parseJadwalToString(jadwalToParse)+"\n");
    }
    System.out.println("PEMBELIAN BERHASIL");
  }
}
