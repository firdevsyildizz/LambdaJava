package javaLambda;

public class Universite {
    /*
    TASK :
    fields --> Universite (String)
    bolum (String)
    ogrcSayisi (int)
    notOrt (int)
    olan POJO clas craete edip main method içinde 5 arklı obj'den List create ediniz.
    pojo class: plan old java object --> model classı
    private veriable
            constructor
    getter setter
    toString
     */
    //pojo class
    private String  universite;
    private String  bolum;
    private int ogrSayisi;
    private int notOrt;

    public Universite(){//bos constructor
    }

    public Universite(String universite, String bolum, int ogrSayisi, int notOrt) {//parametreli constructor
        this.universite = universite;
        this.bolum = bolum;
        this.ogrSayisi = ogrSayisi;
        this.notOrt = notOrt;
    }

    public String getUniversite() {//geter setter yapiyorduk
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrSayisi() {
        return ogrSayisi;
    }

    public void setOgrSayisi(int ogrSayisi) {
        this.ogrSayisi = ogrSayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {//to string yapiyoruz
        return "Universite{" +
                "universite='" + universite + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrSayisi=" + ogrSayisi +
                ", notOrt=" + notOrt +
                '}';
    }


}
