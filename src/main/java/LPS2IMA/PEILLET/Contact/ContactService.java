package LPS2IMA.PEILLET.Contact;


import LPS2IMA.PEILLET.Contact.Exception.ContactException;

public class ContactService {

    private IContactDAO contactDAO;

    public ContactService(){
        this.contactDAO = new ContactDAO();
    }

    public void creeContact(String nom, String tel) throws ContactException{


        if(nom!=null && !nom.equals("")){
            if(nom.length()<3){
                throw new ContactException("Nom trop court");
            }else if(nom.length()>40){
                throw new ContactException("Nom trop long");
            }else{
                boolean find = contactDAO.isContactExiste(nom);
                if(!find){
                    Contact contact = new Contact(nom,tel);
                    contactDAO.creerContact(contact);
                }else{
                    throw new ContactException("Nom existe deja");
                }
            }
        }else{
            throw new ContactException("Le nom est obligatoire");
        }

    }

    public void supprimerContact(String nom) throws ContactException{
        if(this.contactDAO.isContactExiste(nom)){
            this.contactDAO.supprimerContact(this.contactDAO.recupererContact(nom));
        }else{
            throw new ContactException("Le contact n'existe pas");
        }
    }

    public IContactDAO getContactDAO() {
        return contactDAO;
    }

}
