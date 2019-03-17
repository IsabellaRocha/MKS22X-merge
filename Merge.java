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
  }
}
