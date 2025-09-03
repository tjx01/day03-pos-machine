package pos.machine;


public class PosMachine {

    Item existProduct(String barcode) {
        return ItemsLoader.loadAllItems().stream()
                .filter(item -> item.getBarcode().equals(barcode))
                .findFirst()
                .orElse(null);
    }
}
