<form action="/search" method="post" class="navbar-form navbar-left">
    <div class="form-group">
        <input type="text" class="form-control" id="search" list="hotelNames" name="name" placeholder="Search">
    </div>
    <div class="form-group">
        <input type="date" class="form-control" placeholder="Begin date" id="begin-date" name="beginDate">
    </div>
    <div class="form-group">
        <input type="date" class="form-control" placeholder="End date" id="end-date" name="endDate">
    </div>
    <div class="form-group">
        <input type="number" step="1" class="form-control" name="guestNumber" style="width: 100px"
               placeholder="Guests">
    </div>
    <button type="submit" class="btn btn-success">Search</button>
</form>