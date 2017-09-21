package peillet.contact;


import peillet.contact.exception.ContactException;

import java.util.ArrayList;
import java.util.List;

public interface IContactDAO {

    public void creerContact(Contact contact) throws ContactException;

    public void supprimerContact(Contact contact) throws ContactException;

    public Contact recupererContact(String nom) throws ContactException;

    public boolean isContactExiste(String nom);

    public List<Contact> getContacts();
}
