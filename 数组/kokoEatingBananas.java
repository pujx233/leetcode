package 数组;

public class kokoEatingBananas {

    public static class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int max = Integer.MIN_VALUE;
            int min = 1;
            for(int pile:piles){
                max = Math.max(pile,max);
            }

            while(min<max){
                int mid = (min+max)/2;
                int time = getHours(piles,mid);
                if(time==h){
                    max = mid;
                }
                else if(time>h){
                    min = mid + 1;
                }
                else{
                    max = mid;
                }
            }


            return min;
        }

        public int getHours(int[] piles,int speed){
            int time = 0;
            for(int pile:piles){
                time += (pile-1)/speed+1;
            }

            return time;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.minEatingSpeed(new int[]{30,11,23,4,20},6);
    }
}
