package Day24_Stream_API;

import java.util.Comparator;

public class Sort {
	static Comparator<Contacts> compareCity = new Comparator<Contacts>() {
		public int compare(Contacts one, Contacts two) {
			return one.getCity().compareTo(two.getCity());
		}
	};
	/*
	 * anonymous calss to State search
	 */
	static Comparator<Contacts> compareState = new Comparator<Contacts>() {
		public int compare(Contacts one, Contacts two) {
			return one.getState().compareTo(two.getState());
		}
	};

	/*
	 * 
	 * anonymous calss to search a person by using first name
	 *
	 */
	static Comparator<Contacts> compareFirstName = new Comparator<Contacts>() {
		public int compare(Contacts one, Contacts two) {
			return one.getFirstName().compareTo(two.getFirstName());
		}
	};
	/*
	 * 
	 * anonymous calss to search a person by zip
	 *
	 */
	static Comparator<Contacts> compareZip = new Comparator<Contacts>() {
		public int compare(Contacts one, Contacts two) {
			return one.getZip().compareTo(two.getZip());
		}
	};
}
