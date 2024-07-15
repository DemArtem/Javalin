<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
<form id="form-new" action="/persons" method="post">
    <label for="id">Id:</label>
    <input type="text" id="id" name="id"><br>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name"><br>
    <label for="surname">Surname:</label>
    <input type="text" id="surname" name="surname"><br>
</form>
<a href="#" onclick="document.getElementById('form-new').submit();">Create person</a>
<ul>
<#list persons as person>
    <li>${person.name} ${person.surname}
    <form id="form-delete-${person.id}" action="/persons/delete/${person.id}" method="post">
        <a href="#" onclick="document.getElementById('form-delete-${person.id}').submit();">Delete</a>
    </form>

<a href="#" onclick="document.getElementById('form-update-${person.id}').style.display='';">Update</a>
    <form id="form-update-${person.id}" action="/persons/update/${person.id}" method="post" style="display:none">
        <label for="id">Id:</label>
        <input type="text" id="id" name="id" value="${person.id}"><br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"  value="${person.name}"><br>
        <label for="surname">Surname:</label>
        <input type="text" id="surname" name="surname" value="${person.surname}"><br>
        <a href="#" onclick="document.getElementById('form-update-${person.id}').submit();">Update</a>
    </form>

    </li>
</#list>
</ul>
</body>
</html>