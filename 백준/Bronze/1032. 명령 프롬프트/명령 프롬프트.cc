#include <iostream>
#include <string>

using namespace std;
int main() {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	
	int n;
	string s,result,temp;
	cin >> n;
	cin >> s;
	result = s;
	for (int i = 1; i < n; i++) {
		cin >> temp;
		for (int j = 0; j <result.length(); j++) {
			if (result[j] != temp[j])
				result[j] ='?';
		}
	}
	cout << result << '\n';
	return 0;
}