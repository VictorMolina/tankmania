<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
    <head>
        <title>Tankmania - Admin Panel</title>

        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, shrink-to-fit=no" />

        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />

        <link rel="stylesheet" href="./lib/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/loader.css">
    </head>
    <body>
        <div id="menu" class="container">
            <a href="assets.jsp" class="btn btn-secondary">Assets</a>
        </div>

        <div id="body" class="container mt-3">
            &nbsp;
        </div>

        <div id="footer" class="container mt-3">
            &nbsp;
        </div>

        <div id="loader" class="loader modal hide" data-backdrop="static" data-keyboard="false"></div>

        <script src="./lib/jquery/js/jquery-3.3.1.min.js"></script>
        <script src="./lib/popper/js/popper.min.js"></script>
        <script src="./lib/bootstrap/js/bootstrap.min.js"></script>
        <script>
            $("a").on("click", function (e) {
                $('#loader').modal();
                return true;
            });
        </script>
    </body>
</html>