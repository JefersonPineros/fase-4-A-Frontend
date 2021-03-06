export class descargarPDF {

    constructor(){}
    descargar(pdf: any): void {
        let archivoBase64 = pdf?.archiboBase64;
        const ARB64 = `data:application/pdf;base64,${archivoBase64}`;
        const link = document.createElement("a");
        link.href = ARB64;
        link.download = `${pdf?.nombreArchivo}.pdf`;
        link.click();
    }
}