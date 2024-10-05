<#import "../layout.ftlh" as category>
<@category.layout ; spring>

    <body>
    <div class="container mt-5">
        <h1 class="text-center">Добавить новую категорию</h1>

        <table class="table table-bordered mt-4">
            <thead class="thead-dark">
            <tr>
                <th>Название</th>
                <th>Описание</th>
                <th>Действия</th>
            </tr>
            </thead>
            <tbody>
            <#if categories?? && categories?has_content>
                <#list categories as cat>
                    <tr>
                        <td>${cat.name}</td>
                        <td>${cat.description}</td>
                        <td>
                            <form action="/admin/deleteCategory/${cat.id}" method="post" style="display: inline;">
                                <#if _csrf??>
                                    <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                                           value="${(_csrf.token)!'csrf-token'}"/>
                                </#if>
                                <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Вы уверены, что хотите удалить эту категорию?');">Удалить</button>
                            </form>
                        </td>
                    </tr>
                </#list>
            <#else>
                <tr>
                    <td colspan="3" class="text-center">Нет существующих категорий.</td>
                </tr>
            </#if>
            </tbody>
        </table>

        <form action="/admin/addCategory" method="post" class="mt-4">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                       value="${(_csrf.token)!'csrf-token'}"/>
            </#if>

            <div class="form-group">
                <label for="name">Название:</label>
                <input type="text" id="name" name="name" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="description">Описание:</label>
                <textarea id="description" name="description" class="form-control" rows="3"></textarea>
            </div>

            <button type="submit" class="btn btn-primary">Добавить категорию</button>
        </form>
        <div class="text-center mt-4">
            <a href="/profile" class="btn btn-secondary">Вернуться в профиль</a>
        </div>
    </div>

    </body>

</@category.layout>
