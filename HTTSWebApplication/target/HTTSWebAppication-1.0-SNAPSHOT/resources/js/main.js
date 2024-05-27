/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function deleteProduct(url, id) {
    fetch(url, {
        method: 'delete'
    }).then(res => {
        location.reload();
    });
}


