package fajar.logging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyService {

    private MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public static final Logger log = LoggerFactory.getLogger(MyService.class);

    public void save(){
        log.info(" - Repository ");
        this.myRepository.save();
    }



}
