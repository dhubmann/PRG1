
public class PizzaMaker {

	public static void main(String[] args) {
		
		Pizza basic = new TomatoSauce(new Mozzarella(new PlainPizza()));
	
		System.out.println(basic.getDescription());
		System.out.println(basic.getCost());
		
	}
	
}
