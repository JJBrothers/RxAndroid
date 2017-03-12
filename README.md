전형적인 안드로이드 MVC 패턴에 벗어나
ui 처리는 Activity에서,
비지니스로직은 Presenter 에서 처리, MVP 패턴을 따르도록 한다
Activity에서 비지니스로직을 철저히 분리하며
콜백을 통한 데이터결과값을 통해 ui를 핸들링한다

전체적인 구조는.
각 preseneter마다 처리할 1.manager 호출후,
manager는 또다른 helper를 호출하도록한다

여러개의 helper 는 하나의 manager를 통해관리를하며
관계는 n:1 로 표현할수있겠다.

모든 로직은 ReactiveX Observer 패턴을 사용하며 flexible하게 데이터와 로직을 처리하도록한다
모든 로직은 Observable로 리턴을 하며 구간별 데이터 핸들링을 용의하게하는 것이 첫번째목표이며
Retrolambda를 사용하여 함수형 언어에 가깝게 코드를 줄일수있도록 하는것이 두번째 목표였다

통신모듈은 ReactiveX를 지원하는 Retrofit을 사용하며
DI 매커니즘 dagger2를 사용하도록한다
