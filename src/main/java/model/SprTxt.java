package model;

public class SprTxt implements Spr {
	public boolean sprawdz(CurrencyCollection kolekcja, String txt) {
		for (int i = 0; i < kolekcja.getTotalWaluty(); i++)
			if (kolekcja.getAll().get(i).getCode().equals(txt))
				return true;

		return false;
	}


}