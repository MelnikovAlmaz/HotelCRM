<html>
<head>
<#include "../head.ftl">
</head>
<body>
<#include "../navBar.ftl">
<div class="container">
    <div class="row">
    <#include "leftBar.ftl">
        <main class="col-lg-10">
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active">
                    <a href="#chart" aria-controls="chart" role="tab" data-toggle="tab">Chart</a>
                </li>
                <li role="presentation">
                    <a href="#table" aria-controls="table" role="tab" data-toggle="tab">Table</a>
                </li>
            </ul>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="chart">
                    <div class="row-fluid panel panel-default">
                        <div class="panel-heading">Month</div>
                        <div class="panel-body row">
                            <div class="col-lg-8">
                                <input class="form-control" type="month" name="monthAnalytic" id="monthAnalytic">
                                <button class=" form-control btn btn-default" id="monthBtn"
                                        onclick="renderMonthChart()">Обновить
                                </button>
                                <div>
                                    <canvas id="monthChart"></canvas>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <span class="badge">14</span>
                                        <span>Max</span>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="badge">14</span>
                                        <span>Min</span>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="badge">14</span>
                                        <span>Average</span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid panel panel-default">
                        <div class="panel-heading">Year</div>
                        <div class="panel-body row">
                            <div class="col-lg-8">
                                <input class="form-control" type="number" min="2000" name="yearAnalytic" id="yearAnalytic">
                                <button class="form-control btn btn-default" id="yearBtn" onclick="renderYearChart()">
                                    Обновить
                                </button>
                                <canvas id="yearChart"></canvas>
                            </div>
                            <div class="col-lg-4">
                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <span class="badge">14</span>
                                        <span>Max</span>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="badge">14</span>
                                        <span>Min</span>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="badge">14</span>
                                        <span>Average</span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="table">
                    <div class="row-fluid panel panel-default">
                        <div class="panel-heading">Year</div>
                        <div class="panel-body row">
                            <div class="col-lg-12">
                                <input class="form-control" type="number" min="2000" id="yearAnalyticTable">
                                <button class="form-control btn btn-default">Обновить</button>
                                <div>
                                    <table class="table table-responsive table-bordered table-striped" id="monthTable1">
                                    </table>
                                    <table class="table table-responsive table-bordered table-striped" id="monthTable2">
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.0.1/Chart.min.js"></script>
<script src="/assets/js/analyticCharts.js"></script>
<script src="/assets/js/analyticMain.js"></script>
</body>
</html>