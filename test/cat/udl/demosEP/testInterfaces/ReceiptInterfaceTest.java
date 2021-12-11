package cat.udl.demosEP.testInterfaces;

import cat.udl.demosEP.Receipt;
import cat.udl.demosEP.exceptions.IsClosedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

public interface ReceiptInterfaceTest {

    Receipt receipt = new Receipt();

    @BeforeEach
    void setUp() throws IsClosedException;

    @Test
    void addLineTest() throws IsClosedException;

    @Test
    void addTaxesTest() throws IsClosedException;

    @Test
    default void getIsClosedExceptionTest() {
        assertThrows(IsClosedException.class,
                () -> {
                    BigDecimal perc = new BigDecimal("15.00");
                    receipt.addTaxes(perc);
                    BigDecimal p = new BigDecimal("100.00");
                    receipt.addLine(p,10);
                });
    }
}
