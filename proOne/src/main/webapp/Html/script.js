






window.onload = function (){
    document.getElementById("enter").addEventListener('click', enterPage)
  }
  
  function enterPage(){
        let age = parseFloat(document.getElementById("age").value);
        let party = parseFloat(document.getElementById("party").value);
        if((10 < age && age < 60) && (0 <= party && party < 5)){
            location.href = "page2.html";
            } else {
            location.href = "zombie.html";
            }
  }