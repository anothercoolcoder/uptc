class FuncionHiperbolica2982 {
    // Atributos
    constructor() {
        this._angulo2982 = 0.0;
    }

    get angulo2982() {
        return this._angulo2982;
    }

    set angulo2982(angulo2982) {
        this._angulo2982 = angulo2982;
    }

    // calcularFactorial2982(valor) {
    //     let valorFinal = 1;
    //     for (let index = 1; index <= valor; index++) {
    //         valorFinal *= index;
    //     }
    //     return valorFinal;
    // }

    // calcularExponencial2982(x) {
    //     const TERMINOS2982 = 50;
    //     let resultado2982 = 0;
    //     let n2982 = 0;

    //     let termino2982 = 1;

    //     while (n2982 < TERMINOS2982) {
    //         resultado2982 += termino2982;

    //         n2982++;
    //         termino2982 *= x / n2982;
    //     }

    //     return resultado2982;
    // }

    calcularSerie22982() {
        let acumulador2982 = 0, i = 0;
        do {
            acumulador2982 += Math.pow(-1, i) * (Math.pow(this._angulo2982, i) / this.calcularFactorial2982(i));
            i++;
        } while (i <= 50);
        return (acumulador2982);
    }

    calcularSenoHiperbolico2982() {
        // sinh(θ) = (e^θ - e^(-θ)) / 2 usando el ángulo global
        let expPos = this.calcularExponencial2982(this._angulo2982);
        let expNeg = this.calcularExponencial2982(-this._angulo2982);
        return (expPos - expNeg) / 2;
    }

    calcularCosenoHiperbolico2982() {
        // cosh(θ) = (e^θ + e^(-θ)) / 2 usando el ángulo global
        let expPos = this.calcularExponencial2982(this._angulo2982);
        let expNeg = this.calcularExponencial2982(-this._angulo2982);
        return (expPos + expNeg) / 2;
    }
}

function ejecutar2982(anguloOficial) {
    let funcionHiperbolica2982 = new FuncionHiperbolica2982();
    funcionHiperbolica2982.angulo2982 = anguloOficial; 

    console.log("Ángulo inicial: " + funcionHiperbolica2982.angulo2982);
    console.log("Ángulo actualizado: " + funcionHiperbolica2982.angulo2982);

    console.log("Sumatoria 2: " + funcionHiperbolica2982.calcularSerie22982());

    console.log("Seno hiperbolico: " + funcionHiperbolica2982.calcularSenoHiperbolico2982());
    console.log("Coseno hiperbolico: " + funcionHiperbolica2982.calcularCosenoHiperbolico2982());
}