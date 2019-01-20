package model;

public interface Parser {
	String[] parseNazwaWaluty();
	String[] parseKodWaluty();
	String[] parsePrzelicznikWaluty();
	String[] parseKursWaluty();
	int getTotalWaluty();
}