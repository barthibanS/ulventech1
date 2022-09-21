package ulventech.skeleton;

import java.util.List;
import java.util.Random;

public interface ProblemInterface {

	static final int START = 48;
	static final int END = 122;
	static final int CHAR_SIZE = 100;
	static final int MAX_COUNT = 230;
	static final String FILE_NAME = "TEMP.txt";
	static final String REGEX = "-?\\d+(\\.\\d+)?";
	
	Random random = new Random();

	public List<String> uniqueStringListCreation(final int count);

	public void fileWrite(final List<String> list);

	public String stringGenaration();

}
