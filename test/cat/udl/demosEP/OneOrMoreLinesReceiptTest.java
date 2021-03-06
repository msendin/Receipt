package cat.udl.demosEP;

import cat.udl.demosEP.exceptions.IsClosedException;
import cat.udl.demosEP.testInterfaces.ReceiptInterfaceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OneOrMoreLinesReceiptTest implements ReceiptInterfaceTest {

    Receipt receipt;

    @BeforeEach
    void setUp() throws IsClosedException {
        receipt = new Receipt();

        BigDecimal p = new BigDecimal("10");
        receipt.addLine(p,1);

        p = new BigDecimal("9");
        receipt.addLine(p,6);
    }

    @Override
    @Test
    public void addLineTest() throws IsClosedException {
        BigDecimal p = new BigDecimal("100");
        receipt.addLine(p,10);
        assertEquals(new BigDecimal("1064"),receipt.getTotal());
    }

    @Override
    @Test
    public void addTaxesTest() throws IsClosedException {
        BigDecimal perc = new BigDecimal("15");
        receipt.addTaxes(perc);
        assertEquals(new BigDecimal("73.6"),receipt.getTotal());
    }

    @Override
    @Test
    public void getIsClosedExceptionTest() {
        Throwable exception = assertThrows(IsClosedException.class,
                () -> {
                    BigDecimal perc = new BigDecimal("15");
                    receipt.addTaxes(perc);
                    BigDecimal p = new BigDecimal("100");
                    receipt.addLine(p,10);
                });
    }
}
