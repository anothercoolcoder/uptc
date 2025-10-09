// Clase que calcula seno y coseno por series de Taylor
class SerieTaylor2982 {
    static LIMITE2982 = 40;

    constructor() {
        this._anguloRadianes2982 = 0.0;
    }

    // Setter: convierte grados a radianes
    set anguloGrados2982(grados2982) {
        this._anguloRadianes2982 = grados2982 * (Math.PI / 180);
    }

    // Método factorial
    calcularFactorial2982(n2982) {
        let factorial2982 = 1;
        for (let i2982 = 1; i2982 <= n2982; i2982++) {
            factorial2982 *= i2982;
        }
        return factorial2982;
    }

    // Serie de Taylor para seno(x)
    calcularSeno2982() {
        let suma2982 = 0;
        for (let i2982 = 1; i2982 <= SerieTaylor2982.LIMITE2982; i2982++) {
            const exponente2982 = 2 * i2982 - 1;
            const signo2982 = Math.pow(-1, i2982 + 1);
            suma2982 += signo2982 * (Math.pow(this._anguloRadianes2982, exponente2982) / this.calcularFactorial2982(exponente2982));
        }
        return suma2982;
    }

    // Serie de Taylor para coseno(x)
    calcularCoseno2982() {
        let suma2982 = 0;
        for (let i2982 = 1; i2982 <= SerieTaylor2982.LIMITE2982; i2982++) {
            const exponente2982 = 2 * i2982 - 2;
            const signo2982 = Math.pow(-1, i2982 + 1);
            suma2982 += signo2982 * (Math.pow(this._anguloRadianes2982, exponente2982) / this.calcularFactorial2982(exponente2982));
        }
        return suma2982;
    }
}

// Función principal
function calcularSerieTaylor2982() {
    const anguloGrados2982 = document.getElementById("anguloGrados2982").value;

    if (anguloGrados2982 === "") {
        alert("Por favor, ingrese un ángulo en grados.");
        return;
    }

    const serie2982 = new SerieTaylor2982();
    serie2982.anguloGrados2982 = parseFloat(anguloGrados2982);

    const seno2982 = serie2982.calcularSeno2982();
    const coseno2982 = serie2982.calcularCoseno2982();

    document.getElementById("resultado2982").innerHTML = `
        <h3>Resultados</h3>
        <p><strong>Ángulo ingresado:</strong> ${anguloGrados2982}°</p>
        <p><strong>En radianes:</strong> ${(parseFloat(anguloGrados2982) * Math.PI / 180).toFixed(6)}</p>
        <p><strong>sen(${anguloGrados2982}) =</strong> ${seno2982.toFixed(6)}</p>
        <p><strong>cos(${anguloGrados2982}) =</strong> ${coseno2982.toFixed(6)}</p>
        <hr>
        <p>Ejemplo esperado: sen(60) ≈ 0.8660, cos(45) ≈ 0.7071</p>
    `;
}
