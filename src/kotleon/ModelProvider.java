package kotleon;

import java.util.ArrayList;
import java.util.List;

public enum ModelProvider {
	INSTANCE;
	
	private List<Cat> cats;
	
	public List<Cat> getCats() {
		return cats;
	}
	
	private ModelProvider() {
		cats = new ArrayList<Cat>();
		
		cats.add(new Cat("Leon", "male", 14, "Maria"));
		cats.add(new Cat("Matylda", "female", 3, "Maria"));
		cats.add(new Cat("Terry", "male", 1, "Pratchett"));
		cats.add(new Cat("Joanne", "female", 2, "Rowling"));
		cats.add(new Cat("PanPazdziernik", "male", 2, "Ruslana"));
		cats.add(new Cat("Luna", "female", 5, "Piotr"));
		cats.add(new Cat("Maiko", "female", 11, "Marianna"));
	}

	public void zmienImieKota(String stareImie, String zmienioneImie) {
		// TODO Auto-generated method stub
		for(Cat cat : cats) {
			if(cat.getName() == stareImie) {
				cat.setName(zmienioneImie);
			}
		}
	}
}
