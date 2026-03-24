#include <iostream>
using namespace std;
int main(){
    int size, best = 0, counter = 0, last = 0;
    cin >> size;
    int array[size];
    // add numbers
    for (int i = 0; (sizeof(array) / sizeof(array[0])) > i; i++)
    {
        cin >> array[i];
    }
    // comparate
    last = 0;
    for (int a = 0; (sizeof(array) / sizeof(array[0])) > a; a++)
    {
        if(array [a] >= last){
            counter++;

            if(counter >= best){
                best = counter;
            }

        }else{
            counter = 1;
        }
        last = array[a];
        
    }
    cout << best;
    return 0;
}