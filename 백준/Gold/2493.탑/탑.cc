#include <iostream>
#include <stack>
#include <utility>

using namespace std;

int n, k;
stack<pair<int, int>>st;

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 1; i < n + 1; i++) {
		cin >> k;
		while (!st.empty()) {
			if (st.top().second < k) {
				st.pop();
			}
			else if (st.top().second >= k) {
				cout << st.top().first << ' ';
				st.push(make_pair(i, k));
				break;
			}
		}
		if (st.empty()) {
			cout << 0 << ' ';
			st.push(make_pair(i, k));
		}
	}
	return 0;
}