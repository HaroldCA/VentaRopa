package pe.edu.upeu.app;

import java.io.Console;

import pe.edu.upeu.dao.CategoriaDao;
import pe.edu.upeu.dao.ProductoDao;
import pe.edu.upeu.dao.UsuarioDao;
import pe.edu.upeu.dao.VentaDao;
import pe.edu.upeu.gui.MainGUI;
import pe.edu.upeu.modelo.CategoriaTO;
import pe.edu.upeu.modelo.ProductoTO;
import pe.edu.upeu.util.LeerTeclado;
import pe.edu.upeu.util.UtilsX;

/**
 * Hello world!
 *
 */
public class App {

    public static void registrarCategoria(CategoriaTO categ) {
        System.out.println("------------Registro de Categoria de Productos---------");
        System.out.println("IDCateg:"+categ.getIdCateg()+"\tNombre:"+categ.getNombre());
    }

    public static void menuMain(){
        String mensaje="Seleccione la Operacion que desea Ejecutar:"+
        "\n1=Registrar Categoria"+
        "\n2=Reportar Categoria "+
        "\n3=Registrar Productos"+
        "\n4=Reportar Producto"+
        "\n5=Modificar Producto"+
        "\n6=Realizar Venta"+
        "\n7=Reporte de Venta en Rango de Fechas"+
        "\n8=Registrar Usuario"+
        "\n0=Salir del programa";
        LeerTeclado lt=new LeerTeclado(); 
        UtilsX ut=new UtilsX();
        CategoriaDao daoC;       
        UsuarioDao daoUso;
        ProductoDao proDao;
        VentaDao venDao;
        int opcion=9;
        opcion=lt.leer(0, mensaje);
        do{            
            switch(opcion){
                case 1:                
                daoC=new CategoriaDao(); daoC.crearCategoria(); 
                ut.clearConsole(); break;
                case 2: daoC=new CategoriaDao(); daoC.reporteCategoria(); break;   
                case 3: proDao=new ProductoDao(); proDao.crearProducto(); break;
                case 4: proDao=new ProductoDao(); proDao.reporteProducto(); break;
                case 5: proDao=new ProductoDao(); proDao.reporteProducto(); break;
                case 6: venDao=new VentaDao(); venDao.registroVentaGeneral(); break;
                case 7: venDao=new VentaDao(); venDao.reporteVentasRangoFecha(); break;
                case 8: daoUso=new UsuarioDao(); daoUso.crearNuevoUsuario(); break;
                case 0: break;
                default: System.out.println("La opcion que eligio no exuiste!");
                break;
            }
            if(opcion!=0){
                System.out.println("\nDesea seguir probando: ");
                opcion=lt.leer(0, mensaje);
            }
            
        }while(opcion!=0);        
    }

    public static void validarAcceso() {
        LeerTeclado lt=new LeerTeclado(); 
        Console  constx= System.console();
        String usuario=lt.leer("", "Ingrese su usuario:");
        System.out.println("Ingrese su clave:");
        char[] clave=constx.readPassword();
        UsuarioDao usuDao=new UsuarioDao();
        if(usuDao.login(usuario, clave)){
            menuMain(); 
        }else{
            System.out.println("Intente Nuevamente!!");
            validarAcceso();
        }
    }

    /*public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";*/

    public static void main( String[] args ){
        //System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);

        validarAcceso();       
        //menuMain(); 
        //new MainGUI();
    }
}
