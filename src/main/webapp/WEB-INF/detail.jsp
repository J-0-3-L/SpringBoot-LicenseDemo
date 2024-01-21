<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>
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
    <div class="container">
        <div class="row justify-content-center">
          <div class="col-sm-4">
            <div class="card mt-5">
              <div class="card-body">
                <p><strong>Nombre:</strong> ${license.person.firstName} ${license.person.lastName}</p>
                <p><strong>Numero de licencia:</strong> ${license.number}</p>
                <p><strong>Estado:</strong> ${license.state}</p>
                <p><strong>Fecha de expiracion:</strong> ${license.expirationDate}</p>
              </div>
            </div>
          </div>
        </div>
    </div>
</body>
</html>