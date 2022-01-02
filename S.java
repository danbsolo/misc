import java.text.MessageFormat;	
import java.text.NumberFormat;

public class S {
	public static void main(String args[]) {
		System.out.println("[...] Daniel's [...] calculator!\n");
		
		P p1 = new P();
		P p2 = new P();
		P[] packs = {p1, p2};
		
		// these words get used a lot, so I'm putting them in a list
		String[] words = {"first", "second"};
		
		// a)
		for (int i = 0; i < packs.length; i++) {
			System.out.println(MessageFormat.format("Enter {0} package dimensions", words[i]));
			packs[i].inputDimensions();
			System.out.println();
		}
		
		for (int i = 0; i < packs.length; i++) {
			System.out.println(
					MessageFormat.format("{0} package dimensions: {1}, Volume = {2}", 
					capitalize(words[i]), packs[i].getDimensions(), 
					String.format("%.1f", packs[i].calcVolume())
					));
		}
		
		for (int i = 0; i < packs.length; i++) {
			System.out.println(
					MessageFormat.format("Package {0} will cost {1} to ship.",
							i + 1, NumberFormat.getCurrencyInstance().format(packs[i].calcBasePrice())
					));
		}
		
		
		// b.2) (b.1 is in Package.java)
		double p1Price = p1.calcBasePrice();
		double p2Price = p2.calcBasePrice();
		
		int multiplier;
		
		if (p1Price > p2Price) {
			multiplier = (int) Math.floor(p1Price / p2Price);
			// don't need to change words[]
		}
		else {
			multiplier = (int) Math.floor(p2Price / p1Price);
			words[0] = "second";
			words[1] = "first";
		}
		
		
		String output = "";
		// c)
		if ((p1Price - p2Price) == 0) {
			output = "The first package is the same cost as the second package.";
		}
		else if (multiplier == 1) {
			output = MessageFormat.format("The {0} package is slightly more than the {1} package.", words[0], words[1]);
		}
		else if (multiplier == 2) {
			output = MessageFormat.format("The {0} package is twice the {1} package.", words[0], words[1]);
		}
		else if (multiplier == 3) {
			output = MessageFormat.format("The {0} package is triple the {1} package.", words[0], words[1]);
		}
		else if (multiplier == 4) {
			output = MessageFormat.format("The {0} package is quadruple the {1} package.", words[0], words[1]);
		}
		else {
			output = MessageFormat.format("The {0} package is {2}x the {1} package.", words[0], words[1], multiplier);
		}
		
		System.out.println(output);
	}
	
	public static String capitalize(String word) {
		return word.substring(0, 1).toUpperCase() + word.substring(1);
	}
}
