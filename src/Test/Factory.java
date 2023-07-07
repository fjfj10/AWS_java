package Test;

class Factory {
	
	private static Factory instance;
	
	private String factoryName;
	
	private Factory() {
		factoryName = Factory.class.getSimpleName().toUpperCase();
	}
	public static Factory getInstance() {  
		if(instance == null) {
			instance = new Factory();
		}
		
		return instance;
	}
	public String getFactoryName() {
		return factoryName;
	}
}
