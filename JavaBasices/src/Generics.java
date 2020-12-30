package src;

public class Generics
{
	public static void main(String[] s)
	{
		Vehicle<String> v = new Car();
		v.getBrand("BMV");
		
		Vehicle<Honda> v1 = new Bike();
		v1.getBrand(new Honda() );
	}
}
interface Vehicle<T> {
	T getBrand(T t);

}

class Car implements Vehicle<String>
{
	@Override
	public String getBrand(String brand)
	{
		return brand;
	}
}

class Bike implements Vehicle<Honda>
{
	@Override
	public Honda getBrand(Honda brand)
	{
		brand.setName("HONDA");
		return brand;
	}
}

class Honda {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
