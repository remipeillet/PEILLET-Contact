package LPS2IMA.PEILLET.Contact;

public class Contact {

    private String nom;
    private String tel;

    public Contact(String nom,String tel){
        this.nom=nom;
        this.tel=tel;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel){
        this.tel = tel;
    }
}
