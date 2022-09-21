package ulventech;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import ulventech.skeleton.ProblemInterface;

public class Problem implements ProblemInterface {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		System.out.println("Enter X : ");
		String stringX = new Scanner(System.in).nextLine();

		if (stringX != null && Pattern.compile(REGEX).matcher(stringX).matches()) {
			Problem problem = new Problem();
			problem.fileWrite(problem.uniqueStringListCreation(Integer.parseInt(stringX)));
		}
	}

	@Override
	public List<String> uniqueStringListCreation(final int count) {
		List<String> list = new ArrayList<>();
		String temp = null;

		for (int i = 0; count > 0 && count <= MAX_COUNT && i < count; i++) {
			temp = stringGenaration();
			if (!list.contains(temp)) {
				list.add(temp);
			} else {
				i--;
			}
		}
		return list;
	}

	@Override
	public void fileWrite(final List<String> list) {
		if (list != null && !list.isEmpty()) {
			try (FileWriter myWriter = new FileWriter(FILE_NAME)) {
				for (String str : list) {
					myWriter.write(str + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String stringGenaration() {
		return random.ints(START, END + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(CHAR_SIZE)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}

}
