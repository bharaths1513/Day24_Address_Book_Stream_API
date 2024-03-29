package Day24_Stream_API;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	public List<Contacts> list = new ArrayList<Contacts>();
	Scanner scan = new Scanner(System.in);

	/*
	 * this method perform all the operations
	 */
	public void operation() {
		System.out.println("Enter Number of contact you want to add");
		int count = scan.nextInt();
		int contactCount = 1;
		while (contactCount <= count) {

			add();
			contactCount++;
		}
		boolean status = true;
		do {

			System.out.println("Choose Operation you want to do");
			System.out.println("1. Add\t2.Edit\t3.Delete\t4.sortCity");
			switch (scan.nextInt()) {
			case 1:
				add();
				break;
			case 2:
				edit();
				break;
			case 3:
				delete();
				break;
			case 4:
				sortCity();
			default:
				status = false;
			}
		} while (status);
	}

	/*
	 * method to add person
	 */
	public void add() {
		Contacts contacts = new Contacts();
		System.out.println("Enter the First name:");
		String firstName = scan.next();
		contacts.setFirstName(firstName);

		System.out.println("Enter the Last name:");
		String lastName = scan.next();
		contacts.setLastName(lastName);

		System.out.println("Enter the address:");
		String address = scan.next();
		contacts.setAddress(address);

		System.out.println("Enter the City:");
		String city = scan.next();
		contacts.setCity(city);

		System.out.println("Enter the State:");
		String state = scan.next();
		contacts.setState(state);

		System.out.println("Enter the Zip:");
		Long zip = scan.nextLong();
		contacts.setZip(zip);

		System.out.println("Enter the Phone Number:");
		Long phoneNumber = scan.nextLong();
		contacts.setPhoneNumber(phoneNumber);

		System.out.println("Enter the Email");
		String email = scan.next();
		contacts.setEmail(email);
		list.add(contacts);
		print();
	}
	/*
	 * method for edit the contact book
	 */

	public void edit() {
		System.out.println("Enter your First name:");
		String firstName = scan.next();

		Iterator<Contacts> iterator = this.list.listIterator();

		while (iterator.hasNext()) {
			Contacts contacts = iterator.next();

			if (firstName.equals(contacts.getFirstName())) {
				System.out.println("Choose field you want to add:");
				System.out.println("1.Last Name\t2.Address\t3.City\t4.State\t5. Zip\t6.Phone Number\t7.Email");
				switch (scan.nextInt()) {
				case 1:
					System.out.println("Re-Correct your Last Name");
					contacts.setLastName(scan.next());
					break;
				case 2:
					System.out.println("Re-Correct your Address");
					contacts.setAddress(scan.next());
					break;
				case 3:
					System.out.println("Re-Correct your City");
					contacts.setCity(scan.next());
					break;
				case 4:
					System.out.println("Re-Correct your State");
					contacts.setState(scan.next());
					break;
				case 5:
					System.out.println("Re-Correct your Zip");
					contacts.setZip(scan.nextLong());
					break;
				case 6:
					System.out.println("Re-Correct your Phone Number");
					contacts.setPhoneNumber(scan.nextLong());
				case 7:
					System.out.println("Re-Correct your Email");
					contacts.setEmail(scan.next());
				}

			}
		}
	}

	/*
	 * method for deleta the contact book
	 */
	public void delete() {
		System.out.println("Enter your First name:");
		String firstName = scan.next();

		Iterator<Contacts> iterator = list.listIterator();
		while (iterator.hasNext()) {
			Contacts contacts = iterator.next();

			if (firstName.equals(contacts.getFirstName())) {
				list.remove(contacts);
			}
		}
	}

	/*
	 * method for print the contact book
	 */

	public void print() {
		Iterator<Contacts> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	/*
	 * method to count using stream
	 */

	public void countList() {
		Long total = list.stream().count();
		System.out.println(total);
	}

	/*
	 * method to search a person by Zip
	 */
	public void sortByZip() {
		Collections.sort(list, Sort.compareZip);
	}

	/*
	 * method to search a person by using first name
	 */
	public void sortByFirstName() {
		Collections.sort(list, Sort.compareFirstName);
	}

	/*
	 * method for sort by city
	 */
	public void sortCity() {
		Collections.sort(list, Sort.compareCity);
	}

	/*
	 * method for sort by state
	 */
	public void sortState() {
		Collections.sort(list, Sort.compareState);
	}
	/*
	 * overriding the to string mathod and returning list
	 */

	@Override
	public String toString() {
		return "AddressBook{" + "list=" + list + '}';
	}
}
