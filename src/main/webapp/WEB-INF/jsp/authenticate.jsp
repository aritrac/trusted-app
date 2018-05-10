<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Partner Application</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
<br/>
    <center>
        <h1>Partner Application</h1>
        <br/><br/>
        <p>Please scan the below QR code</p>
        <br/>
        <p>
            <img src="data:image/png;base64,${qr}">
        </p>
    </center>
</div>
<form method="post" action="userinfo" id="userinfoForm">
    <input type="hidden" name="txId" value="${txId}" />
</form>
</body>
<script>
    $(document).ready(function() {
        poll();
    });
    function poll() {
        $.ajax({
            url: "/verified?txId=${txId}",
            success: function(result) {
                console.log(result);
                var jsonObj = JSON.parse(result);
                if(jsonObj.status == true) {
                    $("#userinfoForm").submit();
                } else {
                    setTimeout(poll, 3000);
                }
            }
        });
    }
</script>
</html>