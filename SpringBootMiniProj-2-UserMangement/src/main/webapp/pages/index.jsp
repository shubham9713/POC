 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  

<title> Login Page </title>
 
 <script src="https://www.google.com/recaptcha/api.js" async defer></script>
   
<style>   
Body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: pink;  
}  
button {   
       background-color: #4CAF50;   
       width: 100%;  
        color: orange;   
        padding: 15px;   
        margin: 10px 0px;   
        border: none;   
        cursor: pointer;   
         }   
 form {   
        border: 3px solid #f1f1f1;   
    }   
 input[type=text], input[type=password] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;   
    }  
 button:hover {   
        opacity: 0.7;   
    }   
  .cancelbtn {   
        width: auto;   
        padding: 10px 18px;  
        margin: 10px 5px;  
    }   
        
     
 .container {   
        padding: 25px;   
        background-color: lightblue;  
    }   
</style>   
</head>    
<body>    
    <center> <h1> SignIn Here </h1> </center>   
    <form action="login" method="post"> 
    <font color='red'>${fail}</font>  
        <div class="container">  
       
            <label>Email : </label>   
            <input type="text" placeholder="Enter Email" name="email"  required>  
            <label>Password : </label>   
            <input type="password" placeholder="Enter Password" name="pwd"  required> 
            <div>
            <div class="g-recaptcha" data-sitekey="6Lfr89kZAAAAAAWyjWoDWpe5C0Md0NY7M_AjCzzQ"></div>
            </div> 
            <br>
             <button type="submit">Login</button> 
           
            <button type="button" class="cancelbtn"> Cancel</button>   
            Forgot <a href="forgotPwd" > password? </a> <a href="register" style="margin: 20px">Sign-Up</a>   
        </div>   
    </form>     
</body>  
</html>