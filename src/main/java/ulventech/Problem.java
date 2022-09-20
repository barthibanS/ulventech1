package ulventech;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem {
	
	public static void main(String args[]) {
		new Problem().startProcceding(52);
	}

	public String startProcceding(final int count) {
		List<String> list = new ArrayList<>();
		String temp = null;

		for (int i = 0; count > 0 && count <= 230 && i < count; i++) {
			temp = stringGenaration();
			if (!list.contains(temp)) {
				list.add(temp);
			} else {
				i--;
			}
		}

		return fileWrite(list);
	}

	public String fileWrite(final List<String> list) {
		if (!list.isEmpty()) {
			try {
				FileWriter myWriter = new FileWriter("TEMP.txt");
				for (String str : list) {
					myWriter.write(str + "\n");
				}
				myWriter.close();
				return "Success";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "Failed";
	}

	public String stringGenaration() {
		int start = 48, end = 122, charSize = 100;
		Random random = new Random();

		String generatedString = random.ints(start, end + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(charSize).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();

		return generatedString;
	}

}
