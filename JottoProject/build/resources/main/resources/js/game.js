function validate_word_r(word){
    $("#error").fadeOut(1);

    var validality = false;
    var status = 0;
    var cpuWord;
    var userCount = 0;
    var cpuCount = 0;
    if(word.length!=5){
        return false;
    }

    $.ajax({
        url: "game.html/word",
        type: "post",
        async: false,
        data: {word: word,gameId:$.cookie('gameId')},
        dataType:"json",
        success: function (data) {
            validality = data.check;
            status = data.status;
            cpuWord = data.cpuGuess;
            userCount = data.userCount;
            cpuCount = data.cpuCount;
            console.log("status="+status);
        }
    });

    if(validality){
        //request database and update table
        if(status ==1){//user win
            //show user win
            $("#win").fadeIn(500);
            $("#newGameBtn").fadeIn(500);
            $("#guess_word").fadeOut(500);
            $("#submitfield").fadeOut(500);
            $("#enterYourGuess").fadeOut(500);

        }else if(status ==2){//computer win
            //show computer win
            $("#lose").fadeIn(500);
            $("#newGameBtn").fadeIn(500);
            $("#guess_word").fadeOut(500);
            $("#submitfield").fadeOut(500);
            $("#enterYourGuess").fadeOut(500);
        }
        var alpaHelper = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
        var secret_word = $.cookie("word");
        var letters= new Array();
        var userletters = new Array();
        for(var i=0;i<5;i++){
            if($.inArray(secret_word[i],letters)==-1){
                letters.push(secret_word[i]);
            }
        }

        for(var i=0;i<26;i++){
            if($.cookie(alpaHelper[i])%3==1){
                userletters.push(alpaHelper[i]);
            }
        }




        var tabl = document.getElementById("tbu");
        var row = document.createElement('tr');
        var cell = document.createElement('td');
        row.appendChild(cell);
        cell = document.createElement('td');
        var wordToRender = word;

        for(var i=0;i<wordToRender.length;i++){
            var lett = document.createElement('span');
            lett.appendChild(document.createTextNode(wordToRender[i]));
            if($.inArray(wordToRender[i].toLowerCase(),userletters)!=-1 || $.inArray(wordToRender[i].toUpperCase(),userletters)!=-1){
                lett.setAttribute("style","color:#00FF00;");
            }else{
                lett.setAttribute("style","color:#FFFFFF;");
            }

            cell.appendChild(lett);
        }

        row.appendChild(cell);
        cell = document.createElement('td');
        cell.appendChild(document.createTextNode(userCount));
        row.appendChild(cell);
        tabl.appendChild(row);

        tabl = document.getElementById("tbc");
        row = document.createElement('tr');
        cell = document.createElement('td');
        row.appendChild(cell);
        cell = document.createElement('td');
        var wordToRender = cpuWord;

        for(var i=0;i<wordToRender.length;i++){
            var lett = document.createElement('span');
            lett.appendChild(document.createTextNode(wordToRender[i]));
            if($.inArray(wordToRender[i].toLowerCase(),letters)!=-1 || $.inArray(wordToRender[i].toUpperCase(),letters)!=-1){
                lett.setAttribute("style","color:#00FF00;");
            }else{
                lett.setAttribute("style","color:#FFFFFF;");
            }

            cell.appendChild(lett);
        }

        row.appendChild(cell);
        cell = document.createElement('td');
        cell.appendChild(document.createTextNode(cpuCount));
        row.appendChild(cell);
        tabl.appendChild(row);

        return validality;
    }else{
        return false;
    }

}