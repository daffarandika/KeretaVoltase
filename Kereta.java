import java.util.*;

public class Kereta {

  String nama;
  public List<Gerbong> daftarGerbong = new ArrayList<Gerbong>();

  public Kereta(String nama) {
    this.nama = nama;
    tambahGerbongKosong();
  }

  public Kereta(String nama, List<Gerbong> daftarGerbong) {
    this.nama = nama;
    this.daftarGerbong = daftarGerbong;
  }

  public String getNama() {
    return this.nama;
  }

  public void tambahGerbong(Gerbong gerbong) {
    this.daftarGerbong.add(gerbong);
  }

  public void tambahGerbongKosong() {
    this.daftarGerbong.add(new Gerbong());
  }

  public void cetakInfoGerbong() {
    int index = 1;
    for (Gerbong gerbong: daftarGerbong) {
      System.out.println(ConsoleColors.RESET + "Gerbong ke-" + index);
      gerbong.getInfo();
      System.out.println(gerbong.daftarKursi[3][0].getPenumpang());
      index++;
    }
    String info = "";
    info += ConsoleColors.RESET;
    info += "Keterangan: \n";
    info += ConsoleColors.RESET;
    info += ConsoleColors.WHITE + "Tulisan merah: tersedia\n";
    info += ConsoleColors.RED + "Tulisan merah: tidak tersedia\n";
    info += ConsoleColors.RESET;
    System.out.println(info);
  }
}
