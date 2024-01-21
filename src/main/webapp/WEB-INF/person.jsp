<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Person</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/' />">Inicio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/dashboard' />">Dashboard</a>
            </li>
        </ul>
    </nav>
    <div class="container mt-4">
        <div class="row justify-content-center">
            <div class="col-sm-4">
                <div class="card border rounded shadow">
                    <div class="card-body">
                        <form action="<c:url value='/person/new' />" method="post">
                            <div class="form-group">
                                <label for="firstname">FirstName:</label>
                                <input type="text" name="firstName" value="${person.firstName}" class="form-control" minlength="3" required>
                            </div>
                            <div class="form-group">
                                <label for="lastname">LastName:</label>
                                <input type="text" name="lastName" value="${person.lastName}" class="form-control" minlength="4" required>   
                            </div>
                            <button type="submit" class="btn btn-primary">CREATE</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>