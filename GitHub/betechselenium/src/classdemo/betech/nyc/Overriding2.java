package classdemo.betech.nyc;

public abstract class Overriding2    {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Overriding1 ovrd = new Overriding1();
		System.out.println(ovrd.add(1,2));
		

	}
	
	public static int add(int i, int j) {
		System.out.println("Running Override2");
		return i + j;

	}

}

interface btc{
	public void apply();
	public void contact();
}


