import java.text.MessageFormat;
import java.util.Scanner;

public class HeightConverter {
	
	public static void main (String args[]) {
		
		class Person {
			private int height;
			private Scanner console = new Scanner(System.in);
			
			public void setHeight() {
				short inputHeight;
				do {
					System.out.print("How tall are you? (cm):  ");
					inputHeight = console.nextShort();
				} while (!(1 <= inputHeight && inputHeight <= 280));
				
				this.height = inputHeight;
				}
			
			public String getHeight() {
				double pureInches = this.height / 2.54;
				short wholeFeet = (short) Math.floor(pureInches / 12);
				double mantissaInches = Math.round(pureInches % 12);
				
				if (mantissaInches == 12) {
					mantissaInches = 0;
					wholeFeet += 1;
				}

				return MessageFormat.format("{0}''{1}\"", wholeFeet, mantissaInches);
			}
			
			public String describeHeight() {
				return "You're " + this.getHeight() + " in height :0";
			}
		}
		
		Person obj = new Person();
		obj.setHeight();
		System.out.println(obj.describeHeight());
	}
}
