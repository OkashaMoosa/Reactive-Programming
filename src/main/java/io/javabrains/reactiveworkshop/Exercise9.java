package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.List;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        // TODO: Write code here
        final int[] size = {0};
        ReactiveSources.intNumbersFlux()
                .doOnComplete(() -> System.out.println(size[0]))
                .subscribe(e -> size[0]++);


        // Collect all items of intNumbersFlux into a single list and print it
        // TODO: Write code here
        List<Integer> tempList = ReactiveSources.intNumbersFlux()
                .collectList()
                .block();
        System.out.println(tempList);
        // Transform to a sequence of sums of adjacent two numbers
        // TODO: Write code here
        Flux<Integer> seqList = ReactiveSources.intNumbersFlux()
                .buffer(2, 1)
                .filter(list -> list.size() == 2)
                .map(list -> list.get(0) + list.get(1));
        seqList.subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
