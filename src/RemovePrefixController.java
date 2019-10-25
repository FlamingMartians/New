import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class RemovePrefixController implements ActionListener {

	private Model model;
	private UIView view;

	public RemovePrefixController(Model m, UIView v) {
		this.model = m;
		this.view = v;
		this.view.getRemovePrefixButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!this.view.getPrefix().isEmpty()) {
			Set<String> names = new HashSet<>();
			for (String name : this.model.getNames()) {
				if (name.toLowerCase().startsWith(this.view.getPrefix().toLowerCase())) {
					names.add(name);
				}
			}

			for (String name : names) {
				this.model.removeName(name);
			}

			this.view.update();
		}
	}

}
