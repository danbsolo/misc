import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Freight {
	public static void main(String args[]) {
		
		// initializing (and validating) a couple variables
		Scanner console = new Scanner(System.in);
		int numOfBoxes;
		double sizePerWagon;
		double totalVolume = 0;
		double totalCost = 0;
		
		do {
			System.out.print("How many boxes for this freight train?: ");
			numOfBoxes = console.nextInt();
			System.out.print("Volume in each wagon?: ");
			sizePerWagon = console.nextDouble();
		} while (numOfBoxes < 0 && sizePerWagon < 0);	
		System.out.println();
		
		Box[] boxes = new Box[numOfBoxes];
	
		// Performing actions for each box
		for (int i = 0; i < numOfBoxes; i++) {
			// Gathering dimensions for each box
			boxes[i] = new Box();
			
			System.out.println(MessageFormat.format("Box {0}''s dimensions-", i + 1));
			boxes[i].inputAllDimensions();
			System.out.println();
			
			// Displaying the data for each box
			System.out.println(
					MessageFormat.format("Dimensions = {0}\nVolume = {1} units³\nCost to ship = {2}\n\n", 
					boxes[i].getDimensions(), boxes[i].calcVolume(),
					NumberFormat.getCurrencyInstance().format(boxes[i].calcBasePrice()
					)));
			
			// Tallying up volume and costs for use later
			totalVolume += boxes[i].calcVolume();
			totalCost += boxes[i].calcBasePrice();
		}	
		
		// Displaying final calculations
		System.out.println(MessageFormat.format(
				compareVolume(sizePerWagon, totalVolume) + "\ntotal cost = {0}",
				NumberFormat.getCurrencyInstance().format(totalCost)
				));
		
		// Scanner objects don't automatically close themselves
		console.close();
	}
	
	// compares the volume available per wagon (sizeOfFreight) compared to volume the user would need (total_volume)
	public static String compareVolume(double volAvail, double volNeed) {
		double ratio = volAvail / volNeed;
		double leftoverSpace = volAvail - volNeed;
		int wholeWagons = (int) Math.ceil(1 / ratio);
		String output;
		
		if (ratio >= 1) {
			output = MessageFormat.format("1 wagon needed\nleftoverSpace = {0} units³",
					leftoverSpace);
		}
		else {
			output = MessageFormat.format("{0} wagon(s) needed\nleftoverSpace = {1} units³",
					wholeWagons,
					((wholeWagons * volAvail) - volNeed)
					);
		}
		return output;
	}
}




