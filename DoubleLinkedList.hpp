#ifndef DOUBLELINKEDLIST_HPP
#define DOUBLELINKEDLIST_HPP

#include "Node.hpp"
#include <vector>

using namespace std;

template <class T>
class DoubleLinkedList {
public:
    DoubleLinkedList();
    bool isEmpty();
    void addEnd(T value);
    void goBack();
    void goForward();
    T getCurrentUrl();
    bool canGoBack();
    bool canGoForward();
    void printHistoryForward();
    void printHistoryBackward();
    vector<T> getElements();
    virtual ~DoubleLinkedList();

private:
    Node<T>* head;
    Node<T>* tail;
    Node<T>* actual;
};

#endif