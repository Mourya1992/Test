package springTutorialsAnno.springFrameworkAnnotations;

import org.springframework.stereotype.Component;

@Component
public class Qualcomm implements Processor{
	
	
	public void process() {
		System.out.println("this is qualcomm snapdragon processor");
	}

}
