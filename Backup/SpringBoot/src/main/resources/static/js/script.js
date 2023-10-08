// Carga despues de que la pagina ya se renderiza
document.addEventListener("DOMContentLoaded", function () {
    // Configuración del slider principal de fotos del landing
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

    // Cambiar la clase "sticky" del encabezado cuando se desplaza la página
  window.addEventListener("scroll", function () {
      const header = document.querySelector("header");
      header.classList.toggle("sticky", window.scrollY > 0);
  });


  // Parte translúcida
  // Abrir el formulario de inicio de sesión
  const loginLink = document.querySelector(".login");

  const blurBackground = document.querySelector(".blur-background");
  const loginForm = document.querySelector(".login-form");

  const closeLoginForm = document.querySelector(".close-login-form");

  // Abre el formulario de inicio de sesión
  loginLink.addEventListener("click", () => {
      blurBackground.style.visibility = "visible";
      blurBackground.style.display = 'block';
      loginForm.style.display = 'block';      
      loginForm.style.opacity = "1"; // Mostrar el formulario gradualmente
  });

  // Cerrar el formulario de inicio de sesión
  closeLoginForm.addEventListener("click", () => {
      blurBackground.style.visibility = "hidden";
      blurBackground.style.display = 'none';
      loginForm.style.display = 'none';      
      loginForm.style.opacity = "0"; // Ocultar el formulario gradualmente
  });

});
