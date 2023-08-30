// Carga despues de que la pagina ya se renderiz
document.addEventListener("DOMContentLoaded", function () {
  // slide principal de fotos del landing
  var swiper = new Swiper(".bg-slider", {
      slidesPerView: 1,
      spaceBetween: 30,
      loop: true,
      pagination: {
          el: ".swiper-pagination",
          clickable: true,
      },
      navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
      },
  });

  window.addEventListener("scroll", function () {
      const header = document.querySelector("header");
      header.classList.toggle("sticky", window.scrollY > 0);
  });


  // TRANSLUCENT PART
  // Login
  const loginLink = document.querySelector(".login");

  const blurBackground = document.querySelector(".blur-background");
  const loginForm = document.querySelector(".login-form");

  const closeLoginForm = document.querySelector(".close-login-form");

  // Abre el formulario de inicio de sesión
  loginLink.addEventListener("click", () => {
      blurBackground.style.visibility = "visible";
      blurBackground.style.display = 'block';
      loginForm.style.display = 'block';      
      loginForm.style.opacity = "1"; // Show the form gradually
  });

  // Cierra el formulario de inicio de sesión
  closeLoginForm.addEventListener("click", () => {
      blurBackground.style.visibility = "hidden";
      blurBackground.style.display = 'none';
      loginForm.style.display = 'none';      
      loginForm.style.opacity = "0"; // Hide the form gradually
  });

});
