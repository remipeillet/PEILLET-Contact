package LPS2IMA.PEILLET.Contact;

import LPS2IMA.PEILLET.Contact.Exception.ContactException;

import java.util.ArrayList;

public class ContactDAO implements IContactDAO {

    private ArrayList<Contact> contacts;



    public ContactDAO(){
        this.contacts = new ArrayList<Contact>();
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void creerContact(Contact contact) throws ContactException{

        contacts.add(contact);

    }

    public void supprimerContact(Contact contact) throws ContactException {
        contacts.remove(contact);
    }

    public Contact recupererContact(String nom) throws ContactException{
        Contact ret = null;
        if(this.isContactExiste(nom)){
            boolean find = false;
            int i=0;
            while(!find && i<contacts.size()){
                if(contacts.get(i).getNom().equals(nom)){
                    find = true;
                    ret = contacts.get(i);
                }
                i++;
            }
        }else{
            throw new ContactException("Le contact n'existe pas");
        }

        return ret;
    }

    public boolean isContactExiste(String nom){
        boolean find = false;
        int i=0;
        while(!find && i<contacts.size()){
            if(contacts.get(i).getNom().equals(nom)){
                find = true;
            }
            i++;
        }
        return find;
    }

}
