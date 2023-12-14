import java.util.*;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Session {

  private String username;
  private FileManager jadwalManager;
  private FileManager keretaManager;

  public Session(FileManager jadwalManager, FileManager keretaManager) {
    System.out.println("Selamat datang di Gerbong Voltase");
    this.jadwalManager = jadwalManager;
    this.keretaManager = keretaManager;
  }

  public void login() {
    System.out.println("Login");
    System.out.println("Siapa nama anda? ");
    Scanner scanner = new Scanner(System.in);
    String username = scanner.nextLine();
    this.username = username;
    if (username.equalsIgnoreCase("admin")) {
      startAdminSession();
    } else {
      startUserSession();
    }
  }

  public String getUsername() {
    return this.username;
  }

  private void startAdminSession() {
    AdminAction admin = new AdminAction(this.username , this.keretaManager, this.jadwalManager);
    System.out.println("Hallo " + this.username + " apa yang ingin anda lakukan?");
    int pilihan;
    do {
      System.out.println("\nMENU KERETA VOLTASE\n");
      System.out.println("1. Lihat jadwal kereta hari ini");
      System.out.println("2. Tambah kereta");
      System.out.println("3. Tambah jadwal");
      System.out.println("0. Logout");
      System.out.print("Pilihan anda: ");
      Scanner scanner = new Scanner(System.in);
      if (scanner.hasNextInt()) {
        pilihan = scanner.nextInt();
      } else {
        pilihan = -1;
      }
      switch (pilihan) {
        case 0:
          logout();
          break;
        case 1:
          admin.lihatJadwal();
          break;
        case 2:
          Scanner namaScanner = new Scanner(System.in);
          System.out.print("Nama Kereta: ");
          String namaKereta = namaScanner.nextLine();
          admin.addKereta(namaKereta);
          break;
        case 3:
          Scanner keretaScanner = new Scanner(System.in);
          System.out.print("Nama Kereta: ");
          String namaKeretaBaru = keretaScanner.nextLine();
          System.out.print("Jam keberangkatan: ");
          int HH = Integer.parseInt(keretaScanner.nextLine());
          System.out.print("Menit keberangkatan: ");
          int MM = Integer.parseInt(keretaScanner.nextLine());
          System.out.print("Stasiun awal: ");
          String awal = keretaScanner.nextLine();
          System.out.print("Stasiun tujuan: ");
          String tujuan = keretaScanner.nextLine();
          System.out.print("Harga tiket: ");
          int harga = Integer.parseInt(keretaScanner.nextLine());
          admin.addJadwal(namaKeretaBaru, HH, MM, awal, tujuan, harga);
          break;
        default:
          System.out.println("Pilihan anda tidak valid");
          break;
      }

    } while (pilihan != 0);
  }

  private void startUserSession() {
    UserAction user = new UserAction(this.username, this.jadwalManager);
    System.out.println("Hallo " + this.username + " apa yang ingin anda lakukan?");
    int pilihan;
    do {
      System.out.println("\nMENU KERETA VOLTASE\n");
      System.out.println("1. Lihat jadwal kereta hari ini");
      System.out.println("0. Logout");
      System.out.print("Pilihan anda: ");
      Scanner scanner = new Scanner(System.in);
      if (scanner.hasNextInt()) {
        pilihan = scanner.nextInt();
      } else {
        pilihan = -1;
      }
      switch (pilihan) {
        case 1:
          user.lihatJadwal();
          break;
        case 0:
          logout();
          break;
        default:
          System.out.println("Pilihan anda tidak valid");
          break;
      }
    } while (pilihan != 0);
  }

  public void logout() {
    System.out.println("logout");
    this.username = null;
    System.out.println("Login lagi? (Y/n)");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    if (input.equalsIgnoreCase("y")) {
      login();
      startUserSession();
    }
  }
}
