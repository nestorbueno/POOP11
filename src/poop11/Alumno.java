package poop11;

/**
 * Representa a un estudiante con información personal básica.
 * Esta clase permite almacenar y manipular los datos de un alumno, 
 * incluyendo su nombre, apellidos, número de cuenta, edad y semestre.
 */
public class Alumno {
    private String nombre;
    private String apPat;
    private String apMat;
    private int numCuenta;
    private int edad;
    private int semestre;

    // Constructor por defecto
    public Alumno() {}

    // Constructor con parámetros
    public Alumno(String nombre, String apPat, String apMat, int numCuenta, int edad, int semestre) {
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMat = apMat;
        this.numCuenta = numCuenta;
        this.edad = edad;
        this.semestre = semestre;
    }

    // Métodos getter y setter
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApPat() { return apPat; }
    public void setApPat(String apPat) { this.apPat = apPat; }

    public String getApMat() { return apMat; }
    public void setApMat(String apMat) { this.apMat = apMat; }

    public int getNumCuenta() { return numCuenta; }
    public void setNumCuenta(int numCuenta) { this.numCuenta = numCuenta; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }

    // Método para simular que el alumno está estudiando
    public void estudiar() {
        System.out.println("Estoy estudiando");
    }

    // Método para convertir el objeto a formato CSV
    public String toCSV() {
        return nombre + "," + apPat + "," + apMat + "," + numCuenta + "," + edad + "," + semestre;
    }

    // Método estático para crear un objeto Alumno desde una cadena CSV
    public static Alumno fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new Alumno(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
    }

    // Método toString para representar el alumno en texto
    @Override
    public String toString() {
       return nombre + ", " + apPat + ", " + apMat + ", " + numCuenta + ", " + edad + ", " + semestre;
    }
}
