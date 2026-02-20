var tamanho = 0, suma = 0, sobreElPromedio = 0,multiplo7 = 0;
let posiciones = [];
var arrayUno = new Array();

positiveNumber();
inputNumbers();
visualizar();

function positiveNumber(){
    do{
        tamanho = prompt("Digite el tamaño del arreglo");
    } while(tamanho<0);
}
function inputNumbers(){
    for(let i = 0; i < tamanho;i++){
        arrayUno[i] = Math.floor(Math.random()*10);
    }
    for(let i = 0; i <arrayUno.length; i++){
        console.log("Dato No."+ i + " : " + arrayUno[i]);
    }
    console.log(arrayUno);
    arrayUno.forEach(num =>{
        suma += num;
    });
    arrayUno.forEach(num => {
        if (num > suma/arrayUno.length) {
            sobreElPromedio++;
        }
    });
    for(let i = 0; i<arrayUno.length;i++){
        if(arrayUno[i]%7 == 0){
            multiplo7++;
            posiciones.push(i);
        }
    }
}
function minAndPos() {
    let min = arrayUno[0];
    let posMin = 0;

    for (let i = 1; i < arrayUno.length; i++) {
        if (arrayUno[i] < min) {
            min = arrayUno[i];
            posMin = i;
        }
    }

    return { min, posMin };
}

function maxAndPos() {
    let max = arrayUno[0];
    let posMax = 0;

    for (let i = 1; i < arrayUno.length; i++) {
        if (arrayUno[i] > max) {
            max = arrayUno[i];
            posMax = i;
        }
    }

    return { max, posMax };
}

function visualizar(){
    const menor = minAndPos();
    const mayor = maxAndPos();
    console.log("Menor Dato: " + menor.min + " Posicion: " + menor.posMin);
    console.log("Mayor Dato: " + mayor.max + " Posicion: " + mayor.posMax);
    console.log("Datos ordenados de manera ascendente: " + arrayUno.sort((a,b)=>a-b));
    console.log("Datos ordenados de manera descendente: " + arrayUno.sort((a,b)=>b-a));
    console.log("La suma es igual a: " + suma); 
    console.log("El promedio es: " + suma/arrayUno.length); 
    console.log("Mayores al promedio: " + sobreElPromedio); 
    console.log("Multiplos de 7: " + multiplo7);
    console.log("Posiciones de los numeros multiplos de 7: " + posiciones);
    console.log("Promedio de multiplos de 7: " + (multiplo7/arrayUno.length)*100) + " % ";
}