
public class ApplicationStarter {

	public static void main(String[] args) {
		Model m = new Model();
		UIView v = new UIView(m);
		AddController c = new AddController(m, v);
		RemoveController rc = new RemoveController(m, v);
		ReverseController rec = new ReverseController(m, v);
		RemovePrefixController rpc = new RemovePrefixController(m, v);
		RemoveSuffixController rsc = new RemoveSuffixController(m, v);
		v.initialize(c);
	}

}
