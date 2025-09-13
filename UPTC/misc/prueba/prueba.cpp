#include <iostream>
using namespace std;
using ll = unsigned long long;

int main() {
    ll value = 0;
    string final;
    cin >> value;
    cout << value << " ";
    while (value !=1)
    {
        
        if (value %2 == 0 && value != 1)
        {
            value /= 2;
            cout << value << " ";
        } else{
            value = (value * 3 ) + 1;
            cout << value << " ";
        }   
    }
       cout << "\n";
}