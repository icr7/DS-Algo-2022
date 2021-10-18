/*
Container With Most Water - LeetCode https://leetcode.com/problems/container-with-most-water/ 
this solution is done with two pointer method with time complexcity O(n)
*/
class Solution {
    public int maxArea(int[] height) {
        int pointer1=0;
        int pointer2=height.length-1;
        int maxHeight=0;
        int minHeight=0;
        int distance=0;
        int maxArea=0;
        while(pointer1!=pointer2){
            distance=Math.abs(pointer1-pointer2);
            int area=0;
            if(height[pointer1]<height[pointer2]){
                maxHeight=height[pointer2];
                minHeight=height[pointer1];
                area= distance*minHeight; 
                pointer1++;
            }
            else{
                maxHeight=height[pointer1];
                minHeight=height[pointer2];
                area= distance*minHeight; 
                pointer2--;
            }
            
            if(maxArea<area){
                maxArea=area;
            }
        }
    return maxArea;
    }
}