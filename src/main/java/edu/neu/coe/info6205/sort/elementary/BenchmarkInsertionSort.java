package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.Random;

public class BenchmarkInsertionSort {



    public static void main(String[] args) {
        Benchmark_Timer benchmark_timer = new Benchmark_Timer<Integer[]>("Benchmarks for Insertion Sort",
                (Integer[] array) -> {
                    new InsertionSort<Integer>().sort(array, true);
                });
        int [] lengthOfArray={200,400,800,1600,3200};
        int n=100;

        System.out.println();
        System.out.println("Random Array Benchmarks:");
        for(int i=0;i<lengthOfArray.length;i++){
            Integer[] random=new Integer[lengthOfArray[i]];
            Random rand = new Random();
            for(int j = 0; j <random.length ; j++){
                random[j] = rand.nextInt(j+1);
            }
            double avgTime=benchmark_timer.run(random,100);
            System.out.println("Avg time taken to sort the Random Array of length "+lengthOfArray[i]+" is T="+avgTime);
        }

        System.out.println();
        System.out.println("Reverse Ordered Array Benchmarks: ");
        for(int i=0;i<lengthOfArray.length;i++){
            Integer[] reverse=new Integer[lengthOfArray[i]];
            int k= 0;
            for(int j =reverse.length-1 ; j >=0; j--){
                reverse[k] = j;
                k++;
            }
            double avgTime=benchmark_timer.run(reverse,100);
            System.out.println("Avg time taken to sort the Reverse Ordered Array of length  "+lengthOfArray[i]+" is T="+avgTime);
        }

        System.out.println();
        System.out.println("Partially Ordered Array Benchmarks:");
        for(int i=0;i<lengthOfArray.length;i++){
            Random rand = new Random();
            Integer[] partial=new Integer[lengthOfArray[i]];
            for(int j = 0; j <= partial.length / 2; j++){
                partial[j] = j;
            }

            for(int j =  partial.length / 2 + 1 ; j < partial.length ; j++){
                partial[j] = rand.nextInt(partial.length - j);
            }
            double avgTime=benchmark_timer.run(partial,100);
            System.out.println("Avg time taken to sort the Partially Ordered Array of length "+lengthOfArray[i]+" is T="+avgTime);
        }

        System.out.println();
        System.out.println("Benchmarks for Sorted Array:");
        for(int i=0;i<lengthOfArray.length;i++){
            Integer[] sorted=new Integer[lengthOfArray[i]];

            for(int j = 0; j < sorted.length ; j++){
                sorted[j] = j;
            }
            double avgTime=benchmark_timer.run(sorted,100);
            System.out.println("Avg time taken to sort the Sorted Array of length "+lengthOfArray[i]+" is T="+avgTime);
        }

    }
}