package logic;

import model.Product;
import persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    private final Persistence persistence = new Persistence();
    private ArrayList<Product> products = new ArrayList<>();

    public Logic() {
        loadProducts();
    }

    private void loadProducts() {
        List<Product> loaded = persistence.load();

        if (loaded != null && !loaded.isEmpty()) {
            products = new ArrayList<>(loaded);
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
        products.add(new Product(idCreator(), 100, "Hojas de papel", "Papeleria"));
        products.add(new Product(idCreator(), 10, "Lapiceros", "Papeleria"));
        saveNow();
    }

    // Método público para reiniciar a valores por defecto (si es necesario)
    public void resetToDefaults() {
        products.clear();
        initializeDefaults();
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

        products.add(new Product(idCreator(), amount, name.trim(), category.trim()));
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
        for (Product p : products) {
            st.append(index++).append(". ").append(p).append("\n");
        }
        return st.toString();
    }

    public boolean duplicateId(String id) {
        if (id == null) return false;

        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public String deleteProduct(String id) {
        if (id == null || id.trim().isEmpty()) {
            return "ID inválido.";
        }

        Product product = searchProduct(id);

        if (product == null) {
            return "No existe un producto con ese identificador.";
        }

        products.remove(product);
        saveNow();
        return "El producto '" + product.getName() + "' ha sido removido exitosamente";
    }

    public Product searchProduct(String id) {
        if (id == null) return null;

        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public String[] productsId() {
        if (products.isEmpty()) {
            return new String[0];
        }

        String[] ids = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            ids[i] = products.get(i).getId();
        }
        return ids;
    }

    public String updateProduct(String id, int amount, String name, String category) {
        if (id == null || id.trim().isEmpty()) {
            return "ID inválido.";
        }
        if (name == null || name.trim().isEmpty()) {
            return "El nombre del producto no puede estar vacío.";
        }
        if (category == null || category.trim().isEmpty()) {
            return "La categoría no puede estar vacía.";
        }
        if (amount <= 0) {
            return "La cantidad debe ser positiva.";
        }

        Product product = searchProduct(id);

        if (product == null) {
            return "No existe un producto con ese identificador.";
        }

        product.setAmount(amount);
        product.setName(name.trim());
        product.setCategory(category.trim());
        saveNow();

        return "Producto actualizado exitosamente:\n" + product;
    }

    public String askProduct(String id, int amount) {
        if (id == null || id.trim().isEmpty()) {
            return "ID inválido.";
        }

        Product product = searchProduct(id);

        if (product == null) {
            return "No existe un producto con ese identificador.";
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

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products); // Retorna copia para evitar modificaciones externas
    }
}