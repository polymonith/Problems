package Range;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class Range {

	ArrayList bounds;
	public Range() {
		bounds = new ArrayList();
	}
	
	abstract protected void addRange(Integer start, Integer end);
	abstract protected boolean queryRange(Integer start, Integer end);
	abstract protected void deleteRange(Integer start, Integer end);
	
	public void addRange(int start, int end) {
		if(start > end) {
			int temp = start;
			start = end;
			end = temp;
		}
		addRange(new Integer(start), new Integer(end));
	}
	public boolean queryRange(int start, int end) {
		if(start > end) {
			int temp = start;
			start = end;
			end = temp;
		}
		return queryRange(new Integer(start), new Integer(end));
	}
	public void deleteRange(int start, int end) {
		if(start > end) {
			int temp = start;
			start = end;
			end = temp;
		}
		deleteRange(new Integer(start), new Integer(end));
	}
	
	public void print() {
		Iterator iPrint = bounds.iterator();
		while (iPrint.hasNext()) {
			System.out.print(iPrint.next());
			System.out.print(" >=< ");
			System.out.println(iPrint.next());
		}
	}
}
