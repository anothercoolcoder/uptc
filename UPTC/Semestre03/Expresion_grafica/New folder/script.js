class FuncionHyperbolicas2982 {
    static LIMITE2982 = 50;

    constructor() {
        this._angulo2982 = 0.0;
    }

    get angulo2982() {
        return this._angulo2982;
    }

    set angulo2982(angulo2982) {
        this._angulo2982 = angulo2982;
    }

    calcularFactorial2982(numero2982) {
        let factorial2982 = 1;
        for (let contador2982 = 1; contador2982 <= numero2982; contador2982++) {
            factorial2982 *= contador2982;
        }
        return factorial2982;
    }

    calcularSerie1_2982() {
        let acumulador2982 = 0, i2982 = 0;
        while (i2982 <= FuncionHyperbolicas2982.LIMITE2982) {
            acumulador2982 += Math.pow(this._angulo2982, i2982) / this.calcularFactorial2982(i2982);
            i2982++;
        }
        return acumulador2982;
    }

    calcularSerie2_2982() {
        let acumulador2982 = 0, i2982 = 0;
        do {
            acumulador2982 += Math.pow(-1, i2982) * (Math.pow(this._angulo2982, i2982) / this.calcularFactorial2982(i2982));
            i2982++;
        } while (i2982 <= FuncionHyperbolicas2982.LIMITE2982);
        return acumulador2982;
    }

    calcularSenoHyper2982() {
        return (this.calcularSerie1_2982() - this.calcularSerie2_2982()) / 2;
    }

    calcularCosenoHyper2982() {
        return (this.calcularSerie1_2982() + this.calcularSerie2_2982()) / 2;
    }

    calcularTanh2982() {
        const senoHyper2982 = this.calcularSenoHyper2982();
        const cosenoHyper2982 = this.calcularCosenoHyper2982();
        return senoHyper2982 / cosenoHyper2982;
    }
}

function ejecutar2982() {
    const anguloInput2982 = document.getElementById("inputAngulo2982").value;

    if (anguloInput2982 === "") {
        alert("Por favor, ingrese un valor para el ángulo.");
        return;
    }

    const funcionHyperbolicas2982 = new FuncionHyperbolicas2982();
    funcionHyperbolicas2982.angulo2982 = parseFloat(anguloInput2982);

    const euler1_2982 = funcionHyperbolicas2982.calcularSerie1_2982();
    const euler2_2982 = funcionHyperbolicas2982.calcularSerie2_2982();
    const senoHyper2982 = funcionHyperbolicas2982.calcularSenoHyper2982();
    const cosenoHyper2982 = funcionHyperbolicas2982.calcularCosenoHyper2982();
    const tanh2982 = funcionHyperbolicas2982.calcularTanh2982();

    document.getElementById("resultado2982").innerHTML = `
        <h3>Resultados 2982</h3>
        <p><strong>Ángulo:</strong> ${funcionHyperbolicas2982.angulo2982}</p>
        <p><strong>e^x:</strong> ${euler1_2982.toFixed(6)}</p>
        <p><strong>e^-x:</strong> ${euler2_2982.toFixed(6)}</p>
        <p><strong>sinh(x):</strong> ${senoHyper2982.toFixed(6)}</p>
        <p><strong>cosh(x):</strong> ${cosenoHyper2982.toFixed(6)}</p>
        <p><strong>tanh(x):</strong> ${tanh2982.toFixed(6)}</p>
    `;
}
