<html>
<head>
<#include "../head.ftl">
</head>
<body>
<#include "../navBar.ftl">
<div class="container">
    <div class="row">
        <main class="col-lg-offset-4 col-lg-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span>Login</span>
                </div>
                <div class="panel-body">
                    <form method="post" action="/j_spring_security_check">
                        <label for="phoneNumber">Phone Number</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="tel" class="form-control" name="phoneNumber" placeholder="Phone Number">
                        </div>
                        <label for="address">Password</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="password" class="form-control" name="password" placeholder="Password">
                        </div>
                        <input type="submit" class="btn btn-success" value="SignIn">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>