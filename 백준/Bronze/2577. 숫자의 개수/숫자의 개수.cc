#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

vector<char> v;

int main() {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	
	int a, b, c;
	cin >> a;
	cin >> b;
	cin >> c;
	string s = to_string(a * b * c);
	for (long long int i = 0; i < s.length(); i++) {
		v.push_back(s[i]);
	}
	int cnt;
	for (int i = 48; i < 58; i++) {
		cnt = count(v.begin(), v.end(), i);
		cout << cnt << '\n';
	}

	return 0;
}