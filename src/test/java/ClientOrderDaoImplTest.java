import com.mycompany.taxi.dao.implementation.ClientOrderDaoImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 09.07.2016.
 */
public class ClientOrderDaoImplTest {

    ClientOrderDaoImpl clientOrderDao = new ClientOrderDaoImpl();

    @Test
    public  void convertToPkeyTest(){
        String data = "(+38) 050 38 67 78";
        String pkey = clientOrderDao.convertToPkey(data);
        String result = clientOrderDao.backconvert(pkey);
        String rdata = data.replaceAll("[ )(]","").replaceFirst("\\+38","");

        Assert.assertEquals(data,result);

    }

}
