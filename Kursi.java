public class Kursi {
  int nomer;
  String penumpang = "0";

  public Kursi (int nomer){
    this.nomer = nomer;
  }

  public void setPenumpang(String penumpang) {
    this.penumpang = penumpang;
  }

  public String getPenumpang() {
    return this.penumpang;
  }

  public int getNomer() {
    return this.nomer;
  }
}
