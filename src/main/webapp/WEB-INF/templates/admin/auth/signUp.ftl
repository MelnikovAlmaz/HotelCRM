<html>
<head>
<#include "../head.ftl">
</head>
<body>
<#include "../navBar.ftl">
<div class="container">
    <div class="row">
        <main class="col-lg-offset-2 col-lg-7">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span>Registration</span>
                </div>
                <div class="panel-body">
                    <form method="post" action="/admin/signUp">
                        <label for="name">Name</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="name" placeholder="Name">
                        </div>
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
                        <label for="address">Confirm Password</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="password" class="form-control" name="confirm_password" placeholder="Confirm Password">
                        </div>
                        <input type="submit" class="btn btn-success" value="Sign Up">
                    </form>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>