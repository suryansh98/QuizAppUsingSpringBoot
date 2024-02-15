const apiALL = "http://localhost:8080/question/allQuestions";

async function getAllQuestions(){

    const response = await fetch(apiALL);

    var data = await response.json();

    console.log(data);


    for(let i = 0; i < data.length; i++)
    {
        
        document.querySelector(".category").innerHTML = data[i].category;
    }
    //console.log(querySelector(".category").innerHTML);

}

getAllQuestions();
