
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;


public class AddressBook implements Serializable 
{
	private ArrayList<PersonDetails> personList = new ArrayList<PersonDetails>();

	/**
	 * @return personlist
	 */
	public ArrayList<PersonDetails> getPersonList() {
		return personList;
	}
	/**this function set the values for person list
	 * @param personList
	 */
	public void setPersonList(ArrayList<PersonDetails> personList) {
		this.personList = personList;
	}
	/**Constructor to retrive all the data from json at the time of execution
	 * @param FILEPATH
	 */
	public AddressBook(String FILEPATH ) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			personList = mapper.readValue(new File(FILEPATH), new TypeReference<ArrayList<PersonDetails>>() {});
		} catch (IOException e) {
			System.err.println("AddressBook is empty..! First add some data.");
		}
	}

}