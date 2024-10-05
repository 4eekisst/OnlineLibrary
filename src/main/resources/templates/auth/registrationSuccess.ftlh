<#import "../layout.ftlh" as registrationSuccess>
<@registrationSuccess.layout ; spring>

    <body>
    <h1>Вы успешно зарегистрировались!</h1>
    <p>Вот ваш читательский билет: <strong>${readerCardNumber}</strong></p>
    <p>Не потеряйте его! Он потребуется для входа в ваш профиль.</p>
    <a href="/auth/login">Перейти к входу</a>
    </body>

</@registrationSuccess.layout>