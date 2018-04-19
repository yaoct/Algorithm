class LeetCode6 {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }            
        String [] arr=new String[numRows];
        for(int i=0;i<arr.length;i++){
            arr[i]="";
        }
        boolean flag=false;
        for(int i=0,j=0;j<s.length();j++){
            if(i==0){
                flag=false;
            }
            else if(i==numRows-1){
                flag=true;
            }
            arr[i]=arr[i]+s.charAt(j);
            if(!flag){
                i++;                
            }else{
                i--;
            }                       
        }
        String str="";
        for(String ss:arr){
            str=str+ss;
        }
        return str;
    }
}