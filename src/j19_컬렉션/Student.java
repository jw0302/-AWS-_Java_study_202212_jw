package j19_컬렉션;

import lombok.AllArgsConstructor;
import lombok.Data;

//ctrl + shift + O -> 필요없는거 정리해준다
//@NoArgsConstructor	//	기본 생성자
//@RequiredArgsConstructor
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode

@AllArgsConstructor	//	전체 생성자
@Data
public class Student {
	private String name;	// 이름
	private int year;	// 학년
//	private final String address;

}
