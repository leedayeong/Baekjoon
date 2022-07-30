#include <iostream> 
#include <deque>

using namespace std;

deque<int>s;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;

	cin >> n;
	for(int i=1;i<=n;i++){
		s.push_back(i);
	}
	while (!s.empty()) {
		if (s.size() == 1) {
			cout << s.front() << '\n';
			break;
		}
		s.pop_front();
		if (s.size() == 1) {
			cout << s.front() << '\n';
			break;
		}
		int temp = s.front();
		s.push_back(temp);
		s.pop_front();
	}

	return 0;
}