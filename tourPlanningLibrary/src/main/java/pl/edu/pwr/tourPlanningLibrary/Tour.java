package pl.edu.pwr.tourPlanningLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class Tour {

	protected int numbOfPeople;
	protected int numbOfDay;
	private static ArrayList<String> typeOfTour = new ArrayList<String>();

	public Tour(int numbOfPeople, int numbOfDay) {
		this.numbOfPeople = numbOfPeople;
		this.numbOfDay = numbOfDay;
	}

	public int getNumbOfPeople() {
		return numbOfPeople;
	}

	public void setNumbOfPeople(int numbOfPeople) {
		this.numbOfPeople = numbOfPeople;
	}

	public int getNumbOfDay() {
		return numbOfDay;
	}

	public void setNumbOfDay(int numbOfDay) {
		this.numbOfDay = numbOfDay;
	}

	public static void setTypeToList() {
		typeOfTour.add("Spływ kajakowy");
		typeOfTour.add("Zwiedzanie");
		typeOfTour.add("Wspinaczka górska");
	}

	public static ArrayList<String> getTypeOfTour() {
		return typeOfTour;
	}

	public void setTypeOfTour(ArrayList<String> typeOfTour) {
		Tour.typeOfTour = typeOfTour;
	}

	public String completeTheEquipment() {
		return null;
	}

	public static Connection getConnection() {

		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tour_planning?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
			return connection;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
