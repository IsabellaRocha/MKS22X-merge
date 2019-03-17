import java.util.*;
public class Merge {
  public static void mergesort(int[] data) {
    mergesort(data, 0, data.length - 1);
  }
  private static void mergesort(int[] data, int start, int end) {
    if (start >= end) {
      return;
    }
    int[] temp = new int[data.length / 2];
    int[] temp2 = new int[data.length - data.length / 2];
    for (int idx = 0; idx < temp.length; idx++) {
      temp[idx] = data[idx];
    }
    for (int idx = 0; idx < temp2.length; idx++) {
      temp2[idx] = data[idx + data.length / 2];
    }
    mergesort(temp, 0, temp.length - 1);
    mergesort(temp2, 0, temp2.length - 1);
    merge(data, temp, temp2);
  }
  private static void merge(int[] data, int[] temp, int[] temp2) {
    int x = 0;
    int y = 0;
    for (int idx = 0; idx < data.length; idx++) {
      if (x >= temp.length) {
        data[idx] = temp2[y];
        y++;
      }
      else if (y >= temp2.length) {
        data[idx] = temp[x];
        x++;
      }
      else if (temp[x] <= temp2[y]) {
        data[idx] = temp[x];
        x++;
      }
      else if (temp2[y] < temp[x]) {
        data[idx] = temp2[y];
        y++;
      }
    }
  }
  public static void main(String[] args) {
    int[] ary = {2, 10, 15, 23, 0,  5};
    int[] ary2 = {999,999,999,4,1,0,3,2,999,999,999};
    int[] ary3 = {17,61,67,47,93,12,20,4,44,78};
    int[] ary4 = {1, 2, 3, 4, 5, 6, 7, 8};
    mergesort(ary);
    System.out.println(Arrays.toString(ary));
    mergesort(ary2);
    System.out.println(Arrays.toString(ary2));
    mergesort(ary3);
    System.out.println(Arrays.toString(ary3));
    mergesort(ary4);
    System.out.println(Arrays.toString(ary4));
  }
}
