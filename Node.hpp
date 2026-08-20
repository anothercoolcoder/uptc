template <class T> class DoubleLinkedList;

template <class T>
class Node {
    friend class DoubleLinkedList<T>;
public:    
    Node(T value) : value(value), next(nullptr), prev(nullptr) {}

    void setValue(T value) {
        this->value = value;
    }

    T& getValue() {
        return value;
    }

    Node<T>* getNext() {
        return next;
    }

    void setNext(Node<T>* next) {
        this->next = next;
    }

    Node<T>* getPrev() {
        return prev;
    }

    void setPrev(Node<T>* prev) {
        this->prev = prev;
    }

    virtual ~Node() {}

private:
    T value;
    Node<T>* next;
    Node<T>* prev;
};
