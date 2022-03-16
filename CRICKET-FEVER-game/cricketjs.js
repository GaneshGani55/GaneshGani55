var start=document.querySelector("#start");
start.addEventListener("click",startcricket);
var balls=document.querySelector("#balls");
var Botscore=document.querySelector("#Botscore");
var yourscore=document.querySelector("#yourscore");
var count1=1;var count2=1;
var runs1=0;var runs2=0;
var c=0;


function startcricket(){
    var overs=document.querySelector("#overs").value;
    var radios = document.getElementsByName('Toss');
    for (var i = 0, length = radios.length; i < length; i++) {
      if (radios[i].checked) {
        window.bb=radios[i].value;
        break;
       }
    }
    var borb=document.querySelector("#borb");
    borb.textContent=bb + " "+"First";
    var totalovers=overs;  
    window.bbcount=(totalovers*6)*2;
    var ofballs=document.querySelector("#ofballs");
    ofballs.textContent=bbcount/2; 
}
function myFunction(val) {
    if (bb==='Batting'){
        c+=1;
        if(c<=bbcount/2){
            if (batting(val)==="o"){
                c=(bbcount/2)+1;
                alert("you are out!!");
                yourscore.textContent=runs1;
                balls.textContent=count2;
                borb.textContent="Bowling Now"

            }else{
                yourscore.textContent=runs1;
            }           
        }
        else if((c>(bbcount/2)&&c<=(2*(bbcount/2)))){
            borb.textContent="Bowling Now"
            if (bowling(val)==="o"){
                alert(" Wicket!!");
                c=(2*(bbcount/2))+1;
                Botscore.textContent=runs2;
                result(runs1,runs2,'batting');
            }else{
                if(runs2>runs1){
                    result(runs1,runs2,'batting');  
                }else{
                    Botscore.textContent=runs2;
                }
                
            }
        }
        else{
            result(runs1,runs2,'batting');
        }                  
    }

    else{
        c+=1;
        if(c<=bbcount/2){
            if (bowling(val)==="o"){
                alert(" Wicket!!");
                c=(bbcount/2)+1;
                borb.textContent="Batting Now"
                balls.textContent=count1;
                Botscore.textContent=runs2;
            }else{
                Botscore.textContent=runs2;
            }           
        }
        else if((c>(bbcount/2)&&c<=(2*(bbcount/2)))){
            borb.textContent="Batting Now"
            if (batting(val)==="o"){
                alert("you are out!!");
                c=(2*(bbcount/2))+1;
                yourscore.textContent=runs1;
                result(runs1,runs2,'bowling');
            }else{
                if(runs1>runs2){
                    result(runs1,runs2,'bowling');  
                }else{
                    yourscore.textContent=runs1;
                }
                
            }
        }
        else{
            result(runs1,runs2,'bowling');
        }            
    }
}             
function batting(val){                 
        var random=randomnumber();
        if (random===parseInt(val)){            
            return("o");
        }else{
            if (count1===bbcount/2){
             runs1+=parseInt(val);
             balls.textContent=count2;
             borb.textContent="Bowling Now"
            }else{
             runs1+=parseInt(val);
             count1+=1
             balls.textContent=count1;
            }           
        }
}
function bowling(val){
       var random=randomnumber();
        if (random===parseInt(val)){
            return("o");
        }else{
            if (count2===bbcount/2){
                runs2+=random;
                count2+=1 ;
                balls.textContent=count1;
                borb.textContent="Batting Now"
            }else{
                runs2+=random;
                count2+=1
                balls.textContent=count2;
            }           
        }
    }
function randomnumber(){
        var r = Math.floor(Math.random() * 6)+1;
        return r;
    }
function result(a,b,c){
    if (c==="batting"){
        if(a<b){
            alert("YOU LOST !!!")
        }else{
            alert("YOU WON !!!")
        }
    }
    else{
        if(a<b){
            alert("YOU LOST !!!")
        }else{
            alert("YOU WON !!!")
        }
    }
}    