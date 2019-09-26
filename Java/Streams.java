import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Comparator;
import java.util.Set;

public class Streams {
	
	public static void main(String[] args) {

		List<String> names = Arrays.asList("a1","a2","a3","b1","b2");
		names.stream().filter(element -> element.startsWith("a")).forEach(System.out::println);
		System.out.println("-------------------------------");

		Stream.of(1,2,3,4,5).map(num -> num*100).forEach(System.out::println);
		System.out.println("-------------------------------");

		Stream.of(1.0, 1.5, 2.0, 2.5, 3.0).mapToInt(Double::intValue).mapToObj(element -> "VALUE: "+element).forEach(System.out::println);
		System.out.println("-------------------------------");

		List<Person> people = Arrays.asList(new Person("Pepe",15), new Person("Paula",15), new Person("Lola",18), new Person("Tina",22), new Person("Pedro",33));	
		List<Person> pPeople = people.stream().filter(person -> person.name.startsWith("P")).collect(Collectors.toList());
		System.out.println("P People:"+pPeople+" ---\n");
		System.out.println("-------------------------------");

		Map<Integer,List<Person>> peopleAgeGroups = people.stream().collect(Collectors.groupingBy(Person::getAge));
		peopleAgeGroups.forEach((age,person) -> System.out.println(""+age+" - "+person));
		people.stream().reduce((p1,p2) -> p1.age < p2.age ? p1 : p2).ifPresent(System.out::println);
		System.out.println("-------------------------------");

		Map<Integer,Map<Boolean,Set<Person>>> groupedPeople = people.stream().collect(Collectors.groupingBy(person -> person.getAge(),Collectors.groupingBy(person -> person.getName().startsWith("P"), Collectors.toSet())));
		groupedPeople.forEach((age,group) -> System.out.println("For age " + age + " there is the group: " + group));
		System.out.println("-------------------------------");

		Map<Integer,Map<String,List<Person>>> anotherGroup = people.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.groupingBy(Person::getName)));
		anotherGroup.forEach((age,group) -> System.out.println("Another age " + age + " another group: "+group));
		System.out.println("-------------------------------");

		Map<Boolean,List<Person>> conditionSplit = people.stream().collect(Collectors.partitioningBy(person -> person.getAge() < 20));
		conditionSplit.forEach((condition, group) -> System.out.println("" + condition + " --- " + group));
		System.out.println("-------------------------------");

		List<A> as = new ArrayList<>();
		IntStream.range(1,4).forEach(index -> as.add(new A("a"+index)));
		as.forEach(a -> IntStream.range(1,4).forEach(index -> a.bs.add(new B("b"+index+" of "+a.name))));
		//System.out.println(""+as);
		//as.forEach(a -> System.out.println(""+a.bs));
		as.stream().flatMap(a -> a.bs.stream()).forEach(flat -> System.out.println(flat));
	}
}

class Person {

	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() { return "Person: "+name+" - "+age; }

	public int getAge() { return age; }

	public String getName() { return name; }
}

class A {
	List<B> bs;
	String name;

	public A(String name) {
		this.name = name;
		bs = new ArrayList<>();
	}

	@Override
	public String toString(){ return ""+name; }
}

class B {
	String name;

	public B(String name) { this.name = name; }

	@Override
	public String toString(){ return ""+name; }
}
