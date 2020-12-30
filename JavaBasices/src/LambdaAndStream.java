package src;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdaAndStream {
	public static void main(String[] str)
	{
		//Lambda for run
		 new Thread( new Runnable (){
				 @Override
				 public void run()
				 {
					 System.out.println(" Thread first");
				 }
		 }).start();;
		 
		// Lambda way
		 
		 new Thread(()-> System.out.println(" Thread Second")).start();
		 
		 System.out.println("==========================================================");
		 
		Stream<String> features = Stream.of("Lambdas", "Default Method", "Stream API", "Date and Time API"); 
		//features.forEach(n -> System.out.println(n));
		 System.out.println("==========================================================");
		//Filter list start with 'D'
		features.filter(p->p.charAt(0)=='D').forEach(p-> System.out.println(p));
		System.out.println("==========================================================");
		features.sorted((a,b)->a.compareTo(b));
		// Even better use Method reference feature of Java 8 
		// method reference is denoted by :: (double colon) operator 
		// looks similar to score resolution operator of C++ 
		features.forEach(System.out::println);
		System.out.println("==========================================================");
		
		filter(features, p->p.charAt(0)=='D');
		System.out.println("==========================================================");
		filter(features,p->p.split("\\s+").length==2);
		 
		System.out.println("==========================================================");
		//Combine 2 predicate
		Predicate<String> woordsIn = p->p.split("\\s+").length==2;
		Predicate<String> startswith =p->p.charAt(0)=='D';
		filter(features,woordsIn.and(startswith));
		System.out.println("=================Map===============================");
		// With Lambda expression: 
		Stream<Integer> costBeforeTax = Stream.of(100, 200, 300, 400, 500);
		costBeforeTax.map((cost) -> cost + .12*cost).forEach(System.out::println);
		System.out.println("=================Reduce===============================");
		Optional<Double> sumall = costBeforeTax.map((cost) -> cost + .12*cost).reduce((cost,sum)->sum+cost);
		System.out.println(sumall.get());
	}
	// Filter method to filter using Predicate
	public static void filter(Stream<String> list, Predicate<String> condition)
	{
		list.filter(p->condition.test(p)).forEach(System.out::println);
	}

}
