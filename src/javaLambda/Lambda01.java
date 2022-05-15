package javaLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 { public static void main(String[] args) {
        /*
   1) Lambda "Functional Programming"-->mathod(action) kullanma pr dili.
      Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
      Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
      Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
       ve hatasiz code yazma acilarindan cok faydalidir.
   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
      Lambda kullanmak hatasız code kullanmaktır.

          Collections Nedir?
          Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
          yapar. Array'ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
          yaptığı gibi, daha fazlasını da yapar.
          Java'da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
          topluluğu bir arada tutan bir yapıdır. 'Collections Framework' ise arayüzler ve onların kurgularından
          (implementations) oluşur.
*/
    List<Integer> sayi = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63));
    printElStructure(sayi);
    System.out.println("\n **********");
    funcional(sayi);
    System.out.println("\n **********");
    funcional2(sayi);
    System.out.println("\n **********");
    funcional3(sayi);
    System.out.println("\n **********");
    ciftElemanlariBulma(sayi);
    System.out.println("\n **********");
    printCiftElFunctional(sayi);
    System.out.println("\n **********");
    printCiftElFunctional1(sayi);
}

    //Task : Structured Programming kullanarak list elemanlarını aralarında bosluk olacak sekilde print ediniz.
    public static void printElStructure(List<Integer> sayi) {

        for (Integer w : sayi) {
            System.out.print(w + " ");
        }
    }

    //Task : functional (lamda) Programming kullanarak list elemanlarını aralarında bosluk olacak sekilde print ediniz.
    public static void funcional(List<Integer> sayi) {
        sayi.stream().forEach(t -> System.out.print(t + " "));//strem hangi aksiyonu yapacaksan akisa sunar stream
        // asagiya dogru calisirneden kullaniriz ekstra 30 kod calistirdigi icin ve data daha guvenli

        /*
 stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
 forEach() :datanin parametresine gore her bir elemanı isler
 t-> : Lambda operatoru
  Lambda Expression-->(parameter list) -> {action body}
      Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
      -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
      Body: Expressionları ve statementları içerir.

     Bir kod bloğundan oluşan bir body...
     Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
     Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

         () -> {
          double pi = 3.1415;
             return pi;
         };
  Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir

 */

    }

    public static void funcional2(List<Integer> sayi) {
        sayi.stream().forEach(System.out::print);//method caldan sout yapisindan print methodunu refere et
        //burda aksiyonu modife edemiyorum yani bosluk biraktir sayilarin yanina yazdiramam
        //34221611352063 yazdirir lamda nasil yapacagini degil ne yapacagini sorar
    }

    public static void yazdir(int a) {//yazdirma aksiyonu yapan seed method create edildi
        System.out.print(a + " ");
    }

    public static void funcional3(List<Integer> sayi) {
        sayi.stream().forEach(Lambda01::yazdir);
    }

    //2-structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void ciftElemanlariBulma(List<Integer> sayi) {
        for (Integer w : sayi) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }
    }

    //2-functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void functionalIf(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0).forEach(Lambda01::yazdir);
    }

    //Task : functional Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElFunctional(List<Integer> sayi) {

        sayi.
                stream().//list elemanlari akisa alindi
                filter(t -> t % 2 == 0).//2 ye bolunenler filtrelendi
                forEach(Lambda01::yazdir);//filitrelenenler print edildi yazdir metoduyla

    }

    public static boolean ciftBul(int a) {//seed(tohum) method kendisine verile int degerin cift olmasını kontrol eder

        return a % 2 == 0;
    }

    public static void printCiftElFunctional1(List<Integer> sayi) {

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                forEach(Lambda01::yazdir);

    }

    //2-functional Programming ile list elemanlarinin 34 den kucuk ve cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElFunctional2(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t > 34).
                filter(Lambda01::ciftBul).
                forEach(Lambda01::yazdir);
    }

    //3-functional Programming ile list elemanlarinin 34 den buyuk veya cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz
    public static void printCiftElFunctional3(List<Integer> sayi) {
        sayi.
                stream().//akisa koydu
                filter(t -> t % 2 == 0 || t < 34).//cift veya 34den buyuk bakicak iki tane filter yapamam ikisini ayni anda kontrol edicek
                //arada rakamlari kaynamasin diye
                        forEach(Lambda01::yazdir);
    }
}




