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
                        <div class="form-group">
                            <input type="checkbox" name="isCleaned"<#if room.cleaned>checked</#if>>
                        </div>
                        <label for="isAvailable">Available</label>
                        <div class="form-group">
                            <input type="checkbox" name="isAvailable" <#if room.available>checked</#if>>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="">Room Category</label>
                            <div class="form-group">
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
                    <div class="panel">
                        <div class="panel-heading">
                            <label class="control-label">Occupancy</label>
                        </div>
                        <div class="panel-body row">
                            <div class="col-xs-3">
                                <div class="form-group">
                                    <input type="date" class="form-control" id="beginDate"/>
                                </div>
                                <div class="form-group">
                                    <input type="date" class="form-control" id="endDate"/>
                                </div>
                                <input type="hidden" value="${room.id}" id="roomId"/>
                                <input type="button" class="btn btn-default" value="Refresh" onclick="room_occupancy()">
                            </div>
                            <div class="col-xs-1">
                                <h1><span class="label label-success" id="occupancy">0%</span></h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
<script src="/assets/js/roomOccupancy.js"></script>
</body>
</html>