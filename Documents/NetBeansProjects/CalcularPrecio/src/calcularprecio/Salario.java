package calcularprecio;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class Salario {
//    private String cedula;
    private String cedula;
    private String nombre;
    private double salarioBasico=1300000;
    private int diasLaborados;
    private double ventasMes;
    private double prestamos;
    private double sueldoBase=0;
    private double auxTrans=0;
    private double auxTrans1;
    private double comisionMes=0;
    private double salarioNeto;
    
    public Salario(String cedula, String nombre, double salarioBasico, int diasLaborados, double ventasMes, double prestamos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.salarioBasico = 1300000;
        this.diasLaborados = diasLaborados;
        this.ventasMes = ventasMes;
        this.prestamos = prestamos;
    }
    
        public double sueldoBase() {
       sueldoBase = salarioBasico * diasLaborados / 30;
       return sueldoBase;
    }
// if(numKilo>0 && numKilo<=2)
        public double auxTrans()
        {
            double salario=sueldoBase();
            if (salario > 0 && salario <= 2600000) {

            auxTrans = 162000 * diasLaborados / 30;
            return auxTrans;

        } else {
        return auxTrans=0;
        }
    }
                 
          
        
         public double comisionMes() {
             comisionMes = 0.02 * ventasMes;
        return comisionMes ;
    }
            public double salarioNeto() {
                 double sueldoBase = sueldoBase();
                    double comisionMes = comisionMes();
                salarioNeto=sueldoBase+comisionMes-prestamos+auxTrans;
        
        return salarioNeto;
    }
         
                public void mostrarInformacion() {
        String mensaje = "Cedula empleado: " + cedula +
                "\nNombre Empleado: " + nombre +
                "\nSalario Básicoa: " + salarioBasico +
                "\nAuxilio de Transporte: " + auxTrans()  +
                "\nComisión de Ventas: " + comisionMes() +
                "\nPréstamos: " + prestamos +
                "\nSalario Neto a Recibir: " + salarioNeto();
        JOptionPane.showMessageDialog(null, mensaje, "Información del Vendedor", JOptionPane.INFORMATION_MESSAGE);
    }
         
                 public static void main(String[] args) {
        
        String cedula = JOptionPane.showInputDialog("Ingrese el numero de cedula del empleado:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
        double sueldoBase = 1300000; 
        int diasLabo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los días trabajados:"));
        double ventasMes = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor total de las ventas del mes:"));
        double prestamos = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el descuentos de los préstamos:"));

     
        Salario vendedor = new Salario(cedula, nombre, sueldoBase, diasLabo, ventasMes, prestamos);
                         
        vendedor.mostrarInformacion();
    }
}