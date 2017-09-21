package peillet.contact;

/**
 * Classe contact.
 */
public class Contact {

    /**
     * attribut nom.
     */
    private String nom;
    /**
     * attribut tel.
     */
    private String tel;

    /**
     * Constructeur.
     * @param nouveauNom nom du contact.
     * @param nouveauTel telephone du contact.
     */
    public Contact(final String nouveauNom, final String nouveauTel) {
        this.nom = nouveauNom;
        this.tel = nouveauTel;
    }

    /**
     * Getter du nom.
     * @return le nom du contact.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * setter du nom.
     * @param nouveauNom nouveau nom du contact.
     */
    public void setNom(final String nouveauNom) {
        this.nom = nouveauNom;
    }

    /**
     * getter du telephone.
     * @return le telephone du contact.
     */
    public String getTel() {
        return this.tel;
    }

    /**
     * setter du tlephone.
     * @param nouveauTel nouveau telephone du contact.
     */
    public void setTel(final String nouveauTel) {
        this.tel = nouveauTel;
    }
}
