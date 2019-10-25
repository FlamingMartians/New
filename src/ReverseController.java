import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

public class ReverseController implements ActionListener {
	private Model model;
	private UIView view;
	private Comparator<String> reverseComp;
	private Comparator<String> normalComp;
	private boolean isReverse;

	public ReverseController(Model m, UIView v) {
		this.model = m;
		this.view = v;
		this.view.getReverseButton().addActionListener(this);
		this.isReverse = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!isReverse) {
			this.model.setComparator(getReverseOrderComp());
			isReverse = true;
		} else {
			this.model.setComparator(getNormalOrderComp());
			isReverse = false;
		}
		this.view.update();
	}

	private Comparator<String> getReverseOrderComp() {
		if (reverseComp == null) {
			reverseComp = new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o2.toLowerCase().compareTo(o1.toLowerCase());
				}

			};
		}
		return reverseComp;
	}

	private Comparator<String> getNormalOrderComp() {
		if (normalComp == null) {
			normalComp = new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o1.toLowerCase().compareTo(o2.toLowerCase());
				}

			};
		}
		return normalComp;
	}
}
