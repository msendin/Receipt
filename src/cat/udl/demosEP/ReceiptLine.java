package cat.udl.demosEP;

import java.math.BigDecimal;

class ReceiptLine {
    private final int numUnits;
    private final BigDecimal price;


    ReceiptLine (BigDecimal price, int num) {
        this.price = price;
        numUnits = num;
    }


    int getNumUnits () {
        return numUnits;
    }

    BigDecimal getPrice() {
        return price;
    }

}