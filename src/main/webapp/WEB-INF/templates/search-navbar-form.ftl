<form action="/search" method="post" class="navbar-form">

    <div style="display:-moz-box;
    -moz-box-pack:center;
    -moz-box-align:center;

    /* Safari and Chrome */
    display:-webkit-box;
    -webkit-box-pack:center;
    -webkit-box-align:center;

    /* W3C */
    display:box;
    box-pack:center;
    box-align:center;">

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

    </div>

</form>