class Solution {
    public int maxArea(int[] height) {
        int area=0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            int l=j-i;
            int h=Math.min(height[i],height[j]);
            area=Math.max(l*h,area);
            if(height[i]<height[j]) i++;
            else{
                j-- ;
            }
        }
        return area;
    }
}