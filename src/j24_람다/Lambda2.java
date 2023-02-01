package j24_람다;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda2 {
	
	public static void main(String[] args) {
		
		//	1. Runnable - run()
		Runnable a = () -> System.out.println("하나만 실행");		//하나만 실행하기 때문에 중괄호 생략
		Runnable b = () -> {
			System.out.println("여");
			System.out.println("러");
			System.out.println("명");
			System.out.println("령");
			System.out.println("실");
			System.out.println("행");
		};
		
		a.run();
		b.run();
		
		System.out.println();
		
		//	2. Supplier<T> - T get()
		Supplier<LocalDate> c = () -> LocalDate.now();
		Supplier<String> d = () -> {
			LocalDate now = LocalDate.now();
			return now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
		};
		
		System.out.println(c.get());
		System.out.println(d.get());
		
		System.out.println();
		
		//	3. Consumer<T> - void accept(T t)
		Consumer<String> e = name -> System.out.println("이름: " + name);
		
		e.accept("이종현");
		
		Consumer<String> f = name -> {
			System.out.println("이름: " + name);
			System.out.println("오늘 날짜: " + d.get());
		};
		
		f.accept("김주리");
		
		//	메소드 참조 표현식 ([인스턴스] :: [메소드명 또는 new]) 인스턴스 = 객체
		Consumer<String> g = System.out :: println;
		g.accept("오늘의 점심메뉴는?");
		
		List<String> names = new ArrayList<>();
		names.add("가나다");
		names.add("라마바");
		names.add("사아자");
		names.add("차카타");
		
		names.forEach(name -> System.out.println("메뉴: " + name + ""));
		
		// 위의 forEach문을 풀어서 쓰면 이렇게 쓰는것
		Consumer<String> h = name -> System.out.println("이름: " + name + "님");
		names.forEach(h);
		
		names.forEach(name -> {
			System.out.println("이름을 출력합니다.");
			System.out.println("이름: " + name);
			System.out.println();
		});
		
		Map<String, String> userMap = new HashMap<>();
		userMap.put("username", "aaa");
		userMap.put("password", "1234");
		
		userMap.forEach((key, value) -> {
			System.out.println("key: " + key);
			System.out.println("value: " + value);
			System.out.println();
		});
		
		// forEach문을 쓰지 않았을때 이렇게 써야 함
		for(Entry<String, String> entry : userMap.entrySet()) {
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
			System.out.println();
		}
		
		//	4. Function<T, R>
		Function<String, Integer> i = num -> Integer.parseInt(num);
		
		int convertStrNum1 = i.apply("10000");
		int convertStrNum2 = i.apply("20000");
		
		System.out.println(convertStrNum1 + convertStrNum2);
		
		//	5. Predicate<T>
		Predicate<String> p1 = str -> str.startsWith("김");
		Predicate<String> p2 = str -> str.startsWith("이");
		
		System.out.println(p1.or(p2).test("김준일"));
		
		Function<Predicate<String>, Boolean> function1 = 
				predicate -> predicate.or(str -> str.startsWith("이")).test("김준일");
				
		boolean rs = function1.apply(str -> str.startsWith("김"));
		
		System.out.println(rs);
		
		System.out.println();
		
		List<String> nameLIst = new ArrayList<>();
		nameLIst.add("김종환");
		nameLIst.add("고병수");
		nameLIst.add("김상현");
		nameLIst.add("김준경");
		
		//	Stream -> 일회용
		Stream<String> stream = nameLIst.stream().filter(name -> name.startsWith("김"));
//		stream.forEach(name -> System.out.println(name));
		List<String> newLIst = stream.collect(Collectors.toList());
		
		newLIst.forEach(str -> System.out.println(str));
		System.out.println(newLIst);
		
		System.out.println("============================================================");
		
		nameLIst.stream()
			.filter(name -> name.startsWith("김"))
			.collect(Collectors.toList())
			.forEach(System.out :: println);		//	.forEach(name -> System.out.println(name)); 이렇게 쓴것과 똑같다.
		
		
		
		
		
		
		
		
		
	}

}
