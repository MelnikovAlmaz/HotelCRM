<html>
<head>
<#include "../../head.ftl">
</head>
<body>
<#include "../../navBar.ftl">
<div class="container">
    <div class="row">
    <#include "../leftBar.ftl">
        <main class="col-lg-7">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span>Hotel</span>
                </div>
                <div class="panel-body">
                    <form method="post" action="/admin/dashboard/hotel/${hotel.id}/?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
                        <label for="name">Name</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="name" placeholder="Name"
                                   value="${hotel.name}">
                        </div>
                        <label for="phoneNumber">Phone Number</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="phoneNumber" placeholder="Phone Number"
                                   value="${hotel.phoneNumber}">
                        </div>
                        <div class="control-group ">
                            <label class="control-label" for="">City</label>
                            <div class="input-group input-margin">
                                <select class="form-control" size="1" name="city">
                                <#list cities as city>
                                    <option
                                        <#if hotel.city.id == city.id>selected</#if>
                                        value="${city.id}">${city.name}
                                    </option>
                                </#list>
                                </select>
                            </div>
                        </div>
                        <label for="address">Address</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="address" placeholder="Address"
                                   value="${hotel.address}">
                        </div>
                        <label for="description">Description</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <textarea class="form-control" name="description"
                                      placeholder="Description">${hotel.description}</textarea>
                        </div>
                        <label for="image">Hotel photo</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="file" class="form-control" name="image" placeholder="Image"
                                   <#if hotel.imageURL??>value="${hotel.imageURL}"</#if>/>
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