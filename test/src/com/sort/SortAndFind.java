package com.sort;

/**
 * Created by ListenYoung on 16/8/13.
 */
public class SortAndFind {
    /**
     * 递归二分排序
     * @param arr
     * @param from
     * @param to
     * @param key
     * @return log(n)
     */
    public int binarySearch(int[] arr , int from , int to , int key){
        if(from < 0 || to < 0 || from > to){
            return -1;
        }
        //if from = 7, to = 9, then?
        //int middle = (from >>> 1) + (to >>> 1);
        int middle = from + (to - from) >>> 1;
        int temp = arr[middle];
        if(temp < key){
            from = middle + 1;
        }else if(temp > key){
            to = middle - 1;
        }else{
            return middle;
        }

        return binarySearch(arr , from , to , key);
    }

    /**
     * 循环二分排序
     * @param arr
     * @param fromIndex
     * @param toIndex
     * @param key
     * @return log(n)
     */
    public int binarySearchLoop(int arr[] , int fromIndex , int toIndex , int key){
        int low = fromIndex;
        int high = toIndex - 1;
        while(low <= high){
            int mid = low + (high - low) >>> 1;
            int midVal = arr[mid];
            if(midVal > key){
                high = mid - 1;
            }else if(midVal < key){
                low = mid + 1;
            }else{
                return mid;
            }
        }

        return -(low + 1);
    }

    /**
     * 直接插入排序
     * @param arr
     * n^2
     */
    public void insertSort(int[] arr){
        //第一个元素一定是在正确位置
        for (int i = 1 ; i < arr.length ; i ++) {
            int j = i;
            int target = arr[i];//这个是要被插入的元素
            //确定要插入的位置
            while (j > 0 && target < arr[j - 1]){
                arr[j] = arr[j - 1]; //向后移动，为要插入的元素腾个地方
                j --;
            }
            arr[j] = target;
        }
    }

    /**
     * 选择排序
     * @param arr
     * n^2
     */
    public void selectionSort(int[] arr){
        for (int i = 0 ; i < arr.length - 1 ; i ++){
            int location = i;
            for (int j = i + 1 ; j < arr.length ; j ++){
                if (arr[j] < arr[location]){
                    location = j;
                }
            }
            if (location != i){
                int temp = arr[i];
                arr[i] = arr[location];
                arr[location] = temp;
            }
        }
    }

    /**
     * 真·晓旭亲传 优化冒泡排序
     * @param arr
     * n^2
     */
    public void bubbleSort(int[] arr){
        for (int i = 0 ; i < arr.length - 1 ; i ++){
            boolean flag = false; // 标识变量 防止无用循环 晓旭亲传
            for (int j = 0 ; j < arr.length - 1 - i ; j ++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (flag){
                flag  = false;
            }else {
                break;
            }
        }
    }

    /**
     * 希尔排序
     * @param arr
     * nlog(n) n^2
     */
    public void shellSort(int[] arr){
        //确定shell每一次排序之间的间隔
        for (int increment = arr.length / 2 ; increment > 0 ; increment /= 2){
            //对每一轮间隔之间的子数组进行插入排序
            for (int i = increment ; i < arr.length ; i ++){
                int temp = arr[i];//要插入的元素
                int j = 0;
                for (j = i - increment ; j >= 0 ; j -= increment){
                    if (temp < arr[j]){
                        arr[j + increment] = arr[j];//说明要插入到j的位置，j要往后稍一稍
                    }else{
                        break;
                    }
                }
                arr[j + increment] = temp;//因为又进了一次循环，break出来的 所以要还原位置
            }
        }
    }

    /**
     * 快速排序 填坑式，效率更高
     * @param arr
     * @param start
     * @param end
     * nlog(n) n^2
     * 由于每次递归都要分配几个额外空间，故有log(n)的空间复杂度
     */
    public void quickSort(int[] arr , int start , int end){
        if(start >= end){
            return;
        }

        int first = start;
        int last = end;
        int temp = arr[first];
        while(first < last){
            while (first < last && arr[last] >= temp){
                last -- ;
            }
            if(first < last){
                arr[first] = arr[last];
                first ++ ;
            }
            while (first < last && arr[first] < temp){
                first ++ ;
            }
            if(first < last){
                arr[last] = arr[first];
                last -- ;
            }
        }
        arr[first] = temp;
        quickSort(arr , start , first - 1);
        quickSort(arr , first + 1 , last);
    }

    /**
     * 归并排序
     * @param arr
     * @param start
     * @param end
     * @return t:nlog(n)  s:n + log(n)
     */
    public void mergeSort(int[] arr , int start , int end){
        if(start > end){
            return;
        }
        int mid = start + (end - start) >>> 1;
        mergeSort(arr , start , mid);
        mergeSort(arr , mid + 1 , end);
        merge(arr , start , mid , end);
    }

    public void merge(int[] arr , int start , int mid , int end){
        int[] tempArr = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end){
            if(arr[i] < arr[j]){
                tempArr[k++] = arr[i++];
            }else{
                tempArr[k++] = arr[j++];
            }
        }
        while (i <= mid){
            tempArr[k++] = arr[i++];
        }

        while (j <= end){
            tempArr[k++] = arr[j++];
        }
        for(int a = 0 ; a < tempArr.length ; a ++){
            arr[a + start] = tempArr[a];
        }
    }

    /**
     * 堆排序
     * http://blog.csdn.net/apei830/article/details/6584645
     * @param arr
     * s:1
     * 建堆 n ； 调整堆 log(n) ； 一共n-1次 -- t:nlog(n)
     */
    public void heapSort(int[] arr){
        for(int i = 0 ; i < arr.length ; i ++){
            createMaxHeap(arr , arr.length - 1 - i);
            int temp = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public void createMaxHeap(int[] arr , int lastIndex){
        for(int i = (lastIndex - 1) / 2 ; i >= 0 ; i --){
            //这样算出来的i是堆中第一个非叶结点
            int k = i;
            while (2 * k + 1 <= lastIndex){
                int biggerIndex = 2 * k + 1;//记录子节点中最大的那个节点的位置
                //判断是否有右节点
                if(biggerIndex < lastIndex){
                    if(arr[biggerIndex] < arr[biggerIndex + 1]){
                        biggerIndex ++ ;
                    }
                }
                //如果子节点比父节点大 就交换 重建下面的堆
                if(arr[k] < arr[biggerIndex]){
                    int temp = arr[k];
                    arr[k] = arr[biggerIndex];
                    arr[biggerIndex] = temp;

                    k = biggerIndex;
                }else{
                    break;
                }
            }
        }
    }

    /*
     基数排序：排序算法的应用，传说中的多关键字排序。比较适合桶排序——第一关键字一样的一桶，比较第二关键字；以此类推。
     */
}
