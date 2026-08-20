#include <iostream>
#include <string>
#include "DoubleLinkedList.cpp"

using namespace std;

int main() {
    DoubleLinkedList<string>* historial = new DoubleLinkedList<string>();

    historial->addEnd("https://google.com");
    historial->addEnd("https://youtube.com");
    historial->addEnd("https://github.com");

    int opcion = 0;
    string url;

    do {
        cout << "\n=========================================" << endl;
        cout << "URL ACTUAL: " << (historial->getCurrentUrl().empty() ? "No hay página" : historial->getCurrentUrl()) << endl;
        cout << "=========================================" << endl;
        cout << "1. Visitar nueva URL (addEnd)" << endl;
        cout << "2. Regresar (goBack) [" << (historial->canGoBack() ? "Disponible" : "No disponible") << "]" << endl;
        cout << "3. Avanzar (goForward) [" << (historial->canGoForward() ? "Disponible" : "No disponible") << "]" << endl;
        cout << "4. Imprimir historial hacia adelante" << endl;
        cout << "5. Imprimir historial hacia atrás" << endl;
        cout << "6. Salir" << endl;
        cout << "Seleccione una opción: ";
        cin >> opcion;

        switch (opcion) {
            case 1:
                cout << "Ingrese la URL: ";
                cin >> url;
                historial->addEnd(url);
                break;
            case 2:
                if (historial->canGoBack()) {
                    historial->goBack();
                } else {
                    cout << "\n[!] No hay páginas anteriores." << endl;
                }
                break;
            case 3:
                if (historial->canGoForward()) {
                    historial->goForward();
                } else {
                    cout << "\n[!] No hay páginas posteriores." << endl;
                }
                break;
            case 4:
                historial->printHistoryForward();
                break;
            case 5:
                historial->printHistoryBackward();
                break;
            case 6:
                cout << "\nSaliendo..." << endl;
                break;
            default:
                cout << "\nOpción no válida." << endl;
        }

    } while (opcion != 6);

    delete historial;
    return 0;
}