package  com.javase.factory;

public class Factory {

	public static  Frute getFrute(String name){
		if(name.equals("apple")){
			return new Apple();
		}else if(name.equals("banana")){
			return new Banana();
		}
		
		return null;
		
	}
}
