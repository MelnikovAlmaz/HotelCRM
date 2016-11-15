<!-- Modal -->
<div class="modal fade" id="registry" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <form action="/guest/signUp" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Registration</h4>
                </div>
                <div class="modal-body">
                <#include "registryData.ftl">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Accept</button>
                </div>
            </div>
        </form>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="logging" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <form action="/guest/j_spring_security_check" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Logging in</h4>
                </div>
                <div class="modal-body">
                <#include "loggingData.ftl">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Accept</button>
                </div>
            </div>
        </form>
    </div>
</div>


<!-- Modal  Orders-->
<div class="modal fade" id="orders" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <form action="/guest/j_spring_security_check" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Orders</h4>
                </div>
                <div class="modal-body">
                    <#if myOrders??>
                        <#list myOrders as order>
                            <h3>Order № ${order.id}: </h3>
                            <h4>Begin date: ${order.getBeginDate()}</h4>
                            <h4>End date: ${order.getEndDate()}</h4>
                            <h4>Hotel: ${order.getRoom().getCategory().getHotel().getName()}</h4>
                            <h4>Room: ${order.getRoom().getCategory().getName()}</h4>
                            <br>
                            <h4>Price: ${order.getPrice()}</h4>

                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#order-edition">Edit</button>

                        </#list>
                    </#if>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Accept</button>
                </div>
            </div>
        </form>
    </div>
</div>


<!-- Modal  Account-->
<div class="modal fade" id="account" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <form action="/guest/j_spring_security_check" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">My account</h4>
                </div>
                <div class="modal-body">
                    <#if user??>
                    <h2>Name: ${user.getName()}</h2>
                    <h3>Telephone number: ${user.getPhoneNumber()}</h3>

                    </#if>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </form>
    </div>
</div>


<!-- Modal  Account-->
<div class="modal fade" id="order-edition" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <form action="/guest/j_spring_security_check" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">My account</h4>
                </div>
                <div class="modal-body">
                <#if user??>


                </#if>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </form>
    </div>
</div>