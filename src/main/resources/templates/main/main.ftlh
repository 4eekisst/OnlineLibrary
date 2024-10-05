<#import "../layout.ftlh" as main>
<@main.layout ; spring>
    <body>
    <div class="container mt-4">
        <h1 class="text-center">Книги</h1>
        <form method="get" action="/books">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                       value="${(_csrf.token)!'csrf-token'}"/>
            </#if>
            <div class="form-group">
                <label for="categorySelect">Выберите категорию:</label>
                <select class="form-control" id="categorySelect" name="categoryId">
                    <option value="">Все категории</option>
                    <#list categories as category>
                        <option value="${category.id}">${category.name}</option>
                    </#list>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Фильтровать</button>
        </form>
        <div class="row mt-4">
            <#list books as book>
                <div class="col-md-4">
                    <div class="card mb-4">
                        <div class="card-body">
                            <h5 class="card-title">${book.title}</h5>
                            <h6 class="card-subtitle mb-2 text-muted">${book.author}</h6>
                            <#if book.category??>
                                <p class="card-text">Категория: ${book.category.name}</p>
                            </#if>
                            <a href="#" class="btn btn-primary">Подробнее</a>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
    </body>
</@main.layout>