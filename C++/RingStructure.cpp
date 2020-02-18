/*
 * Example of a circular data structure
 */

#include <iostream>

using namespace std;

template<typename T>
class Ring {
private:
	int m_pos;
	int m_size;
	T * m_values;
public:
	Ring(int size): m_pos(0), m_size(size), m_values(NULL) {
		m_values = new T[size];
	}

	~Ring() {
		delete [] m_values;
	}

	int size() {
		return m_size;
	}

	void add(T value) {
		m_values[m_pos++] = value;

		if (m_pos == m_size)
			m_pos = 0;
	}

	T & get(int pos) {
		if (pos >= m_size)
			pos = m_size - pos - 1;
		return m_values[pos];
	}

};

int main(int argc, char const *argv[])
{
	
	Ring<string> ring(3);
	ring.add("one");
	ring.add("two");
	ring.add("three");
	ring.add("four");

	for (int i = 0; i < ring.size(); ++i)
		cout << ring.get(i) << endl;

	return 0;
}