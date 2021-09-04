package springTutorialsAnno.springFrameworkAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class Mobile {
	
	private String brand;
	private String name;
	private double screenSize;
	@Autowired 
	@Qualifier("mediaTek")
	private Processor processor;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}
	public Processor getProcessor() {
		return processor;
	}
	public void setProcessor(Processor processor) {
		this.processor = processor;
	}
	public Mobile(String brand, String name, double screenSize, Processor processor) {
		super();
		this.brand = brand;
		this.name = name;
		this.screenSize = screenSize;
		this.processor = processor;
	}
	
	public Mobile() {
		// TODO Auto-generated constructor stub
	}
	public void processorDetails() {
		 processor.process();
	}

}
