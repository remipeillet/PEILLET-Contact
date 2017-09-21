package LPS2IMA.PEILLET.Contact;


import LPS2IMA.PEILLET.Contact.Exception.ContactException;

import java.util.ArrayList;

public interface IContactDAO {

    public void creerContact(Contact contact) throws ContactException;

    public void supprimerContact(Contact contact) throws ContactException;

    public Contact recupererContact(String nom) throws ContactException;

    public boolean isContactExiste(String nom);

    public ArrayList<Contact> getContacts();
}
