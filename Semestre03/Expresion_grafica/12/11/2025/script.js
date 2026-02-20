// var arrayUno = new Array(1,2,3);
// var arrayDos = new Array(4,5,6);
// var arrayTres = new Array(7,8,9);
// var matriz = new Array(arrayUno,arrayDos,arrayTres);
// for (let index = 0; index < matriz.length; index++) {
//     console.log(matriz[index]);
// }
// console.log("Matriz: " + matriz);
var filasA = prompt("Digite la cantidad de filas de la matriz A: ");
var columnasA = prompt("Digite la cantidad de columnas de la matriz A: ");
var matrizA = new Array();
var filasB = prompt("Digite la cantidad de filas de la matriz B: ");
var columnasB = prompt("Digite la cantidad de columnas de la matriz B: ");
var matrizB = new Array();

ingresarDatosMatriz(matrizA, filasA, columnasA);
ingresarDatosMatriz(matrizB, filasB, columnasB);

// visualizar();
console.log(visualizar2(matrizA));
console.log(visualizar2(matrizB));

function ingresarDatosMatriz(matriz, filas, columnas){
    for (let i = 0; i < filas; i++) {
        matriz[i] = new Array();
        for (let j = 0; j < columnas; j++) {
            matriz[i][j] = Math.random();
        }
    }
}
function visualizar(matriz){
    for(let i = 0; i < matriz.length;i++){
        console.log(matriz[i]);
    }
}
function visualizar2(matriz){
    let str="";
    for (let i = 0; i < matriz.length; i++) {
        for (let j = 0; j < matriz[i].length; j++) {
            str = str + matriz[i][j]+ "\t";
        }        
        str +=  "\n";
    }
    return str;
}