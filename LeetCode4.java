class LeetCode4 {     
    public static double findMedianSortedArrays(int[] A, int[] B) {  
    int a=A.length;  
        int b=B.length;  
        if((a+b)%2==0){  
            return ((double)(findKth((a+b)/2+1,A,B)+findKth((a+b)/2,A,B)))/2;  
        }  
        return (double)findKth((a+b)/2+1,A,B);  
    }  
    public static int findKth(int k,int[] A,int[] B){  
        int a=0;//��¼A,B�������һλ��ʼ��ǰ�����������  
        int b=0;  
        while(true){  
            if(a==A.length){  
                return B[b+k-1];  
            }  
            if(b==B.length){  
                return A[a+k-1];  
            }  
            //�����һ��Ҫ��ȡ����    
            int q=Math.min(Math.min(A.length-a,B.length-b),k/2);  
            if(k==1){           //�߽�����k==1  
                return Math.min(A[a],B[b]);  
            }  
            if(A[a+q-1]<=B[b+q-1]){//A����qλ,֮��q�����±�Ϊq-1��  
                a+=q;  
            }else if(A[a+q-1]>B[b+q-1]){  
                b+=q;  
            }  
            k-=q;  
        }  
    }  
}  