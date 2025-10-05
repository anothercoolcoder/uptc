// Array para almacenar los libros
        let biblioteca = [];

        // Clase Libro
        class Libro {
            constructor(titulo, autor, anio, paginas, precio) {
                this.titulo = titulo;
                this.autor = autor;
                this.anio = anio;
                this.paginas = paginas;
                this.precio = precio;
            }

            // Método para obtener información del libro
            obtenerInfo() {
                return `"${this.titulo}" - ${this.autor} (${this.anio}) - ${this.paginas} páginas - $${this.precio}`;
            }

            // Método para verificar si es un libro antiguo
            esAntiguo() {
                const añoActual = new Date().getFullYear();
                return (añoActual - this.anio) > 20;
            }
        }

        // Función para validar los datos de entrada
        function validarDatos(titulo, autor, anio, paginas, precio) {
            const errores = [];

            // Validar título
            if (!titulo || titulo.trim().length < 2) {
                errores.push("El título debe tener al menos 2 caracteres");
            }

            // Validar autor
            if (!autor || autor.trim().length < 3) {
                errores.push("El autor debe tener al menos 3 caracteres");
            }

            // Validar año
            const añoActual = new Date().getFullYear();
            if (!anio || anio < 1000 || anio > añoActual) {
                errores.push(`El año debe estar entre 1000 y ${añoActual}`);
            }

            // Validar páginas
            if (!paginas || paginas < 1 || paginas > 10000) {
                errores.push("El número de páginas debe estar entre 1 y 10000");
            }

            // Validar precio
            if (!precio || precio < 0 || precio > 10000) {
                errores.push("El precio debe estar entre $0 y $10000");
            }

            return errores;
        }

        // Función principal para agregar un libro
        function agregarLibro() {
            // Obtener valores de los inputs
            const titulo = document.getElementById('titulo').value;
            const autor = document.getElementById('autor').value;
            const anio = parseInt(document.getElementById('anio').value);
            const paginas = parseInt(document.getElementById('paginas').value);
            const precio = parseFloat(document.getElementById('precio').value);

            // Validar datos
            const errores = validarDatos(titulo, autor, anio, paginas, precio);

            if (errores.length > 0) {
                mostrarResultado(errores.join('<br>'), 'error');
                return;
            }

            // Crear nuevo objeto Libro
            const nuevoLibro = new Libro(
                titulo.trim(),
                autor.trim(),
                anio,
                paginas,
                precio
            );

            // Agregar a la biblioteca
            biblioteca.push(nuevoLibro);

            // Mostrar éxito
            mostrarResultado(`✅ Libro agregado exitosamente:<br>${nuevoLibro.obtenerInfo()}`, 'success');

            // Limpiar formulario
            limpiarFormulario();
        }

        // Función para mostrar todos los libros
        function mostrarLibros() {
            if (biblioteca.length === 0) {
                mostrarResultado("📚 La biblioteca está vacía", 'error');
                return;
            }

            let resultadoHTML = `<h3>📖 Libros en la Biblioteca (${biblioteca.length})</h3>`;
            
            biblioteca.forEach((libro, index) => {
                const antiguedad = libro.esAntiguo() ? ' 📜 <em>Libro antiguo</em>' : '';
                resultadoHTML += `<p>${index + 1}. ${libro.obtenerInfo()}${antiguedad}</p>`;
            });

            mostrarResultado(resultadoHTML, 'success');
        }

        // Función para buscar libro por título
        function buscarLibro() {
            const tituloBuscado = prompt("Ingrese el título a buscar:");

            if (!tituloBuscado) {
                mostrarResultado("❌ Debe ingresar un título para buscar", 'error');
                return;
            }

            const librosEncontrados = biblioteca.filter(libro => 
                libro.titulo.toLowerCase().includes(tituloBuscado.toLowerCase())
            );

            if (librosEncontrados.length === 0) {
                mostrarResultado(`❌ No se encontraron libros con el título "${tituloBuscado}"`, 'error');
                return;
            }

            let resultadoHTML = `<h3>🔍 Libros encontrados (${librosEncontrados.length})</h3>`;
            
            librosEncontrados.forEach((libro, index) => {
                resultadoHTML += `<p>${index + 1}. ${libro.obtenerInfo()}</p>`;
            });

            mostrarResultado(resultadoHTML, 'success');
        }

        // Función auxiliar para mostrar resultados
        function mostrarResultado(mensaje, tipo) {
            const resultadoDiv = document.getElementById('resultado');
            resultadoDiv.innerHTML = mensaje;
            resultadoDiv.className = 'result ' + tipo;
        }

        // Función para limpiar el formulario
        function limpiarFormulario() {
            document.getElementById('titulo').value = '';
            document.getElementById('autor').value = '';
            document.getElementById('anio').value = '';
            document.getElementById('paginas').value = '';
            document.getElementById('precio').value = '';
        }

        // Datos de ejemplo para probar
        function cargarDatosEjemplo() {
            const librosEjemplo = [
                new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, 471, 25.99),
                new Libro("1984", "George Orwell", 1949, 328, 18.50),
                new Libro("El Quijote", "Miguel de Cervantes", 1605, 863, 35.75)
            ];

            biblioteca = [...librosEjemplo];
            mostrarResultado("📚 Datos de ejemplo cargados. Use 'Mostrar Todos los Libros' para verlos.", 'success');
        }

        // Cargar datos de ejemplo al iniciar
        cargarDatosEjemplo();