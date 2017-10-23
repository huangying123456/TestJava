package com.sort;

/**
 * Created by ListenYoung on 16/8/13.
 */
public class SortAndFind {
    public int binarySearch(int[] arr , int from , int to , int key){
        if(from < 0 || to < 0 || from > to){
            return -1;
        }
        if(from <= to){
            int middle = (from >>> 1) + (to >>> 1);
            int temp = arr[middle];
            if(temp < key){
                from = middle + 1;
            }else if(temp > key){
                to = middle - 1;
            }else{
                return middle;
            }
        }

        return binarySearch(arr , from , to , key);
    }

    public int binarySearchLoop(int arr[] , int fromIndex , int toIndex , int key){
        int low = fromIndex;
        int high = toIndex - 1;
        while(low <= high){
            int mid = (low + high) >>> 1;
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

    public int[] mergeSort(int[] arr , int start , int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) >>> 1;
        mergeSort(arr , start , mid);
        mergeSort(arr , mid + 1 , end);
        merge(arr , start , mid , end);
        return arr;
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

    //http://blog.csdn.net/apei830/article/details/6584645
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
            int k = i;
            while (2 * k + 1 < lastIndex){
                int biggerIndex = 2 * k + 1;
                //判断是否有右节点
                if(biggerIndex < lastIndex){
                    if(arr[biggerIndex] < arr[biggerIndex + 1]){
                        biggerIndex ++ ;
                    }
                }

                if(arr[k] < arr[biggerIndex]){
                    int temp = arr[k];
                    arr[k] = arr[biggerIndex];
                    arr[biggerIndex] = arr[k];

                    k = biggerIndex;
                }else{
                    break;
                }
            }
        }
    }

    //todo 冒泡 插入 选择 基数 希尔
}
