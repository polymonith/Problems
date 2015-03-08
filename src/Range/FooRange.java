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
		//When Deleting values should be incremented by one.
		bounds.add(startIndex, add ? start : new Integer(start.intValue()-1));
		bounds.add(endIndex, add ? end : new Integer(end.intValue()+1));
		int consolidateIndex;
		int consolidateCount;
		if(add) {
			consolidateIndex = startIndex-startIndex%2+1;
			consolidateCount = endIndex-consolidateIndex+1-endIndex%2;
			//Check for neighboring ranges, if the values are within one they should be considered the same range.
			if(startIndex>1 &&
					((Integer) bounds.get(startIndex)).intValue()-1 == ((Integer) bounds.get(startIndex-1)).intValue()) {
				consolidateIndex-=2;
				consolidateCount+=2;
			}
			if(endIndex+1<bounds.size()&&
					((Integer) bounds.get(endIndex)).intValue()+1 == ((Integer) bounds.get(endIndex+1)).intValue()) {
				consolidateCount+=2;
			}
		} else {
			consolidateIndex = startIndex+startIndex%2;
			consolidateCount = endIndex-consolidateIndex;
		}
		consolidateCount+=consolidateCount%2; // Ensure we always remove a pair.
		for(int remove = 0; remove < consolidateCount; remove++) {
			bounds.remove(consolidateIndex);
		}
	}

}
