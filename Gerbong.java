public class Gerbong {

  public Kursi[][] daftarKursi = new Kursi[4][10];

  public Gerbong() {
     for(int kolom=0; kolom<10; kolom++) {
      for(int baris=0; baris<4; baris++) {
        (this.daftarKursi[baris][kolom]) = new Kursi (4 * (kolom) + (baris+1));
      }
    }
  }

  public Gerbong(Kursi[][] daftarKursi) {
    this.daftarKursi = daftarKursi;
  }

  public void getInfo() {
    for (int baris = 0; baris < 4; baris++) {
      for (int kolom = 0; kolom < 10; kolom++) {
        Kursi kursi = daftarKursi[baris][kolom];
        if (kursi.getPenumpang().equals("0")) {
            System.out.print(ConsoleColors.RESET);
        } else {
            System.out.print(ConsoleColors.RED);
        }
        System.out.print(kursi.getNomer() + " ");
      }
      System.out.println(); // Move to the next line after each row
    }
    System.out.print(ConsoleColors.RESET); // Reset color at the end
  }

  public String findPosisiKursi(int nomerKursi) {
    for(int baris=0; baris<4; baris++) {
      for(int kolom=0; kolom<10; kolom++) {
        if (nomerKursi == (4 * kolom + (baris+1))) {
          return baris + ":" + kolom;
        }
      }
    }
    return "gagal melakukan pencarian";
  }

}
