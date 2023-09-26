<?php
include('connection.php');
$username = $_POST['username'];
$email = $_POST['email'];
$password = $_POST['password'];
$confirmPassword = $_POST['confirmPassword'];

if(!empty($username) || !empty($email) || !empty($password) || !empty($confirmPassword)){

    if(mysqli_connect_error()){
        die('Connect Error ('.mysqli_connect_errno().')'.mysqli_connect_error());
    }
    else{
        $select = "Select email From signup Where email = ? Limit 1";
        $insert = "Insert Into signup(username,email,password,confirmPassword)
                    Values(?,?,?,?)";

        // prepare statement
        $stmt = $conn->prepare($select);
        $stmt->bind_param("s",$email);
        $stmt->execute();
        $stmt->bind_result($email);
        $stmt->store_result();
        $rnum = $stmt->num_rows;

        //checking username
        if($rnum==0){
            $stmt->close();
            $stmt = $conn->prepare($insert);
            $stmt->bind_param("ssss",$username,$email,$password,$confirmPassword);
            $stmt->execute();
            echo "Account Successfully Created";
            $insertLog = "Insert Into login(email,password) Values($email,$password)";
            $stmt = $conn->($insertLog);
            $stmt->execute();
        }
        else{
            echo "Account Already Exists"; 
        }
        $stmt->close();
        $conn->close();
    }
   
}
else{
    echo "All Fields are Required";
    die();
}
?>