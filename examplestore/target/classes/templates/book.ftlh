<!DOCTYPE html>
<html>
<head>
    <title>Список книг</title>
</head>
<body>
<h2>Добавить новую книгу</h2>
<form action="/book/add" method="post">
    <input type="text"  name="title" placeholder="Название книги"/><br><br>
    <input type="text"  name="author" placeholder="Автор"/><br><br>
    <input type="number"  name="page" placeholder="Количество страниц"/><br><br>
    <input type="number"  name="price" placeholder="Цена"/><br><br>
    <input type="submit" value="Добавить книгу"/>
</form>
<h4>Список книг</h4><hr>
<table>
    <tr>
        <th>Id</th>
        <th>Название книги</th>
        <th>Автор</th>
        <th>Количество страниц</th>
        <th>Цена</th>
        <th>Редактирование</th>
        <th>Удаление</th>
    </tr>

    <#list books as book>
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.page}</td>
            <td>${book.price}</td>
            <td><a href="/book/${book.id}/edit" class="btn btn-warning">Редактировать</a></td>
            <td>
                <form action="/book/delete/${book.id}" method="post">
                    <input type="submit" value="Удалить товар"/>
                </form>
            </td>
        </tr>
    <#else>
        <h3>Книга не найдена</h3
    </#list>
</table>

</body>
</html>