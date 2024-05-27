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


