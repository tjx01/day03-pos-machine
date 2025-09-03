package pos.machine;


public class PosMachine {

    void formatBeginAndEnd(StringBuilder receiptBuilder) {
        receiptBuilder.insert(0, "***<store earning no money>Receipt***\n");
        receiptBuilder.append("**********************");
    }

    Item existProduct(String barcode) {
        return ItemsLoader.loadAllItems().stream()
                .filter(item -> item.getBarcode().equals(barcode))
                .findFirst()
                .orElse(null);
    }
}
