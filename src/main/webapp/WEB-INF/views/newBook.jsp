<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Book</title>
</head>
<body>
<h1>Create a New Book</h1>
<form action="addBook">
    <div>
        <label for="bookId">id:</label>
        <input type="text" id="bookId" name="bookId" required>
    </div>
    <div>
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>
    </div>
    <div>
        <label for="authorName">Author:</label>
        <input type="text" id="authorName" name="authorName" required>
    </div>
    <div>
        <label for="isbn">ISBN:</label>
        <input type="text" id="isbn" name="isbn" required>
    </div>
    <div>
        <button type="submit" onClick>Create Book</button>
    </div>
</form>
</body>
</html>
