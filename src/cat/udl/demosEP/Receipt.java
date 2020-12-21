package cat.udl.demosEP;

import cat.udl.demosEP.exceptions.IsClosedException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

class Receipt {

    private List<ReceiptLine> listOfProducts;
    private BigDecimal total;
    private boolean isClosed;

    Receipt() {
        listOfProducts = new ArrayList<>();
        total = new BigDecimal("0");
        isClosed = false;
    }

    void addLine(BigDecimal pricePerUnit, int numUnits) throws IsClosedException {
        if (isClosed)
            throw new IsClosedException("Recibo ya cerrado");
        else {
            ReceiptLine rcline = new ReceiptLine(pricePerUnit, numUnits);
            listOfProducts.add(rcline);
            total = total.add(rcline.getPrice().multiply(BigDecimal.valueOf(rcline.getNumUnits())));
        }
    }

    void addTaxes(BigDecimal percent) throws IsClosedException {
        if (isClosed)
            throw new IsClosedException ("Recibo ya cerrado");
        else {
            BigDecimal cent = new BigDecimal("100");
            total = total.add(total.multiply(percent).divide(cent,2, RoundingMode.CEILING));
            isClosed = true;
        }
    }

    BigDecimal getTotal() {
        return total;
    }

}
