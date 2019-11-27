package lessons.dataStructures.coreType.creationalPatterns.aFactory;

public enum ExchangeType {
	INVALID("INVALID"), DOLLAR("DOLLAR"), EURO("EURO"), WON("WON");

	private String name;

	private ExchangeType(String s) {
	}

	public String getName() {
		return name;
	}

	public static ExchangeType getByName(String s) {

		switch (s.toUpperCase()) {
		case "DOLLAR":
			return DOLLAR;
		case "EURO":
			return EURO;
		case "WON":
			return WON;
		default:
			return INVALID;
		}
	}
}
