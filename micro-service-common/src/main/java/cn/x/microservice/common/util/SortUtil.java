package cn.x.microservice.common.util;

/**
 * @author xqa
 * @since 2021/6/29
 */
public class SortUtil {

    public void bubbleSort(double[] arr) {
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

    public void selectSort(double[] arr) {
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

    public void insertSort(double[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        //未排序区间
        for (int i = 1; i < arr.length; i++) {
            double insertValue = arr[i];
            //已排序区间
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > insertValue) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
