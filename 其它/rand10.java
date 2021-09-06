package 其它;

/**
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *
 * 不要使用系统的 Math.random() 方法。
 * */


public class rand10 {

    /**
     * 1.构造n次相互独立的采样
     * 2.提取题目要求的区间，并进行映射
     * (randX() - 1)*Y + randY() 可以等概率的生成[1, X * Y]范围的随机数
     * */

    class Solution {
        public int rand10() {
            // 首先得到一个数
            int num = (rand7() - 1) * 7 + rand7();
            // 只要它还大于10，那就给我不断生成，因为我只要范围在1-10的，最后直接返回就可以了
            while (num > 10){
                num = (rand7() - 1) * 7 + rand7();
            }
            return num;
        }

        public int rand7(){
            return 0;
        }
    }

    /**
     * 舍去太多了，选择优化
     * */
    class Solution_2{
        public int rand10() {
            // 首先得到一个数
            int num = (rand7() - 1) * 7 + rand7();
            // 只要它还大于40，那你就给我不断生成吧
            while (num > 40)
                num = (rand7() - 1) * 7 + rand7();
            // 返回结果，+1是为了解决 40%10为0的情况
            return 1 + num % 10;
        }

        public int rand7(){
            return 0;
        }
    }

    /**
     * 某种意义上的通解
     * 述方法理论上可以构造任何范围的随机数发生器，比如 rand11()：
     *
     * 构造 2 组采样，分别有 2 和 6 种结果，组合起来便有 12 种概率相同的结果。
     * 把这 12 种结果映射到 [1,12] ，然后再拒绝 12 即可。
     * rand100() ：
     *
     * 构造 3 组采样，分别有 4,5,5种结果，组合起来便有 100种概率相同的结果。
     * 把这 12 种结果映射到[1,100] 即可。
     * */
    class Solution_3{
        public int rand10() {
            int first, second;
            while ((first = rand7()) > 6);
            while ((second = rand7()) > 5);
            return (first&1) == 1 ? second : 5+second;
        }

        public int rand7(){
            return 0;
        }
    }
}
