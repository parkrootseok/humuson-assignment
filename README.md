# 제품팀 과제테스트

## 📑 목차

- [제품팀 과제테스트](#제품팀-과제테스트)
  - [📑 목차](#-목차)
  - [📋 프로젝트 개요](#-프로젝트-개요)
  - [✅ 주요 기능 및 요구사항 충족 여부](#-주요-기능-및-요구사항-충족-여부)
    - [1. 로그 데이터 생성](#1-로그-데이터-생성)
    - [2. 로그 분석 API](#2-로그-분석-api)
      - [2-1. 로그 파일 업로드 (POST /logs/upload)](#2-1-로그-파일-업로드-post-logsupload)
      - [2-2. 로그 분석 (GET /logs/analyze)](#2-2-로그-분석-get-logsanalyze)
      - [2-3. 에러 로그 조회 (GET /logs/errors)](#2-3-에러-로그-조회-get-logserrors)
      - [2-4. 실시간 로그 스트리밍 (GET /logs/stream)](#2-4-실시간-로그-스트리밍-get-logsstream)
    - [3. 웹 UI](#3-웹-ui)
  - [🛠 기술 스택](#-기술-스택)
    - [클라이언트](#클라이언트)
    - [서버](#서버)
    - [공통](#공통)
  - [🚀 실행 방법](#-실행-방법)
    - [1. 루드 디렉터리 이동](#1-루드-디렉터리-이동)
    - [2. Docker Compose 실행](#2-docker-compose-실행)
  - [📌 API 문서](#-api-문서)
    - [**1. POST /logs/upload**](#1-post-logsupload)
    - [**2. GET /logs/analyze**](#2-get-logsanalyze)
    - [**3. GET /logs/errors**](#3-get-logserrors)
    - [**4. GET /logs/ws-stream**](#4-get-logsws-stream)
    - [**5. GET /logs/ws-distribution**](#5-get-logsws-distribution)
  - [💻 웹 UI 설명](#-웹-ui-설명)
  - [🤖 AI 도구 활용](#-ai-도구-활용)
    - [클라이언트](#클라이언트-1)
      - [1. Cursor AI 기반 프론트엔드 초기 설정](#1-cursor-ai-기반-프론트엔드-초기-설정)
      - [2. 페이지 디자인 구현](#2-페이지-디자인-구현)
      - [3. 문제 해결](#3-문제-해결)
      - [4. 마이그레이션](#4-마이그레이션)
    - [서버](#서버-1)
      - [1. 효율적인 코드 작성](#1-효율적인-코드-작성)
    - [공통](#공통-1)
      - [1. 효율적인 문서화](#1-효율적인-문서화)
  - [📸 스크린샷](#-스크린샷)

## 📋 프로젝트 개요

Spring Boot 기반 로그 분석 시스템과 React 대시보드를 구현하여, 로그 데이터 생성, 분석, 시각화를 수행하는 과제 테스트입니다.

## ✅ 주요 기능 및 요구사항 충족 여부

### 1. 로그 데이터 생성

-   **기능 설명**: Logback을 이용하여 10초 간격으로 로그를 자동 생성
-   **요구사항 체크리스트**:
    -   [x] 10초 간격 자동 로그 생성 구현
    -   [x] 랜덤하게 INFO, ERROR, WARN 로그 출력 구현

### 2. 로그 분석 API

#### 2-1. 로그 파일 업로드 (POST /logs/upload)

-   **기능 설명**: 사용자가 로그 파일을 업로드할 수 있음
-   **요구사항 체크리스트**:
    -   [x] 파일 업로드 기능 구현
    -   [x] 업로드 후 로그 데이터 반영 처리

#### 2-2. 로그 분석 (GET /logs/analyze)

-   **기능 설명**: 전체 로그 개수와 ERROR 로그 개수를 분석하여 반환
-   **요구사항 체크리스트**:
    -   [x] 전체 로그 개수 반환 구현
    -   [x] ERROR 로그 개수 반환 구현

#### 2-3. 에러 로그 조회 (GET /logs/errors)

-   **기능 설명**: ERROR 및 WARN 로그만 필터링하여 조회
-   **요구사항 체크리스트**:
    -   [x] ERROR, WARN 로그 필터링 구현

#### 2-4. 실시간 로그 스트리밍 (GET /logs/stream)

-   **기능 설명**: WebSocket을 활용하여 실시간 로그 스트리밍 제공
-   **요구사항 체크리스트**:
    -   [x] WebSocket 기반 실시간 데이터 전송 구현

### 3. 웹 UI

-   **기능 설명**: 단일 페이지에서 로그 분석 결과를 시각화
-   **요구사항 체크리스트**:
    -   [x] 최신 로그 20개 테이블 표시 구현
    -   [x] 에러 로그 개수 차트 (예: Bar Chart) 구현
    -   [x] 로그 검색 및 필터링 기능 구현

## 🛠 기술 스택

### 클라이언트

|                  |                                                                                                                                       |
| :--------------- | :------------------------------------------------------------------------------------------------------------------------------------ |
| Framework        | <img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black">                                  |
| Language         | <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"/>                       |
| State Management | <img src="https://img.shields.io/badge/zustanrd-5B4638?style=for-the-badge&logoColor=white">                                          |
| IDE              | <img src="https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visualstudiocode&logoColor=white"/> |

### 서버

|           |                                                                                                                          |
| :-------- | :----------------------------------------------------------------------------------------------------------------------- |
| Framework | <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=SpringBoot&logoColor=white"/>          |
| Language  | <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=openjdk&logoColor=white"/>                   |
| IDE       | <img src="https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white"/> |

### 공통

|                 |                                                                                                                                                                                                                         |
| :-------------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Version Control | <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"/> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"/>               |
| Copilot         | <img src="https://img.shields.io/badge/openai-412991.svg?style=for-the-badge&logo=openai&logoColor=white"/> <img src="https://img.shields.io/badge/Cursor-181717.svg?style=for-the-badge&logo=Cursor&logoColor=white"/> |

## 🚀 실행 방법

### 1. 루드 디렉터리 이동

```
cd humuson-assignment
```

### 2. Docker Compose 실행

```
docker compose up -d --build
```

## 📌 API 문서

### **1. POST /logs/upload**

-   **설명**: 로그 파일을 업로드하는 기능
-   **요청 형식**: `multipart/form-data`
-   **요청 데이터**:  
     | 필드 | 타입 | 필수 여부 | 설명 |
    |---------|-----------------------|-----------|----------------------------------------|
    | `file` | `multipart/form-data` | ✅ | 업로드할 로그 파일 (`.log`, `.txt` 지원) |
-   **응답 예시 (`200 OK`)**:
    ```json
    {
        "fileName": "d8b7e3a4-45fa-4dfb-b2a2-8f42b6899f64.log"
    }
    ```

---

### **2. GET /logs/analyze**

-   **설명**: 전체 로그 개수 및 `ERROR` 로그 개수를 분석
-   **요청 파라미터**:  
     | 필드 | 타입 | 필수 여부 | 기본값 | 설명 |
    |-----------|---------|-----------|-----------------|--------------------------------|
    | `fileName`| `string`| ❌ | `logs/app.log` | 분석할 로그 파일명 (생략 시 기본 로그 파일 사용) |
-   **응답 예시** (`200 OK`):
    ```json
    {
        "totalLogs": "1300",
        "errorLogs": "345"
    }
    ```

---

### **3. GET /logs/errors**

-   **설명**: 특정 레벨(`ERROR`, `WARN`, `INFO`)의 로그 목록을 조회
-   **요청 파라미터**:  
     | 필드 | 타입 | 필수 여부 | 기본값 | 설명 |
    |-----------|---------|-----------|---------------------|----------------------------------|
    | `fileName`| `string`| ❌ | `logs/app.log` | 조회할 로그 파일명 |
    | `levels` | `string`| ❌ | `"ERROR,WARN,INFO"` | 조회할 로그 레벨 (쉼표로 구분) |
-   **응답 예시** (`200 OK`):
    ```json
    [
        {
            "timestamp": "2025-02-25 15:37:36",
            "level": "WARN",
            "className": "c.h.b.d.l.s.LogGeneratorServiceImpl",
            "serviceName": "PaymentService",
            "message": "Low stock warning for item: A8841"
        }
    ]
    ```

---

### **4. GET /logs/ws-stream**

-   **설명**:

    -   WebSocket 기반 실시간 로그 스트리밍 API
    -   클라이언트는 WebSocket을 통해 **최초 연결 시 최근 20개 로그를 수신**하고, 이후 **9초 주기로 최신 로그를 자동 수신**

-   **요청 형식**:

    -   `ws://` 또는 `wss://`(SSL 환경)
    -   클라이언트는 WebSocket 연결을 통해 로그 데이터를 지속적으로 수신

-   **응답 예시 (WebSocket 메시지 포맷)**:

    ```json
    {
        "timestamp": "2025-02-25 15:37:36",
        "level": "WARN",
        "className": "c.h.b.d.l.s.LogGeneratorServiceImpl",
        "serviceName": "PaymentService",
        "message": "Low stock warning for item: A8841"
    }
    ```

-   **참고 사항**:
    -   WebSocket 연결 URL은 환경 변수(`REACT_APP_WS_URL`)에서 관리

### **5. GET /logs/ws-distribution**

-   **설명**:

    -   WebSocket 기반 **로그 분포 데이터 조회 API**
    -   클라이언트는 WebSocket을 통해 **최근 10분간의 로그 데이터를 수신**하고, **로그 레벨별(Info, Warn, Error) 분포를 1분 단위로 그룹화하여 제공**

-   **요청 형식**:

    -   `ws://` 또는 `wss://`(SSL 환경)
    -   클라이언트는 WebSocket 연결을 통해 일정 시간 내 로그 분포 데이터를 수신

-   **응답 예시 (WebSocket 메시지 포맷)**:

    ```json
    [
        {
            "timestamp": "2025-02-25 15:30",
            "counts": {
                "INFO": 5,
                "WARN": 3,
                "ERROR": 1
            }
        },
        {
            "timestamp": "2025-02-25 15:31",
            "counts": {
                "INFO": 2,
                "WARN": 6,
                "ERROR": 0
            }
        }
    ]
    ```

-   **참고 사항**:
    -   `timestamp`는 **초(`ss`)를 제외한 `yyyy-MM-dd HH:mm` 형식**으로 제공됨
    -   로그 분포 데이터는 **최대 10분 범위 내에서 조회되며, 1분 단위로 그룹화됨**
    -   WebSocket 연결 URL은 환경 변수(`REACT_APP_WS_URL`)에서 관리

## 💻 웹 UI 설명

> 대시보드 구성, 테이블/차트, 검색 및 필터링 등 UI 구성 요소에 대해 작성하세요.

## 🤖 AI 도구 활용

### 클라이언트

#### 1. Cursor AI 기반 프론트엔드 초기 설정

-   **React 프로젝트 생성**  
    React 앱 초기화로 프로젝트를 시작함.
-   **패키지 설치**  
    `@mui/material`, `styled-components`, `recharts`, `axios` 등 필요한 패키지를 설치.
-   **프로젝트 구조 설정**  
    코드 유지보수를 위해 `components`, `services`, `styles` 등으로 디렉토리 구성.
-   **스타일링 설정**  
    전역 스타일(`GlobalStyle`)과 테마(`theme`)를 설정하여 일관된 디자인 적용.
-   **API 기본 구조 구축**  
    백엔드와의 통신을 위한 API 서비스 구조를 마련.
-   **코드 품질 도구 설정**  
    Prettier, ESlint, 환경 변수(.env), .gitignore 등을 설정하여 코드 품질 및 관리 효율성을 향상.

#### 2. 페이지 디자인 구현

-   **페이지 구현**
    페이지에 대한 기능을 설명하고, 빠르게 초기 화면 구현
-   **디자인 구현**
    로그 모니터링 서비스라는 점을 명시하여, 이에 맞는 디자인 적용

#### 3. 문제 해결

-   **파일 업로드 시 중복 호출 문제 해결**
    상태 관리 문제로 인한, 파일 업로드 중복 호출 문제 해결에 사용

#### 4. 마이그레이션

-   **상태 관리 라이브러리 마이그레이션**
    React 기본 상태 관리에서 Zustand 라이브러리로 마이그레이션 수행

### 서버

#### 1. 효율적인 코드 작성

-   **빠르게 초기 구현 후, Chat GPT를 활용하여 리팩토링 수행**  
    초기에는 모든 로직을 Controller에 집중 구현한 후, 클린 아키텍처 원칙을 적용하여 코드 리팩토링

### 공통

#### 1. 효율적인 문서화

-   **미리 정의한 PR, ISSUE 템플릿을 참고하여 작업 내용 작성**
-   **개발 진행 중간에 README.md 파일 수정 사항 반영**

## 📸 스크린샷

> 프로젝트 실행 화면 캡처 이미지 및 설명을 여기에 작성하세요.
