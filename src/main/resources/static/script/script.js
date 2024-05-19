let menu = document.querySelector('#menu-bar');
let navbar = document.querySelector('.navbar');

menu.onclick = () =>{
    menu.classList.toggle('fa-times');
    navbar.classList.toggle('active');
}

window.onscroll = () =>{
    menu.classList.remove('fa-times');
    navbar.classList.remove('active');

    if(window.scrollY > 60){
        document.querySelector('#scroll-top').classList.add('active');
    }
    else{
        document.querySelector('#scroll-top').classList.remove('active');
    }
}

function loader(){
    document.querySelector('.loader-container').classList.add('fade-out')
}

function fadeOut(){
    setInterval(loader, 750);
}

window.onload = fadeOut();


window.addEventListener("load", function(){
    setTimeout(
        function open(event){
            document.querySelector(".popup-container").style.
            display = "block";
        },
        2000
    )
});

document.querySelector(".close").addEventListener
("click", function(){
    document.querySelector(".popup-container").style.display = 
    "none";
});

