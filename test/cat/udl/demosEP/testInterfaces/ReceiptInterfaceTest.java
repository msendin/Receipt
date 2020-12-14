package cat.udl.demosEP.testInterfaces;

import cat.udl.demosEP.exceptions.IsClosedException;
import org.junit.jupiter.api.Test;

public interface ReceiptInterfaceTest {

    @Test
    void addLineTest() throws IsClosedException;

    @Test
    void addTaxesTest() throws IsClosedException;

    @Test
    void getIsClosedExceptionTest();
}
