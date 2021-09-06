## Entity
### 주의할 점
- 무분별한 setter 메소드 생성을 주의해야 한다. 
- 해당 클래스의 인스턴스 값들이 언제 어디서 변해야하는지 코드상으로 명확히 구분할수가 없어, 차후 기능 변경시 복잡해짐
- 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야 한다.

```
잘못된 사용
public Class Order {
    public void setStatus(boolean status) {
        this.status = status;
    }
}

public void 주문서비스의_취소메소드() {
    order.setStatus(false);
}

올바른 사용
public class Order {
    public void cancelOrder() {
        this.status = false;
    }
}

public void 주문서비스의_취소메소드() {
    order.cancelOrder();
}
```

- 기본 생성자도 AccessLevel.PROTECTED 로 막아놓고, setter 메소드도 없는 상황에서 어떻게 값을 채워 DB 에 insert 해야하나?
  + 기본적인 구조는 생성자를 통해 최종값을 채운 후 DB 에 insert 하는 것이며,
  + 값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경하는 것을 전제로 한다. 
  + 여기서 생성자 대신에 @Builder 를 통해 제공되는 빌더 클래스를 사용한다. 
  + 생성자나 빌더나 생성시점에 값을 채워주는 역할은 똑같다. 
  + 다만, 생성자의 경우 지금 채워야할 필드가 무엇인지 명확히 지정해줄 수 없다. 

```
아래와 같을 경우, 실제로 코드를 실행하기전까진 전혀 문제를 찾을 수가 없다. 
public Example(String a, String b) {
    this.a = a;
    this.b = b;
}

그러나, Builder 를 사용하게 되면 어느 필드에 어떤 값을 채워야 할지 명확하게 인지할 수 있다. 
Example.builder()
    .a(a)
    .b(b)
    .build();
```

## Bean 주입 받는 방식
```
- @Autowired
- setter
- 생성자
```
- 이 중 가장 권장하는 방식이 생성자로 주입받는 방식(@Autowired 는 비권장방식)
- 생성자로 Bean 객체를 받도록 하면 @Autowired 와 동일한 효과를 볼 수 있다. 
- 이는 @AllArgsConstructor 로 해결 가능하다!
- 생성자를 직접 안쓰고 Lombok 어노테이션을 사용한 이유는,
  + 해당 클래스의 의존성 관계가 변경될때마다 생성자 코드를 계속해서 수정하는 번거로움을 해결하기 위함

## controller annotation 관련
- Spring 4.3 부터는 @RequestMapping 을 대체할 수 있는 여러 매핑 어노테이션이 추가 되었다. 
- @GetMapping 은 이전으로 보면 @RequestMapping(value = "/", method = RequestMethod.GET) 과 동일



