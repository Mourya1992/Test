package springTutorialsAnno.springFrameworkAnnotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appcontext = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Mobile mobile = appcontext.getBean(Mobile.class);
        mobile.processorDetails();
    }
}
