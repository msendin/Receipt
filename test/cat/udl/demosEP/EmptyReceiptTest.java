package cat.udl.demosEP;

import cat.udl.demosEP.exceptions.IsClosedException;
import cat.udl.demosEP.testInterfaces.ReceiptInterfaceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EmptyReceiptTest implements ReceiptInterfaceTest {

    Receipt receipt;

    @Override
    @BeforeEach
    public void setUp() {
        receipt = new Receipt();
    }

    @Override
    @Test
    public void addLineTest() throws IsClosedException {
        BigDecimal p = new BigDecimal("100.00");
        receipt.addLine(p,10);
        assertEquals(new BigDecimal("1000.00"),receipt.getTotal());
    }

    @Override
    @Test
    public void addTaxesTest() throws IsClosedException {
        BigDecimal perc = new BigDecimal("15.00");
        receipt.addTaxes(perc);
        assertEquals(new BigDecimal("0.00"),receipt.getTotal());
    }

}