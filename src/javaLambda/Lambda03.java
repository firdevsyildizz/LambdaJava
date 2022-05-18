package javaLambda;

import java.util.*;

public class Lambda03 {
    public static void main(String[] args) {
        List<String>yemek=new ArrayList<>(Arrays.asList("dolma","sarmax","manti","karniyarik","sarma"));
        alfBykTekrrsiz(yemek);
        System.out.println("\n ****");
        chrSayisiTersSirali(yemek);
        System.out.println("\n ****");
        chrSayiBkSirala(yemek);
        System.out.println("\n ****");
        sonHarfBkSirala(yemek);
        System.out.println("\n ****");
        charKaresiCiftSirala(yemek);
        System.out.println("\n ****");
        harfSayisi7denAzKontrol(yemek);
        System.out.println("\n ****");
        wIleBaslayanElemen(yemek);
        System.out.println("\n ****");
        xIleBitenEleman(yemek);
        System.out.println("\n ****");
        karakterSayisiEnBuyuk(yemek);
        System.out.println("\n ****");
        ilkElemenHaricSonHarfeGreSirala(yemek);
    }
    //task1-list elemanlarini alfabetik buyuk harf kucuk harf ve tekrarsiz print ediniz
    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void alfBykTekrrsiz(List<String>yemek){
        yemek.stream().
                // map(t->t.toUpperCase()).//jambda expession yaptikbuyuk harf yapti
                        map(String::toUpperCase).//methot ref yaptik buyuk harf yapti
                sorted().//alfabetik sira yapti
                distinct().//benzersiz /tekrarsiz hale geldi iki sarma vardi bir yazdirdi
                forEach(t-> System.out.print(t+" "));//lambdadaki 1 yazdir metodunu kullanamazsin o int bu string

        //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.

    }
    // Task 2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersSirali(List<String>yemek){
        yemek.stream().
                map(t->t.length()).//sana her kelimenin length getirdi
                //map(String::length).
                        sorted(Comparator.reverseOrder()).//tersten baslatti
                distinct().
                forEach(t-> System.out.print(t+" "));
        //forEach(Lambda01::yazdir); //10 5


    }
// Task 3: List elemanlarini character sayisina gore kckten byk e gore print ediniz..

    public static void chrSayiBkSirala(List<String>yemek){
        yemek.stream().
                sorted(Comparator.comparing(String::length)).
                //eleman sayilarini karsilastir neye gore=> stringlerin karakter sayilarina gore karsilastir
                        forEach(t-> System.out.print(t+" "));
    }
// Task 4: List elemanlarini son harfine gore ters sirali print ediniz..

    public static void sonHarfBkSirala(List<String>yemek){
        yemek.stream().
                sorted(Comparator.comparing(t->t.toString().
                                charAt(t.toString().length()-1)).
                        //kelimenin son harfi charat kullanmak icin to string methodunu kullaniyoruz
                                reversed()).
                //ters siraladi
                        forEach(t-> System.out.print(t+" "));
    }
    // Task 5: List elemanlarinin karelerinin cift sayili characterini hesaplayan ve karelerini tekrarsiz   byk kucuge gore print ediniz..
    public static void charKaresiCiftSirala(List<String>yemek){
        yemek.stream().map(t->t.length()*t.length()).//akistaki string eleman boyutlari karesine update edildi
                filter(Lambda01::ciftBul).//cift elemanlar filtrelendi
                distinct().//benzersiz yapildi
                sorted(Comparator.reverseOrder()).//buyukten kucuge
                forEach(Lambda01::yazdir);//print
    }
    // Task 6: List elemanlarinin karakter sayisi 7 ve 7den az oldugu durumu kontrol ediniz
    public static void harfSayisi7denAzKontrol(List<String>yemek) {
        boolean kontrol = yemek.stream().allMatch(t -> t.length() <= 7);//hepsini kontrol et=> allmatch,
        if (kontrol) {
            System.out.println("list elemanlari 7 haften daha az");
        } else System.out.println("7 harften buyuk");
        System.out.println(kontrol);
        System.out.println("clean kod");

        //clean kod nasil yazariz
        System.out.println(yemek.stream().allMatch(t -> t.length() <= 7) ? "ist elemanlari 7 haften daha az" : "7 harften buyuk");
        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
        //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    }
    // Task 7: List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayanElemen(List<String>yemek){

        System.out.println( yemek.stream().noneMatch(t->t.startsWith("w"))?"w ile baslayan yemek yok":"w ile baslayan yemek var");
    }


    // Task 8: List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xIleBitenEleman(List<String>yemek){
        System.out.println( yemek.stream().map(String::toUpperCase).anyMatch(t->t.endsWith("x"))?"x ile biten yemek var":"x ile biten yemek yok");
    }


    // Task 9: Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karakterSayisiEnBuyuk(List<String>yemek){
        System.out.println(yemek.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).//findFirst());
                limit(1));
        //2 yol
        Optional<String> enBuyukEleman= yemek.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).findFirst();
    }

    // Task 10: list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElemenHaricSonHarfeGreSirala(List<String>yemek){
        yemek.stream().sorted(Comparator.comparing(t->t.charAt(t.length()-1))).//son harfe gore siralandi
                skip(1).//ilk eleman atlandi
                forEach(t-> System.out.println(t+" "));//print

    }



}
