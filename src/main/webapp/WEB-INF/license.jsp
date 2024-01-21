<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New License</title>
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
                        <form action="<c:url value='/license/new' />" method="post">
                            <div class="form-group">
                                <label for="person">Person:</label>
                                <select name="person_id" class="form-control" required>
                                    <c:forEach items="${persons}" var="person">
                                        <option value="${person.id}">${person.firstName} ${person.lastName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="state">State:</label>
                                <input type="text" name="state" value="${license.state}" class="form-control" minlength="2" maxlength="2" required>   
                            </div>
                            <div class="form-group">
                                <label for="expirationDate">ExpirationDate:</label>
                                <input type="date" name="expirationDate" value="${license.expirationDate}" class="form-control" required>   
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