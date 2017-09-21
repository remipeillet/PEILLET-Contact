package peillet.contact;

import peillet.contact.exception.ContactException;

import java.util.ArrayList;

/**
 * Class contactDAO.
 */
public class ContactDAO implements IContactDAO {

    /**
     * Liste des contacts.
     */
    private ArrayList<Contact> contacts;

    /**
     * Constructeur.
     */
    public ContactDAO() {
        this.contacts = new ArrayList<Contact>();
    }

    /**
     * getter des contacts.
     * @return la liste des contacts.
     */
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    /**
     * creation nouveau contact.
     * @param nouveauContact le nouveau contact.
     * @throws ContactException Exception leve si contact non comforme.
     */
    public void creerContact(final Contact nouveauContact) throws ContactException {

        contacts.add(nouveauContact);

    }

    /**
     * Supprimer un contact.
     * @param contact nom du contact a supprimer.
     * @throws ContactException Exception leve si contact non comforme.
     */
    public void supprimerContact(final Contact contact) throws ContactException {
        contacts.remove(contact);
    }

    /**
     * recuperer un contact.
     * @param nom nom du contact a recuperer.
     * @return le contact.
     * @throws ContactException Exception leve si contact non comforme.
     */
    public Contact recupererContact(final String nom) throws ContactException {
        Contact ret = null;
        if (this.isContactExiste(nom)) {
            boolean find = false;
            int i = 0;
            while (!find && i < contacts.size()) {
                if (contacts.get(i).getNom().equals(nom)) {
                    find = true;
                    ret = contacts.get(i);
                }
                i++;
            }
        } else {
            throw new ContactException("Le contact n'existe pas");
        }

        return ret;
    }

    /**
     * verifie l'existance du contact.
     * @param nom nom du contact a tester.
     * @return si il existe ou pas
     */
    public boolean isContactExiste(final String nom) {
        boolean find = false;
        int i = 0;
        while (!find && i < contacts.size()) {
            if (contacts.get(i).getNom().equals(nom)) {
                find = true;
            }
            i++;
        }
        return find;
    }

}
