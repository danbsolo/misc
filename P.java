import java.util.Scanner;

public class P {
	// a)
	private double length;
	private double width;
	private double height;
	
	// b)
	private Scanner input = new Scanner(System.in);
	
	// c)
	public P() {
		this.length = 1.0;
		this.width = 1.0;
		this.height = 1.0;
	}
	
	// d)
	public P(double length, double width, double height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	// e)
	public P(P other) {
		this.length = other.length;
		this.width = other.width;
		this.height = other.height;
	}
	
	// f.1)
	public void inputLength() {
		// input validation; disallowing negative numbers
		do {
			System.out.print("Enter length: ");
			this.length = input.nextDouble();
		} while (this.length < 0);
	}
	// f.2)
	public void inputWidth() {
		do {
			System.out.print("Enter width: ");
			this.width = input.nextDouble();
		} while (this.width < 0);
	}
	
	// f.3)
	public void inputHeight() {
		do {
			System.out.print("Enter height: ");
			this.height = input.nextDouble();
		} while (this.height < 0);
	}
	
	// g) Added another method for just *returning* the string as opposed to printing it out
	public String getDimensions() {
		return this.length + " X " + this.width + " X " + this.height;
	}
	
	public void displayDimensions() {
		// prints as int if the double's mantissa is just a 0 (E.g. 5.0 will become just 5 when printed)
		System.out.println(this.getDimensions());
	}
	
	// h)
	public double calcVolume() {
		// returning a more exact number than the sample output provided
		return this.length * this.width * this.height;
	}
	
	
	// adding more methods on my own accord
	// b.1)
	public double calcBasePrice() {
		double vol = (double) this.calcVolume();
		
		if (vol <= 1) {
			return (double) 3.0;
		}
		else {
			return (double) (vol + 2);
		}
	}
	
	public void inputDimensions() {
		this.inputLength();
		this.inputWidth();
		this.inputHeight();
	}
}
