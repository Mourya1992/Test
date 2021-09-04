package springTutorialsAnno.springFrameworkAnnotations;

import org.springframework.stereotype.Component;

@Component
public class MediaTek implements Processor{
	
	public void process() {
		System.out.println("this is Mediatek processor");
	}

}
