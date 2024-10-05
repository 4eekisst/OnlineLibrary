<#import "../layout.ftlh" as addBook>
<@addBook.layout ; spring>

    <body>
    <div class="container mt-4">
        <h1 class="text-center">Добавить книгу</h1>
        <form action="/admin/addBook" method="post" enctype="multipart/form-data">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                       value="${(_csrf.token)!'csrf-token'}"/>
            </#if>
            <div class="mb-3">
                <label for="title" class="form-label">Название книги</label>
                <input type="text" class="form-control" id="title" name="title" required>
            </div>
            <div class="mb-3">
                <label for="author" class="form-label">Автор книги</label>
                <input type="text" class="form-control" id="author" name="author" required>
            </div>
            <div class="mb-3">
                <label for="categoryId" class="form-label">Категория</label>
                <select class="form-select" id="categoryId" name="categoryId" required>
                    <#list categories as category>
                        <option value="${category.id}">${category.name}</option>
                    </#list>
                </select>
            </div>
            <div class="mb-3">
                <label for="image" class="form-label">Изображение книги</label>
                <input type="file" class="form-control" id="image" name="image">
            </div>
            <button type="submit" class="btn btn-primary">Добавить книгу</button>
        </form>
        <a href="/admin/addCategory" class="btn btn-secondary mt-3">Назад</a>
    </div>
    </body>

</@addBook.layout>