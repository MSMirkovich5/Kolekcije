import java.util.Objects;

class Polaznik  implements Comparable<Polaznik>{
    private String ime;
    private String prezime;
    private String email;

    public Polaznik(String ime, String prezime, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int compareTo(Polaznik p) {
        int cmp = this.prezime.compareTo(p.prezime);

        if (cmp == 0) {
            cmp = this.ime.compareTo(p.ime);
        }

        if (cmp == 0) {
            cmp = this.email.compareTo(p.email);
        }

        return cmp;
    }
    @Override
    public String toString() {
        return "Ime: " + ime + ", Prezime: " + prezime + ", E-mail: " + email;
    }
}