package fajar.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyController {

    private MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    public static final Logger log = LoggerFactory.getLogger(MyController.class);

    public void save(){
        log.info(" - Service ");
        this.myService.save();
    }


}
