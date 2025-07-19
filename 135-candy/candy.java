class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int i = 1, sum = 1;

        while (i < n) {
            // Flat region
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            // Peak region (increasing)
            int up = 0;
            while (i < n && ratings[i] > ratings[i - 1]) {
                up++;
                sum += up + 1; // include 1 for the first in sequence
                i++;
            }

            // Downhill region (decreasing)
            int down = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                down++;
                sum += down;
                i++;
            }

            // Adjust for peak overlap
            if (up < down) {
                sum += (down - up);
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