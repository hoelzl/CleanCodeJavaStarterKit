package demo;

public class CleanAlgorithm {

	private boolean[]	marker;
	private int			anzahlMarkierte	= 0;
	private int			currentUnmarked	= 0;

	public static int getLastUnmarkedPerson(int anzahl) {
		return new CleanAlgorithm(anzahl).getLastUnmarkedPerson();
	}

	public CleanAlgorithm(int i) {
		marker = new boolean[i];
	}

	public int getLastUnmarkedPerson() {
		while (nochMehrAlsEineUnmarkiertePersonVorhanden()) {
			markNext();
			gotoNextUnmarked();
		}

		return currentUnmarked;
	}

	private boolean nochMehrAlsEineUnmarkiertePersonVorhanden() {
		return anzahlMarkierte < marker.length - 1;
	}

	private void markNext() {
		marker[getNextUnmarkedPerson()] = true;
		anzahlMarkierte++;
	}

	private void gotoNextUnmarked() {
		currentUnmarked = getNextUnmarkedPerson();
	}

	private int getNextUnmarkedPerson() {
		int next = currentUnmarked;
		do {
			next = (next + 1) % marker.length;
		} while (marker[next]);
		return next;
	}

}
