package de.gfn.api;

public class Person implements Comparable<Person> {

    private String vorname;
    private String nachname;

    public Person() {
    }

    public Person(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public int compareTo(Person o) { // Natürliche Ordnung
        return vorname.compareTo(o.vorname);
    }
}
