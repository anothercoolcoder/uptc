class Funciones2982 {
    static LIMITE2982 = 40;

    constructor(angulo2982) {
        this._angulo2982 = angulo2982;
    }

    get angulo2982() {
        return this._angulo2982;
    }

    set angulo2982(angulo2982) {
        this._angulo2982 = angulo2982;
    }

    calcularRadianes2982() {
        return (this._angulo2982 * Math.PI / 180);
    }

    calcularFactorial2982(numero2982) {
        if (numero2982 === 0) return 1;

        let factorial2982 = 1,
            contador2982 = numero2982;

        do {
            factorial2982 *= contador2982;
            contador2982--;
        } while (contador2982 >= 1);

        return factorial2982;
    }

    calcularSeno2982() {
        let seno2982 = 0,
            i2982 = 1;

        while (i2982 <= Funciones2982.LIMITE2982) {
            seno2982 += Math.pow(-1, i2982 + 1) *
                (Math.pow(this.calcularRadianes2982(), 2 * i2982 - 1) /
                    this.calcularFactorial2982(2 * i2982 - 1));
            i2982++;
        }

        return seno2982;
    }

    calcularCoseno2982() {
        let coseno2982 = 0,
            i2982 = 1;

        while (i2982 <= Funciones2982.LIMITE2982) {
            coseno2982 += Math.pow(-1, i2982 + 1) *
                (Math.pow(this.calcularRadianes2982(), 2 * i2982 - 2) /
                    this.calcularFactorial2982(2 * i2982 - 2));
            i2982++;
        }

        return coseno2982;
    }

    calcularTangente2982() {
        return this.calcularSeno2982() / this.calcularCoseno2982();
    }

    calcularCotangente2982() {
        return this.calcularCoseno2982() / this.calcularSeno2982();
    }

    calcularSecante2982() {
        return 1 / this.calcularCoseno2982();
    }

    calcularCosecante2982() {
        return 1 / this.calcularSeno2982();
    }
}

function procesarFormulario2982() {
    const anguloInput2982 = document.getElementById("angulo2982").value;
    const funciones2982 = new Funciones2982(parseFloat(anguloInput2982));

    document.getElementById("resAngulo2982").textContent = funciones2982.angulo2982;
    document.getElementById("resRadianes2982").textContent = funciones2982.calcularRadianes2982();
    document.getElementById("resSeno2982").textContent = funciones2982.calcularSeno2982();
    document.getElementById("resCoseno2982").textContent = funciones2982.calcularCoseno2982();
    document.getElementById("resTan2982").textContent = funciones2982.calcularTangente2982();
    document.getElementById("resCot2982").textContent = funciones2982.calcularCotangente2982();
    document.getElementById("resSec2982").textContent = funciones2982.calcularSecante2982();
    document.getElementById("resCsc2982").textContent = funciones2982.calcularCosecante2982();
}
