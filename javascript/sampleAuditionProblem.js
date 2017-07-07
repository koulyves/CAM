function playButton(){
    validateForm();
    run();
    return false;
}

function run(){
    var x = parseInt(document.getElementById("startingNum").value);
    var y = parseInt(document.getElementById("endingNum").value);
    var z = parseInt(document.getElementById("step").value);
    document.getElementById("startNum").innerHTML = x;
    document.getElementById("endNum").innerHTML = y;
    document.getElementById("stepNum").innerHTML = z;
    var evenNum = [];
    while (x < y){    
        if (x%2 == 0){
            evenNum.push(x);
        }        
        x += z;  
    }
    for (var i = 0; i<evenNum.length; i++){
      document.getElementById("result").innerHTML += "<p>" + evenNum[i] + "</p>";  
    }
    

}

function validateForm() {
    var num1 = document.forms["myForm"]["startingNum"].value;
    var num2 = document.forms["myForm"]["endingNum"].value;
    var num3 = document.forms["myForm"]["step"].value;

    if (num1 == "" || isNaN(num1) || num1<=0) {
        alert("Starting Number must be filled in with a positive number.");
        document.forms["myForm"]["num1"]
           .parentElement.className = "form-group has-error";
        document.forms["myForm"]["num1"].focus();
        return false;
    }
   if (num2 == "" || isNaN(num2) || num2<=0) {
       alert("Ending Number must be filled in with a positive number.");
        document.forms["myForm"]["num2"]
           .parentElement.className = "form-group has-error";
        document.forms["myForm"]["num2"].focus();
       return false;
   }
   if (num3 == "" || isNaN(num3) || num3<=0) {
       alert("Step Number must be filled in with a positive number.");
        document.forms["myForm"]["num3"]
           .parentElement.className = "form-group has-error";
        document.forms["myForm"]["num3"].focus();
       return false;
   }
   if (num2>=num1){
       alert("Ending Number cannot be less than or equal to Starting Number.");
    }

}