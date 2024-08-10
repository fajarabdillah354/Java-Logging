package fajar.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFormatTest {


    private static final Logger log = LoggerFactory.getLogger(LogFormatTest.class);

    @Test
    void testFormat() {

        log.info("ini tanpa parameter");
        log.info("{} + {} = {}", 10,10,(10+10));//memasukan nilai ke dalam {} dengan tanpa concatnate(penjumlahan)
        log.error("Upss ini error ", new NullPointerException());//kita bisa menambahkan message string dengan Exceptionnya

    }
}
