<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="page-wrapper">
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                Résumé de l'oeuvre
            </div>
            <div class="panel-body">
                <div class="page-information"><b>Numéro : </b>${oeuvre.idOeuvrevente}<br/>
                    <b>Titre : </b>${oeuvre.titreOeuvrevente}<br/>
                    <b>Prix : </b>${oeuvre.prixOeuvrevente}</div>
                <!-- /.panel-body -->
            </div>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="col-lg-6">
                    <h2>Reservation</h2>
                    <form name="reservation" method="post" action="reservation?action=reserver&oeuvre=${oeuvre.idOeuvrevente}" role="form">
                        <div class="form-group">
                            <label for="adherent">
                                Réserver au nom de :
                            </label>

                                <select name="adherent" id="adherent" class="form-control" name="adherent">
                                    <c:forEach items="${adherents}" var="item">
                                        <option value="${item.getIdAdherent()}">${item.getPrenomAdherent()} ${item.getNomAdherent()}</option>
                                    </c:forEach>
                                </select>
                            </div>

                        <button type="submit" class="btn btn-default">Reserver</button
                    </form>
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
