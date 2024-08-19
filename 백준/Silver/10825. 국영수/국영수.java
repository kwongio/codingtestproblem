import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		List<Person> persons = new ArrayList<Main.Person>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			persons.add(new Person(name, math, english, korean));
		}
		StringBuilder sb = new StringBuilder();
		Collections.sort(persons);
		for (Person p : persons) {
			sb.append(p.name).append("\n");
		}
		System.out.println(sb.toString());
	}

	static class Person implements Comparable<Person> {
		String name;
		int math;
		int english;
		int korean;

		public Person(String name, int math, int english, int korean) {
			super();
			this.name = name;
			this.math = math;
			this.english = english;
			this.korean = korean;
		}

		@Override
		public int compareTo(Person o) {
			if (o.korean == this.korean) {
				if (this.english == o.english) {
					// 국어 점수와 영어 점수가 같으면 수학점수가 감소하는 순서로
					if (o.math == this.math) {
						return this.name.compareTo(o.name);
					}
					return Integer.compare(o.math, this.math);
				}
				// 국어 점수가 같으면 영엊 점수가 증가하는 데로
				return Integer.compare(this.english, o.english);
			}
			// 국어 점수가 감소하는 순서대로
			return Integer.compare(o.korean, this.korean);
		}
	}
}