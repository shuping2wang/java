package  com.javase.singleton;

public class SingletonOfLazy {
	private SingletonOfLazy(){}
	private static SingletonOfLazy singleton = null;
	public static SingletonOfLazy getInstance(){
		if(singleton==null){
			synchronized (SingletonOfLazy.class) {
				if(singleton == null){
					singleton = new SingletonOfLazy();
				}
			}
		}
		return singleton;
	}
}

