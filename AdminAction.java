public class AdminAction extends UserAction {
  FileManager keretaManager;
  FileManager jadwalManager;

  public AdminAction(String nama, FileManager keretaManager, FileManager jadwalManager) {
    super(nama, jadwalManager);
    this.keretaManager = keretaManager;
    this.jadwalManager = jadwalManager;
  }

  public void addKereta(String name) {
    Kereta kereta = new Kereta(name);
    keretaManager.appendToFile(Helper.parseKeretaToString(kereta) + "\n");
  }

  public void addJadwal(String kereta, int HH, int MM, String awal, String tujuan, int harga) {
    Jadwal jadwal = new Jadwal(kereta, HH, MM, awal, tujuan, harga);
    jadwalManager.appendToFile(Helper.parseJadwalToString(jadwal) + "\n");
    System.out.println("JADWAL BERHASIL DITAMBAHKAN, MOHON LOGIN ULANG AGAR DAPAT MELIHAT JADWAL BARU INI");
  }
}
