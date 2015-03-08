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
		}
		System.out.println("\nTesting Delete");
		{
			testRange.deleteRange(100,50);
			testRange.print();
			testRange.deleteRange(75,150);
			testRange.print();
			testRange.deleteRange(400,500);
			testRange.deleteRange(600,700);
			testRange.print();
			testRange.deleteRange(400,600);
			testRange.print();
			testRange.deleteRange(10000,100000);
			testRange.print();
		}
		System.out.println("\nTesting Query");
		{
			System.out.println(!testRange.queryRange(-2,-40) ? "Pass" : "Fail");
			System.out.println(testRange.queryRange(2,40) ? "Pass" : "Fail");
			System.out.println(testRange.queryRange(40,2) ? "Pass" : "Fail");
			System.out.println(!testRange.queryRange(2,80) ? "Pass" : "Fail");
			System.out.println(testRange.queryRange(151,399) ? "Pass" : "Fail");
			System.out.println(!testRange.queryRange(150,1500) ? "Pass" : "Fail");
			System.out.println(!testRange.queryRange(400,450) ? "Pass" : "Fail");
			System.out.println(!testRange.queryRange(1600,4000) ? "Pass" : "Fail");
			System.out.println(!testRange.queryRange(16000,40000) ? "Pass" : "Fail");
		}
		testRange = new FooRange();
		System.out.println("\nNeighboring Range Tests");
		{
			testRange.addRange(1,2);
			testRange.addRange(7,8);
			testRange.addRange(5,6);
			testRange.addRange(3,4);
			testRange.addRange(11,12);
			testRange.addRange(13,14);
			testRange.addRange(15,16);
			testRange.addRange(17,18);			
			testRange.print();
			System.out.println(testRange.queryRange(2,6) ? "Pass" : "Fail");
			System.out.println(testRange.queryRange(12,16) ? "Pass" : "Fail");
			testRange.addRange(1,20);
			testRange.deleteRange(4,5);
			testRange.deleteRange(6,7);
			testRange.deleteRange(8,9);
			testRange.deleteRange(15,16);
			testRange.deleteRange(11,12);
			testRange.deleteRange(13,14);
			testRange.print();
			System.out.println(testRange.queryRange(1,3) ? "Pass" : "Fail");
			System.out.println(testRange.queryRange(10,10) ? "Pass" : "Fail");
			System.out.println(!testRange.queryRange(15,19) ? "Pass" : "Fail");
			System.out.println(!testRange.queryRange(10,16) ? "Pass" : "Fail");

		}
	}

}
