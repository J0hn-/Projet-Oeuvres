<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Ajout d'un propriétaire</h1>
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
                            <form name="identification" method="post" action="oeuvre?action=insertion" role="form">
                                <div class="form-group">
                                    <label>Nom</label>
                                    <input name="nom" class="form-control">
                                    <p class="help-block">Nom du propriétaire</p>
                                </div>
                                <div class="form-group">
                                    <label>Prénom</label>
                                    <input name="prenom" class="form-control">
                                    <p class="help-block">Prénom du propriétaire</p>
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
