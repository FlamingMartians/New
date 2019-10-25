import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveController implements ActionListener {

	private Model model;
	private UIView view;
	
	public RemoveController(Model m, UIView v) {
		this.model = m;
		this.view = v;
		this.view.getRemoveButton().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.model.removeName(this.view.getComboxText());
		this.view.update();
	}

}
