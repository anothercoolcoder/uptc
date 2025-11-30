// ===============================
//   ARREGLO BIDIMENSIONAL 2982
// ===============================

let matriz2982 = [];

// Generar matriz vacía n * m
function generarMatriz2982() {
    const filas = parseInt(document.getElementById("filas2982").value);
    const columnas = parseInt(document.getElementById("columnas2982").value);

    if (filas <= 0 || columnas <= 0) {
        document.getElementById("resultadoMatriz2982").textContent =
            "Ingresa dimensiones válidas.";
        return;
    }

    matriz2982 = Array.from({ length: filas }, () =>
        Array.from({ length: columnas }, () => 0)
    );

    mostrarMatriz2982();
    document.getElementById("resultadoMatriz2982").textContent =
        "Matriz generada correctamente.";
}

// Llenar matriz con datos aleatorios
function llenarMatriz2982() {
    if (matriz2982.length === 0) {
        document.getElementById("resultadoMatriz2982").textContent =
            "Primero genera la matriz.";
        return;
    }

    for (let i = 0; i < matriz2982.length; i++) {
        for (let j = 0; j < matriz2982[0].length; j++) {
            matriz2982[i][j] = Math.floor(Math.random() * 100);
        }
    }

    mostrarMatriz2982();
    document.getElementById("resultadoMatriz2982").textContent =
        "Datos aleatorios ingresados.";
}

// Acceder a un elemento
function accederElemento2982() {
    const f = parseInt(document.getElementById("filaAcceso2982").value);
    const c = parseInt(document.getElementById("colAcceso2982").value);

    if (
        f < 0 || c < 0 ||
        f >= matriz2982.length ||
        c >= matriz2982[0].length
    ) {
        document.getElementById("resultadoMatriz2982").textContent =
            "Índice fuera de rango.";
        return;
    }

    document.getElementById("resultadoMatriz2982").textContent =
        `Elemento en [${f}, ${c}] = ${matriz2982[f][c]}`;
}

// Mostrar matriz en pantalla (formato bonito)
function mostrarMatriz2982() {
    let texto = "";

    for (let i = 0; i < matriz2982.length; i++) {
        texto += matriz2982[i].join("   ") + "\n";
    }

    document.getElementById("vistaMatriz2982").textContent = texto;
}
