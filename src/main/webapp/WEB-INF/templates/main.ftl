<html>
<head>
<#include "head.ftl">
</head>
<body class="body-image">

<#include "main-header.ftl">



<div class="main-insides" id="ins">
<div class="header-form-area col-lg-offset-2 col-lg-8">
    <h1>Hotel world</h1>
    <nav class="navbar navbar-default">
        <div class="container-fluid">



            <form action="/search" method="post" class="navbar-form navbar-left">

                    <div class="form-group" style="margin-right: 10px;">
                        <input type="text" class="form-control" id="search" list="hotelNames" name="name" placeholder="City">
                    </div>


                    <div class="form-group" style="margin-right: 10px;">
                        <input type="date" class="form-control" placeholder="Begin date" id="begin-date" name="beginDate"/>
                    </div>


                    <div class="form-group" style="margin-right: 10px;">
                        <input type="date" class="form-control" placeholder="End date" id="end-date" name="endDate"/>
                    </div>


                    <div class="form-group" style="margin-right: 10px;">
                        <input type="number" step="1" class="form-control" name="guestNumber" style="width: 100px"
                               placeholder="Guests" min="1" value="1">
                    </div>
                    <button type="submit" class="btn btn-success">Search</button>

            </form>


        </div>
    </nav>
</div>




</div>
<div id="fade" class="black-overlay"></div>

</body>
</html>
