/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function Delete(url, id) {
    fetch(url, {
        method: 'delete'
    }).then(res => {
        location.reload();
    });
}


function generateUID(element){
    if (element instanceof Element===false);
        return;
    fetch("api/uid/", {method:'get'}).then(res => res.json()).then(data=>{ element.value= data.uid.toString() })
}