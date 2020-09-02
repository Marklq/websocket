package com.dd.websocket;

import java.util.Arrays;

public class Sort {

    private static int[] Array = {5, 12, 2, 63, 22, 6, 54, 42};


    /**
     * 插入法排序 大到小
     */
    private static void InsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] < tmp) {
                array[j] = array[j - 1];
                --j;
            }
            array[j] = tmp;
        }
    }

    /**
     * 插入法排序 小到大
     * <p>
     * 1、设置i从1开始遍历数组
     * 2、如果下标i的值小于前一个，就将i的值赋值给temp,
     * 3、设置j为i的前一个数的下标，如果temp还是小于下标为j的值，将下标j的值赋值给j后面一个下标
     * 并将j指向前一个下标
     * 4、把temp赋值给j后面一个下标
     */
    private static void InsertSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int j;
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }

    }

    /**
     * 冒泡法排序 小到大
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡法排序 大到小
     */
    private static void bubbleSort2(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序 小到大
     * <p>
     * 1、遍历数组
     * 2、将下标为0的设置为最小值的下标，并开始遍历该下标以后是否有比他更小的元素存在，如果有就将该值的下标设置为最小下标
     * 3、将最小值的下标和遍历到当前下标的i的值进行对换。
     *
     * @param arr
     */
    public static void SelectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
//					int temp = arr[min];
//					arr[min] = arr[j];
//					arr[j] = temp;
                    min = j;
                }
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    /**
     * 希尔排序
     * 1、设置一个增量s,记录每次arr的长度除以2的值
     * 2、设置一个i等于这个s，i从这个数组的一半开始每次循环加一
     * 3、设置一个j等于i - s，每次减s个增量，减到小于0为止
     * 4、在这里进行下标i和下标j的值的对比
     * 当增量序列为dlta[k]=2t-k+1-1（0≤k≤t≤⌊log2(n+1)⌋）时，可以获得不错的效率
     *
     * @param arr
     */
    private static void ShellSort(int[] arr) {
        for (int s = arr.length / 2; s > 0; s /= 2) {
            //s
            for (int i = s; i < arr.length; i++) {
//				for(int j = i - s; j < arr.length; j+=s)
                for (int j = i - s; j >= 0; j -= s) {
                    //第一次的i - s就等于0   表示arr[j]从数组下标零开始
                    //每隔s个位置经行比较
                    //之后的i - s
                    if (arr[i] < arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    /**
     * 快速排序
     * 思路：
     * 1.需要形参有开头start和结尾end
     * 2.如果start < end就递归自己
     * 3.把下标为0（也可以是其他下标）的值设为标准值
     * 把开头和结束分别设置为低位（low）和高位（high）
     * 4.当low<high时循环执行
     * 1.（low<high时)高位的值大于标准值，把高位减一位，直到小于时把当前高位的值赋值给低位
     * 2.（low<high时)低位的值小于标准值，把低位减一位，直到大于时把当前低位的值赋值给高位
     * 5.执行完后此时的高位和低位相等，把标准值赋值给低位or高位的值
     * （low<high时)保证高位一定等于低位出循环
     * 6.此时的数组分为（low右边）大于标准值和（low左边）小于标准值
     * 然后分两边递归调用自己
     * 7.直到start >= end（low >= high）不会递归下去
     *
     * @param arr
     * @param start
     * @param end
     */
    private static void QuickSort(int[] arr, int start, int end) {
        if (start < end) {
            int low = start;
            int high = end;
            int standard = arr[low];
            while (low < high) {
                while (low < high && standard < arr[high]) high--;
                if (low < high) arr[low++] = arr[high];
                while (low < high && standard > arr[low]) low++;
                if (low < high) arr[high--] = arr[low];
            }
            arr[low] = standard;
            QuickSort(arr, start, low - 1);
            QuickSort(arr, low + 1, end);
        }
    }


    public static void main(String[] args) {

        //冒泡排序
        System.out.println("冒泡排序：");
        bubbleSort(Array);
        System.out.println(Arrays.toString(Array));
        bubbleSort2(Array);
        System.out.println(Arrays.toString(Array));

        //插入排序
        System.out.println("插入排序：");
        InsertSort(Array);
        System.out.println(Arrays.toString(Array));
        InsertSort2(Array);
        System.out.println(Arrays.toString(Array));

        //选择排序
        System.out.println("选择排序：");
        SelectSort(Array);
        System.out.println(Arrays.toString(Array));

        //希尔排序
        System.out.println("希尔排序：");
        ShellSort(Array);
        System.out.println(Arrays.toString(Array));

        //快速排序
        System.out.println("快速排序：");
        QuickSort(Array, 0, Array.length - 1);
        System.out.println(Arrays.toString(Array));
    }


}
