package pos.machine;


import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class PosMachine {

    Map<String, Integer> groupItems(List<String> barcodes) {
        return barcodes.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        barcode -> 1,
                        Integer::sum,
                        LinkedHashMap::new
                ));
    }

    String calculatePrices(Map<String, Integer> barcodeMap) {
        StringBuilder receiptBuilder = new StringBuilder();
        formatReceipt(receiptBuilder, barcodeMap);
        formatBeginAndEnd(receiptBuilder);
        return receiptBuilder.toString();
    }

    void formatReceipt(StringBuilder receiptBuilder, Map<String, Integer> barcodeMap) {
        int totalPrice = 0;
        for (Map.Entry<String, Integer> entry : barcodeMap.entrySet()) {
            String barcode = entry.getKey();
            int count = entry.getValue();
            Item item = existProduct(barcode);
            if (item != null) {
                int itemTotalPrice = item.getPrice() * count;
                totalPrice += itemTotalPrice;
                receiptBuilder.append(String.format("Name: %s, Quantity: %d, Unit price: %d (yuan), Subtotal: %d (yuan)\n",
                        item.getName(), count, item.getPrice(), itemTotalPrice));
            } else {
                throw new RuntimeException("Unknown barcode: " + barcode);
            }
        }
        receiptBuilder.append("----------------------\n");
        receiptBuilder.append(String.format("Total: %d (yuan)\n", totalPrice));
    }

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
