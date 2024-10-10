// Convert Binary to Decimal
function convertBinaryToDecimal() {
    let binary = document.getElementById("binaryInput").value;
    let decimal = parseInt(binary, 2);
    document.getElementById("binaryResult").innerText = `Decimal: ${decimal}`;
}

// Convert Binary to Hexadecimal
function convertBinaryToHex() {
    let binary = document.getElementById("binaryInput").value;
    let decimal = parseInt(binary, 2);
    let hex = decimal.toString(16).toUpperCase();
    document.getElementById("binaryResult").innerText = `Hexadecimal: ${hex}`;
}

// Convert Binary to Octal
function convertBinaryToOctal() {
    let binary = document.getElementById("binaryInput").value;
    let decimal = parseInt(binary, 2);
    let octal = decimal.toString(8);
    document.getElementById("binaryResult").innerText = `Octal: ${octal}`;
}

// Convert Hexadecimal to Binary
function convertHexToBinary() {
    let hex = document.getElementById("hexInput").value;
    let decimal = parseInt(hex, 16);
    let binary = decimal.toString(2);
    document.getElementById("hexResult").innerText = `Binário: ${binary}`;
}

// Convert Hexadecimal to Decimal
function convertHexToDecimal() {
    let hex = document.getElementById("hexInput").value;
    let decimal = parseInt(hex, 16);
    document.getElementById("hexResult").innerText = `Decimal: ${decimal}`;
}

// Convert Hexadecimal to Octal
function convertHexToOctal() {
    let hex = document.getElementById("hexInput").value;
    let decimal = parseInt(hex, 16);
    let octal = decimal.toString(8);
    document.getElementById("hexResult").innerText = `Octal: ${octal}`;
}

// Convert Octal to Binary
function convertOctalToBinary() {
    let octal = document.getElementById("octalInput").value;
    let decimal = parseInt(octal, 8);
    let binary = decimal.toString(2);
    document.getElementById("octalResult").innerText = `Binário: ${binary}`;
}

// Convert Octal to Decimal
function convertOctalToDecimal() {
    let octal = document.getElementById("octalInput").value;
    let decimal = parseInt(octal, 8);
    document.getElementById("octalResult").innerText = `Decimal: ${decimal}`;
}

// Convert Octal to Hexadecimal
function convertOctalToHex() {
    let octal = document.getElementById("octalInput").value;
    let decimal = parseInt(octal, 8);
    let hex = decimal.toString(16).toUpperCase();
    document.getElementById("octalResult").innerText = `Hexadecimal: ${hex}`;
}

// Convert Decimal to Binary
function convertDecimalToBinary() {
    let decimal = document.getElementById("decimalInput").value;
    let binary = parseInt(decimal, 10).toString(2);
    document.getElementById("decimalResult").innerText = `Binário: ${binary}`;
}

// Convert Decimal to Hexadecimal
function convertDecimalToHex() {
    let decimal = document.getElementById("decimalInput").value;
    let hex = parseInt(decimal, 10).toString(16).toUpperCase();
    document.getElementById("decimalResult").innerText = `Hexadecimal: ${hex}`;
}

// Convert Decimal to Octal
function convertDecimalToOctal() {
    let decimal = document.getElementById("decimalInput").value;
    let octal = parseInt(decimal, 10).toString(8);
    document.getElementById("decimalResult").innerText = `Octal: ${octal}`;
}
