<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Résumé de l'oeuvre</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <h3>Numéro</h3>
                <h4>${oeuvre.idOeuvrevente}</h4>
                <h3>Titre</h3>
                <h4>${oeuvre.titreOeuvrevente}</h4>
                <h3>Prix</h3>
                <h4>${oeuvre.prixOeuvrevente}</h4>
                <!-- /.panel-body -->
            </div>
            <div class="panel panel-default">
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
                    <button type="submit" class="btn btn-default">Reserver</button>
                </form>
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
