<#import "../layout.ftlh" as profile>
<@profile.layout ; spring>

    <body>
    <div class="container mt-4">
        <h1 class="text-center">Профиль пользователя</h1>
        <div class="card mb-4">
            <div class="card-body">
                <p><strong>Имя:</strong> <span>${user.name}</span></p>
                <p><strong>Фамилия:</strong> <span>${user.surname}</span></p>
                <p><strong>Отчество:</strong> <span>${user.patronymic}</span></p>
                <p><strong>Адрес:</strong> <span>${user.address}</span></p>
                <p><strong>Номер паспорта:</strong> <span>${user.passportNumber}</span></p>
                <p><strong>Номер читательского билета:</strong> <span>${user.readerCardNumber}</span></p>
            </div>
        </div>

        <h2 class="mt-4">Взятые книги</h2>
        <div class="row mt-3">
            <#if borrowedBooks?has_content>
                <#list borrowedBooks as book>
                    <div class="col-md-4 mb-4">
                        <div class="card h-100">
                            <img src="${book.image}" alt="${book.title}" class="card-img-top" style="height: 600px; object-fit: cover;">
                            <div class="card-body d-flex flex-column">
                                <h5 class="card-title">${book.title}</h5>
                                <h6 class="card-subtitle mb-2 text-muted">Автор: ${book.author}</h6>
                                <form action="/returnBook/${book.id}" method="post">
                                    <#if _csrf??>
                                        <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                                               value="${(_csrf.token)!'csrf-token'}"/>
                                    </#if>
                                    <button type="submit" class="btn btn-danger">Вернуть книгу</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </#list>
            <#else>
                <p>У вас нет взятых книг.</p>
            </#if>
        </div>
    </div>
    </body>
</@profile.layout>
