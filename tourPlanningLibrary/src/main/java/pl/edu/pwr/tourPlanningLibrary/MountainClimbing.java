package pl.edu.pwr.tourPlanningLibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MountainClimbing extends Tour {

	private double drink;
	private int rope;
	private double calories;
	private int climbingHarness;
	private int helmet;
	private int firstAidKit;
	private int map;
	private int flashlight;

	public MountainClimbing(int numberOfPeople, int numberOfDays) {
		super(numberOfPeople, numberOfDays);
	}

	public int getRope() {
		return rope;
	}

	public void setRope(int rope) {
		this.rope = rope;
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

	public int getClimbingHarness() {
		return climbingHarness;
	}

	public void setClimbingHarness(int climbingHarness) {
		this.climbingHarness = climbingHarness;
	}

	public int getHelmet() {
		return helmet;
	}

	public void setHelmet(int helmet) {
		this.helmet = helmet;
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
		return "Wspinaczka górska";
	}

	public double calculateDrinkOnTour() {
		return getDrink() * numbOfPeople * numbOfDay;
	}

	public double calculateFoodOnTour() {
		return getCalories() * numbOfPeople * numbOfDay;
	}

	public long calculateNumberOfRope() {
		return getRope();
	}

	public long calculateNumberOfClimbingHarness() {
		return getClimbingHarness() * numbOfPeople;
	}

	public long calculateNumberOfHelmet() {
		return getHelmet() * numbOfPeople;
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

			String query = "SELECT drink, rope, calories, climbing_harness, helmet, first_aid_kit, map, flash_light FROM mountain_climbing";

			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				this.drink = (rs.getDouble("drink"));
				this.rope = (rs.getInt("rope"));
				this.calories = (rs.getInt("calories"));
				this.climbingHarness = (rs.getInt("climbing_harness"));
				this.helmet = (rs.getInt("helmet"));
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
				+ ((calculateNumberOfHelmet() == 1) ? calculateNumberOfHelmet() + " kask\n •  "
						: calculateNumberOfHelmet() + " kaski\n •  ")
				+ ((calculateNumberOfRope() == 1) ? calculateNumberOfRope() + " lina\n •  "
						: calculateNumberOfRope() + " liny\n •  ")
				+ ((calculateNumberOfClimbingHarness() == 1) ? calculateNumberOfClimbingHarness() + " uprząż\n •  "
						: calculateNumberOfClimbingHarness() + " uprzęże\n •  ")
				+ ((calculateFirstAidKit() == 1) ? calculateFirstAidKit() + " apteczka\n •  "
						: calculateFirstAidKit() + " apteczki\n •  ")
				+ ((calculateNumberOfMap() == 1) ? calculateNumberOfMap() + " mapa\n •  "
						: calculateNumberOfMap() + " mapy\n •  ")
				+ ((calculateNumberOfFlashlight() == 1) ? calculateNumberOfFlashlight() + " latarka\n"
						: calculateNumberOfFlashlight() + " latarki\n");
		return result;

	}

}
