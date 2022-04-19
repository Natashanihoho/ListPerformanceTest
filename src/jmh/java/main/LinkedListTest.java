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
public class LinkedListTest {

    private final static int NUMBER = 100_000;
    private static List<Integer> linkedList;

    @Setup
    public static void setUp() {
        linkedList = new ArrayList<>();
        for (int i = 0; i < NUMBER; i++) {
            linkedList.add(i);
        }
    }

    @Benchmark
    public static void getFirstElement(){
        linkedList.get(0);
    }

    @Benchmark
    public static void getMiddleElement(){
        linkedList.get(linkedList.size() / 2);
    }

    @Benchmark
    public static void getLastElement(){
        linkedList.get(linkedList.size() - 1);
    }

    @Benchmark
    public static void addFirstElement(){
        linkedList.add(0,905);
    }

    @Benchmark
    public static void addMiddleElement(){
        linkedList.add(linkedList.size() / 2, 45200);
    }

    @Benchmark
    public static void addLastElement(){
        linkedList.add(18700);
    }

    @Benchmark
    public static void removeFirstElement(){
        linkedList.remove(0);
    }

    @Benchmark
    public static void removeMiddleElement(){
        linkedList.remove(linkedList.size() / 2);
    }

    @Benchmark
    public static void removeLastElement(){
        linkedList.remove(linkedList.size() - 1);
    }

    @Benchmark
    public static void contains(){
        linkedList.contains(85694);
    }
}
