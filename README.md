<h1>Java Google Convention</h1>
https://sihyung92.oopy.io/af26a1f6-b327-45a6-a72b-c6fcb754e219


------------------------


<h1>Git Commit Convention</h1>

- feat : 새로운 기능을 추가하는 경우
- fix : 버그를 고친경우
- docs : 문서를 수정한 경우
- style : 코드 포맷 변경, 세미콜론 누락, 코드 수정이 없는경우
- refactor : 코드 리펙토링
- test : 테스트 코드. 리펙토링 테스트 코드를 추가했을 때
- chore : 빌드 업무 수정, 패키지 매니저 수정
- design : CSS 등 사용자가 UI 디자인을 변경했을 때
- rename : 파일명(or 폴더명) 을 수정한 경우
- remove : 코드(파일) 의 삭제가 있을 때. "Clean", "Eliminate" 를 사용하기도 함

```
feat: "Add login API"        // 타입: 제목

로그인 API 개발               // 본문


/*
* 아래는 이슈 해결이 아니라면 굳이 하지 않아도 됨
*/
Resolves: #123              // 꼬리말 => 이슈 123을 해결했으며,
Ref: #456                                 이슈 456 를 참고해야하며,
Related to: #48, #45         현재 커밋에서 아직 이슈 48 과 45 가 해결되지 않았다.
```
