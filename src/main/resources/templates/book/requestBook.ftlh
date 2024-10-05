<#import "../layout.ftlh" as req>
<@req.layout; spring>

    <body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Запрос книги</h2>

        <div class="card mb-4 shadow">
            <div class="card-body">
                <h5 class="card-title">${book.title}</h5>
                <p class="card-text">Автор: ${book.author}</p>
                <p class="card-text">Статус:
                    <#if book.status == 'AVAILABLE'>
                        <span class="text-success">Доступна</span>
                    <#elseif book.status == 'EXPECTED'>
                        <span class="text-warning">Ожидается</span>
                    <#elseif book.status == 'RETURNED'>
                        <span class="text-info">Возвращена</span>
                    <#elseif book.status == 'OVERDUE'>
                        <span class="text-danger">Просрочена</span>
                    <#else>
                        <span class="text-muted">Неизвестный статус</span>
                    </#if>
                </p>
            </div>
        </div>

        <form action="/submitBookRequest" method="post" class="shadow p-4 bg-light rounded">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                       value="${(_csrf.token)!'csrf-token'}"/>
            </#if>
            <input type="hidden" name="bookId" value="${book.id}">

            <div class="mb-3">
                <label for="readerTicket" class="form-label">Читательский билет:</label>
                <input type="text" class="form-control" id="readerTicket" name="readerTicket" required placeholder="Введите номер читательского билета">
            </div>

            <div class="mb-3">
                <label for="returnDate" class="form-label">Дата возврата:</label>
                <input type="date" class="form-control" id="returnDate" name="returnDate" required>
            </div>

            <button type="submit" class="btn btn-primary">Отправить запрос</button>
        </form>
    </div>
    </body>
</@req.layout>
