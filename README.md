# OAuth2 를 만들면서.



<img src="http://www.newsworks.co.kr/news/photo/201808/212050_99877_3549.jpg" alt="소셜로그인&#39; 개인정보 줄줄...“페이스북 최다, 70개 개인정보 제공” - 뉴스웍스" style="zoom:50%;" />

> 가장 먼저 프로젝트에 로그인 방식으로 Kakao와 Google 로그인을 구현하려다
>
> 기초부터 공부하는 것이 좋다고 생각하여 Login의 기본이 되는 OAuth2 개념에 대해 이해하고
>
> 실제로 Owner, Client, Resource 서버를 백기선님의 Live Coding을 통해 구현해 보았습니다. 
>
> 출처 : https://www.youtube.com/watch?v=NQM1hghpF0Q





---

## 가장 먼저 OAuth2 란 

- 우리가 평소 프로젝트를 진행할 때, 우리만의 서비스의 정보가 아닌, 

  다른 제 3의 ( 예로는 구글, 카카오, 페이스북, 네이버 등)  등록되어있는 회원의 정보와 해당 기능을 이용하기 위해 

  `3rd 파티로 부터 access Token`을 받는 과정을 이야기한다. 



- 방금 말했듯이 OAuth2의 가장 중요한 목적은 해당 유저에 대한 정보나 기술을 사용하기 위해 `access Token`을 부여받아 기능을 대신 사용할 수 있게끔 하는 것이다. 따라서 어떻게 OAuth2의 access Token을 받아오는지 확인한다.

---

## 순서

<img src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F236C70435940026011" alt="oauth2에 대하여"  />



#### 1, 2 과정 

<img src="https://blog.kakaocdn.net/dn/mYFlJ/btqFXf3Olvp/Kq6Q1gTBbjkh2byo1isFyk/img.png" alt="카카오 로그인(Kakao Login) 인증 API을 활용해서 간단하게 사용자 로그인 처리하는 방법" style="zoom: 25%;" />

> 우리가 흔히 만나는 화면이다. 이 화면에서 로그인을 진행하게 된다면 바로 `access Token` 을 부여받을 수 있을 것 같지만, 그렇지 않다. 그 전에 `Authorization code` 를 `Client`에 전달한다.



### 3, 4 과정

![한번의 클릭으로 소비자에서 내 회원으로! 카카오싱크를 소개합니다! | 케이알마케팅](https://lh3.googleusercontent.com/proxy/NMFGONLe0Le_NNFX1QXtP3pd0ohqxX2hNcFWsYog0UgpTFVfGJGWAYlnF02-k5fQ87sMplbUysNjko9hEi8SJrmFysoOdfRWiL0UHK4)

> 그 다음은 이런 화면을 만나본 적이 있을 것이다. 이 화면이 위에 3, 4 번에 해당하는 부분이다. 
>
> `Resource Server`에서는 당연하게도 모든 정보를 주지 않는다. 당연히 `User` 또한 주고 싶지 않을 것이다. 
>
> 따라서 해당 `Resource Server` 에서 얻을 수 있는 정보에 대한 허용 범위를 선택하게 된다. 
>
> 이 후, 드디어 OAuth2의 목적인 `access Token` 을 발급받게 된다



### 5, 6 과정 

> `access Token` 으로 해당 통신이 완료되면, 설정하지 않았지만 자동으로 ***님 반갑습니다. 라는 문구를 종종 봤을 것이다. 이 부분이 내가 해당 정보를 동의했기때문에, 제 3의 (`Resource Server`) 에서 해당 정보를 넘겨준 것이다. 이렇게 함으로써 `OAuth2` 통신이 마무리 됐다.



---

### 마치며, 

- `OAuth2` 를 로그인에만 사용했지만, 나의 서비스에서 지속된 사용자로 이용하기 위하여 어떻게 처리를 해야할지가 아직 의문이다. 갖고 있는 해결책으론, 받아온 개인정보를 가지고 나의 Application에 회원으로 등록하는 방법이 있는 것 같다. 그리고 우리만의 JWT를 발급해 인가에 대한 부분을 해결할 수 있을 것이라 생각한다. 아직은 처음이라 잘은 와닿지 않지만 조금더 Spring Security 와 OAuth2에 대한 공부를 이어나가야겠다. 