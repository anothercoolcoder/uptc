class Funciones2982 {
    static limite2982 = 40;
    constructor(angulo2982){
        this._angulo2982 = angulo2982;
    }
    get angulo2982(){
        return this._angulo2982;
    }
    // convierte los grados a radianes
    set angulo2982(angulo2982){
        this._angulo2982 = angulo2982;
    }
    calcularRadianes2982(){
        return (this._angulo2982 * (Math.PI /180));
    }
    calcularFactorial2982(n2982){
        let factorial2982 = 1;
        if(n2982 == 0){
            return 1;
        }else{
            do{
                factorial2982 *= n2982;
                n2982--;
            }while(n2982 > 1)
                return factorial2982;
        }
        

    }
    calcularSeno2982(){
        let seno2982 = 0;
        let i2982 = 1;
        while (i2982 <= Funciones2982.limite2982) {
            seno2982 += Math.pow(-1, i2982+1)*(Math.pow(this.calcularRadianes2982(),2*i2982-1)/this.calcularFactorial2982(2*i2982-1));
            i2982++;
        }
        return seno2982;
    }
    calcularCoseno2982(){
        let Coseno2982 = 0;
        let i2982 = 1;
        while (i2982 <= Funciones2982.limite2982) {
            Coseno2982 += Math.pow(-1, i2982+1)*(Math.pow(this.calcularRadianes2982(),2*i2982-2)/this.calcularFactorial2982(2*i2982-2));
            i2982++;
        }
        return Coseno2982;
    }
    calcularTangente2982(){
        return (this.calcularSeno2982()/this.calcularCoseno2982());
    }
    calcularCotangente2982(){
        return (this.calcularCoseno2982()/this.calcularSeno2982())
    }
    calcularSecante2982(){
        return (1/this.calcularCoseno2982())
    }
    calcularCosecante2982(){
        return (1/this.calcularSeno2982())
    }
    
}

let value = 45;
funciones2982 = new Funciones2982(value);
console.log("Angulo: "     + funciones2982.angulo2982)
console.log("Radianes: "   + funciones2982.calcularRadianes2982());
console.log("Factorial: "  + funciones2982.calcularFactorial2982(7));
console.log("Seno: "       + funciones2982.calcularSeno2982());
console.log("CoseSeno: "       + funciones2982.calcularCoseno2982());
console.log("Tangente: "       + funciones2982.calcularTangente2982());
console.log("Cotangente: "       + funciones2982.calcularCotangente2982());
console.log("Secante: "       + funciones2982.calcularCosecante2982());
console.log("Cosecante: "       + funciones2982.calcularSecante2982());
// funcion principal
// funcion principal
function calcularFunciones2982(){
    const anguloGrados2982 = document.getElementById("anguloGrados2982").value;
    if(anguloGrados2982 === ""){
        alert("Por favor, ingrese un angulo en grados");
        return;
    }

    const funciones2982 = new Funciones2982(parseFloat(anguloGrados2982));

    const radianes2982 = funciones2982.calcularRadianes2982();
    const seno2982 = funciones2982.calcularSeno2982();
    const coseno2982 = funciones2982.calcularCoseno2982();
    const tangente2982 = funciones2982.calcularTangente2982();
    const cotangente2982 = funciones2982.calcularCotangente2982();
    const secante2982 = funciones2982.calcularSecante2982();
    const cosecante2982 = funciones2982.calcularCosecante2982();

    document.getElementById("resultado2982").innerHTML = `
        <h3>Resultados 2982</h3>
        <p>Ángulo (°): <strong>${anguloGrados2982}</strong></p>
        <p>Radianes: <strong>${radianes2982}</strong></p>
        <p>Seno 2982: <strong>${seno2982}</strong></p>
        <p>Coseno 2982: <strong>${coseno2982}</strong></p>
        <p>Tangente 2982: <strong>${tangente2982}</strong></p>
        <p>Cotangente 2982: <strong>${cotangente2982}</strong></p>
        <p>Secante 2982: <strong>${secante2982}</strong></p>
        <p>Cosecante 2982: <strong>${cosecante2982}</strong></p>
    `;
}


//calcular tan(x) = sen/cos
//calcular cotangente(x) = cos(x) / sen (x)
//sec(X) = 1/ con(x)
//csec(x) = 1/sen(x)
//ingresan por formulario el angulo
// visualizar los datos en el doc html

