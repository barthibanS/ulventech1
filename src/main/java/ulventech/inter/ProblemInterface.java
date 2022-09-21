package ulventech.inter;

import java.util.List;
import java.util.Random;

public interface ProblemInterface {

	static final int START = 48;
	static final int END = 122;
	static final int CHAR_SIZE = 100;
	static final String FILE_NAME = "TEMP.txt";
	static final String REGEX = "-?\\d+(\\.\\d+)?";
	static final String SUCCESS = "Success";
	static final String FAILED = "Failed";
	
	Random random = new Random();

	public String startProcceding(final int count);

	public String fileWrite(final List<String> list);

	public String stringGenaration();

}
