package ulventech;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JUnitProblem {
	Problem problem;
	List<String> elementlist, emptyList;
	String fileName;

	@Before
	public void setUp() throws Exception {
		problem = new Problem();
		elementlist = Arrays.asList(new String[] {
				"hrzoml0d3PUIfcFejdhvJ9fCp2PgTE1O44Y1K0STBcxuqJxBTdbNrmAx4kZyAVJh9AtdrBhaL0YJmKEzOdQzUsZtUWql4m4IcOWW",
				"DyclQ6zSLwLAU8gC7wYnV062t9JEDsfdvGa3KAQLzltzjcltwKCD3Smqd1r46qB5zMP7QlEWabvNdSGMGdGXiOqPgmvrsgv045cl" });
		emptyList = new ArrayList<>();
		fileName = "TEMP.txt";
	}

	@Test
	public void teststringGenaration() {
		assertNotNull(problem.stringGenaration());
	}

	@Test
	public void testfileWrite() {
		assertEquals(problem.fileWrite(elementlist), "Success");
		assertEquals(problem.fileWrite(emptyList), "Failed");
	}

	@Test
	public void teststartProcceding() {
		assertEquals(problem.startProcceding(230), "Success");
		assertEquals(problem.startProcceding(0), "Failed");
	}

	@Test
	public void testFileValidation() {
		int size = 10;
		String line;
		List<String> testList = new ArrayList<>();
		
		assertEquals(problem.startProcceding(size), "Success");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
			while ((line = br.readLine()) != null) {
				testList.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals(testList.size(), size);
		assertEquals(testList.size(), (new HashSet<String>(testList)).size());
	}
}
