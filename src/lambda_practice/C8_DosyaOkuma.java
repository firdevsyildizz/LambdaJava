package lambda_practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class C8_DosyaOkuma {
    public static void main(String[] args) throws IOException {

        Stream<String> satir= Files.lines(Path.of("src/lambda_practice/C7_TextFile")); //artik stream e donustu methodlari kullanabiliriz
        //NOT:  PATH cift tirnak icine alinmali



        // S1: Yazdiralim
        //satir.forEach(t->System.out.println(t));

        //S2: tum harflari buyuk harf ile yazdiralim
        //satir.map(String ::toUpperCase).forEach(System.out::println);

        // S3: son satiri buyuk harfle yazdiralim
        //satir.skip(4).map(String ::toUpperCase).forEach(System.out::println);

        //S4: 2.ve 3. satirlari yazdiralim
        //    satir.skip(1).limit(2).forEach(System.out::println);

        //S5: kac tane "icin" kelimesi vardir

        //    System.out.println(satir.filter(t->t.contains("icin")).count());

        //S6: tum kelimeleri natural order  yazdiriniz.
        //    satir.map(t-> t.split(" ")).flatMap(Arrays::stream).
        //            sorted().forEach(System.out::println);
        // S7:  metinde kac tane "a"  vardir
        System.out.println(  satir.map(t-> t.split("")).flatMap(Arrays::stream).
                filter(t-> t.contains("a")).count());


    }

}
