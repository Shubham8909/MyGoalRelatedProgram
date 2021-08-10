package com.heap.program;

public class HeapMin {

	private int[] Heap;
	private int size;
	private int maxsize;

	private static final int FRONT = 1;

	public HeapMin(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MIN_VALUE;
	}
	
	   private void swap(int fpos, int spos)   {
	        int tmp;
	        tmp = Heap[fpos];
	        Heap[fpos] = Heap[spos];
	        Heap[spos] = tmp;
	    }
	
	  private int parent(int pos){
	        return pos / 2;
	    }
	
	private void insert(int i) {
		if(size>=maxsize) {
			return;
		}
		Heap[++size]=i;
		int current=size;
		while(Heap[current]<Heap[parent(current)]) {
			 swap(current,parent(current));
			 current=parent(current);
		}
	}
	
	   // Function to heapify the node at pos
    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)]
                || Heap[pos] > Heap[rightChild(pos)]) {
                // Swap with the left child and heapify
                // the left child
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
	
	private int leftChild(int pos) {
		return 2*pos;
	}

	private int rightChild(int pos) {
		return 2*pos+1;
	}

	private boolean isLeaf(int pos) {
		if(pos>=(size/2) && pos <=size) {
			return true;
		}
		return false;
	}

	private void minHeap() {
		  for (int pos = (size / 2); pos >= 1; pos--) {
	            minHeapify(pos);
	        }
	}
	
	  public void print(){
	        for (int i = 1; i <= size / 2; i++) {
	            System.out.print(" PARENT : " + Heap[i]
	                             + " LEFT CHILD : " + Heap[2 * i]
	                             + " RIGHT CHILD :" + Heap[2 * i + 1]);
	            System.out.println();
	        }
	    }

	public static void main(String[] args) {
        System.out.println("The Min Heap is ");
        HeapMin minHeap = new HeapMin(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.print();
        minHeap.minHeap();
        System.out.println("After min heap implement.");
        minHeap.print();
        System.out.println("The size val is " + minHeap.size);
        System.out.println("The Min val is " + minHeap.remove());
        System.out.println("The size val is " + minHeap.size);
        minHeap.print();

	}

	private int remove() {
		
		int removed=Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		minHeapify(FRONT);
		return removed;
	}

	

	

}
