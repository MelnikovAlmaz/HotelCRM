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
                    <span>Room</span>
                </div>
                <div class="panel-body">
                    <form method="post" action="/admin/entity/${hotel.id}/room/${room.id}">
                        <label for="number">Number</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="number" placeholder="Number"
                            value=${room.number}>
                        </div>
                        <label for="isCleaned">Cleaned</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="checkbox" class="form-control" name="isCleaned" value=${room.isCleaned}>
                        </div>
                        <label for="isAvailable">Available</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="checkbox" class="form-control" name="isAvailable" value=${room.isAvailable}>
                        </div>
                        <div class="control-group ">
                            <label class="control-label" for="">Room Category</label>
                            <div class="input-group input-margin">
                                <select class="form-control" size="1" name="category">
                                <#list categories as category>
                                    <option
                                        <#if room.category.id == category.id>selected</#if>
                                        value="${category.id}">${category.name}</option>
                                </#list>
                                </select>
                            </div>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="submit" class="btn btn-success" value="Save">
                    </form>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>