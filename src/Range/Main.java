package Range;

public class Main {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Range testRange = new FooRange();
		System.out.println("Testing Add");
		{	
			testRange.addRange(1,1);
			testRange.addRange(2,10);
			testRange.addRange(20,100);
			testRange.print();
			testRange.addRange(50,200);
			testRange.print();
			testRange.addRange(300,400);
			testRange.print();
			testRange.addRange(250,310);
			testRange.print();
			testRange.addRange(900,910);
			testRange.addRange(920,930);
			testRange.addRange(940,950);
			testRange.print();
			testRange.addRange(905,930);
			testRange.print();
			testRange.addRange(1,1000);
			testRange.print();
			testRange.addRange(1000,1500);
			testRange.print();
			testRange.addRange(1600,1550);
			testRange.print();
		}
		System.out.println("Testing Delete");
		{
			testRange.deleteRange(100,50);
			testRange.print();
			testRange.deleteRange(75,150);
			testRange.print();
			testRange.deleteRange(400,500);
			testRange.deleteRange(600,700);
			testRange.print();
			testRange.deleteRange(450,600);
			testRange.print();
		}
		System.out.println("Testing Query");
		{
			System.out.println(testRange.queryRange(2,40) ? "Pass" : "Fail");
			System.out.println(testRange.queryRange(40,2) ? "Pass" : "Fail");
			System.out.println(!testRange.queryRange(2,80) ? "Pass" : "Fail");
			System.out.println(testRange.queryRange(150,400) ? "Pass" : "Fail");
			System.out.println(!testRange.queryRange(150,1500) ? "Pass" : "Fail");
			System.out.println(!testRange.queryRange(400,450) ? "Pass" : "Fail");
			System.out.println(!testRange.queryRange(1600,4000) ? "Pass" : "Fail");
		}
	}

}
