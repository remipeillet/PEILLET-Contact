import LPS2IMA.PEILLET.Contact.ContactService;
import LPS2IMA.PEILLET.Contact.Exception.ContactException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactServiceTest {

    private ContactService contactService;

    @Before
    public void setUp(){
        this.contactService = new ContactService();
    }


    @Test(expected =ContactException.class)
    public void testNomNull() throws ContactException{
        this.contactService.creeContact(null,"0625092785");
    }

    @Test(expected =ContactException.class)
    public void testNomVide() throws ContactException{
        this.contactService.creeContact("","0625092785");
    }

    @Test(expected =ContactException.class)
    public void testNomMoinsTroisCaractere() throws ContactException{
        this.contactService.creeContact("re","0625092785");
    }

    @Test(expected =ContactException.class)
    public void testNomPlusDeQuaranteCaractere() throws ContactException{
        this.contactService.creeContact("reeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee","0625092785");
    }

    @Test(expected =ContactException.class)
    public void testNomExisteDeja() throws ContactException{
        this.contactService.creeContact("Peillet","0625092785");
        this.contactService.creeContact("Peillet","0625092785");
    }

    @Test
    public void testNom3Caractere() throws ContactException{
        this.contactService.creeContact("pei","0625092785");
    }

    @Test
    public void testNom40Caractere() throws ContactException{
        this.contactService.creeContact("reeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee","0625092785");
    }
}
