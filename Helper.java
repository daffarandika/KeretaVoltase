import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.*;

public class Helper {
  public static String formatDate(LocalDateTime date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    return date.format(formatter);
  }

  public static String removeLastChar(String s) {
    if (s == null || s.length() == 0) {
        return s;
    }
    return s.substring(0, s.length()-1);
}

  public static String formatRupiah(int amount) {
    NumberFormat rupiahFormat = NumberFormat.getNumberInstance();
    return "Rp. " + rupiahFormat.format(amount);
  }

  public static String parseKeretaToString(Kereta kereta) {
    String result = kereta.getNama();
    result += ":";
    for (Gerbong gerbong : kereta.daftarGerbong) {
     for(int kolom=0; kolom<10; kolom++) {
      for(int baris=0; baris<4; baris++) {
        Kursi kursi = gerbong.daftarKursi[baris][kolom];
        result += kursi.getNomer() + "_" + kursi.getPenumpang() + ",";
      }
    }
      result = removeLastChar(result);
      result += ";";
    }
    result = removeLastChar(result);
    return result;
  }

  public static Kereta parseStringToKereta(String input){
    String nama = input.split(":")[0];
    String stringGerbong = input.split(":")[1];
    String[] listStringGerbong = stringGerbong.split(";");
    List<Gerbong> daftarGerbong = new ArrayList<Gerbong>();
    for (String stringPenumpangGerbong : listStringGerbong) {
      Gerbong gerbong = new Gerbong();
      for (String stringKursi : stringPenumpangGerbong.split(",")) {
        int nomerKursi = Integer.parseInt(stringKursi.split("_")[0]);
        String penumpangKursi = stringKursi.split("_")[1];

        int baris = Integer.parseInt(gerbong.findPosisiKursi(nomerKursi).split(":")[0]);
        int kolom = Integer.parseInt(gerbong.findPosisiKursi(nomerKursi).split(":")[1]);

        gerbong.daftarKursi[baris][kolom].setPenumpang(penumpangKursi);
      }
      daftarGerbong.add(gerbong);
    }
    Kereta kereta = new Kereta(nama);
    for (Gerbong gerbong : daftarGerbong) {
      kereta.tambahGerbong(gerbong);
    }
    return kereta;
  }

  public static String parseJadwalToString(Jadwal jadwal) {
    String kereta = parseKeretaToString(jadwal.kereta);
    String jam = jadwal.jam.toString();
    String awal = jadwal.awal;
    String tujuan = jadwal.tujuan;
    String harga = Integer.toString(jadwal.harga);
    return kereta + "  " + jam + "  " + awal + "  " + tujuan + "  " + harga;
  }

  public static Jadwal parseStringToJadwal(String input) {
    String[] arr = input.split("  ");
    Kereta kereta = parseStringToKereta(arr[0]);
    LocalDateTime jam = LocalDateTime.parse(arr[1]);
    String awal = arr[2];
    String tujuan = arr[3];
    int harga = Integer.parseInt(arr[4]);
    return new Jadwal(kereta, jam, awal, tujuan, harga);
  }

}
