<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Ajout d'une oeuvre</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Veuillez saisir les données suivantes :
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                            <form name="identification" method="post" action="oeuvre?action=inserer" role="form">
                                <div class="form-group">
                                    <label>Titre</label>
                                    <input name="titre" class="form-control">
                                    <p class="help-block">Titre de l'oeuvre</p>
                                </div>
                                <div class="form-group">
                                    <label>État</label>
                                    <select name="etat" class="form-control">
                                        <option value="R">Réservée</option>
                                        <option value="L">Libre</option>
                                    </select>
                                    <p class="help-block">État de l'oeuvre</p>
                                </div>
                                <div class="form-group">
                                    <label>Prix</label>
                                    <input name="prix" class="form-control">
                                    <p class="help-block">Prix de l'oeuvre</p>
                                </div>
                                <div class="form-group">
                                    <label>Proprietaire</label>
                                    <select name="proprio" class="form-control">
                                        <c:forEach items="${proprios}" var="item">
                                            <option value="${item.idProprietaire}">${item.prenomProprietaire} ${item.nomProprietaire}</option>
                                        </c:forEach>
                                    </select>
                                    <p class="help-block">Proprietaire de l'oeuvre</p>
                                </div>
                                <button type="submit" class="btn btn-default">Ajouter</button>
                                <button type="reset" class="btn btn-default">Réinitialiser</button>
                            </form>
                        </div>
                    </div>
                    <!-- /.row (nested) -->
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
