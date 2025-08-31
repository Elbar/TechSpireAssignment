# 🟢 Android Points Viewer

![Android Version](https://img.shields.io/badge/Android-13-brightgreen)
![Kotlin Version](https://img.shields.io/badge/Kotlin-2.0.0-orange)
![Code Coverage](https://img.shields.io/badge/Coverage-95%25-brightgreen)
![License](https://img.shields.io/badge/License-MIT-blue)

Тестовое приложение для Android, которое запрашивает координаты точек у сервера и отображает их в виде таблицы и графика.


https://github.com/user-attachments/assets/c20e2854-760c-47b3-9e71-945f67b43941



---


## ⚡ Особенности

- Чистый, многомодульный код
- Покрытие тестами для UI и бизнес-логики
- Легко расширяемая архитектура
- Поддержка масштабирования графика и портрет/ландшафт
- Используется кастомный `ToastMatcher` для проверки Toast в UI-тестах


## 📸 Скриншоты

### Главный экран


![IMAGE 2025-08-31 11:57:01](https://github.com/user-attachments/assets/8988e3cb-f057-4156-9b73-e8f22140e183)

### Экран с таблицей и графиком

![IMAGE 2025-08-31 11:57:19](https://github.com/user-attachments/assets/e6356f35-a05f-4499-81bf-74e20d308c7a)

![IMAGE 2025-08-31 11:57:27](https://github.com/user-attachments/assets/b0fee46d-57cb-454b-9f18-0b4c9991e0c1)




## 🎯 Функционал

- Главный экран с информационным текстом, полем для ввода числа точек и кнопкой «Поехали»
- Получение точек с сервера (`GET /api/test/points?count=N`)
- Отображение точек в таблице (`RecyclerView`)
- Отображение графика точек (`LineChart`) с возможностью масштабирования и сглаживания
- Поддержка портретной и ландшафтной ориентации

---

## 🛠 Использованные технологии

| Категория | Технологии |
|-----------|------------|
| Язык | ![Kotlin](https://img.shields.io/badge/Kotlin-FF5722?style=flat&logo=kotlin&logoColor=white) Kotlin |
| Архитектура | MVVM + Clean Architecture |
| Dependency Injection | ![Koin](https://img.shields.io/badge/Koin-43BCF8?style=flat&logo=koin&logoColor=white) Koin |
| Асинхронность | Kotlin Coroutines, Flow |
| UI | Android Views / XML Layouts |
| Графики | ![MPAndroidChart](https://img.shields.io/badge/MPAndroidChart-3.1.0-00BCD4) |
| Тестирование | JUnit5, MockK, Espresso, ToastMatcher, kotlinx-coroutines-test |

---

## 📂 Структура проекта

- app/  →  TechSpireApp 
- domain/ → UseCase и модели
- data/ → Repository, API, DTO
- presentation/ → Activities, UI views, unit and UI tests

---

## 🧪 Результаты тестов

### Unit-тесты (ViewModel и UseCase)

| Тестовый набор | Запущено | Ошибки | Пропущено |
|----------------|----------|--------|-----------|
| ViewModel & UseCase | 12 | 0 | 0 |

<img width="1203" height="615" alt="Screenshot 2025-08-31 at 11 59 02" src="https://github.com/user-attachments/assets/f9c6838c-5e9f-4803-a298-9efa5577332d" />



### UI-тесты (Espresso)

| Экран | Сценарий | Статус |
|-------|----------|--------|
| MainActivity | Проверка текста и Toast при неверном числе | ✅ Пройден |
| ResultActivity | Проверка видимости RecyclerView и графика | ✅ Пройден |


#### MainActivity
<img width="986" height="934" alt="Screenshot 2025-08-31 at 12 00 19" src="https://github.com/user-attachments/assets/0155da1f-7bcb-4943-8424-4f69cfaf0b5a" />

#### ResultActivity

<img width="1376" height="848" alt="Screenshot 2025-08-31 at 12 00 57" src="https://github.com/user-attachments/assets/50c700fe-4d73-4ddd-b75e-a04e72ff4a0c" />

---


📝 Примечания
- Для UI-тестов предусмотрен отдельный testAppModule с моками зависимостей
- Все зависимости через Koin
- Тесты полностью изолированы от сети
