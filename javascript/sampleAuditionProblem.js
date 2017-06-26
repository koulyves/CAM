function playButton(){
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