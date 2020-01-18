
public class HeapSort {
	public static void main(String[] args) {
		int[] A=new int[] {23,45,6,3,13,434,-1212,-33};
		HeapSort.sort(A);
		for(int a:A) {
			System.out.print(a+" ");
		}
	}
	static public void sort(int[] A) {
		for(int i=A.length/2;i>=1;i--) {
			sink(A,i,A.length-1);
		}
		int p=A.length-1;
		while(p>1) {
			swap(A,p,1);
			sink(A,1,p-1);
			p--;
		}
		for(int i=1;i<A.length;i++) {
			if(A[i]<A[i-1]) {
				swap(A,i,i-1);
			}else {
				break;
			}
		}
	}
	
	static private void sink(int[] A,int p,int e) {
		while(p*2<=e) {//´óµÄÏÂ³Á
			int k=p;
			if(A[k]<A[2*p]) {
				k=2*p;
			}
			if(2*p+1<=e&&A[k]<A[2*p+1]) {
				k=2*p+1;
			}
			if(k==p)break;
			else {
				swap(A,p,k);
			}
			p=k;
		}
	}
	static private void swap(int[] A,int idx1,int idx2) {
		int t=A[idx1];
		A[idx1]=A[idx2];
		A[idx2]=t;
	}
}
