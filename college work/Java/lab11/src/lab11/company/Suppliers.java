package lab11.company;

import java.util.ArrayList;
import java.util.List;

public class Suppliers {
    private List<Supplier> supplierList;

    public Suppliers() {
        this.supplierList = new ArrayList<>();
    }

    public void addSupplier(Supplier supplier) {
        supplierList.add(supplier);
    }

    public Supplier getSupplier(int id) {
        for (Supplier supplier : supplierList) {
            if (((InvolvedParty) supplier).getId() == id) {
                return supplier;
            }
        }
        return null;
    }
}