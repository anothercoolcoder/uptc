#include <bits/stdc++.h>
using namespace std;
using ll = unsigned long long;


int main() {
    string value;
    cin >> value;
    ll maxStreak = 1;
    ll currentStreak = 1;

    for (size_t i = 0; i < value.size(); i++)
    {
        if (value[i] == value[i - 1])
        {
            currentStreak++;
        }else{
            currentStreak = 1;
        }
        maxStreak = max(maxStreak, currentStreak);
        
    }
    cout << maxStreak;

}
