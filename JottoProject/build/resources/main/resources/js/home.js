function logout(){
    $.cookie('username', null);
    document.location.href="./index.html";
}