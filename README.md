# Requirement

A cash register (POS) system is used in the store for settlement of the store. This cashier will settle and print the receipt (Receipt) according to the item(Item) in the customer's shopping cart (Cart) at the time of settlement.

We need to implement a function called printReceipt, which can input the data of the specified format as a parameter and then output the text of the receipt.

This time, the input will be an array of barcodes (string). For example:

```
[
  'ITEM000000',
  'ITEM000000',
  'ITEM000000',
  'ITEM000000',
  'ITEM000001',
  'ITEM000001',
  'ITEM000004',
  'ITEM000004',
  'ITEM000004'
]
```

Then the output should be

```
***<store earning no money>Receipt***
Name: Coca-Cola, Quantity: 4, Unit price: 3 (yuan), Subtotal: 12 (yuan)
Name: Sprite, Quantity: 2, Unit price: 3 (yuan), Subtotal: 6 (yuan)
Name: Battery, Quantity: 3, Unit price: 2 (yuan), Subtotal: 6 (yuan)
----------------------
Total: 24 (yuan)
**********************
```

The database is as follows:

```
[
   {
      barcode: 'ITEM000000',
      name: 'Coca-Cola',
      price: 3
    },
    {
      barcode: 'ITEM000001',
      name: 'Sprite',
      price: 3
    },
    {
      barcode: 'ITEM000004',
      name: 'Battery',
      price: 2
    }
]
```


# Steps

1. Please draw task diagrams.
2. Please declare all the methods according to your diagram.
3. Please write implementations according to the task diagram
4. Please repeat step 3 until all functions are implemented and make sure test case can pass.