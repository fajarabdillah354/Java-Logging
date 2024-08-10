package fajar.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.MDC;

import java.util.UUID;

public class MyTest {


    /** Mapped Diagnostic Context
     * Saat kita membuat aplikasi, biasanya aplikasi kita akan diakses oleh banyak sekali user, dan artinya mungkin bisa diakses oleh banyak thread
     * MDC merupakan fitur seperti thread local, dimana kita bisa memberi informasi tambahkan kepada logger, tanpa harus kita kirim data tersebut secara manual ke class atau method
     *
     */

    /** Penggunakan MDC
     * MDC mirip dengan Map, dimana kita bisa menambahkan data dengan key, dan juga menghapusnya
     * Saat kita menggunakan MDC, secara otomatis data di MDC bisa kita akses di logger
     * http://www.slf4j.org/apidocs/org/slf4j/MDC.html
     */

    @Test
    void testMy() {

        String requestId = UUID.randomUUID().toString();


        MyController myController = new MyController(new MyService(new MyRepository()));//data akan semakin dalam ke lokasi database


        MDC.put("requestId",requestId);
        myController.save();
        MDC.remove("requestId");

    }


    /** Multi Thread
     * Data MDC disimpan dalam ThreadLocal, artinya selama didalam thread yang sama, kita bisa mengakses data di MDC
     * Oleh karena itu jika kita membuat aplikasi berbasis multithread, selama satu user mendapat satu thread, kita bisa menggunakan MDC
     * Namun jika aplikasi kita sudah reactive, yang tidak jelas thread mana yang memproses method mana, kita tidak bisa menggunakan fitur MDC lagi
     * @throws InterruptedException
     */

    @Test
    void testMultiThreadMDC() throws InterruptedException {

        /**
         * Selama Threadnya sama bisa diakses
         */

        MyController myController = new MyController(new MyService(new MyRepository()));

        for (int i = 0; i<10;i++){
            new Thread(() -> {
                String requestId = UUID.randomUUID().toString();
                MDC.put("requestId", requestId);
                myController.save();
                MDC.remove("requestId");
            }).start();
        }


        Thread.sleep(5000L);

    }
}
