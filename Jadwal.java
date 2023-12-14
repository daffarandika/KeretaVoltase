import java.time.LocalDate;
import java.time.LocalDateTime;
public class Jadwal {
  public Kereta kereta;
  public LocalDateTime jam;
  public String awal;
  public String tujuan;
  public int harga;

  public Jadwal(Kereta kereta, int HH, int MM, String awal, String tujuan, int harga) {
    this.kereta = kereta;
    this.awal = awal;
    this.tujuan = tujuan;
    LocalDate today = LocalDate.now();
    this.jam = today.atTime(HH, MM);
    this.harga = harga;
  }

  public Jadwal(String namaKereta, int HH, int MM, String awal, String tujuan, int harga) {
    this.kereta = new Kereta(namaKereta);
    this.awal = awal;
    this.tujuan = tujuan;
    LocalDate today = LocalDate.now();
    this.jam = today.atTime(HH, MM);
    this.harga = harga;
  }

  public Jadwal(Kereta kereta, LocalDateTime jam, String awal, String tujuan, int harga) {
    this.kereta = kereta;
    this.awal = awal;
    this.tujuan = tujuan;
    this.jam = jam;
    this.harga = harga;
  }

}
