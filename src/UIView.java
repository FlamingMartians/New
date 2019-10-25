import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UIView {
	private Model model;
	private JButton addButton;
	private JButton removeButton;
	private JButton reverseButton;
	private JButton removePrefixButton;
	private JButton removeSuffixButton;
	private JComboBox comboBox;
	private JTextField textField;
	private JTextField prefixField;
	private JPanel panel;
	
	public UIView(Model m) {
		this.model = m;
		this.addButton = new JButton();
		this.removeButton = new JButton();
		this.reverseButton = new JButton();
		this.removePrefixButton = new JButton();
		this.removeSuffixButton = new JButton();
		this.comboBox = new JComboBox();
		this.textField = new JTextField();
		this.prefixField = new JTextField();
		this.panel = new JPanel();
	}
	
	public JPanel getPanel() {
		return this.panel;
	}
	
	public JButton getAddButton() {
		return this.addButton;
	}
	
	public JButton getReverseButton() {
		return this.reverseButton;
	}
	
	public JButton getRemoveButton() {
		return this.removeButton;
	}
	
	public JButton getRemovePrefixButton() {
		return this.removePrefixButton;
	}
	
	public JButton getRemoveSuffixButton() {
		return this.removeSuffixButton;
	}
	
	public String getText() {
		return this.textField.getText();
	}
	
	public String getPrefix() {
		return this.prefixField.getText();
	}
	
	public String getSuffix() {
		return this.prefixField.getText();
	}
	
	public String getComboxText() {
		return (String) this.comboBox.getSelectedItem();
	}
	
	public void update() {
		this.comboBox.removeAllItems();
		for(String name : this.model.getNames()) {
			this.comboBox.addItem(name);
		}
		this.textField.setText("");
	}
	
	public void initialize(ActionListener controller) {
		JFrame frame = new JFrame();
		frame.setSize(200, 300);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Name Sorter");
		panel.setPreferredSize(new Dimension(200, 300));
		panel.setLayout(new GridLayout(7,1));
		
		this.textField.setVisible(true);
		this.textField.setPreferredSize(new Dimension(200, 40));

		this.textField.addKeyListener(new ReturnPressKeyListener(controller, this.textField));
		panel.add(this.textField, BorderLayout.NORTH);
		
		this.comboBox.setVisible(true);
		this.comboBox.setPreferredSize(new Dimension(200, 40));
		panel.add(this.comboBox, BorderLayout.SOUTH);
		
		this.addButton.setText("ADD");
		this.addButton.setVisible(true);
		this.addButton.setPreferredSize(new Dimension(200, 40));
		panel.add(this.addButton, BorderLayout.SOUTH);

		this.removeButton.setText("REMOVE");
		this.removeButton.setVisible(true);
		this.removeButton.setPreferredSize(new Dimension(200, 40));
		panel.add(this.removeButton, BorderLayout.SOUTH);
		
		this.reverseButton.setText("REVERSE");
		this.reverseButton.setVisible(true);
		this.reverseButton.setPreferredSize(new Dimension(200, 40));
		panel.add(this.reverseButton, BorderLayout.SOUTH);	
		
		this.prefixField.setVisible(true);
		this.prefixField.setPreferredSize(new Dimension(200, 40));
		panel.add(this.prefixField, BorderLayout.SOUTH);
		
		JPanel removeButtonSection = new JPanel();
		removeButtonSection.setPreferredSize(new Dimension(200, 40));
		this.removePrefixButton.setText("<html>REMOVE<br>PREFIX</html>");
		this.removePrefixButton.setVisible(true);
		this.removePrefixButton.setPreferredSize(new Dimension(90, 40));
		this.removeSuffixButton.setText("<html>REMOVE<br>SUFFIX</html>");
		this.removeSuffixButton.setVisible(true);
		this.removeSuffixButton.setPreferredSize(new Dimension(90, 40));
		removeButtonSection.add(removePrefixButton);
		removeButtonSection.add(removeSuffixButton);
		panel.add(removeButtonSection, BorderLayout.SOUTH);
		
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}
}
