# Проект по автоматизации тестирования для компании [BATTLESTATE GAMES](https://www.escapefromtarkov.com/)

> **Escape From Tarkov** — многопользовательская онлайн-игра в жанре тактического шутера от первого лица с элементами RPG и MMO, разрабатываемая и издаваемая компанией Battlestate Games.

## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>
____
<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="images/logo/AllureReport.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="images/logo/AllureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
</p>

____
<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>
____
- ✓ *Проверка работы смены языка.*
- ✓ *Проверка работоспособности видео.*
- ✓ *Проверка заголовка и подзаголовка в новостях.*
- ✓ *Проверка работоспособности кнопок для управления новостями.*
- ✓ *Проверка работы навигационного меню в правой части экрана.*



____
<a id="jenkins"></a>
## <img alt="Jenkins" height="20" src="images/logo/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/EFT-build/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/EFT-build/"><img src="images/screenshots/JenkinsBuild.png" alt="Jenkins" width="950"/></a>  
</p>


### **Параметры сборки в Jenkins:**
 
- *ENVIRONMENT (окружение в котором будем запускать тесты, по умолчанию PROD)*
- *COMMENT (комментарий, который отобразиться в Telegram отчете)*
- *BROWSER (браузер, по умолчанию chrome)*
- *SELENOID_HOST (адрес хоста для удалённого запуска тестов)*
- *BROWSER_VERSION (версия браузера, по умолчанию 126)*
- *BROWSER_SIZE (размер окна браузера, по умолчанию 1920x1080)*

<a id="console"></a>
## Команды для запуска из терминала
___
***Локальный запуск:***
```bash  
gradle clean smoke_test
```
```bash  
gradle clean test
```

***Удалённый запуск через Jenkins:***
```bash  
clean 
smoke 
"-DbrowserType=${BROWSER}" 
"-DbrowserVersion=${BROWSER_VERSION}"
"-DbrowserSize=${BROWSER_SIZE}" 
"-DremoteHost=${SELENOID_HOST}"
```
___
<a id="allure"></a>
## <img alt="Allure" height="20" src="images/logo/AllureReport.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.autotests.cloud/job/EFT-build/allure/)</a>
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screenshots/AllureMainPage.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="images/screenshots/AllureTestCases.png" width="850">  
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="images/screenshots/AllureGrafic.png" width="850">

</p>

____
<a id="telegram"></a>
## <img alt="Allure" height="20" src="images/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
<p align="center">  
<img title="Allure Overview Dashboard" src="images/screenshots/AllureTelegramNotification.png" width="550">  
</p>

____
