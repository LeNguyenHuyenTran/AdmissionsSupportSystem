/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

const loadItem = document.createElement("div");
loadItem.className
        =``
        ;
        loadItem.id='loadItem';
loadItem.innerHTML=`<div class='position-fixed top-0 end-0 start-0 bottom-0 
h-100 d-flex justify-content-center align-items-center bg-body-tertiary'>
<div class="spinner-border text-primary" role="status">
  <span class="visually-hidden">Loading...</span>
</div>

</div>`;

window.document.body.appendChild(loadItem);

window.onload=function (){
    console.log("loaded");
    loadItem.className='fade-out';
    loadItem.remove();
    console.log("item remove");
};
