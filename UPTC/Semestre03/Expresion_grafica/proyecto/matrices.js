// ========================================
//      OPERACIONES CON MATRICES — 2982
// ========================================

let matrizA2982 = [];
let matrizB2982 = [];

// Generar matrices A y B
function generarMatricesOps2982() {
    const filas = parseInt(document.getElementById("filasOps2982").value);
    const columnas = parseInt(document.getElementById("colsOps2982").value);

    if (filas <= 0 || columnas <= 0) {
        document.getElementById("resultadoOps2982").textContent =
            "Dimensiones inválidas.";
        return;
    }

    matrizA2982 = Array.from({ length: filas }, () =>
        Array.from({ length: columnas }, () => Math.floor(Math.random() * 50))
    );

    matrizB2982 = Array.from({ length: filas }, () =>
        Array.from({ length: columnas }, () => Math.floor(Math.random() * 50))
    );

    mostrarMatricesOps2982();
    document.getElementById("resultadoOps2982").textContent =
        "Matrices A y B generadas correctamente.";
}

// Mostrar matrices en pantalla
function mostrarMatricesOps2982() {
    let vistaA = "A:\n";
    for (let fila of matrizA2982) vistaA += fila.join("   ") + "\n";

    let vistaB = "B:\n";
    for (let fila of matrizB2982) vistaB += fila.join("   ") + "\n";

    document.getElementById("vistaA2982").textContent = vistaA;
    document.getElementById("vistaB2982").textContent = vistaB;
}

// ======================
//     SUMA DE MATRICES
// ======================
function sumarMatrices2982() {
    if (matrizA2982.length === 0 || matrizB2982.length === 0) {
        document.getElementById("resultadoOps2982").textContent =
            "Primero genera las matrices.";
        return;
    }

    const filas = matrizA2982.length;
    const columnas = matrizA2982[0].length;

    const resultado = [];

    for (let i = 0; i < filas; i++) {
        resultado[i] = [];
        for (let j = 0; j < columnas; j++) {
            resultado[i][j] = matrizA2982[i][j] + matrizB2982[i][j];
        }
    }

    mostrarResultadoOps2982(resultado);
}

// ========================
//     RESTA DE MATRICES
// ========================
function restarMatrices2982() {
    if (matrizA2982.length === 0 || matrizB2982.length === 0) {
        document.getElementById("resultadoOps2982").textContent =
            "Primero genera las matrices.";
        return;
    }

    const filas = matrizA2982.length;
    const columnas = matrizA2982[0].length;

    const resultado = [];

    for (let i = 0; i < filas; i++) {
        resultado[i] = [];
        for (let j = 0; j < columnas; j++) {
            resultado[i][j] = matrizA2982[i][j] - matrizB2982[i][j];
        }
    }

    mostrarResultadoOps2982(resultado);
}

// ============================
//   MULTIPLICACIÓN DE MATRICES
// ============================
function multiplicarMatrices2982() {
    if (matrizA2982.length === 0 || matrizB2982.length === 0) {
        document.getElementById("resultadoOps2982").textContent =
            "Primero genera las matrices.";
        return;
    }

    const filasA = matrizA2982.length;
    const columnasA = matrizA2982[0].length;
    const filasB = matrizB2982.length;
    const columnasB = matrizB2982[0].length;

    // Compatibilidad: columnasA debe ser igual a filasB
    if (columnasA !== filasB) {
        document.getElementById("resultadoOps2982").textContent =
            "No se pueden multiplicar: columnas de A ≠ filas de B.";
        return;
    }

    const resultado = Array.from({ length: filasA }, () =>
        Array.from({ length: columnasB }, () => 0)
    );

    for (let i = 0; i < filasA; i++) {
        for (let j = 0; j < columnasB; j++) {
            for (let k = 0; k < columnasA; k++) {
                resultado[i][j] += matrizA2982[i][k] * matrizB2982[k][j];
            }
        }
    }

    mostrarResultadoOps2982(resultado);
}

// Mostrar resultado final
function mostrarResultadoOps2982(matriz) {
    let texto = "";

    for (let fila of matriz) {
        texto += fila.join("   ") + "\n";
    }

    document.getElementById("resultadoOps2982").textContent = texto;
}
