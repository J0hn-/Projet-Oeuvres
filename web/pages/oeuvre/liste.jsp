<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Liste des oeuvres</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Tableau des oeuvres
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="dataTable_wrapper">
                        <table class="table table-striped table-bordered table-hover" id="datas" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>Numéro</th>
                                <th>Titre</th>
                                <th>Prix</th>
                                <th>Propriétaire</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Numéro</th>
                                <th>Titre</th>
                                <th>Prix</th>
                                <th>Propriétaire</th>
                                <th>Actions</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach items="${mesOeuvres}" var="item">
                                <tr>
                                    <td>${item.idOeuvrevente}</td>
                                    <td>${item.titreOeuvrevente}</td>
                                    <td>${item.prixOeuvrevente}</td>
                                    <td>${item.proprietaire.nomProprietaire} ${item.proprietaire.prenomProprietaire}</td>
                                    <td>
                                        <a href="oeuvre?action=modif&oeuvre=${item.idOeuvrevente}"><i class="fa fa-edit"></i></a>
                                        <c:if test="${item.etatOeuvrevente == 'L'}">
                                            <a href="reservation?action=resume&oeuvre=${item.idOeuvrevente}"><i class="fa fa-cc-visa"></i></a>
                                        </c:if>
                                    </td>
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
