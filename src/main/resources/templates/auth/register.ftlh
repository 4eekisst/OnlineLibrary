<#import "../layout.ftlh" as register>
<@register.layout ; spring>
    <body>
    <h1>Регистрация пользователя</h1>
    <form action="/auth/register" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                   value="${(_csrf.token)!'csrf-token'}"/>
        </#if>
        <label>Имя:</label>
        <input type="text" name="name" required /><br />

        <label>Фамилия:</label>
        <input type="text" name="surname" required /><br />

        <label>Отчество:</label>
        <input type="text" name="patronymic" /><br />

        <label>Адрес:</label>
        <input type="text" name="address" required /><br />

        <label>Номер паспорта:</label>
        <input type="text" name="passportNumber" required /><br />


        <label>Пароль:</label>
        <input type="password" name="password" required /><br />

        <button type="submit">Зарегистрироваться</button>
    </form>
    </body>

</@register.layout>