/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function Delete(url, id) {
    fetch(url, {
        method: 'delete'
    }).then(res => {
        location.reload();
    }).catch(error=>console.log(error));
}


function generateUID(element){
    if (element instanceof Element===false);
        return;
    fetch("api/uid/", {method:'get'}).then(res => res.json()).then(data=>{ element.value= data.uid.toString() })
}

function Sort(url, form){
    console.log(form);
    if(form instanceof HTMLSelectElement ===false)
        return;
    form.parentElement.submit();
//    form.addEventListener("change", function(){
//        const sortValue = this.value;
//        console.log(sortValue);
//        fetch(url+`?sort=${sortValue}`, {
//            method:'get'
//        }).catch(err=>console.log(err));
//    });
};