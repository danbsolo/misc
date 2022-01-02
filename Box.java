import java.text.MessageFormat;
import java.util.Scanner;

public class Box {
	private double length;
	private double width;
	private double height;
	
	private Scanner console = new Scanner(System.in);
	
	public Box() {
		this.length = 1.0;
		this.width = 1.0;
		this.height = 1.0;
	}
	
	public Box(double length, double width, double height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	public Box(Box other) { // for copying one box's dimensions to another
		this.length = other.length;
		this.width = other.width;
		this.height = other.height;
	}
	
	private double inputOneDimension(String inquire) {
		// input validation; disallowing negative numbers
		double tempArr;
		do {
			System.out.print(MessageFormat.format("Input {0}: ", inquire));
			tempArr = console.nextDouble();
		} while (tempArr < 0);
		
		return tempArr;
	}
	
	public void inputLength() {
		this.length = inputOneDimension("length");
	}

	public void inputWidth() {
		this.width = inputOneDimension("width");
	}
	
	public void inputHeight() {
		this.height = inputOneDimension("height");
	}
	
	public void inputAllDimensions() {
		this.inputLength();
		this.inputWidth();
		this.inputHeight();
	}
	
	public String getDimensions() {
		return MessageFormat.format("{0} X {1} X {2}", this.length, this.width, this.height);
	}
	
	public void displayDimensions() {
		System.out.println(this.getDimensions());
	}
	

	public double calcVolume() {
		return this.length * this.width * this.height;
	}
	

	public double calcBasePrice() {
		double vol = (double) this.calcVolume();
		
		if (vol <= 1) {
			return (double) 3.0;
		}
		else {
			return (double) (vol + 2);
		}
	}
}
