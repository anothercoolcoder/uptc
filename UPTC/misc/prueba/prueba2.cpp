#include <bits/stdc++.h>
using namespace std;
using ll = unsigned long long;

int main() {
    ll n = 0;
    ll sum = 0;
    ll sum1 = 0;
    cin >> n;
    vector<ll> numbers (n - 1);
    for (size_t i = 0; i <= n; i++)
    {
        sum1 += i;
    }
    
    for (size_t i = 0; i < n - 1; i++)
    {
        cin >> numbers[i];
    }
    for (size_t i = 0; i < numbers.size() ; i++)
    {
        sum += numbers[i];
    }
    cout << sum1 - sum;
}