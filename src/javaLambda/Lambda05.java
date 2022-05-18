package javaLambda;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println("TASK 01 -->"+toplaAmele(10));
        System.out.println("TASK lambdayla -->"+toplama(10));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->"+toplamaCift(20));
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->"+toplamaIlkXCift (10 ));//2+4+6+...
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->"+toplamaIlkXTek (10));//1+3+5
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        ikininIlkXKuvveti (5 );
        System.out.println("   ***   ");

        System.out.println("TASK 06 -->");
        istenenSayiXKuvvetPrint (4, 3 );
        System.out.println("   ***   ");

        System.out.println("TASK 07 -->"+istenenSayiFactorial(3));//1*2*3
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->"+istenenSayiXKuvveti(3,3));
        System.out.println("   ***   ");

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.
    //Structured(AMELE) Programming
    public  static int toplaAmele (int x ){
        int toplam =0;
        for (int i = 1; i <=x ; i++) {
            toplam+=i;

        }
        return toplam;
    }

    //Functional(cincix Programming
    public  static int toplama (int x ){
        return  IntStream.//genel akis sagler onceden kaynak belliydi simdi kaynak yok int stream kullandik
                range(1,x+1).//1 den x e kadar deger alindi ama x+1 haric yani 1 inclusive x exclusive ama biz +1 yaparak dahil ettik
                sum();//topladi
    }






    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public  static int toplamaCift (int x ){
        return  IntStream.//genel akis sagler

                rangeClosed(1,x+1).//1 E X DAHIL OLUR
                filter(Lambda01::ciftBul).
                sum();//topladi
    }


    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public  static int toplamaIlkXCift (int x ){
        return  IntStream.//genel akis sagler

                iterate(2,t->t+2).//BASLANGIC DEGERI VERIR VE AKISI NASIL AKTIRACAGINIZI SOYLER
                //2 den baslayarak sonsuza kadar elemanlari 2 artirarak akisa  alir

                //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koyar
                        limit(x).//akistaki ilk x degerlerini akisa alir
                        sum();//topladi
    }





    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public  static int toplamaIlkXTek (int x ){
        return  IntStream.//genel akis sagler

                iterate(1,t->t+2).//BASLANGIC DEGERI VERIR VE AKISI NASIL AKTIRACAGINIZI SOYLER
                //2 den baslayarak sonsuza kadar elemanlari 2 artirarak akisa  alir

                //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koyar
                        limit(x).//akistaki ilk x degerlerini akisa alir
                        sum();//topladi
    }



    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public  static void ikininIlkXKuvveti (int x ){
        IntStream.//genel akis sagler

                iterate(1,t->t*2).//BASLANGIC DEGERI VERIR VE AKISI NASIL AKTIRACAGINIZI SOYLER
                //2 den baslayarak sonsuza kadar elemanlari 2 carparak akisa  alir

                //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koyar
                        limit(x).//akistaki ilk x degerlerini akisa alir
                forEach(Lambda01::yazdir);//akistakiler yazdirildi
    }





    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public  static void istenenSayiXKuvvetPrint (int istenensayi, int x ){
        IntStream.//genel akis sagler

                iterate(istenensayi,t->t*istenensayi).//BASLANGIC DEGERI VERIR VE AKISI NASIL AKTIRACAGINIZI SOYLER
                //2 den baslayarak sonsuza kadar elemanlari 2 carparak akisa  alir

                //iterate(seed, repeat action) --> seed'den başlayarak repeat action'a göre  sonsuza kadar elemanları akısa koyar
                        limit(x).//akistaki ilk x degerlerini akisa alir
                forEach(Lambda01::yazdir);//akistakiler yazdirildi
    }


    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenenSayiFactorial(int x) {
        return IntStream.
                rangeClosed(1, x).
                //reduce(Math::multiplyExact).
                        reduce(1, (t, u) -> t * u);
    }


    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.3*3*3*3
    public static int istenenSayiXKuvveti(int istenenSayi,int x) {
        return IntStream.
                iterate(istenenSayi,t->t*istenenSayi).limit(x).reduce(0,(t,u)->u);
        // return Math.pow(istenenSayi,x);
    }

}
