package cn.x.microservice.common.util;

import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * @author xqa
 * @since 2021/6/29
 */
public class SortUtil {

    public static void main(String[] args) {
        int size = 5;
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            double random = Math.random();
            arr[i] = random;
        }
        arr[0] = 3;
        arr[1] = 1;
        arr[2] = 5;
        arr[3] = 4;
        arr[4] = 2;
//        bubbleSort(arr);
//        selectSort(arr);
//        shellSort(arr);
        quickSort(arr, 0, arr.length - 1);
    }

    public static void bubbleSort(double[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        boolean flag = false;  //表示是否进行过交换  如果一趟排序下来没有进行过交换 则已经是有序的
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
            flag = false;
        }
    }

    public static void selectSort(double[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < arr.length - 1; i++) {
            double minValueTemp = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (minValueTemp > arr[j]) {
                    minValueTemp = arr[j];
                    minIndex = j;
                }
            }
            // 将当前索引位置的value和本轮最小值交换
            arr[minIndex] = arr[i];
            arr[i] = minValueTemp;
        }
    }

    public static void insertSort(double[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        //未排序区间
        for (int i = 1; i < arr.length; i++) {
            double insertValueTemp = arr[i];
            int insertIndex = i - 1;
            //已排序区间
            while (insertIndex >= 0 && arr[insertIndex] > insertValueTemp) {
                arr[insertIndex + 1] = arr[insertIndex--];
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValueTemp;
            }
        }
    }

    public static void shellSort(double[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
//                for (int j = i - gap; j >= 0; j -= gap) {
//                    // 如果当前元素大于加上步长后的那个元素，说明交换
//                    if (arr[j] > arr[j + gap]) {
//                        swap(arr, j, j + gap);
//                    }
//                }
                double insertValueTemp = arr[i];
                int insertIndex = i - gap;
                while (insertIndex >= 0 && insertValueTemp < arr[insertIndex]) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                if (insertIndex + gap != i) {
                    arr[insertIndex + gap] = insertValueTemp;
                }
            }
        }
    }

    /**
     * 快速排序 使得数组arr的【l,r】部分有序
     */
    public static void quickSort(double[] arr, int left, int right) {
        //原子性 一致性  隔离性  持久化

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        if (left < right) {
            //左边第一个元素作为基准数
            double pivot = arr[left];
            //从左向右找的起始位置
            int l = left;
            //从右向左找的起始位置
            int r = right;
            while (l != r) {
                //因为是左边第一个元素作为基准数 所以必须先从右向左查找
                while (r > l && arr[r] >= pivot) {
                    r--;
                }
                arr[l] = arr[r];
                System.out.println(Arrays.toString(arr));
                while (l < r && arr[l] <= pivot) {
                    l++;
                }
                arr[r] = arr[l];
                System.out.println(Arrays.toString(arr));
            }
            //最终将基准数归位（基准数到达中间位置）
            arr[l] = pivot;
            System.out.println(Arrays.toString(arr));
            //递归处理基准数左边数据
            quickSort(arr, left, r - 1);
            //递归处理基准数右边数据
            quickSort(arr, l + 1, right);
        }
    }

}
