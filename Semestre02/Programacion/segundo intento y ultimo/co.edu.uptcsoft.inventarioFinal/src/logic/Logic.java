package logic;

import model.Product;
import persistence.Persistence;

import java.util.HashMap;

public class Logic {

    private final Persistence persistence = new Persistence();
    private HashMap<String, Product> products = new HashMap<>();

    public Logic() {
        loadProducts();
    }

    private void loadProducts() {
        HashMap<String, Product> loaded = persistence.load();

        if (loaded != null && !loaded.isEmpty()) {
            products = new HashMap<>(loaded);
        } else {
            // Si no hay datos guardados, inicializar con productos por defecto
            initializeDefaults();
        }
    }

    private void saveNow() {
        persistence.save(products);
    }

    // Este método solo se llama si no hay productos guardados
    private void initializeDefaults() {
        String id1 = idCreator();
        Product p1 = new Product(id1, 100, "Hojas de papel", "Papeleria");
        products.put(p1.getName(), p1);

        String id2 = idCreator();
        Product p2 = new Product(id2, 10, "Lapiceros", "Papeleria");
        products.put(p2.getName(), p2);

        saveNow();
    }

    public String createProduct(int amount, String name, String category) {
        // Validaciones
        if (name == null || name.trim().isEmpty()) {
            return "El nombre del producto no puede estar vacío.";
        }
        if (category == null || category.trim().isEmpty()) {
            return "La categoría no puede estar vacía.";
        }
        if (amount <= 0) {
            return "La cantidad debe ser positiva.";
        }

        String normalizedName = name.trim();

        // Verificar si ya existe un producto con ese nombre
        if (products.containsKey(normalizedName)) {
            return "Ya existe un producto con el nombre '" + normalizedName + "'.";
        }

        String id = idCreator();
        Product newProduct = new Product(id, amount, normalizedName, category.trim());
        products.put(normalizedName, newProduct);
        saveNow();
        return "El producto ha sido creado exitosamente";
    }

    public String idCreator() {
        int value;
        int attempts = 0;
        do {
            value = (int) (Math.random() * 41) + 10; // 10–50
            attempts++;
            if (attempts > 100) {
                // Seguridad: evitar bucle infinito si hay muchos productos
                return String.valueOf(System.currentTimeMillis() % 10000);
            }
        } while (duplicateId(String.valueOf(value)));
        return String.valueOf(value);
    }

    public String showProducts() {
        if (products.isEmpty()) {
            return "No hay productos registrados actualmente";
        }
        StringBuilder st = new StringBuilder("Lista de productos:\n\n");
        int index = 1;
        for (Product p : products.values()) {
            st.append(index++).append(". ").append(p).append("\n");
        }
        return st.toString();
    }

    public boolean duplicateId(String id) {
        if (id == null) return false;

        for (Product p : products.values()) {
            if (p.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public String deleteProduct(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Nombre inválido.";
        }

        Product product = products.remove(name.trim());

        if (product == null) {
            return "No existe un producto con ese nombre.";
        }

        saveNow();
        return "El producto '" + product.getName() + "' ha sido removido exitosamente";
    }

    public Product searchProduct(String name) {
        if (name == null) return null;
        return products.get(name.trim());
    }

    public String[] productsId() {
        if (products.isEmpty()) {
            return new String[0];
        }

        return products.keySet().toArray(new String[0]);
    }

    public String updateProduct(String oldName, int amount, String newName, String category) {
        if (oldName == null || oldName.trim().isEmpty()) {
            return "Nombre inválido.";
        }
        if (newName == null || newName.trim().isEmpty()) {
            return "El nombre del producto no puede estar vacío.";
        }
        if (category == null || category.trim().isEmpty()) {
            return "La categoría no puede estar vacía.";
        }
        if (amount <= 0) {
            return "La cantidad debe ser positiva.";
        }

        String normalizedOldName = oldName.trim();
        String normalizedNewName = newName.trim();

        Product product = searchProduct(normalizedOldName);

        if (product == null) {
            return "No existe un producto con ese nombre.";
        }

        // Si el nombre cambió, verificar que el nuevo nombre no exista
        if (!normalizedOldName.equals(normalizedNewName)) {
            if (products.containsKey(normalizedNewName)) {
                return "Ya existe un producto con el nombre '" + normalizedNewName + "'.";
            }

            // Remover con el nombre viejo y agregar con el nuevo
            products.remove(normalizedOldName);
        }

        product.setAmount(amount);
        product.setName(normalizedNewName);
        product.setCategory(category.trim());

        products.put(normalizedNewName, product);
        saveNow();

        return "Producto actualizado exitosamente:\n" + product;
    }

    public String askProduct(String name, int amount) {
        if (name == null || name.trim().isEmpty()) {
            return "Nombre inválido.";
        }

        Product product = searchProduct(name);

        if (product == null) {
            return "No existe un producto con ese nombre.";
        }

        if (amount <= 0) {
            return "La cantidad debe ser positiva.";
        }

        int current = product.getAmount();

        if (current < amount) {
            return "No hay suficiente stock disponible.\nStock actual: " + current + " unidades.";
        }

        product.setAmount(current - amount);
        saveNow();

        return "Producto solicitado exitosamente.\n" +
                "Ordenaste " + amount + " unidades de '" + product.getName() + "'.\n" +
                "Stock restante: " + product.getAmount() + " unidades.";
    }

    public int getTotalProducts() {
        return products.size();
    }

    public HashMap<String, Product> getProducts() {
        return new HashMap<>(products); // Retorna copia para evitar modificaciones externas
    }

    public String checkLowStock() {
        StringBuilder lowStockAlert = new StringBuilder();
        int threshold = 10; // Umbral de stock bajo

        for (Product p : products.values()) {
            if (p.getAmount() < threshold && p.getAmount() > 0) {
                lowStockAlert.append("⚠️ ")
                        .append(p.getName())
                        .append(": ")
                        .append(p.getAmount())
                        .append(" unidades\n");
            }
        }

        return lowStockAlert.toString();
    }

    public boolean hasLowStock() {
        int threshold = 10;

        for (Product p : products.values()) {
            if (p.getAmount() < threshold && p.getAmount() > 0) {
                return true;
            }
        }
        return false;
    }
}