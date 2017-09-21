import LPS2IMA.PEILLET.Contact.Contact;
import LPS2IMA.PEILLET.Contact.ContactService;
import LPS2IMA.PEILLET.Contact.Exception.ContactException;
import LPS2IMA.PEILLET.Contact.IContactDAO;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.testng.Assert;

public class ContactServiceMock extends MockTest {

    @TestSubject
    private ContactService service =new ContactService();

    @Mock
    private IContactDAO dao;

    @Test
    public void testCreerContactOk() throws ContactException{
        //Phase d'enregistrement des comportements
        String nom = "ContactOk";
        String tel = "01213456789";
        EasyMock.expect(dao.isContactExiste(nom)).andReturn(false);

        Capture<Contact> capture = EasyMock.newCapture();
        dao.creerContact(EasyMock.capture(capture));
        //Fin de l'enregistrement
        replayAll();

        //Appel de la methode
        service.creeContact(nom,tel);

        //Vérification
        verifyAll();
        Contact contact = capture.getValue();
        Assert.assertEquals(nom,contact.getNom());
        Assert.assertEquals(tel,contact.getTel());
    }

    @Test(expected = ContactException.class)
    public void testCreerContactExisteDeja() throws ContactException{
        //Phase d'enregistrement des comportements
        String nom = "ContactOk";
        String tel = "01213456789";
        EasyMock.expect(dao.isContactExiste(nom)).andReturn(true);
        //Fin de l'enregistrement
        replayAll();

        //Appel de la methode
        service.creeContact(nom,tel);

        //Vérification
        verifyAll();
    }

    @Test(expected = ContactException.class)
    public void testDeleteContactNonExistant() throws ContactException{
        //Phase d'enregistrement des comportements
        String nom = "ContactOk";
        EasyMock.expect(dao.isContactExiste(nom)).andReturn(false);
        //Fin de l'enregistrement
        replayAll();

        //Appel de la methode
        service.supprimerContact(nom);

        //Vérification
        verifyAll();
    }



}
