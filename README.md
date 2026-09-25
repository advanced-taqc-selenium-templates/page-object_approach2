# Page Object, частина 2

Стартер для практики Page Object на сайті [Навчай українською](http://speak-ukrainian.eastus2.cloudapp.azure.com/dev/).

Готові сторінки (`HomePage`, `TopPart`, `ClubComponent`, `ClubsContainer`) вже зібрані за схемою **Page Object → Functional → Business Logic**. Ваші класи мають повторювати цю схему. Методи з `// TODO` навмисно не реалізовані: їх треба доробити вам. Поки реалізація відсутня, геттери даних кидають `UnsupportedOperationException`, щоб тест не проходив на заглушці.

## Середовище

- JDK 25 (поточний LTS)
- Maven 3.9+
- Google Chrome

Запуск усіх тестів:

```bash
mvn test
```

Один тест:

```bash
mvn test -Dtest=SomeTest#checkChallenge
```

Для запису відео можна увімкнути паузи між кроками (за замовчуванням їх немає):

```bash
mvn test -Dpresentation.delay.seconds=1
```

Скріншоти й HTML невдалих тестів зберігаються в `target/test-artifacts`.

## Pre-requirements

1. Реалізуйте `ClubDetailsPage`, `ClubInfoModal` і `LoggedDropdown`.
   У `LoggedDropdown` локатори ще не задані: знайдіть пункти меню залогіненого користувача за зразком `GuestDropdown`.

## Task 1

1. Реалізуйте `ChallengeTeachPage` для челенджу «Навчайся».
2. Реалізуйте `YoutubeFrame` для iframe YouTube. У `gotoYoutubeFrame()` треба перейти в цей iframe, а в `gotoChallengeTeachPage()` — повернутися на сторінку челенджу.
3. Доповніть `SomeTest.checkChallenge(Challengies)`. Перевірте URL, на який веде елемент YouTube.

## Task 2

1. Реалізуйте enum `Cities`: збережіть назву міста з конструктора.
2. Реалізуйте enum `ClubContents`: місто, назва і опис гуртка. Опис читається через `getDescription()`.
3. Доповніть `openClubInfoModal()` і `openClubDetailsPage()` у `ClubComponent`.
4. Доповніть `isEnablePreviousPageLink()`, `isEnableNextPageLink()` і `clickPageLinkByNumber(int)` у `ClubsContainer`.
5. Доповніть `chooseCity(Cities)` у `ClubPage`.
6. Доповніть `nextClubPagination()` у `AdvancedClubPage`, щоб після переходу сторінка лишалась advanced search.
7. Доповніть `SomeTest.checkClubExist()`. Перевірте назву і частину опису.
8. Доповніть `SomeTest.checkAdvancedSearch()`. Знайдіть гурток, пройшовши пагінацію.

## Task 3 (додатково)

1. Реалізуйте `CommentComponent` для одного коментаря на `ClubDetailsPage`.
2. Реалізуйте `CommentsContainer` для списку коментарів.
3. Доповніть `SomeTest.checkCommentExist()`.

Звіт: посилання на GitHub і коротке відео (3–5 хв) із запуском тестів.
