package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BenchmarkEntry {
    public static void main(String[] args) {
        int sizeOfArray = 10;
        int noOfRuns = 10;
        int reverseSizeOfArray = sizeOfArray;
        int orderedSizeOfArray = sizeOfArray;
        int partialOrderedSizeOfArray = sizeOfArray;
        int randomOrderedSizeOfArray = sizeOfArray;
        for (int i = 0; i < noOfRuns; i++) {
            reverseSizeOfArray*= 2;
            BenchmarkEntry.reversed(reverseSizeOfArray);
        }
        for (int i = 0; i < noOfRuns; i++) {
            orderedSizeOfArray*= 2;
            BenchmarkEntry.ordered(orderedSizeOfArray);
        }
        for (int i = 0; i < noOfRuns; i++) {
            partialOrderedSizeOfArray*= 2;
            BenchmarkEntry.partiallyordered(partialOrderedSizeOfArray);
        }
        for (int i = 0; i < noOfRuns; i++) {
            randomOrderedSizeOfArray*= 2;
            BenchmarkEntry.randomOrdered(randomOrderedSizeOfArray);
        }
    }
    public static void reversed(int sizeOfArray) {

        InsertionSort<Integer> sorter = new InsertionSort<Integer>();
        Supplier<Integer[]> reverseSupplier = () -> reversedArray(sizeOfArray);
        Consumer<Integer[]> consumer = (t)->{sorter.sort(t, 0,t.length);};
        Supplier<Integer[]> supplier = reverseSupplier;

        Benchmark_Timer<Integer[]> benchT = new Benchmark_Timer<Integer[]>("Insertion Sort Benchmark testing: ",consumer);
        double meantime = benchT.runFromSupplier(supplier, 10);
        System.out.println("meantime For Reversed Array of input size: " + sizeOfArray + " meantime of Insertion sort is  " + meantime);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
    }
    public static void ordered(int sizeOfArray) {
        InsertionSort<Integer> sorter = new InsertionSort<Integer>();
        Supplier<Integer[]> orderedSupplier = () -> orderedArray(sizeOfArray);
        Consumer<Integer[]> consumer = (t)->{sorter.sort(t, 0,t.length);};
        Supplier<Integer[]> supplier = orderedSupplier;

        Benchmark_Timer<Integer[]> benchT =new Benchmark_Timer<Integer[]>("Insertion Sort Benchmark testing: ",consumer);
        double meantime = benchT.runFromSupplier(supplier, 10);
        System.out.println("meantime For Ordered Array of input size: " + sizeOfArray + " meantime of Insertion sort is  " + meantime);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
    }
    public static void partiallyordered(int sizeOfArray) {

        InsertionSort<Integer> sorter = new InsertionSort<Integer>();
        Supplier<Integer[]> partiallyOrdered = () -> partialOrderArray(sizeOfArray);
        Consumer<Integer[]> consumer = (t)->{sorter.sort(t, 0,t.length);};
        Supplier<Integer[]> supplier = partiallyOrdered;

        Benchmark_Timer<Integer[]> benchT =new Benchmark_Timer<Integer[]>("Insertion Sort Benchmark testing: ",consumer);
        double meantime = benchT.runFromSupplier(supplier, 10);
        System.out.println("meantime For partially ordered Array of input size: " + sizeOfArray + " meantime of Insertion sort is  " + meantime);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
    }
    public static void randomOrdered(int sizeOfArray) {
        InsertionSort<Integer> sorter = new InsertionSort<Integer>();
        Supplier<Integer[]> randomOrdered = () -> randomArray(sizeOfArray);
        Consumer<Integer[]> consumer = (t)->{sorter.sort(t, 0,t.length);};
        Supplier<Integer[]> supplier = randomOrdered;

        Benchmark_Timer<Integer[]> benchT =new Benchmark_Timer<Integer[]>("Insertion Sort Benchmark testing: ",consumer);
        double meantime = benchT.runFromSupplier(supplier, 10);
        System.out.println("meantime For random ordered Array of input size: " + sizeOfArray + " meantime of Insertion sort is  " + meantime);
        System.out.println("-------------------------------------------------------------------------------------------------------------");
    }

    public static Integer[] reversedArray(int n)
    {
        Integer[] int1 = new Integer[n];
        int counter =1;
        for(int i=0;i<n;i++)
        {
            int1[i]=n+8-counter;
            counter++;
        }
        return int1;
    }
    public static Integer[] orderedArray(int n)
    {
        Integer[] int1 = new Integer[n];
        for(int i=0;i<n;i++)
        {
            int1[i]=i+5;
        }
        return int1;

    }
    public static Integer[] randomArray(int n)
    {
        Random r= new Random();
        Integer[] int1 = new Integer[n];
        for(int i=0;i<n;i++)
        {
            int1[i]=r.nextInt(n);
        }
        return int1;
    }
    public static Integer[] partialOrderArray(int n) {
        Random r = new Random();
        Integer[] in = new Integer[n];
        for (int i = 0; i < n / 4; i++) {
            in[i] = i + 1;
        }
        for (int i = n / 4; i < n * 3 / 4; i++) {
            in[i] = r.nextInt(n);
        }
        for (int i = n * 3 / 4; i < n; i++) {
            in[i] = i + 1;
        }
        return in;

    }
}
