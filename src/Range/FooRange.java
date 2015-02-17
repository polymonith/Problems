package Range;

public class FooRange extends Range {
	final boolean ADD = true;
	final boolean DELETE = false;
	
	public void addRange(Integer start, Integer end) {
		applyChange(start,end,ADD);
	}	

	public boolean queryRange(Integer start, Integer end) {
		for (int index = 0; index < bounds.size(); index+=2) {
			if(start.intValue() >= ((Integer) bounds.get(index)).intValue() && start.intValue() <= ((Integer) bounds.get(index+1)).intValue()) {
				return end.intValue() <= ((Integer) bounds.get(index+1)).intValue();
			}
		}
		return false;
	}

	public void deleteRange(Integer start, Integer end) {
		applyChange(start,end,DELETE);
	}

	private void applyChange(Integer start, Integer end, boolean add) {
		int startIndex = 0;
		int endIndex = bounds.size()+1;
		for(int index = 0; index < bounds.size(); index++) {
			Integer indexValue = (Integer) bounds.get(index);
			if(start.intValue() > indexValue.intValue()) startIndex++;
			if(end.intValue() < indexValue.intValue()) endIndex--;
		}
		bounds.add(startIndex, start);
		bounds.add(endIndex, end);
		int consolidateIndex;
		int consolidateCount;
		if(add) {
			consolidateIndex = startIndex-startIndex%2+1;
			consolidateCount = endIndex-consolidateIndex+1-endIndex%2;
		} else {
			consolidateIndex = startIndex+startIndex%2;
			consolidateCount = endIndex-consolidateIndex;
		}
		consolidateCount+=consolidateCount%2;
		for(int remove = 0; remove < consolidateCount; remove++) {
			bounds.remove(consolidateIndex);
		}
	}

}
