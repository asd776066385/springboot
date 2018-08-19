package javabase;


import java.util.Arrays;

public class TestSort {

    /**
     * 冒泡
     * @param a
     */
    public static void bubbleSort(int a[]){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j]= a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 快速排序
     * @param a
     * @param low
     * @param high
     */
    public  static void quickSort(int[] a, int low, int high){

        //1,找到递归算法的出口
        if( low > high) {
            return;
        }

        //2, 存
        int i = low;
        int j = high;
        //3,key
        int key = a[ low ];

        while (i<j){
            //4.1 ，从右往左找到第一个小于key的数
            while(i<j && a[j] > key){
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while( i<j && a[i] <= key) {
                i++;
            }
            //4.3 交换
            if(i<j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }

        // 4.4，调整key的位置
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        //5, 对key左边的数快排
        quickSort(a, low, i-1 );
        //6, 对key右边的数快排
        quickSort(a, i+1, high);


    }


    public static void main(String[] args) {
        int a[] = {1,5,3,7,6,4,9};
        bubbleSort(a);
    }
}
