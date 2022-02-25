package src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoilerPlateTest {
	@Test
	public void FixedTest1() {
		try {
			assertEquals("Throw an exception!", BoilerPlate.boil(new String[0]));
		} catch (RuntimeException e) {
		}
	}

	@Test
	public void FixedTest2() {
		try {
			assertEquals("Throw an exception!", BoilerPlate.boil(new String[]{"Cake", "double", "price", "color"}));
		} catch (RuntimeException e) {
		}
	}

	@Test
	public void FixedTest3() {
		String a = "public class Cake\n" +
				"{\n" +
				"	private double price;\n" +
				"	private String color;\n"+
				"	public Cake(double price, String color)\n"+
				"	{\n"+
				"		this.price=price;\n"+
				"		this.color=color;\n"+
				"	}\n"+
				"	public double getPrice()\n"+
				"	{\n"+
				"		return price;\n"+
				"	}\n"+
				"	public void setPrice(double price)\n"+
				"	{\n"+
				"		this.price=price;\n"+
				"	}\n"+
				"	public String getColor()\n"+
				"	{\n"+
				"		return color;\n"+
				"	}\n"+
				"	public void setColor(String color)\n"+
				"	{\n"+
				"		this.color=color;\n"+
				"	}\n"+
				"	public String toString()\n"+
				"	{\n"+
				"		return \"Price: \"+price+\"\\n\"\n"+
				"			+\"Color: \"+color;\n"+
				"	}\n"+
				"}";
		assertEquals(a, BoilerPlate.boil(new String[]{"Cake", "double", "price", "String", "color"}));
	}

	@Test
	public void FixedTest4() {
		String a = "public class ID\n" +
				"{\n"+
				"	private String name;\n"+
				"	private int idNumber;\n"+
				"	private boolean expired;\n"+
				"	public ID(String name, int idNumber, boolean expired)\n"+
				"	{\n"+
				"		this.name=name;\n"+
				"		this.idNumber=idNumber;\n"+
				"		this.expired=expired;\n"+
				"	}\n"+
				"	public String getName()\n"+
				"	{\n"+
				"		return name;\n"+
				"	}\n"+
				"	public void setName(String name)\n"+
				"	{\n"+
				"		this.name=name;\n"+
				"	}\n"+
				"	public int getIdNumber()\n"+
				"	{\n"+
				"		return idNumber;\n"+
				"	}\n"+
				"	public void setIdNumber(int idNumber)\n"+
				"	{\n"+
				"		this.idNumber=idNumber;\n"+
				"	}\n"+
				"	public boolean getExpired()\n"+
				"	{\n"+
				"		return expired;\n"+
				"	}\n"+
				"	public void setExpired(boolean expired)\n"+
				"	{\n"+
				"		this.expired=expired;\n"+
				"	}\n"+
				"	public String toString()\n"+
				"	{\n"+
				"		return \"Name: \"+name+\"\\n\"\n"+
				"			+\"Id Number: \"+idNumber+\"\\n\"\n"+
				"			+\"Expired: \"+expired;\n"+
				"	}\n"+
				"}";
		assertEquals(a, BoilerPlate.boil(new String[]{"ID", "String", "name", "int", "idNumber", "boolean", "expired"}));
	}
}