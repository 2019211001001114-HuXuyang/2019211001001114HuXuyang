let password=document.querySelector("#password")
let submit=document.querySelector("#submit")
console.log(password)

submit.onclick=function (){
if(password.value.length<8){
    console.log(password.value.length);
    alert("the password‘s minlength must eight")
}
}
