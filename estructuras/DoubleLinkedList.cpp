#include "DoubleLinkedList.hpp"
#include <iostream>

using namespace std;

template <class T>
// constructor
DoubleLinkedList<T>::DoubleLinkedList() {
    head = nullptr;
    tail = nullptr;
    actual = nullptr;
}

template <class T>
// definir si esta vacio
bool DoubleLinkedList<T>::isEmpty() {
    return head == nullptr;
}

template <class T>

void DoubleLinkedList<T>::addEnd(T value) {
    Node<T>* nuevo = new Node<T>(value);
    // ta vacia
    if (isEmpty()) {
        head = nuevo;
        tail = nuevo;
        actual = nuevo;
        return;
    }
    // definimos el actual y en base a el tomamos la ruta
    if (actual->getNext() != nullptr) { // verifica que no sea cola
        Node<T>* aux = actual->getNext();
        while (aux != nullptr) {
            Node<T>* borrar = aux;
            aux = aux->getNext();
            delete borrar;
        }
        actual->setNext(nullptr);
        tail = actual;
    }

    nuevo->setPrev(tail);
    tail->setNext(nuevo);
    tail = nuevo;
    actual = nuevo;
}

template <class T>
void DoubleLinkedList<T>::goBack() {
    if (canGoBack()) {
        actual = actual->getPrev();
    }
}

template <class T>
void DoubleLinkedList<T>::goForward() {
    if (canGoForward()) {
        actual = actual->getNext();
    }
}

template <class T>
T DoubleLinkedList<T>::getCurrentUrl() {
    if (actual != nullptr) {
        return actual->getValue();
    }
    return "";
}

template <class T>
bool DoubleLinkedList<T>::canGoBack() {
    return actual != nullptr && actual->getPrev() != nullptr;
}

template <class T>
bool DoubleLinkedList<T>::canGoForward() {
    return actual != nullptr && actual->getNext() != nullptr;
}

template <class T>
void DoubleLinkedList<T>::printHistoryForward() {
    Node<T>* aux = head;
    cout << "\nHistorial hacia adelante:" << endl;
    while (aux != nullptr) {
        cout << aux->getValue();
        if (aux == actual) {
            cout << " <- (Página Actual)";
        }
        cout << endl;
        aux = aux->getNext();
    }
}

template <class T>
void DoubleLinkedList<T>::printHistoryBackward() {
    Node<T>* aux = tail;
    cout << "\nHistorial hacia atrás:" << endl;
    while (aux != nullptr) {
        cout << aux->getValue();
        if (aux == actual) {
            cout << " <- (Página Actual)";
        }
        cout << endl;
        aux = aux->getPrev();
    }
}

// borrar
template <class T>
DoubleLinkedList<T>::~DoubleLinkedList() {
    Node<T>* aux = head;
    while (aux != nullptr) {
        head = aux->getNext();
        delete aux;
        aux = head;
    }
    tail = nullptr;
    actual = nullptr;
}