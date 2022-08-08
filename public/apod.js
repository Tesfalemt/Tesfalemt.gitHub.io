$(document).ready(function () {
  $("#view_button").click(getPicture);
  console.log('apod');
});
function getPicture() {


var url=
"https://api.nasa.gov/planetary/apod?api_key=Jxlm5AOzoYVAlOI95juUxxN3SlkW2zLoYzu3iomd&date="+ $("#date").val();


let fe=fetch(url);

fe.then(res=> res.json())
.then(d=>{
   showPicture(d);
    //error: noPicture,
})
.catch(d=>{
  noPicture(d);
   //error: noPicture,
});
console.log('getpic');

};



function showPicture(data) {
  console.log('picture find')
  $("#pic").attr("src", data.url);
  $("#title").text(data.title);
}
function noPicture(error) {
  console.log('picture not find')
  alert(error.responseText);
}
