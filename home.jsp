<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Assignment 6</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <center>
        <h3> Mortgage Calculator </h3>
        
    <table border="3" width="800" height="400">
    <tr>
        
        <td width="400">
    <center>
            <form action="/Assigment6/Calculator" method="post" onsubmit="return checkNum()">
            <input type="hidden" name="select" value="Calculator"/>
            Enter Principal Amount: <input type="text" id="num" name="num">
            <br/>   
            Enter Interest Rate:    <input type="text" id="rate" name="rate">
            <br/>
            Enter Monthly Payment:<input type="text" id="monpay" name="monpay">
            <br/>
            <input type ="submit" name="submit" value="Submit"/>
            <br/>
        </form>
        <br/>
        <button onclick="setzero()">CLEAR</button>
        <br/>
        <form action="/Assigment6/Calculator" method="post">
            <input type="hidden" name="select" value="clearall"/>
            <input type ="submit" name="clearall" value="CLEAR ALL"/>
        </form>
        <br/>
        <br/>
        ***************************************
        <h4>${requestScope.out1}</h4>
        <h4>${requestScope.out2}</h4>
        
    </center>
        </td>
        <td width="500">
            <h4>${requestScope.OutputStr}</h4>
        </td>
        
    </tr>
    </table>
        
        
    </center>
</body>
<script>
    function setzero() {
        document.getElementById("num").value = 0.0;
        document.getElementById("rate").value = 0.0;
        document.getElementById("monpay").value = 0.0;
    }
    
    function checkNum()
    {
        var num = document.getElementById("num").value;
        var rate = document.getElementById("rate").value;
        var monpay = document.getElementById("monpay").value;
        if(isNaN(num) || isNaN(rate)|| isNaN(monpay)){
            alert("Please enter number");
            if (isNaN(num) ){
                document.getElementById("num").value = 0.0;
            }
            if (isNaN(rate) ){
                document.getElementById("rate").value = 0.0;
            }            
            if (isNaN(monpay) ){
                document.getElementById("monpay").value = 0.0;
            }
               
            
            return false;
        }
        else{
            return true;
        }
    }
</script>    
</html>
