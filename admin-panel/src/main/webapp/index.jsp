<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
    <head>
        <title>Tankmania - Admin Panel</title>

        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, shrink-to-fit=no" />

        <!-- CSS -->
        <link rel="stylesheet" href="./lib/bootstrap/css/bootstrap.min.css">
    </head>
    <body>
        <div id="menu" class="container">
            <button id="menu-assets" type="button" class="btn btn-secondary">Assets</button>
            <button id="menu-items" type="button" class="btn btn-secondary">Items</button>
            <button id="menu-players" type="button" class="btn btn-secondary">Players</button>
            <button id="menu-games" type="button" class="btn btn-secondary">Games</button>
        </div>

        <div id="body" class="container mt-3">&nbsp;</div>

        <div id="footer" class="container mt-3">&nbsp;</div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="./lib/jquery/js/jquery-3.3.1.min.js"></script>
        <script src="./lib/popper/js/popper.min.js"></script>
        <script src="./lib/bootstrap/js/bootstrap.min.js"></script>

        <!-- menu -->
        <script>
            $('#menu-assets').on('click',function(){
                $('#body').load('menu/assets.jsp');
            });
            $('#menu-items').on('click',function(){
                $('#body').load('menu/items.jsp');
            });
            $('#menu-players').on('click',function(){
                $('#body').load('menu/players.jsp');
            });
            $('#menu-games').on('click',function(){
                $('#body').load('menu/games.jsp');
            });
        </script>
    </body>
</html>