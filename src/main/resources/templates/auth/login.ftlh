<#import "../layout.ftlh" as login>
<@login.layout ; spring>

    <body>
<div class="container mt-5">
    <h2 class="text-center">Вход в систему</h2>

    <#if error??>
        <div class="alert alert-danger">
            Неправильный читательский билет или пароль.
        </div>
    </#if>

    <form action="/auth/login" method="post">

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                   value="${(_csrf.token)!'csrf-token'}"/>
        </#if>

        <div class="form-group">
            <label for="readerCardNumber">Читательский билет</label>
            <input type="text" id="readerCardNumber" name="username" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="password">Пароль</label>
            <input type="password" id="password" name="password" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-primary btn-block">Войти</button>
    </form>

</div>



</@login.layout>