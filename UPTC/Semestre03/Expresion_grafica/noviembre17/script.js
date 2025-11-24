let filas2982 = parseInt(prompt("Número de filas:"));
let columnas2982 = parseInt(prompt("Número de columnas:"));

function crearMatriz2982(f2982, c2982) {
    let matriz2982 = [];
    for (let i = 0; i < f2982; i++) {
        matriz2982[i] = [];
        for (let j = 0; j < c2982; j++) {
            matriz2982[i][j] = Math.floor(Math.random() * 10);
        }
    }
    return matriz2982;
}

function sumarMatrices2982(a2982, b2982) {
    let c2982 = [];
    for (let i = 0; i < a2982.length; i++) {
        c2982[i] = [];
        for (let j = 0; j < a2982[0].length; j++) {
            c2982[i][j] = a2982[i][j] + b2982[i][j];
        }
    }
    return c2982;
}

function restarMatrices2982(a2982, b2982) {
    let c2982 = [];
    for (let i = 0; i < a2982.length; i++) {
        c2982[i] = [];
        for (let j = 0; j < a2982[0].length; j++) {
            c2982[i][j] = a2982[i][j] - b2982[i][j];
        }
    }
    return c2982;
}

function multiplicarMatrices2982(a2982, b2982) {
    let c2982 = [];
    for (let i = 0; i < a2982.length; i++) {
        c2982[i] = [];
        for (let j = 0; j < b2982[0].length; j++) {
            let s2982 = 0;
            for (let k = 0; k < a2982[0].length; k++) {
                s2982 += a2982[i][k] * b2982[k][j];
            }
            c2982[i][j] = s2982;
        }
    }
    return c2982;
}

let matrizA2982 = crearMatriz2982(filas2982, columnas2982);
let matrizB2982 = crearMatriz2982(filas2982, columnas2982);

console.log("A:", matrizA2982);
console.log("B:", matrizB2982);
console.log("Suma:", sumarMatrices2982(matrizA2982, matrizB2982));
console.log("Resta:", restarMatrices2982(matrizA2982, matrizB2982));
console.log("Multiplicación:", multiplicarMatrices2982(matrizA2982, matrizB2982));
