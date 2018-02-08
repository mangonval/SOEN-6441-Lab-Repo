import java.util.*;
import java.util.stream.Collectors;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class PuttingIntoPractice{
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        
        // Query 1
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
		
		List<Transaction> transactions2011 = transactions.stream()
				.filter(i -> i.getYear() == 2011)
				.sorted(comparing(Transaction::getValue))
				.collect(Collectors.toList());
		
		transactions2011.forEach(System.out::println);
		
		// Query 2
		
		List<String> cities = transactions.stream()
				.map(transaction -> transaction.getTrader().getCity())
				.distinct()
				.collect(toList());
		
		cities.forEach(System.out::println);
		
		// Query 3
		
		List<Trader> traders = transactions.stream()
				.map(transaction -> transaction.getTrader())
				.filter(trader -> trader.getCity() == "Cambridge")
				.sorted(comparing(Trader::getName))
				.distinct()
				.collect(toList());
		traders.forEach(System.out::println);
		
		// Query 4
		
		List<String> tradersNames = transactions.parallelStream()
				.map(Transaction::getTrader)
				.distinct()
				.map(Trader::getName)
				.sorted()
				.collect(toList());
		tradersNames.forEach(System.out::println);
		
		// Query 5
		
		List<Trader> tradersInMilan = transactions.parallelStream()
				.map(Transaction::getTrader)
				.filter(trader -> trader.getCity() == "Milan")
				.distinct()
				.collect(toList());
		tradersInMilan.forEach(System.out::println);
        
       
    }
}