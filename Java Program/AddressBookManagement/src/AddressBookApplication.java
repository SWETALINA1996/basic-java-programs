

import java.io.IOException;
import com.bridgelabz.utility.Utility;

public class AddressBookApplication 
{
	static final String STORAGE_FILE_PATH = "/home/bridgelabz/swetalina/basic-java-programs/AddressBookManagement/src/files/storage.json";
	public static void main(String[] args) throws IOException {
		AddressBookController bookManager = new AddressBookController(STORAGE_FILE_PATH);
		showInitialOptions(bookManager);
	}

	/**This function show initial options to perform some operations such as create ,delete,open, view address book
	 * @param bookManager
	 */
	public static void showInitialOptions(AddressBookController bookManager) {
		System.out.println("Choose One from following options: ");
		System.out.println("1.CREATE\n2.OPEN\n3.VIEW\n4.DELETE\n5.QUIT");
		int option = Utility.readInteger();
		switch (option) {
		case 1:
			bookManager.createNew();
			bookManager.showList();
			break;
		case 2:
			System.out.println("Which AddressBook you want to open ? ");
			bookManager.showList();
			System.out.println("Enter index");
			int indexOfFile = Utility.readInteger();
			bookManager.openExistingAddressBook(indexOfFile);
			break;
		case 3:
			System.out.println(" This Address Books are exist");
			bookManager.showList();
			showInitialOptions(bookManager);
			break;
		case 4:
			System.out.println("Which address book you want to delete");
			bookManager.showList();
			System.out.println("Enter index: ");
			int index = Utility.readInteger();
			bookManager.deleteAddressBook(index);
			bookManager.showList();
			showInitialOptions(bookManager);
			break;
		case 5:
			bookManager.exit();
			
			break;
		}
	}
}
