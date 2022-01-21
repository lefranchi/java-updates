package br.com.lefranchi.java8.newfeatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Classes for testing and studing Java Streams.
 *
 * @author leandrofranchi / 2018.
 */
public class StreamsDemo {

    public static void main(String[] args) throws IOException {

        printLine();

        IntStream
                .range(1, 10)
                .forEach(System.out::print);

        printLine();

        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.print(x));

        printLine();

        System.out.print(
                IntStream
                        .range(1, 5)
                        .sum()
        );

        printLine();

        Stream.of("Ava", "Aneri", "Alberti")
                .sorted()
                .findFirst()
                .ifPresent(System.out::print);

        printLine();

        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "Amanda", "Hans", "Gervasio", "Shakira" };
        Arrays.stream(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::print);

        printLine();

        Arrays.stream(new int[] {2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::print);

        printLine();

        List<String> people = Arrays.asList("Al", "Gerva", "Heppaminondas", "Heroltides", "Hans", "Goreti");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("g"))
                .forEach(System.out::println);

        printLine();

        Path currentDir = Paths.get(".");
        String bandsFilePath = currentDir.toAbsolutePath() + "/src/main/resources/bands.txt";

        Stream<String> bands = Files.lines(Paths.get(bandsFilePath));
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close();

        printLine();

        List<String> bandList = Files.lines(Paths.get(bandsFilePath))
                .filter(x -> x.contains("met"))
                .collect(Collectors.toList());
        bandList.forEach(x -> System.out.println(x));

        printLine();

        String dataFilePath = currentDir.toAbsolutePath() + "/src/main/resources/data.txt";

        Stream<String> rows1 = Files.lines(Paths.get(dataFilePath));
        int rowCount = (int) rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();

        System.out.println(rowCount + " rows.");
        rows1.close();

        printLine();

        Stream<String> rows2 = Files.lines(Paths.get(dataFilePath));
        rows2
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter((x -> Integer.parseInt(x[1]) > 15))
                .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        rows2.close();

        printLine();

        Stream<String> rows3 = Files.lines(Paths.get(dataFilePath));
        Map<String, Integer> map = new HashMap<>();
        map = rows3
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter((x -> Integer.parseInt(x[1]) > 15))
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])
                ));
        rows3.close();
        for(String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        printLine();

        double total = Stream.of(7.3, 1.5, 4.8)
                        .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total is " + total);

        printLine();

        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                        .summaryStatistics();
        System.out.println(summary);

        printLine();

    }

    private static void printLine() {
        System.out.println();
        System.out.println("--------");
    }

}
