function calcularHiper2982() {
    const x2982 = parseFloat(document.getElementById("valorHiper2982").value);
    const n2982 = parseInt(document.getElementById("terminosHiper2982").value);

    if (isNaN(x2982) || isNaN(n2982) || n2982 <= 0) {
        document.getElementById("resultadoHiper2982").textContent =
            "Por favor ingresa valores válidos.";
        return;
    }

    function factorial2982(k2982) {
        if (k2982 === 0) return 1;
        let f2982 = 1;
        for (let i2982 = 1; i2982 <= k2982; i2982++) f2982 *= i2982;
        return f2982;
    }

    // cosh(x)
    let cosh2982 = 0;
    for (let k2982 = 0; k2982 < n2982; k2982++) {
        cosh2982 += Math.pow(x2982, 2 * k2982) / factorial2982(2 * k2982);
    }

    // sinh(x)
    let sinh2982 = 0;
    for (let k2982 = 0; k2982 < n2982; k2982++) {
        sinh2982 += Math.pow(x2982, 2 * k2982 + 1) / factorial2982(2 * k2982 + 1);
    }

    const tanh2982 = sinh2982 / cosh2982;
    const coth2982 = cosh2982 / sinh2982;
    const sech2982 = 1 / cosh2982;
    const csch2982 = 1 / sinh2982;

    document.getElementById("resultadoHiper2982").innerHTML =
        `<strong>x:</strong> ${x2982}<br>
         <strong>Términos:</strong> ${n2982}<br><br>
         <strong>sinh(x):</strong> ${sinh2982}<br>
         <strong>cosh(x):</strong> ${cosh2982}<br>
         <strong>tanh(x):</strong> ${tanh2982}<br>
         <strong>coth(x):</strong> ${coth2982}<br>
         <strong>sech(x):</strong> ${sech2982}<br>
         <strong>csch(x):</strong> ${csch2982}`;
}
