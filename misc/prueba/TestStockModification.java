import java.util.ArrayList;

// Clase Item para representar productos
class Item {
    private String name;
    private double price;
    private int amount;
    private int id;

    public Item(String name, double price, int amount, int id) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.id = id;
    }

    // Getters y setters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getAmount() { return amount; }
    public int getId() { return id; }
    public void setAmount(int amount) { this.amount = amount; }

    @Override
    public String toString() {
        return "Item{name='" + name + "', price=" + price + ", amount=" + amount + ", id=" + id + "}";
    }
}

// Clase Logic que maneja la lógica de negocio
class Logic {
    ArrayList<Item> Items = new ArrayList<>();

    // Método para agregar producto
    public String product(String name, double price, int amount, int id) {
        if (searchItem(name) != -1) {
            return "El producto ya existe previamente";
        } else {
            Item item = new Item(name, price, amount, id);
            Items.add(item);
            return "Producto agregado exitosamente: " + name;
        }
    }

    // Método para vender producto (simula facturación)
    public String sellItem(String itemName, int amount) {
        int itemIndex = searchItem(itemName);
        
        if (itemIndex == -1) {
            return "El producto no está registrado";
        }

        Item item = Items.get(itemIndex);
        System.out.println("ANTES de modificar - Item en ArrayList: " + Items.get(itemIndex));
        System.out.println("Referencia obtenida: " + item);
        
        if (item.getAmount() < amount) {
            return "Stock insuficiente. Disponible: " + item.getAmount();
        }

        // ✅ ESTA ES LA PARTE IMPORTANTE - Modificamos el objeto
        item.setAmount(item.getAmount() - amount);
        
        System.out.println("DESPUÉS de modificar - Item en ArrayList: " + Items.get(itemIndex));
        System.out.println("Referencia después de modificar: " + item);
        
        return "Venta exitosa. Nuevo stock de " + itemName + ": " + item.getAmount();
    }

    // Método de búsqueda corregido
    public int searchItem(String name) {
        for (int i = 0; i < Items.size(); i++) {
            if (Items.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // Método para mostrar todos los items
    public void showAllItems() {
        System.out.println("\n--- INVENTARIO ACTUAL ---");
        for (Item item : Items) {
            System.out.println(item);
        }
        System.out.println("-------------------------\n");
    }
}

// Clase principal para testing
public class TestStockModification {
    public static void main(String[] args) {
        Logic logic = new Logic();

        System.out.println("=== PRUEBA DE MODIFICACIÓN DE STOCK ===");
        
        // Agregar productos
        System.out.println(logic.product("Laptop", 1000.0, 10, 1));
        System.out.println(logic.product("Mouse", 25.0, 50, 2));
        
        // Mostrar inventario inicial
        logic.showAllItems();

        // 🔍 PRUEBA 1: Vender unidades de Laptop
        System.out.println("--- Venta 1: 3 Laptops ---");
        System.out.println(logic.sellItem("Laptop", 3));
        logic.showAllItems();

        // 🔍 PRUEBA 2: Vender más unidades
        System.out.println("--- Venta 2: 2 Laptops ---");
        System.out.println(logic.sellItem("Laptop", 2));
        logic.showAllItems();

        // 🔍 PRUEBA 3: Intentar vender más de lo disponible
        System.out.println("--- Venta 3: 10 Laptops (solo hay 5) ---");
        System.out.println(logic.sellItem("Laptop", 10));
        logic.showAllItems();

        // 🔍 PRUEBA 4: Vender Mouse
        System.out.println("--- Venta 4: 5 Mouses ---");
        System.out.println(logic.sellItem("Mouse", 5));
        logic.showAllItems();

        // 🔍 PRUEBA 5: Verificar que son el mismo objeto
        System.out.println("--- Verificación de referencias ---");
        Item itemFromList = logic.Items.get(0);
        int itemIndex = logic.searchItem("Laptop");
        Item itemFromSearch = logic.Items.get(itemIndex);
        
        System.out.println("¿Son el mismo objeto? " + (itemFromList == itemFromSearch));
        System.out.println("HashCode itemFromList: " + System.identityHashCode(itemFromList));
        System.out.println("HashCode itemFromSearch: " + System.identityHashCode(itemFromSearch));

        System.out.println("\n=== PRUEBA COMPLETADA ===");
    }
}