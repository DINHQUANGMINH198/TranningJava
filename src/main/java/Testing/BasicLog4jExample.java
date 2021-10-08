package Testing;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BasicLog4jExample {

    final static Logger logger = Logger.getLogger(BasicLog4jExample.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j2.properties");

        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.warn("This is warn message");
        logger.fatal("This is fatal message");
        logger.error("This is error message");

        System.out.println("Logic executed successfully....");

    }

}
