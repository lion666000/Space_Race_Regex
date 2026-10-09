public class Pilot {
    String kod;
    String planeta;
    int rokNarozeni;
    String typLodi;
    int pocetVytezstvi;

    public Pilot(String kod, String planeta, int rokNarozeni, String typLodi, int pocetVytezstvi) {
        this.kod = kod;
        this.planeta = planeta;
        this.rokNarozeni = rokNarozeni;
        this.typLodi = typLodi;
        this.pocetVytezstvi = pocetVytezstvi;
    }

    public String getKod() {
        return kod;
    }

    public String getPlaneta() {
        return planeta;
    }

    public int getRokNarozeni() {
        return rokNarozeni;
    }

    public String getTypLodi() {
        return typLodi;
    }

    public int getPocetVytezstvi() {
        return pocetVytezstvi;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "kod='" + kod + '\'' +
                ", planeta='" + planeta + '\'' +
                ", rokNarozeni=" + rokNarozeni +
                ", typLodi='" + typLodi + '\'' +
                ", pocetVytezstvi=" + pocetVytezstvi +
                '}';
    }
}
