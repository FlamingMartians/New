import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Model {
	private Set<String> names;

	public Model() {
		this.names = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.toLowerCase().compareTo(o2.toLowerCase());
			}

		});
	}

	public Set<String> getNames() {
		return this.names;
	}

	public void addName(String name) {
		names.add(name);
	}

	public void removeName(String name) {
		names.remove(name);
	}

	public void setComparator(Comparator<String> comp) {
		Set<String> s = new TreeSet<>(comp);
		for (String name : this.names) {
			s.add(name);
		}
		this.names = s;
	}
}
