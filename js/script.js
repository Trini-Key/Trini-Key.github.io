var output = document.getElementById('output');

function submitData(fdata){
    console.log(fdata);
    return false;
}

//AJAX
var ajaxhttp = new XMLHttpRequest();
var url = "json.php";

ajaxhttp.open("GET", url, true);
ajaxhttp.setRequestHeader("content-type", "application/json");
output.innerHTML = "Loading...";
ajaxhttp.onreadstatechange = function(){
    output.innerHTML = "";
}