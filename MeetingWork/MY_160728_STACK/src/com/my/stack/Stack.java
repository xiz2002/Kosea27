package com.my.stack;

public final class Stack<T> {
	private int iSize;
	private int iCurrent;
	private Object obStack[];
	
	Stack(int param) {
		this.iSize = param;
		this.iCurrent = 0;
		obStack = new Object[this.iSize];
	}
	
	public final T pop() {
		T rtn = null;
		rtn = (T) obStack[this.obStack.length-this.iCurrent];
		return rtn;			
	}
	
	public final void push(T param) {
		if(!(iCurrent<iSize)) {
			System.out.println("OverFlow");
			return;
		}
		obStack[this.iCurrent] = param;
		iCurrent++;
	}
	
	public final int getCurrent() {
		return this.iCurrent;
	}
	
	public final int getCapacity() {
		return this.iSize;
	}
}