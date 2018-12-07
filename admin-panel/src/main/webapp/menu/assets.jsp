<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.tankmania.adminpanel.TankManiaServices" %>

<form>
    <div class="form-group">
        <label for="assets">Current assets</label>
        <textarea class="form-control" id="assets" rows="24"><% out.println(TankManiaServices.getAssets()); %></textarea>
    </div>
    <button type="button" class="btn btn-primary">Save</button>
</form>