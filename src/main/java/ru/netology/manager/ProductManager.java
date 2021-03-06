package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;


public class ProductManager {
    private ProductRepository repository = new ProductRepository();
    private Product[] products = new Product[0];

    public ProductManager() {
    }

    public Product[] getAll() {
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    //public boolean matches(Product item, String search) {
    //   if (item instanceof Book) { // если в параметре product лежит объект класса Book
    //Book book = (Book) item; // положем его в переменную типа Book чтобы пользоваться методами класса Book
    //       if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
    //           return true;
    //      }
    //       if (book.getName().contains(search)) {
    //           return true;
    //       }
    //       return false;
    //   }
    //   if (item instanceof Smartphone) {
    //      Smartphone smartphone = (Smartphone) item;
    //      if (smartphone.getManufacturer().contains(search)) {
    //          return true;
    //      }
    //      if (smartphone.getName().contains(search)) {
    //          return true;
    //      }
    //      return false;
    //  }
    // return false;
    //}
    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}