<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/admin">Admin Panel</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <#if user??>
                    <li><a href="/admin/dashboard"><span class="btn btn-default">${user.name}</span></a></li>
                    <li><a href="/j_spring_security_logout"><span class="btn btn-default">LogOut</span></a></li>
                <#else>
                    <li><a href="/admin/login"><span class="btn btn-default">LogIn</span></a></li>
                    <li><a href="/admin/signUp"><span class="btn btn-success">SignUp</span></a></li>
                </#if>
            </ul>
        </div>
    </div>
</nav>