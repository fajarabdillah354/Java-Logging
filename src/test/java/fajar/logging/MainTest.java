package fajar.logging;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTest {

    /**
     * Jangan lupa menambahkan dependency slfj4 (org.slf4j)
     * dan dependency Loggback(ch.qos.logback)
     * ketika kita menggunakan confuguration pada package default maka semua log aka tidak berfungsi, kita perlu menyetel dalam file xml configuration terlebih dahulu
     */
    private static final Logger log = LoggerFactory.getLogger(MainTest.class);//getLogger(namaClass<>)

    @Test
    void testLog() {

        // jika menggunakan logger kita dapat mengetahui waktunya,Threadnya[main], log methodnya(contohnya info), nama class loggernya, dan informasi kejadian pada class tersebut

        log.info("hello fajar");
        log.info("selamat belajar java logging");
        System.out.println("hello");

    }
}
