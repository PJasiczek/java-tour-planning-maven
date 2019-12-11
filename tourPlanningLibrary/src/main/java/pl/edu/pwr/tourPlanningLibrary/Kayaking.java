package pl.edu.pwr.tourPlanningLibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Kayaking extends Tour {

	private int kayak;
	private double drink;
	private double calories;
	private int lifeJacket;
	private int firstAidKit;
	private int map;
	private int flashlight;

	public Kayaking(int numberOfPeople, int numberOfDays) {
		super(numberOfPeople, numberOfDays);
	}

	public int getKayak() {
		return kayak;
	}

	public void setKayak(int kayak) {
		this.kayak = kayak;
	}

	public double getDrink() {
		return drink;
	}

	public void setDrink(double drink) {
		this.drink = drink;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public int getLifeJacket() {
		return lifeJacket;
	}

	public void setLifeJacket(int lifeJacket) {
		this.lifeJacket = lifeJacket;
	}

	public int getFirstAidKit() {
		return firstAidKit;
	}

	public void setFirstAidKit(int firstAidKit) {
		this.firstAidKit = firstAidKit;
	}

	public int getMap() {
		return map;
	}

	public void setMap(int map) {
		this.map = map;
	}

	public int getFlashlight() {
		return flashlight;
	}

	public void setFlashlight(int flashlight) {
		this.flashlight = flashlight;
	}

	@Override
	public String toString() {
		return "Spływ kajakowy";
	}

	public double calculateDrinkOnTour() {
		return getDrink() * numbOfPeople * numbOfDay;
	}

	public double calculateFoodOnTour() {
		return getCalories() * numbOfPeople * numbOfDay;
	}

	public long calculateNumberOfKayak() {
		return getKayak() * numbOfPeople;
	}

	public long calculateNumberOfLifeJackets() {
		return getLifeJacket() * numbOfPeople;
	}

	public long calculateFirstAidKit() {
		return getFirstAidKit();
	}

	public long calculateNumberOfMap() {
		return getMap();
	}

	public long calculateNumberOfFlashlight() {
		return getFlashlight();
	}

	public String completeTheEquipment() {

		try {

			Connection connection = Tour.getConnection();

			String query = "SELECT drink, calories, kayak, life_jacket, first_aid_kit, map, flash_light FROM kayaking";

			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				this.drink = (rs.getDouble("drink"));
				this.calories = (rs.getInt("calories"));
				this.kayak = (rs.getInt("kayak"));
				this.lifeJacket = (rs.getInt("life_jacket"));
				this.firstAidKit = (rs.getInt("first_aid_kit"));
				this.map = (rs.getInt("map"));
				this.flashlight = (rs.getInt("flash_light"));
			} else {
				JOptionPane.showMessageDialog(null, "Nastąpił nieoczekiwany problem z połączeniem z bazą danych");
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		String result = " •  " + calculateDrinkOnTour() + " l napojów\n •  " + calculateFoodOnTour()
				+ " kcal pożywienia\n •  "
				+ ((calculateNumberOfKayak() == 1) ? calculateNumberOfKayak() + " kajak jednoosobowy\n •  "
						: calculateNumberOfLifeJackets() + " kajaki jednoosobowe\n •  ")
				+ ((calculateNumberOfLifeJackets() == 1) ? calculateNumberOfLifeJackets() + " kapok\n •  "
						: calculateNumberOfLifeJackets() + " kapoki\n •  ")
				+ ((calculateFirstAidKit() == 1) ? calculateFirstAidKit() + " apteczka\n •  "
						: calculateFirstAidKit() + " apteczki\n •  ")
				+ ((calculateNumberOfMap() == 1) ? calculateNumberOfMap() + " mapa\n •  "
						: calculateNumberOfMap() + " mapy\n •  ")
				+ ((calculateNumberOfFlashlight() == 1) ? calculateNumberOfFlashlight() + " latarka\n"
						: calculateNumberOfFlashlight() + " latarki\n");
		return result;

	}
}
