package com.miapp.biblioteca.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.LibroServicio;
import com.miapp.biblioteca.service.UsuarioServicio;

public class Main {

	public static void main(String[] args) {
		
		// INSTANCIAMOS LOS METODOS 
		ArrayList<Libro> biblioteca = new ArrayList();
		ArrayList<Usuario> usuarios = new ArrayList();
		LibroServicio libroServicio = new LibroServicio(biblioteca);
		UsuarioServicio usuarioServicio = new UsuarioServicio(usuarios);
		Scanner scan = new Scanner(System.in);

		int opc;
		int opc2;
		int opc3;
		// CODIGO DEL FUNCIONAMIENTO GENERAL DEL PROGRAMA -------------------
		// CODIGO DEL FUNCIONAMIENTO GENERAL DEL PROGRAMA -------------------
		System.out.println("======= Bienvenido ADMIN! =======");

		do {
			System.out.println("");
			System.out.println("======== -------------- ========");
			System.out.println("======== Menu Principal ========");

			System.out.println("1. Administrar usuarios");
			System.out.println("2. Administrar libros");
			System.out.println("3. Prestamos");
			System.out.println("4. Devoluciones");
			System.out.println("0. SALIR");
			System.out.print("Seleccione una de las opciones: ");
			
			opc = scan.nextInt();
			System.out.println("");
			// CODIGO POR SI EL ADMIN SE CONDUNDE AL TIPAEAR
			
// -------------------------------------- MENU PRINCIPAL -----------------------------------	
// -------------------------------------- MENU PRINCIPAL -----------------------------------
				switch(opc){
			
				case 0:
					break;

// ---------------------------------- MENU SECUNDARIO UNO - USUARIOS --------------------------------	
// ---------------------------------- MENU SECUNDARIO UNO - USUARIOS --------------------------------	
				case 1: 
					do {
						System.out.println("===== -------------------- =====");
						System.out.println("===== Administrar USUARIOS =====");
						System.out.println("1. Ingresar un nuevo usuario");
						System.out.println("2. Actualizar datos de un usuario");
						System.out.println("3. Buscar usuario por ID");
						System.out.println("4. Buscar usuario por Nombre");
						System.out.println("5. Listar usuarios");
						System.out.println("6. Eliminar un usuario");
						System.out.println("0. Volver al menu principal");
						System.out.print("Seleccione una de las opciones: ");
					
						opc2 = scan.nextInt();
						
						switch(opc2){
						case 0:

							break;

						case 1: // INGRESAR UN NUEVO USUARIO
							System.out.println("");

							System.out.print("Ingrese el ID del nuevo usuario: ");
							String id = scan.next();
							
							
							// Controlamos que el ID no esté en uso
							Usuario usuarioPorID_ing = usuarioServicio.buscarUsuarioPorID(id) ; 
							if (usuarioPorID_ing != null){System.out.println("El ID ingresado ya se encuentra en uso, porfavor ingrese otro.");System.out.println("");}
							else {
							System.out.print("Ingrese el nombre del nuevo usuario: ");
							scan.nextLine();
							String nombre = scan.nextLine();


							usuarioServicio.crearUsuario(nombre, id);
							
							System.out.println("Usuario creado correctamente, sus datos son:");
							Usuario usuarioPorID_cr = usuarioServicio.buscarUsuarioPorID(id);
							System.out.println("Nombre: " + usuarioPorID_cr.getNombre() + " , ID: " + usuarioPorID_cr.getId());
							System.out.println("");
							}
							
							break;
				
						
						case 2: // ACTUALIZAR LOS DATOS DE UN USUARIO
							System.out.println("");
							System.out.print("Ingrese el ID del usuario a los que le desea actualizar los datos: ");
							String idActualizar = scan.next();

							Usuario usuarioPorID_ac = usuarioServicio.buscarUsuarioPorID(idActualizar);
							if (usuarioPorID_ac == null){System.out.println("No se encontro el ID, porfavor vuelva a intentar.");System.out.println("");}
							else {
								System.out.print("Ingrese el nuevo nombre del usuario: ");
								scan.nextLine();
								String nuevoNombre = scan.nextLine();
								System.out.println("");
								
								System.out.println("Los datos del usuario con ID: "+ usuarioPorID_ac.getId());
								System.out.println("se actualizaron de: "+ usuarioPorID_ac.getNombre());
								usuarioServicio.actualizarUsuario(idActualizar, nuevoNombre); // Aca se actualiza el usuario
								Usuario usuarioPorID_ac2 = usuarioServicio.buscarUsuarioPorID(idActualizar);
								System.out.println("a: "+ usuarioPorID_ac2.getNombre());
								System.out.println("");
							}
							
							break;
						
							
						case 3: // CONSULTAR USUARIO POR ID
							System.out.println("");
							System.out.print("Ingrese el ID del usuario buscar: ");
							String idAConsultar_cons = scan.next();
							Usuario usuarioPorID_cons = usuarioServicio.buscarUsuarioPorID(idAConsultar_cons) ; 
							if (usuarioPorID_cons == null) {System.out.println("No existe usuario con este ID");System.out.println("");}
							else {
							System.out.println("El usuario correspondiente al ID es:");
							System.out.println("Nombre: "+usuarioPorID_cons.getNombre());
							System.out.println("Libros prestados: " + usuarioPorID_cons.getLibrosPrestados());
							}
							System.out.println("");
							
							break;
							
							
						case 4: // BUSQUEDA DE USUARIOS POR NOMBRE
							System.out.println("");
							System.out.print("Ingrese el nombre del usuario que esta buscando: ");
							scan.nextLine();
							String nombreABuscar = scan.nextLine();
							ArrayList<Usuario> usuariosEncontrados = usuarioServicio.buscarUsuarioPorNombre(nombreABuscar);
							if(!usuariosEncontrados.isEmpty()) {
								System.out.println("Usuario Encontrado:");
								for(Usuario usuario : usuariosEncontrados) {
									System.out.println("Nombre: " + usuario.getNombre());
									System.out.println("Libros Prestados: " + usuario.getLibrosPrestados());
									System.out.println("");
								}
								
							}else{
								System.out.println("No se encontraron libros con el titulo ingresado");
							}
							
							System.out.println("");
							
							break;
						
						
						
						case 5: // LISTAR USUARIOS
							System.out.println();
							System.out.println("Los usuarios ingresados en el sistema son los siguientes:");
							ArrayList<Usuario> listaUsuarios = usuarioServicio.consultarUsuarios();
							for (Usuario usuario : listaUsuarios){
								System.out.println("ID: " + usuario.getId() + " , Nombre: " + usuario.getNombre());
								System.out.println("Libros prestados: " + usuario.getLibrosPrestados() );
								System.out.println();
							}
							System.out.println();
							break;
							
						
						case 6: // ELIMINAR USUARIO DEL SISTEMA
							System.out.println();
							System.out.print("Ingrese el ID del usuario que desea eliminar del sistema: ");
							String idABorrar = scan.next();
							
							Usuario usuarioPorID_elim = usuarioServicio.buscarUsuarioPorID(idABorrar);
							if (usuarioPorID_elim == null){System.out.println("No se encontro el ID, porfavor vuelva a intentar.");System.out.println("");}
							else{
							System.out.println("El usuario " + usuarioPorID_elim.getNombre() + ", de ID " + usuarioPorID_elim.getId());
							System.out.println("Se elimino correctamente");System.out.println("");
							usuarioServicio.eliminarUsuario(idABorrar);
								
							}
							
							break;
							
							
						default:
							System.out.println("Porfavor, ingrese una opcion correcta...");
							System.out.println("");
							break;
						} // CIERRA SWITCH
					
						
					}while(opc2 != 0); // CIERRA DO
					
					break;

													
// ---------------------------------- MENU SECUNDARIO DOS - LIBROS --------------------------------	
// ---------------------------------- MENU SECUNDARIO DOS - LIBROS --------------------------------		
				case 2:
					do {
						System.out.println("====== ------------------ ======");
						System.out.println("====== Administrar LIBROS ======");
						System.out.println("1. Ingresar un nuevo libro");
						System.out.println("2. Actualizar datos de un libro");
						System.out.println("3. Buscar libro por ISBN");
						System.out.println("4. Buscar libro por Titulo");
						System.out.println("5. Listar libros de la biblioteca");
						System.out.println("6. Eliminar un libro");
						System.out.println("0. Volver al menu principal");
						System.out.print("Seleccione una de las opciones: ");
					
						opc3 = scan.nextInt();
						
						switch(opc3){
						case 0:
							break;
							
						case 1: // INGRESAR UN NUEVO LIBRO
							System.out.println("");
							System.out.print("Ingrese el ISBN del nuevo libro: ");
							String nuevoISBN = scan.next();
							
							System.out.print("Ingrese el titulo del nuevo libro: ");
							scan.nextLine();
							String titulo = scan.nextLine();
							
							System.out.print("Ingrese el autor del nuevo libro: ");

							String autor = scan.nextLine();
							
							System.out.print("Ingrese el genero del nuevo libro: ");
							String genero = scan.nextLine();
							System.out.println("");

							libroServicio.ingresarLibro(nuevoISBN, titulo, autor, genero);
							
							System.out.println("Libro ingresado correctamente, sus datos son:");
							Libro libroPorISBN_cr = libroServicio.buscarLibroPorISBN(nuevoISBN);
							System.out.println("ISBN: " + libroPorISBN_cr.getISBN() + " , Titulo: " + libroPorISBN_cr.getTitulo());
							System.out.println("Autor: " + libroPorISBN_cr.getAutor() + " , Genero: " + libroPorISBN_cr.getGenero());
							System.out.println("");
							
							break;
							
						case 2: // ACTUALIAR LOS DATOS DE UN LIBRO
							System.out.println("");
							System.out.print("Ingrese el ISBN del libro al cual le desea actualizar los datos: ");
							scan.nextLine();
							String isbnActualizar = scan.next();

							Libro libroPorISBN_ac = libroServicio.buscarLibroPorISBN(isbnActualizar);
							if (libroPorISBN_ac == null){System.out.println("No se encontro el ISBN del libro, porfavor vuelva a intentar.");System.out.println("");}
							else {
								System.out.print("Ingrese nuevo titulo: ");
								scan.nextLine();
								String tituloActualizar = scan.next();
								System.out.print("Ingrese nuevo autor: ");
								scan.nextLine();
								String autorActualizar = scan.next();
								System.out.print("Ingrese nuevo genero: ");
								scan.nextLine();
								String generoActualizar = scan.next();
								
								System.out.println(" ");
								System.out.println("Los datos del libro con ISBN: "+ libroPorISBN_ac.getISBN() );
								System.out.println("se actualizaron de Titulo: "+ libroPorISBN_ac.getTitulo() + ", Autor " + libroPorISBN_ac.getAutor() + ", Genero " + libroPorISBN_ac.getGenero() );
								libroServicio.actualizarLibro(isbnActualizar, tituloActualizar, autorActualizar, generoActualizar); // Aca se actualiza el usuario
								Libro libroPorISBN_ac2 = libroServicio.buscarLibroPorISBN(isbnActualizar);
								System.out.println("a Titulo: "+ libroPorISBN_ac2.getTitulo() + ", Autor " + libroPorISBN_ac.getAutor() + ", Genero " + libroPorISBN_ac.getGenero() );
								System.out.println("");
							}
							
							break;
							
							
						case 3:
							System.out.println("");
							System.out.print("Ingrese el ISBN del libro que desea buscar: ");
							String isbnAConsultar_cons = scan.next();
							Libro libroPorISBN_cons = libroServicio.buscarLibroPorISBN(isbnAConsultar_cons); 
							if (libroPorISBN_cons == null) {System.out.println("No existe libro con este ISBN");System.out.println("");}
							else {
							System.out.println("El libro correspondiente al ISBN es:");
							System.out.print("Titulo: " + libroPorISBN_cons.getTitulo() + ", Autor: " + libroPorISBN_cons.getAutor()) ;}
							System.out.print(", Genero: " + libroPorISBN_cons.getGenero() + ", Disponibilidad: " + libroPorISBN_cons.getDisponible());
							System.out.println("");
							break;
							
							
						case 4:
							
							System.out.println("");
							System.out.print("Ingrese el titulo del libro que esta buscando: ");
							scan.nextLine();
							String tituloABuscar = scan.nextLine();
							ArrayList<Libro> librosEncontrados = libroServicio.buscarLibroPorTitulo(tituloABuscar);
							if(!librosEncontrados.isEmpty()) {
								System.out.println("Libros Encontrados:");
								for(Libro libro : librosEncontrados) {
								System.out.print("Titulo: " + libro.getTitulo() + ", Autor: " + libro.getAutor()) ;
								System.out.print(", Genero: " + libro.getGenero() + ", Disponibilidad: " + libro.getDisponible());
								System.out.println("");
									
								}
								
							}else{
								System.out.println("No se encontraron libros con el titulo ingresado");
							}
							
							System.out.println("");
							
							
							break;
							
							
						case 5:
							System.out.println("");
							System.out.println("Los libros ingresados en el sistema son: ");
		
							ArrayList<Libro> listaLibros = libroServicio.consultarBiblioteca();
							for (Libro libro : listaLibros){
								System.out.print("Titulo: " + libro.getTitulo() + ", Autor: " + libro.getAutor()) ;
								System.out.print(", Genero: " + libro.getGenero() + ", Disponibilidad: " + libro.getDisponible());
								System.out.println("");
							}
							System.out.println("");
							
							break;
							
							
						case 6: // ELIMINAR UN LIBRO DEL SISTEMA
							
							System.out.println();
							System.out.print("Ingrese el ISBN del libro que desea eliminar del sistema: ");
							String isbnABorrar = scan.next();
							
							Libro libroPorISBN_elim = libroServicio.buscarLibroPorISBN(isbnABorrar);
							if (libroPorISBN_elim == null){System.out.println("No se encontro libro con el correspndiente ISBN, porfavor vuelva a intentar.");System.out.println("");}
							else{
							System.out.println("El libro de titulo: " + libroPorISBN_elim.getTitulo() + ", autor: " + libroPorISBN_elim.getAutor() + ", e ISBN: " + libroPorISBN_elim.getISBN());
							System.out.println("Se elimino correctamente");System.out.println("");
							libroServicio.eliminarLibro(isbnABorrar);
								
							}
							
							break;
							
							
						default:
							System.out.println("Porfavor, ingrese una opcion correcta...");
							System.out.println("");
							break;
												
						}
						
						
					}while(opc3 != 0);
					
					break;
					
// ------------------------------ CIERRE MENU SECUNDARIO DOS - LIBROS --------------------------------	
// ------------------------------ CIERRE MENU SECUNDARIO DOS - LIBROS --------------------------------	
					
				case 3: // PRESTAMOS
					System.out.print("Ingrese el ID del usuario: ");
					String idUsuario = scan.next();
					Usuario usuarioPrestamo = usuarioServicio.buscarUsuarioPorID(idUsuario);
					
					if(usuarioPrestamo != null) {
						System.out.print("Ingrese el ISBN de libro que se va a prestar: ");
						String isbnPrestamo = scan.next();
						Libro libroPrestamo = libroServicio.buscarLibroPorISBN(isbnPrestamo);
						if (libroPrestamo != null){
							if (libroServicio.verificarDisponibilidad(libroPrestamo)) {
								usuarioServicio.prestarLibro(libroPrestamo, usuarioPrestamo);
								System.out.println("Se registro el prestamo de libro al usuario: " + usuarioPrestamo.getNombre());
							}else{System.out.println("El libro no esta disponible para prestamo");}
						
						}else{System.out.println("El libro no encontrado, porfavor ingrese un ISBN valido");}
						
					}else{System.out.println("Usuario no encontrado, porfavor ingrese un ID valido");}
					
					
					
					break;
					
				case 4: // DEVOLUCIONES
					System.out.print("Ingrese el ID del usuario: ");
					String idUsuario_dev = scan.next();
					Usuario usuarioDevolucion = usuarioServicio.buscarUsuarioPorID(idUsuario_dev);
					if(usuarioDevolucion != null){
						System.out.print("Ingrese el ISBN del libro que se va a devolver: ");
						String isbnDevolucion = scan.next();
						Libro libroDevolucion = libroServicio.buscarLibroPorISBN(isbnDevolucion);
						if(libroDevolucion != null){
							usuarioServicio.devolverLibro(usuarioDevolucion, libroDevolucion);
							System.out.println("La devolucion se ha hecho con exito, por el usuario: " + usuarioDevolucion.getNombre());
						}else{System.out.println("No se ha encontrado el libro, porfavor ingrese el ISBN nuevamente");}
						
					}else{System.out.println("No se ha encontrado el usuario, porfavor ingrese el ID nuevamente");}
					
					break;
					
				default:
					System.out.println("Por favor seleccione una opcion correcta...");
					break;
					
									
				} // CIERRA SWITCH
			

		}while(opc != 0);
		System.out.println("Que tenga un buen dia!");
		 // CIERRA DO PRINCIPAL
		
		
		
		
		
		
		
	}

}
