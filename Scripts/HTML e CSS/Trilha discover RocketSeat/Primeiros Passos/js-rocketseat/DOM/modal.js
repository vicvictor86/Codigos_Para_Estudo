let modalWrapper = document.querySelector('.modal-wrapper');
let buttonOpenWindow = document.getElementById("openModal");

document.addEventListener('keydown', (event) => {
    let isEscKey = event.key === "Escape";
    let hasInvisible = modalWrapper.classList.contains('invisible');

    if(isEscKey && !hasInvisible){
       modalWrapper.classList.add('invisible')
    }
});

buttonOpenWindow.onclick = () => {
    modalWrapper.classList.remove('invisible')
}