import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;



public class MapExercise {
	public static void main(String...args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		Function<Integer, Integer> square = x -> x * x;
		List<Integer> squares = numbers.stream()
				.map(square)
				.collect(Collectors.toList());
		
		squares.forEach(System.out::println);
		
		List<Integer> setA = Arrays.asList(1,2,3);
		List<Integer> setB = Arrays.asList(4,5);
		
		List<int[]> pairs = setA.stream()
				.flatMap(i -> setB.parallelStream().map(j -> new int[] {i, j}))
				.collect(Collectors.toList())
				.stream()
				.filter(i -> (i[0] + i[1])%3 == 0)
				.collect(Collectors.toList());
		
		pairs.forEach(i -> {
            System.out.println("{" + i[0]+ "," + i[1]+ "}");
		});
		
		
	}

}
