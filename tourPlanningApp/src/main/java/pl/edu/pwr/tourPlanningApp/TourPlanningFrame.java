package pl.edu.pwr.tourPlanningApp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pl.edu.pwr.tourPlanningLibrary.*;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TourPlanningFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNumberOfPeople;
	private JTextField textFieldNumberOfDays;
	private JComboBox<String> comboBoxTypeTour;
	private JTextArea textArea;

	public TourPlanningFrame() {
		setTitle("Przewodnik wycieczkowicza");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Tour.setTypeToList();

		JLabel lblType = new JLabel("Typ:");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(107, 32, 76, 16);
		contentPane.add(lblType);

		String[] array = Tour.getTypeOfTour().toArray(new String[Tour.getTypeOfTour().size()]);
		comboBoxTypeTour = new JComboBox<String>(array);
		comboBoxTypeTour.setBounds(195, 29, 146, 22);
		contentPane.add(comboBoxTypeTour);

		textFieldNumberOfPeople = new JTextField();
		textFieldNumberOfPeople.setBounds(195, 77, 146, 22);
		contentPane.add(textFieldNumberOfPeople);
		textFieldNumberOfPeople.setColumns(10);

		JLabel lblNumberOfPeople = new JLabel("Liczba osób:");
		lblNumberOfPeople.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumberOfPeople.setBounds(61, 80, 122, 16);
		contentPane.add(lblNumberOfPeople);

		textFieldNumberOfDays = new JTextField();
		textFieldNumberOfDays.setBounds(195, 121, 146, 22);
		contentPane.add(textFieldNumberOfDays);
		textFieldNumberOfDays.setColumns(10);

		JLabel lblNumberOfDays = new JLabel("Liczba dni:");
		lblNumberOfDays.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumberOfDays.setBounds(88, 124, 96, 16);
		contentPane.add(lblNumberOfDays);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 182, 402, 249);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		JButton btnWygeneruj = new JButton("Wygeneruj ");
		btnWygeneruj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tour t = new Tour(Integer.parseInt(textFieldNumberOfPeople.getText()),
						Integer.parseInt(textFieldNumberOfDays.getText()));
				if (Tour.getTypeOfTour().contains(comboBoxTypeTour.getSelectedItem())
						&& (comboBoxTypeTour.getSelectedItem().equals("Spływ kajakowy"))) {
					Kayaking k = new Kayaking(Integer.parseInt(textFieldNumberOfPeople.getText()),
							Integer.parseInt(textFieldNumberOfDays.getText()));
					textArea.setText(k.completeTheEquipment());
				} else if (Tour.getTypeOfTour().contains(comboBoxTypeTour.getSelectedItem())
						&& (comboBoxTypeTour.getSelectedItem().equals("Zwiedzanie"))) {
					Sightseeing s = new Sightseeing(Integer.parseInt(textFieldNumberOfPeople.getText()),
							Integer.parseInt(textFieldNumberOfDays.getText()));
					textArea.setText(s.completeTheEquipment());
				} else if (Tour.getTypeOfTour().contains(comboBoxTypeTour.getSelectedItem())
						&& (comboBoxTypeTour.getSelectedItem().equals("Wspinaczka górska"))) {
					MountainClimbing m = new MountainClimbing(Integer.parseInt(textFieldNumberOfPeople.getText()),
							Integer.parseInt(textFieldNumberOfDays.getText()));
					textArea.setText(m.completeTheEquipment());
				}
			}
		});
		btnWygeneruj.setBounds(189, 455, 120, 25);
		contentPane.add(btnWygeneruj);

	}

}
