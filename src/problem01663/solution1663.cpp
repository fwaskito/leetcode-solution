/*
1663. Smallest String With A Given Numeric Value

- Difficulty: Medium
- Topics: String, Greedy
- Hint:
    1. Think greedily.
    2. If you build the string from the end to the beginning, it will
       always be optimal to put the highest possible character at the
       current index.
*/

#include <string>
#include <iostream>
#include <chrono>

using namespace std;
using namespace std::chrono;

class Solution
{
public:
    string getSmallestString(int n, int k)
    {
        string result = "";
        int max = 26;

        while (n > 0)
        {
            if (k > n)
            {
                int quotient = k / max;
                int remainder = k % max;

                if (quotient > 1)
                {
                    if ((k - max) > n)
                    {
                        while ((k - max * quotient) < (n - quotient))
                        {
                            quotient--;
                        }

                        result = string(quotient, 'z');
                        k -= max * quotient;
                        n -= quotient;
                        continue;
                    }

                    k -= (n - 1);
                    result = char(96 + k) + result;
                }
                else if (quotient == 1)
                {
                    if (remainder >= (n - 1))
                    {
                        result = char(96 + max) + result;
                        k -= max;
                        max = remainder;
                    }
                    else
                    {
                        max -= (n - (1 + remainder));
                        result = char(96 + max) + result;
                        k -= max;
                    }
                }
                else
                {
                    max = remainder - (n - 1);
                    result = char(96 + max) + result;
                    k -= max;
                }
            }
            else
            {
                return string(n, 'a') + result;
            }

            n--;
        }

        return result;
    }
};

int main()
{
    // int n = 3;
    // int k = 27;
    // expected: "aay"

    // int n = 5;
    // int k = 73;
    // expected: "aaszz"

    // int n = 85;
    // int k = 2159;
    // expected:
    // "aayzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"

    int n = 95474;
    int k = 2394483;

    auto start = high_resolution_clock::now();

    Solution solution;
    cout << solution.getSmallestString(n, k) << endl;

    auto end = high_resolution_clock::now();
    auto execTime = duration_cast<milliseconds>(end - start).count();
    cout << "\nExecution time: " << execTime << " ms." << endl;
}