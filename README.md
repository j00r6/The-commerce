# The-commerce

## 개발환경

- 운영체제 : macOS Ventura 13.5.1(22G90)
- 개발툴 : intelliJ IDEA CE
- 언어 : JAVA
- FrameWork : Spring Boot 2.6.2
- SDK : Amazon Corretto Version 1.8.0_412

## 요구사항 목차

[1. 회원가입 요청사항](#회원가입-요청사항)<br>
[2. 회원조회 요청사항](#회원조회-요청사항)<br>
[3. 회원정보 수정 요청사항](#회원정보-수정-요청사항)


<br>
<br>

## 회원가입 요청사항
[목차로 이동](#목차)
### 1. URL 
- api/user/join
### 2. Method
 - POST
### 3. 요청 파라미터
- 회원 ID
- 비밀번호
- 닉네임
- 이름
- 전화번호
- 이메일주소
### 4. 응답
- 응답코드 201
### 5. API 명세

| Category | Description | Method | URI | URL | 
|----------|-------------|--------|-----|-----|
| Member   |  회원가입           | POST   |  api/user   | join    | 

#### Request

##### 요청 URI
```URL
localhost:8080/api/user/join
```

##### Request Body
```json
{
    "loginId" : "adm33in",
    "password" : "dd",
    "nickName" : "4111",
    "name" : "dd",
    "phone" : "11",
    "email" : "dd"
}
```
#### Response
##### 응답코드
```
HTTP Status Code 201
```
##### Response Body
```
회원가입 성공!
```
<br>
<br>

## 회원조회 요청사항
[목차로 이동](#목차)
### 1. URL 
- api/user/list
### 2. Method
 - GET
### 3. 요청 파라미터
- page
- pagesize
- sort (가입일순 , 이름순)
### 4. 응답
- 응답코드 200
- 적절한 응답값

### 5. API 명세

| Category | Description | Method | URI | URL | 
|----------|-------------|--------|-----|-----|
| Member   |  회원조회           | get   |  api/user   | list    |  

#### Request
##### 요청 URI
```URL
localhost:8080/api/user/list?page=1&pageSize=10
```
##### Request Body
```
없음
```

#### Response
##### 응답코드
```
HTTP Status Code 200
```
##### Response Body
```json
{
    "data": [
        {
            "loginId": "adm33in",
            "password": "{bcrypt}$2a$10$uS1Qh9gaAv4ImsjOHx73hOE94reEJaAqJqXZyh0B67YM/2o8mGwqq",
            "nickName": "4111",
            "name": "dd",
            "phone": 11,
            "email": "dd"
        },
        {
            "loginId": "admin",
            "password": "{bcrypt}$2a$10$R71dobAI/hrAbUSisEo2KeVH.NkzDdsUdkbN0Mr.3lT5bkrvs3ryO",
            "nickName": "421",
            "name": "dd",
            "phone": 11,
            "email": "dd"
        }
    ],
    "pageInfo": {
        "page": 1,
        "size": 10,
        "totalElements": 2,
        "totalPages": 1
    }
}
```
<br>
<br>

## 회원정보 수정 요청사항
[목차로 이동](#목차)
### 1. URL 
- api/user/list
### 2. Method
 - GET
### 3. 요청 파라미터
- page
- pagesize
- sort (가입일순 , 이름순)

### 4. 응답
- 응답코드 200
- Paging 처리가된 응답값

### 5. API 명세

| Category | Description | Method | URI | URL | 
|----------|-------------|--------|-----|-----|
| Member   |  회원조회           | get   |  api/user   | list    |  

#### Request
##### 요청 URI
```URL
localhost:8080/api/user/admin43
```
##### Requst Body
```json
{
    "loginId" : "admin33",
    "password" : "dd",
    "nickName" : "44",
    "name" : "444",
    "phone" : "123",
    "email" : "dd"
}
```

#### Response
##### 응답코드
```
HTTP Status Code 200
```
##### Response Body
```json
{
    "loginId" : "admin33",
    "password" : "dd",
    "nickName" : "44",
    "name" : "444",
    "phone" : "123",
    "email" : "dd"
}
```
