package pl.edu.pwr.tourPlanningLibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Sightseeing extends Tour {

	private int camera;
	private double drink;
	private int guid;

	public Sightseeing(int numberOfPeople, int numberOfDays) {
		super(numberOfPeople, numberOfDays);
	}

	public int getCamera() {
		return camera;
	}

	public void setCamera(int camera) {
		this.camera = camera;
	}

	public double getDrink() {
		return drink;
	}

	public void setDrink(double drink) {
		this.drink = drink;
	}

	public int getGuid() {
		return guid;
	}

	public void setGuid(int guid) {
		this.guid = guid;
	}

	@Override
	public String toString() {
		return "Zwiedzianie";
	}

	public double calculateDrinkOnTour() {
		return getDrink() * numbOfPeople;
	}

	public long calculateNumberOfCamera() {
		return getCamera();
	}

	public long calculateNumberOfGuid() {
		return getGuid();
	}

	public String completeTheEquipment() {
		
		try {

			Connection connection = Tour.getConnection();

			String query = "SELECT drink, camera, guid FROM sightseeing";

			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				this.drink = (rs.getDouble("drink"));
				this.camera = (rs.getInt("camera"));
				this.guid = (rs.getInt("guid"));

			} else {
				JOptionPane.showMessageDialog(null, "Nastąpił nieoczekiwany problem z połączeniem z bazą danych");
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		String result = " •  " + calculateDrinkOnTour() + " l napojów w ciągu dnia\n •  "
				+ ((calculateNumberOfGuid() == 1) ? calculateNumberOfGuid() + " przewodnik\n •  "
						: calculateNumberOfGuid() + " przewodniki\n •  ")
				+ ((calculateNumberOfCamera() == 1) ? calculateNumberOfCamera() + " aparat\n"
						: calculateNumberOfCamera() + " aparaty\n");
		return result;

	}

}
