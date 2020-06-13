# 블록체인 시스템 엔지니어 양성과정 스터디
블록체인 교육을 받기에 앞서 교육에서 웹 애플리케이션에 개발에 사용될 Node.js의 사용법을 익히고 여러가지 자료 공유와 서브 프로젝트 진행을 함께한다.

# Git

## Git 설치
Git을 사용하려면 우선 설치해야 한다.  
패키지를 설치하거나 별도의 인스톨러로 설치할 수 있다.  
Windows에 Git을 설치하는 방법은 여러 가지다. 공식 배포판은 Git 웹사이트에서 내려받을 수 있다. http://git-scm.com/download/win에 가면 자동으로 다운로드가 시작된다. 이 프로젝트가 'Git for Windows’인데, Git 자체와는 다른 별도의 프로젝트다. 자세한 정보는 https://git-for-windows.github.io/에서 확인한다.

자동화된 설치 방식은 Git Chocolatey 패키지를 통해 이용해볼 수 있다. 패키지는 커뮤니티에 의해 운영되는 프로그램인 점을 알려드린다.

Windows에서도 Git을 사용하는 또 다른 방법으로 'GitHub Desktop’을 설치하는 방법이 있다. 이 인스톨러는 CLI와 GUI를 모두 설치해준다. 설치하면 Git을 Powershell에서 사용할 수 있다. 인증정보(Credential) 캐싱과 CRLF 설정까지 잘 된다. 이런 것들은 차차 배우게 될 것인데, Git 사용자라면 쓰게 될 기능들이다. 'GitHub Desktop’은 GitHub Desktop 웹사이트에서 내려받는다.

### Reference
> https://git-scm.com/book/ko/v2/%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-Git-%EC%84%A4%EC%B9%98

## 깃허브 레포지터리 로컬에 생성하는 방법 (Git Clone)  
1. `git clone https://github.com/wjrmffldrhrl/blockchain_study.git`

## 변경 내용을 레포지터리에 업로드 하는 방법 (add, commit, push)
1. `git add .`
2. `git commit -m "commit"`
3. `git push origin master`
