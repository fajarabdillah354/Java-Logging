package fajar.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevelLogTest {

    // dengan menggunakan logger kita bisa menambahkan informasinya jenisnya apa, jika kita menggunakan system.out.println itu tidak jelas dia hanya menampilkan hasil saja

    private static final Logger log = LoggerFactory.getLogger(LevelLogTest.class);

    @Test
    void testLevel() {
        log.trace("ini trace");// level terendah, secara default ketika menggunakan slf4j dengan implementasi Loogback, dia akan menampilkan level trace ke atas, untuk level trace tidak akan ditampilkan
        log.debug("ini debug");
        log.info("ini info");
        log.warn("ini warning");
        log.error("ini error");// level tertinggi

    }
}
