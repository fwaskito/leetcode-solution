/*
412. Fizz Buzz

- Diffulty: Easy
- Topics: Math, String, Simulation

------------------
Author: F. Waskito
*/

#include <vector>
#include <string>
#include <iostream>
#include <chrono>

using namespace std;
using namespace std::chrono;

class Solution
{
public:
    vector<string> fizzBuzz(int n)
    {
        vector<string> result;
        for (int i = 1; i <= n; i++)
        {
            if ((i % 3 == 0) && (i % 5 == 0))
            {
                result.push_back("FizzBuzz");
            }
            else if (i % 3 == 0)
            {
                result.push_back("Fizz");
            }
            else if (i % 5 == 0)
            {
                result.push_back("Buzz");
            }
            else
            {
                result.push_back(to_string(i));
            }
        }
        return result;
    }
};

int main()
{
    // int n = 3;
    // expected: ["1","2","Fizz"]

    // int n = 5;
    // expected: ["1","2","Fizz","4","Buzz"]

    int n = 15;
    // expected: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

    auto start = high_resolution_clock::now();

    Solution solution;
    vector<string> result = solution.fizzBuzz(n);

    auto end = high_resolution_clock::now();
    auto execTime = duration_cast<milliseconds>(end - start).count();

    for (string x : result)
        cout << x << ", ";
    cout << endl;
    cout << "\nExecution time: " << execTime << " ms." << endl;
}