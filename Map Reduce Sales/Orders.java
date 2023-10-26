import com.sun.corba.se.spi.ior.Writeable;
import org.omg.CORBA_2_3.portable.OutputStream;

public class Orders implements Writeable {
    private int OrderID;
    private int OrderDate;
    private int OrderTotalAmount;
    private int OrderQty;



    @Override
    public void write(OutputStream arg0) {

    }
}
