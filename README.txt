# springboot-missions

■ 100번은 한 것같은데 이것도 3주 지난다고 좀 생경해진다.
1. 일단 sql로 db를 만들어야 된다. mysql로 적절하게 만들었다고 치고
2. dao 짜라.
3. controller 만들고 @restcontroller 쓰고 MemberService로 넘겨라.
4. MemberService에서는 일단 MemberDao로 넘겨라.
5. Dao로 왔으면 생성자에서 Class.forname으로 드라이버 깔고
6. 각 메서드에서는 일단 List부터 만들어라.
7. 그다음 query = ""; 입력하고
8. psmt = 로 문구 준비하고
9. rs에 담아서
10 rs.next()가 있는 동안
11 MemberVO m 인스턴스화를 해서
12 m.set 어쩌구 해서 list에 add

1 서비스에서 list 만드는 거는
2 생성자에서 니가 반복문 돌면서 list에 add하고
3. getMember
List하나 더 파서 list1을 만들고
list를 돌면서 id랑 같으면 list1에 add
4. addMember
postman에 있는 memberVO를 add
regidate만 new date로
5. updateMember
반복문을 돌면서 같으면 m.setPass/setName
6. deleteMember
반복문을 돌면서 같으면 list.remove(m)

@ 이렇게 인터넷에 줄줄이 쓰는게 초보인거 드러내는 거 같고 하지만 뭐..
@ 초보 맞으니까.
@ 못하는 것보다는 훨씬 낫지 않을까?


미션1
controller에서 메서드를 던져주면 service에서 list를 만들어서 브라우저에 json타입으로 보여준다.

미션2
dao에서 서버에 연결하고 거기서 쿼리를 몇 개 날려본다.

미션3
2의 dao를 인터페이스로 만들고 그 구현은 dao에서 상속받은 클래스 파일에서 한다.

미션4
Service단에서 질의한 쿼리를 텍스트파일과 db에 기록하는 법을 알아본다.

미션5
클래스 또는 생성자에서 선언된 필드를 autowire 해 본다. 사실 메서드나 매개변수도 wire할 수 있다.

# tips

■ h2 테이블 수정하기 https://121202.tistory.com/27 <br>
ALTER TABLE MEMBER ALTER COLUMN NAME varchar(200);

Controller에서 객체를 선언 안하고 필드만 선언해서 쓰고 싶으시면 @Autowired를 쓰면 된다.
@Autowired를 쓰는 방법에는 3가지 정도가 있는데
필드에 @Autowired를 쓰는 게 제일 심플하긴 하지만
메서드 또는 매개변수에 wiring을 하는 것보다 문제가 생길 소지는 더 크다고 한다. 

■ 새로운 h2 db 만드는 법
c:\users\user\test.mv.db를 복사
니가 만들고 싶은 db 이름으로 수정
들어가서 테이블 다 밀고 시작하면 된다.

■ ConcurrentModificationException
https://codechacha.com/ko/java-concurrentmodificationexception/ <br>
 위와 같은 에러가 떴을 때는 쿨하게 Iterator 사용해라.

■ Maven project 만드는 법
자바 프로젝트 하나 만들고 그거를 Maven으로 convert해라.

■ @Qualifier
니가 서비스단에서 dao를 2개 이상 쓰고 싶으면 필드 앞에다가 @Qualifier("연결하고 싶은 이름")을 쓰고, 그 다음 그 연결할 Repo에도 Repository("연결하고 싶은 이름")을 달아라.

# troubleshoot
class 위에 @restcontroller를 빼먹으면 not found, 못 찾는다.

리스트에 저장하지 않으면 리스트에 아무 것도 안 들어간다.

삭제를 하는 메서드의 반복문 내에서 return을 하지 않으면 500을 내면서 서버가 터진다.

Constructor threw exception; nested exception is java.lang.NullPointerException: Cannot invoke "java.util.List.add(Object)" because "this.list" is null
list라는 변수가 null이라는 얘기다.
null이 안되게 객체를 만들어 줘라.
			 
상속을 이미 받은 상태에서는 그냥 변수를 쓰면 된다. 다시 변수의 데이터타입을 선언할 필요는 없어보인다.

■ this.con is null
연결해서 con에다가 대입했는지 봐라. 안했으면 당연히 null
