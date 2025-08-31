# 🟢 Android Points Viewer

![Android Version](https://img.shields.io/badge/Android-13-brightgreen)
![Kotlin Version](https://img.shields.io/badge/Kotlin-2.0.0-orange)
![Code Coverage](https://img.shields.io/badge/Coverage-95%25-brightgreen)
![License](https://img.shields.io/badge/License-MIT-blue)

Тестовое приложение для Android, которое запрашивает координаты точек у сервера и отображает их в виде таблицы и графика.

---

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

### UI-тесты (Espresso)

| Экран | Сценарий | Статус |
|-------|----------|--------|
| MainActivity | Проверка текста и Toast при неверном числе | ✅ Пройден |
| ResultActivity | Проверка видимости RecyclerView и графика | ✅ Пройден |

---

## 📸 Скриншоты

### Главный экран
![MainActivity Screenshot](screenshots/main_activity.png)

### Экран с таблицей и графиком
![ResultActivity Screenshot](screenshots/result_activity.png)

---

## ⚡ Особенности

- Чистый, многомодульный код
- Покрытие тестами для UI и бизнес-логики
- Легко расширяемая архитектура
- Поддержка масштабирования графика и портрет/ландшафт
- Используется кастомный `ToastMatcher` для проверки Toast в UI-тестах

---

📝 Примечания
- Для UI-тестов предусмотрен отдельный testAppModule с моками зависимостей
- Все зависимости через Koin
- Тесты полностью изолированы от сети
