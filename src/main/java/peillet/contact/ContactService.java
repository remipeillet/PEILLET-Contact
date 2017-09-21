package peillet.contact;


import peillet.contact.exception.ContactException;

/**
 * Class contact service.
 */
public class ContactService {

    /**
     * conctacDAO.
     */
    private IContactDAO contactDAO;

    /**
     * constructeur.
     */
    public ContactService() {
        this.contactDAO = new ContactDAO();
    }

    /**
     * Creation d'un contact.
     * @param nom nom du contact.
     * @param tel numero de telephone du contact.
     * @throws ContactException Exception leve si contact non comforme.
     */
    public void creeContact(final String nom, final String tel) throws ContactException {


        if (nom != null && !nom.equals("")) {
            if (nom.length() < 3) {
                throw new ContactException("Nom trop court");
            } else if (nom.length() > 40) {
                throw new ContactException("Nom trop long");
            } else {
                boolean find = contactDAO.isContactExiste(nom);
                if (!find) {
                    Contact contact = new Contact(nom, tel);
                    contactDAO.creerContact(contact);
                } else {
                    throw new ContactException("Nom existe deja");
                }
            }
        } else {
            throw new ContactException("Le nom est obligatoire");
        }

    }

    /**
     * Supression d'un contact.
     * @param nom nom du contact a suprimer.
     * @throws ContactException Exception leve si contact non comforme.
     */
    public void supprimerContact(final String nom) throws ContactException {
        if (this.contactDAO.isContactExiste(nom)) {
            this.contactDAO.supprimerContact(this.contactDAO.recupererContact(nom));
        } else {
            throw new ContactException("Le contact n'existe pas");
        }
    }

    /**
     * getter contactDAO.
     * @return contactDAO.
     */
    public IContactDAO getContactDAO() {
        return contactDAO;
    }

}
