// ==========================
// ARREGLO UNIDIMENSIONAL 2982
// ==========================

let arreglo2982 = [];

// Generar n datos aleatorios
function generarArray2982() {
    const n = parseInt(document.getElementById("cantidad1D2982").value);
    const min = parseInt(document.getElementById("min1D2982").value);
    const max = parseInt(document.getElementById("max1D2982").value);

    if (isNaN(n) || n <= 0) {
        document.getElementById("resultadoArray2982").textContent =
            "Ingresa una cantidad válida.";
        return;
    }

    arreglo2982 = [];

    for (let i = 0; i < n; i++) {
        const val = Math.floor(Math.random() * (max - min + 1)) + min;
        arreglo2982.push(val);
    }

    document.getElementById("vistaArray2982").textContent = JSON.stringify(arreglo2982);
    document.getElementById("resultadoArray2982").textContent = "Datos generados correctamente.";
}


// Calcular suma
function sumarArray2982() {
    const suma = arreglo2982.reduce((a, b) => a + b, 0);

    document.getElementById("resultadoArray2982").textContent =
        "Suma total: " + suma;
}


// Calcular promedio
function promedioArray2982() {
    if (arreglo2982.length === 0) {
        document.getElementById("resultadoArray2982").textContent =
            "Primero genera datos.";
        return;
    }

    const suma = arreglo2982.reduce((a, b) => a + b, 0);
    const prom = suma / arreglo2982.length;

    document.getElementById("resultadoArray2982").textContent =
        "Promedio: " + prom.toFixed(2);
}


// Cantidad sobre el promedio
function cantSobreProm2982() {
    if (arreglo2982.length === 0) {
        document.getElementById("resultadoArray2982").textContent =
            "Primero genera datos.";
        return;
    }

    const promedio = arreglo2982.reduce((a, b) => a + b, 0) / arreglo2982.length;
    const cant = arreglo2982.filter(x => x > promedio).length;

    document.getElementById("resultadoArray2982").textContent =
        `Cantidad sobre el promedio (${promedio.toFixed(2)}): ${cant}`;
}


// Dato menor con posición
function menorPos2982() {
    if (arreglo2982.length === 0) {
        document.getElementById("resultadoArray2982").textContent =
            "Primero genera datos.";
        return;
    }

    let menor = arreglo2982[0];
    let pos = 0;

    for (let i = 1; i < arreglo2982.length; i++) {
        if (arreglo2982[i] < menor) {
            menor = arreglo2982[i];
            pos = i;
        }
    }

    document.getElementById("resultadoArray2982").textContent =
        `Menor: ${menor} en posición ${pos}`;
}


// Dato mayor con posición
function mayorPos2982() {
    if (arreglo2982.length === 0) {
        document.getElementById("resultadoArray2982").textContent =
            "Primero genera datos.";
        return;
    }

    let mayor = arreglo2982[0];
    let pos = 0;

    for (let i = 1; i < arreglo2982.length; i++) {
        if (arreglo2982[i] > mayor) {
            mayor = arreglo2982[i];
            pos = i;
        }
    }

    document.getElementById("resultadoArray2982").textContent =
        `Mayor: ${mayor} en posición ${pos}`;
}


// Orden ascendente
function ordenarAsc2982() {
    const copia = [...arreglo2982].sort((a, b) => a - b);
    document.getElementById("vistaArray2982").textContent = JSON.stringify(copia);
    document.getElementById("resultadoArray2982").textContent = "Orden ascendente listo.";
}


// Orden descendente
function ordenarDesc2982() {
    const copia = [...arreglo2982].sort((a, b) => b - a);
    document.getElementById("vistaArray2982").textContent = JSON.stringify(copia);
    document.getElementById("resultadoArray2982").textContent = "Orden descendente listo.";
}
