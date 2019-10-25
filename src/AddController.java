import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddController implements ActionListener {
	private Model model;
	private UIView view;
	
	public AddController(Model m, UIView v) {
		this.model = m;
		this.view = v;
		this.view.getAddButton().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.model.addName(this.view.getText());
		this.view.update();
	}

}
