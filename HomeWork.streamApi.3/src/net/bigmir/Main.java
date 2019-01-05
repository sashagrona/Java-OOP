package net.bigmir;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		String line = "Hello everyone";
        List<String> array = new ArrayList<>();
        array.add(line);
        List<Integer> list = array.stream()
        		.flatMapToInt(n -> n.chars())
        		.mapToObj(n -> (int) n)
        		.collect(Collectors.toCollection(ArrayList::new));
        
        System.out.println(list);
        }

}
