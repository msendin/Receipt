package cat.udl.demosEP.testInterfaces;

import cat.udl.demosEP.Receipt;
import cat.udl.demosEP.exceptions.IsClosedException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

public interface ReceiptInterfaceTest {

    Receipt receipt = new Receipt();

    @Test
    void addLineTest() throws IsClosedException;
    // Checks the addLine() method

    @Test
    void addTaxesTest() throws IsClosedException;
    // Checks the addTaxes() method

    @Test
    default void getIsClosedExceptionTest() {
    // Checks if the IsClosedException throws adequately
        BigDecimal perc = new BigDecimal("15.00");
        BigDecimal p = new BigDecimal("100.00");
        assertThrows(IsClosedException.class,
                () -> { receipt.addTaxes(perc);
                        receipt.addLine(p,10);
                });
    }
}
