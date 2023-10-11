import {Component, ElementRef, AfterViewInit, Renderer2, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import Swiper from 'swiper';
import {Cliente} from "../cliente/cliente";
import {ClienteService} from "../service/cliente/cliente.service";
import {PacienteService} from "../service/paciente/paciente.service";

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit{

  clienteLista: Cliente[] = [];


  ngOnInit() {
    //metodo para obtener todos los clientes
    this.clienteService.getAllClientes().subscribe(clienteLista => {
      this.clienteLista = clienteLista; // Asigna los datos a clientesLista
      console.log('Clientes:', this.clienteLista); // Agrega este log para verificar los datos
    });
  }

  title = 'catcareAngular';

  slides = [
    {
      image: 'https://cdn.pixabay.com/photo/2018/06/03/08/57/cat-3449999_1280.jpg',
      alt: 'Gato 1',
      title: 'Optimiza la comunicación y colaboración',
      description: 'Nuestra página web no sólo se trata de gestionar datos, sino también de mejorar la comunicación entre los miembros del equipo de la clínica veterinaria. Con herramientas de mensajería interna, podrás mantener conversaciones privadas sobre casos específicos, compartir información relevante y colaborar de manera efectiva. Esto garantiza que todos los involucrados estén en la misma página cuando se trata del bienestar de las mascotas bajo tu cuidado.'
    },
    {
      image: 'https://cdn.pixabay.com/photo/2015/06/19/14/20/cat-814952_1280.jpg',
      alt: 'Gato 2',
      title: 'Acceso rápido y seguro a la información',
      description: 'Con la seguridad de la información en mente, hemos implementado medidas robustas para proteger los datos de tus pacientes. Accede a la plataforma desde cualquier dispositivo con conexión a internet, ya sea desde tu computadora de escritorio, tableta o teléfono móvil. Esto significa que podrás consultar datos importantes incluso cuando te encuentres fuera de la clínica, lo cual resulta especialmente útil en situaciones de emergencia.'
    },
    {
      image: 'https://cdn.pixabay.com/photo/2016/06/14/00/14/cat-1455468_1280.jpg',
      alt: 'Gato 3',
      title: 'Gestiona tus pacientes de manera sencilla',
      description: 'Nuestra plataforma en línea te permite llevar un registro completo de tus pacientes de manera sencilla y ordenada. Desde fichas médicas individuales hasta historiales de tratamientos y diagnósticos previos, todo estará al alcance de tus manos. Olvida los engorrosos papeleos y archivos físicos; con unos pocos clics, podrás agregar nueva información, actualizar estados de salud y programar recordatorios para futuras consultas.'
    },
  ];

  constructor(
    private el: ElementRef,
    private renderer: Renderer2,
    private router: Router,
    private clienteService: ClienteService
  ) {}

  ngAfterViewInit() {
    this.setupSwiper();
    this.setupListeners();
    this.setupScrollListener();
  }

  private setupSwiper() {
    console.log('Setting up Swiper');
    new Swiper('.bg-slider', {
      direction: 'horizontal',
      loop: true,
      pagination: {
        el: '.swiper-pagination',
        clickable: true,
      },
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    });
  }


  private setupListeners() {
    const clienteBtn = this.el.nativeElement.querySelector('#clienteBtn');
    const veterinarioBtn = this.el.nativeElement.querySelector('#veterinarioBtn');
    const adminBtn = this.el.nativeElement.querySelector('#adminBtn');
    const clienteForm = this.el.nativeElement.querySelector('#clienteForm');
    const veterinarioForm = this.el.nativeElement.querySelector('#veterinarioForm');
    const adminForm = this.el.nativeElement.querySelector('#adminForm');
    const btnCliSignin = this.el.nativeElement.querySelector('#btnCliSignin');
    const btnVetSignin = this.el.nativeElement.querySelector('#btnVetSignin');
    const btnAdmSignin = this.el.nativeElement.querySelector('#btnAdmSignin');
    const loginLink = this.el.nativeElement.querySelector('.login');
    const blurBackground = this.el.nativeElement.querySelector('.blur-background');
    const loginForm = this.el.nativeElement.querySelector('.login-form');
    const closeLoginForm = this.el.nativeElement.querySelector('.close-login-form');

    clienteBtn.addEventListener('click', () => {
      clienteForm.style.display = 'block';
      veterinarioForm.style.display = 'none';
      adminForm.style.display = 'none';
    });

    veterinarioBtn.addEventListener('click', () => {
      clienteForm.style.display = 'none';
      veterinarioForm.style.display = 'block';
      adminForm.style.display = 'none';
    });

    adminBtn.addEventListener('click', () => {
      clienteForm.style.display = 'none';
      veterinarioForm.style.display = 'none';
      adminForm.style.display = 'block';
    });

    btnCliSignin.addEventListener('click', () => {
      const cedula = this.el.nativeElement.querySelector('#CliCedula').value;
      const contraseña = '1111'; // Contraseña por defecto. Se usa para que el método no falle.
      const errorCedula = this.el.nativeElement.querySelector('#errorCedula');

      // Verificar si la cédula coincide con alguna cédula en la lista de clientes
      const clienteEncontrado = this.clienteLista.find(cliente => cliente.cedula === cedula);

      if (clienteEncontrado) {
        errorCedula.style.display = 'none'; // Oculta el mensaje de error
        if (this.validarCampos(cedula, contraseña)) {
          this.router.navigate([`/cliente/${clienteEncontrado.id}/pacientes`]);
        }
      } else {
        errorCedula.style.display = 'block'; // Muestra el mensaje de error
      }
    });




    btnVetSignin.addEventListener('click', () => {
      const cedula = this.el.nativeElement.querySelector('#VetCedula').value;
      const contraseña = this.el.nativeElement.querySelector('#VetPassword').value;
      if (this.validarCampos(cedula, contraseña)) {
        this.router.navigate(['/veterinario/pacientes']); // Navega al componente de PACIENTE
      }
    });

    btnAdmSignin.addEventListener('click', () => {
      const cedula = this.el.nativeElement.querySelector('#AdmCedula').value;
      const contraseña = this.el.nativeElement.querySelector('#AdmPassword').value;
      if (this.validarCampos(cedula, contraseña)) {
        this.router.navigate(['/administrador/pacientes']); // Navega al componente de PACIENTE
      }
    });

    loginLink.addEventListener('click', () => {
      blurBackground.style.visibility = 'visible';
      blurBackground.style.display = 'block';
      loginForm.style.display = 'block';
      loginForm.style.opacity = '1';
    });

    closeLoginForm.addEventListener('click', () => {
      blurBackground.style.visibility = 'hidden';
      blurBackground.style.display = 'none';
      loginForm.style.display = 'none';
      loginForm.style.opacity = '0';
    });
  }

  private setupScrollListener() {
    this.renderer.listen('window', 'scroll', () => {
      const header = this.el.nativeElement.querySelector('header');
      if (header) {
        const isSticky = window.scrollY > 0;
        if (isSticky) {
          this.renderer.addClass(header, 'sticky');
        } else {
          this.renderer.removeClass(header, 'sticky');
        }
      }
    });
  }


  private validarCampos(cedula: string, contrasena: string): boolean {
    if (!cedula.trim()) {
      alert('Por favor, ingrese la cédula.');
      return false;
    }

    if (!contrasena.trim()) {
      alert('Por favor, ingrese la contraseña.');
      return false;
    }
    return true;
  }
}

