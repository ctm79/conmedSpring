window.onload = iniciar;
var intento=0;


function iniciar() {
    
    var entradas = document.getElementsByClassName('form-control');
    desactivar(entradas);
      
  // Registramos el evento para cuando se haga click en el boton enviar en
  // la fase de burbujeo
     document.getElementById('modificar').addEventListener('click',modificar,false);
     
      
  
}
// En esta función validamos todos los campos del formulario
function modificar(evento) {
	//prompt('Introduce un número:','');
  // Almacenamos los valores que le vamos a pasar a las funciones de validacion
  var entradas = document.getElementsByClassName('form-control');
   
 for (x in entradas) {
	entradas[x].disabled = false;

  }
  
  
}

function desactivar(entradas) {
      if(entradas.length) {
        for (x in entradas) {
              entradas[x].disabled = true;
        }
    }
  }
  
  /*
  var nombre = document.getElementById('nombre').value;
  var apellido = document.getElementById('apellidos').value;
  var edad = parseInt(document.getElementById('edad').value);
  var nif = document.getElementById('nif').value;
  var email = document.getElementById('email').value;
  var provincia = document.getElementById('provincia').value;
  var fecha = document.getElementById('fecha').value;
  var telefono = document.getElementById('telefono').value;
  var hora = document.getElementById('hora').value;

  // Comprobamos sii se cumplen las validaciones
  if (validarNombre(nombre) && validarApellido(apellido) && validarEdad(edad)
      && validarDNI(nif) && validarEmail(email) && validarProvincia(provincia)
      && validarFecha(fecha) && validarTelefono(telefono) && validarHora(hora)) {
    return true;
  } else {
    // Si no se cumple cancelamos el envío del formulario
    evento.preventDefault();
    // Incrementamos el número de intentos
    intento++;
    // Y lo almacenamos en el cliente
    window.localStorage.setItem('contador',intento);
    // Recuperamos la información para mostrarla en el contenedor
    intento = window.localStorage.getItem('contador');
    document.getElementById('intentos').innerHTML= "Intentos de envío del formulario " + intento;

    return false;
  }
}

function validarNombre(name) {

  // Con ^ especificamos que el primer caracter sean en mayúscula
  var  expresion =  /^[A-Z]/;


  if (expresion.test(name)) {
    return true;
  } else {
		document.getElementById('errores').innerHTML= "El nombre no se ha introducido correctamente<br>";
    document.getElementById("nombre").focus();
		return false;	// Salimos de la función devolviendo false.
	}

}

function validarApellido(surname) {

// Con ^ especificamos que el primer caracter sean en mayúscula
// Con [A-Z]+ que se incluya una o mas letras en mayuscula
// Con $ que el último caracter sea en mayúscula.
  var  expresion =  /^[A-Z]+$/;

  if (expresion.test(surname)) {
    return true;
  } else {
		document.getElementById('errores').innerHTML= "El apellido no se ha introducido correctamente<br>";
    document.getElementById("apellidos").focus();
		return false;	// Salimos de la función devolviendo false.
	}

}


function validarEdad(age) {

  if (!isNaN(age) && (age>17) && (age<121)) {
    return true;
  } else {
		document.getElementById('errores').innerHTML= "La edad no se ha introducido correctamente<br>";
    document.getElementById("edad").focus();
		return false;	// Salimos de la función devolviendo false.
	}

}

// Esta función devuelve la letra correspondiente a un número DNI}
function letraDni(dni) {
  return "TRWAGMYFPDXBNJZSQVHLCKE".charAt(dni % 23);
}

function validarDNI(dni) {

  var letra = dni.slice(8);
  var numero = dni.slice(0,8);

  var expresion =  /\d{8}[A-Z]/;
  // Con \d{8{} indicamos que se deben introducir 8 digitos
  // Con [A-Z] indicamos que debe haber una letra mayuscula

  if ((expresion.test(dni)) && (letraDni(numero)==letra)) {
    return true;
  } else {
		document.getElementById('errores').innerHTML= "El DNI no se ha introducido correctamente<br>";
    document.getElementById("nif").focus();
		return false;	// Salimos de la función devolviendo false.
	}

}

function validarEmail(mail) {

  var expresion =  /^\w+[@][A-Za-z0-9]+[.][A-Za-z]{3}$/;
  // Con ^\w+ indicamos que la cadena debe comenzar con caracteres de tipo
  // letras, dígitos o subrayados y que puede contener uno o mas
  // Con [@] indicamos que deber haber una arroba
  // Con [A-Za-z0-9]+ indicamos que puede haber uno o varios letras y numeros
  // [.] Indicamos que debe haber un punto
  // [A-Za-z]{3}$  la cadena debe finalizar con tres letras en mayuscula o minuscula


  if (expresion.test(mail)) {
    return true;
  } else {
		document.getElementById('errores').innerHTML= "El eMail no se ha introducido correctamente<br>";
    document.getElementById("email").focus();
		return false;	// Salimos de la función devolviendo false.
	}

}

function validarProvincia(prov) {

  if (prov!=0) {
    return true;
  } else {
		document.getElementById('errores').innerHTML= "No se ha seleccionado ninguna provincia<br>";
    document.getElementById("provincia").focus();
		return false;	// Salimos de la función devolviendo false.
	}

}

function validarFecha(date) {

  var expresion =  /^\d{2}[/-]\d{2}[-/]\d{4}$/;
  // ^\d{2} la cadena debe empezar con dos digitos
  // [/-] se debe introducir barra inclinada o guión medio
  // \d{2} se deben introducir dos digitos
  // [/-] se debe introducir barra inclinada o guión medio
  // \d{4}$ debe finalizar con 4 digitos
  if (expresion.test(date)) {
    return true;
  } else {
		document.getElementById('errores').innerHTML= "La fecha no se ha introducido correctamente<br>";
    document.getElementById("fecha").focus();
		return false;	// Salimos de la función devolviendo false.
	}

}

function validarTelefono(phone) {

  var expresion =  /\d{9}/;
  // \d{9} se deben introducir nueve digitos
  // No es necesaria más validación puesto que el formulario solo permite
  // introducir nueve caracteres
  if (expresion.test(phone)) {
    return true;
  } else {
		document.getElementById('errores').innerHTML= "El telefono no se ha introducido correctamente<br>";
    document.getElementById("telefono").focus();
		return false;	// Salimos de la función devolviendo false.
	}

}

function validarHora(time) {

  var expresion = /^\d{2}[:]\d{2}$/;
  // ^\d{2} se deben introducir dos digitos al inicio de la cadena
  // [:] Se debe introducir dos puntos[:]
  // \d{2}$ se deben introducir dos digitos al inicio de la cadena
  if (expresion.test(time)) {
    return true;
  } else {
		document.getElementById('errores').innerHTML= "La hora no es válida<br>";
    document.getElementById("hora").focus();
		return false;	// Salimos de la función devolviendo false.
	}
*/

