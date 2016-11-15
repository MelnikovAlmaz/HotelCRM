<html>
<body>
<div class="container">
    <div class="row">
        <main class="col-lg-7">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span>New Hotel</span>
                </div>
                <div class="panel-body">
                    <form method="post" action="/file" enctype="multipart/form-data">

                        <label for="file">Hotel Image</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="file" name="file">
                        </div>
                        <input type="submit" class="btn btn-success" value="Save">
                    </form>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>