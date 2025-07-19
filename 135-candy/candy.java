class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int i=1;
        int sum=1;
        while(i<n) {
            if(ratings[i]==ratings[i-1]) {
                sum+=1;
                i++;
                continue;
            }
            int peak=1;
            while(i<n && ratings[i]>ratings[i-1]) {
                peak+=1;
                i++;
                sum+=peak;
            }
            int down=0;
            while(i<n && ratings[i]<ratings[i-1]) {
                down+=1;
                i++;
                sum+=down;
            }
            down++;
            if(down>peak) {
                sum+=down-peak;
            }
        }
        return sum;
    
    }
}




/*
//simple approach
class Solution {
    public int candy(int[] ratings) {
        int[] left=new int[ratings.length];
        int[] right=new int[ratings.length];
        left[0]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i-1]<ratings[i]){
                left[i]=left[i-1]+1;
            }
            else{
                left[i]=1;
            }
        }
        right[ratings.length-1]=1;
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i+1]<ratings[i]){
                right[i]=right[i+1]+1;
            }
            else{
                right[i]=1;
            }
        }
        int c=0;
        for(int i=0;i<ratings.length;i++){
            c+=Math.max(left[i],right[i]);
        }
        return c;
    }
}
*/