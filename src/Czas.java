
public class Czas {
	private int godz;
	private int minuty;

public Czas(int h, int min) {
	godz = h;
	minuty = min;
	int a=0;
	while (minuty>59) {
		a++;
		minuty-=60;
	}
	godz=godz+a;
}

public Czas(String tekst) {
	int h=0, min=0, i=0;
	while (i<tekst.length()) {
		if (tekst.charAt(i)>47 && tekst.charAt(i)<58) {
			h = h*10+ Integer.valueOf(tekst.charAt(i)-'0');
			i++;
			if(Character.isWhitespace(tekst.charAt(i))==true) {
				break;
			}
		}
		else {
			i++;
		}
	}
	while (i<tekst.length()) {
		if (tekst.charAt(i)>47 && tekst.charAt(i)<58) {
			min = min*10+ Integer.valueOf(tekst.charAt(i)-'0');
			i++;
			if(Character.isWhitespace(tekst.charAt(i))==true) {
				break;
			}
		}
		else {
			i++;
		}
	}
	godz=h;
	minuty=min;
}

public String toString() {
	return (godz+" h "+minuty+" min");
}

public Czas dodaj(Czas t) {
	int a=0, b=0;
	a = t.godz + godz;
	b = t.minuty + minuty;
	return new Czas(a, b);
}

public Czas odejmij(Czas t) {
	int min = (godz*60+minuty)-(t.godz*60+t.minuty);
	return new Czas(0, min);
}

public Czas pomnoz(int ile) {
	int a = godz * ile;
	int b = minuty * ile;
	return new Czas(a, b);
}

public static Czas sumuj(Czas [] tab, int n) {
	Czas t = tab[0];
	for(int i=1; i<tab.length; i++) {
		t=t.dodaj(tab[i]);
	}
	return t;
}
}

