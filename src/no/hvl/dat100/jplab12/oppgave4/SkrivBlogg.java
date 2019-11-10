package no.hvl.dat100.jplab12.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab12.oppgave3.Blogg;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn) {

		try {
			PrintWriter pw = new PrintWriter (MAPPE + filnavn);
			pw.print(samling.toString());
			pw.close();
			return true;
		}
		catch (FileNotFoundException e) {
			System.out.print("Error: " + e);
			return false;
		}
	}
}
