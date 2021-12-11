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
    public void setUp() throws IsClosedException {
        receipt = new Receipt();

        BigDecimal p = new BigDecimal("10.00");
        receipt.addLine(p,1);

        p = new BigDecimal("9.00");
        receipt.addLine(p,6);
    }

    @Override
    @Test
    public void addLineTest() throws IsClosedException {
        BigDecimal p = new BigDecimal("100.00");
        receipt.addLine(p,10);
        assertEquals(new BigDecimal("1064.00"),receipt.getTotal());
    }

    @Override
    @Test
    public void addTaxesTest() throws IsClosedException {
        BigDecimal perc = new BigDecimal("15.00");
        receipt.addTaxes(perc);
        assertEquals(new BigDecimal("73.60"),receipt.getTotal());
    }

 }
