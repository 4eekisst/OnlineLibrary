<#import "../layout.ftlh" as profile>
<@profile.layout ; spring>
    <body>
    <div class="container mt-4">
        <#if isAdmin>
            <h1 class="text-center">Административная панель</h1>
        <#else>
            <h1 class="text-center">Профиль пользователя</h1>
        </#if>

        <div class="card mb-4">
            <div class="card-body">
                <h5 class="card-title">Личная информация</h5>
                <p><strong>Имя:</strong> <span>${user.name}</span></p>
                <p><strong>Фамилия:</strong> <span>${user.surname}</span></p>
                <p><strong>Отчество:</strong> <span>${user.patronymic}</span></p>
                <p><strong>Адрес:</strong> <span>${user.address}</span></p>
                <p><strong>Номер паспорта:</strong> <span>${user.passportNumber}</span></p>
                <p><strong>Номер читательского билета:</strong> <span>${user.readerCardNumber}</span></p>
            </div>
        </div>

        <#if isAdmin>
            <h2 class="mt-4">Список пользователей</h2>
            <#if allUsers?has_content>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Имя</th>
                            <th>Фамилия</th>
                            <th>Читательский билет</th>
                            <th>Взятые книги</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list allUsers as user>
                            <tr>
                                <td>${user.name}</td>
                                <td>${user.surname}</td>
                                <td>${user.readerCardNumber}</td>
                                <td>
                                    <#assign borrowedBooks = borrowedBooksMap[user.readerCardNumber]>
                                    <#if borrowedBooks?has_content>
                                        <ul class="list-unstyled">
                                            <#list borrowedBooks as book>
                                                <li>${book.title} (Автор: ${book.author})</li>
                                            </#list>
                                        </ul>
                                    <#else>
                                        <span class="text-muted">Нет взятых книг</span>
                                    </#if>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            <#else>
                <p class="text-muted">Нет пользователей.</p>
            </#if>
        <#else>
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
                                        <button type="submit" class="btn btn-danger mt-auto">Вернуть книгу</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </#list>
                <#else>
                    <p class="text-muted">У вас нет взятых книг.</p>
                </#if>
            </div>
        </#if>
    </div>
    </body>
</@profile.layout>
