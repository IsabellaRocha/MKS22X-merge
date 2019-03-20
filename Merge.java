import java.util.*;
public class Merge {
  public static void mergesort(int[] data) {
    mergesort(data, 0, data.length - 1);
  }
  private static void mergesort(int[] data, int start, int end) {
    if (end - start <= 43) {
      insertionsort(data, start, end);
    }
    else {
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
  public static void insertionsort(int[] ary, int start, int end) {
    for (int idx = start + 1; idx < end + 1; idx++) {
      int current = ary[idx]; // Storing value for later to move
      int curIdx = idx - 1;
      while (curIdx >= 0 && ary[curIdx] > current) {
        ary[curIdx + 1] = ary[curIdx]; // Shifting values over
        curIdx--;
      }
      ary[curIdx + 1] = current;
    //  System.out.println(Arrays.toString(ary));
    }
  }
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Merge.mergesort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
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
