package no.hvl.dat100.jplab12.oppgave3;

//import java.util.ArrayList;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;

public class Blogg {

	// TODO: objektvariable
	protected Innlegg[] blogg2; //claimed the array
	protected int nextvar;
	
	public Blogg() {
		this.blogg2 = new Innlegg[20]; //constructor for the declaration
	}								

	public Blogg(int lengde) {
		this.blogg2 = new Innlegg[lengde];
		this.nextvar = 0;
	}

	public int getAntall() {
		return nextvar; 
	}
	
	public Innlegg[] getSamling() {
		
		return blogg2;
	}
	
	public int finnInnlegg(Innlegg innlegg) {

		int position = -1;
		int id1 = innlegg.getId();
		for (int i = 0; i<blogg2.length; i++) {
			if (id1 == blogg2[i].getId()) {
				position = i;
			}
		}
		return position;
	}

	public boolean finnes(Innlegg innlegg) {
		
		for (int i = 0; i<blogg2.length; i++) {
			if (blogg2[i] != null) {
				if (innlegg.erLik(blogg2[i]) == true) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		
		boolean exists = false;
		for (int i = 0; i < blogg2.length; i++) {
			if (blogg2[i] == null) {
				exists = true;
			}
		}
		return exists;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		
		boolean done;
		if (finnes(innlegg) == false) {
			blogg2[nextvar] = innlegg;
			nextvar ++;
			done = true;
		} else { done = false; }
		return done;
	}
	
	public String toString() {
		String output = nextvar + "\n";
		for (int i = 0; i < blogg2.length; i++) {
			if (finnes(blogg2[i]) == true) {
		output += blogg2[i].toString();
			}
		}
		return output;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg [] expandedblogg = new Innlegg [blogg2.length * 2];
		for (int i = 0; i < blogg2.length; i++) {
			expandedblogg[i] = blogg2[i];
		}
		blogg2 = expandedblogg;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		
		boolean accomplished = true;
		for (int i = 0; i < blogg2.length; i++) {
			if (innlegg.erLik(blogg2[i]) == true) {
				accomplished = false;
			}
		}
			if (nextvar > blogg2.length) {
				utvid();
			}
			if (accomplished) {
				blogg2[nextvar] = innlegg;
				return accomplished;
			}
		return false;
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}