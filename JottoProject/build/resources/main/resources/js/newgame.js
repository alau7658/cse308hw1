function validate_word(word){
    if(word.length!=5){
        return false;
    }
    var letters= new Array();
    var counter= 0;
    var validality = false;
    var gameId = -1;
    for(var i=0;i<word.length;i++){
        if($.inArray(word[i],letters)==-1){
            letters.push(word[i]);
            counter+=1;
        }
    }
    if(counter==5) {
        $.ajax({
            url: "newgame.html/word",
            type: "post",
            async: false,
            data: {username:$.cookie('username'),word: word},
            dataType:"json",
            success: function (data) {
                validality = data.check;
                gameId = data.game_id;
            }
        });
        $.cookie('gameId',gameId);
        console.log(validality);
        return validality;
    }else{
        return false;
    }

}




// if(counter==5) {
//     $.ajax({
//         url: "newgame.html/word",
//         type: "post",
//         async: false,
//         data: {word: word},
//         dataType:"json",
//         success: function (data) {
//             console.log(data.name);
//             validality = data;
//         }
//     });
//     return validality;
// }else{
//     return false;
// }