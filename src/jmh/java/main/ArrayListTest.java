package main;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@State(Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@Fork(3)
public class ArrayListTest {

    private final static int NUMBER = 100_000;
    private static List<Integer> arrayList;

    @Setup
    public static void setUp() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < NUMBER; i++) {
            arrayList.add(i);
        }
    }

    @Benchmark
    public static void getFirstElement(){
        arrayList.get(0);
    }

    @Benchmark
    public static void getMiddleElement(){
        arrayList.get(arrayList.size() / 2);
    }

    @Benchmark
    public static void getLastElement(){
        arrayList.get(arrayList.size() - 1);
    }

    @Benchmark
    public static void addFirstElement(){
        arrayList.add(0,905);
    }

    @Benchmark
    public static void addMiddleElement(){
        arrayList.add(arrayList.size() / 2, 45200);
    }

    @Benchmark
    public static void addLastElement(){
        arrayList.add(18700);
    }

    @Benchmark
    public static void removeFirstElement(){
        arrayList.remove(0);
    }

    @Benchmark
    public static void removeMiddleElement(){
        arrayList.remove(arrayList.size() / 2);
    }

    @Benchmark
    public static void removeLastElement(){
        arrayList.remove(arrayList.size() - 1);
    }

    @Benchmark
    public static void contains(){
        arrayList.contains(85694);
    }
}
