<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Liste des reservations</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Tableau des reservations
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="dataTable_wrapper">
                        <table class="table table-striped table-bordered table-hover" id="datas" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>Titre de l'oeuvre</th>
                                <th>Réservant</th>
                                <th>Statut</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Titre de l'oeuvre</th>
                                <th>Réservant</th>
                                <th>Statut</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${reservations}" var="item">
                                <tr>
                                    <td>${item.oeuvrevente.titreOeuvrevente}</td>
                                    <td>${item.adherent.prenomAdherent} ${item.adherent.nomAdherent}</td>
                                    <td>${item.statut}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
</div>
<!-- /#page-wrapper -->

<%@ include file="../footer.jsp" %>
