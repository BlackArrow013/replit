import java.util.ArrayList;

public class EjercicioR868
{
    public ArrayList<Alumno> obtenerAlumnosOrdenadorPorNotaMedia(ArrayList<Alumno> alumnosGrupo1, ArrayList<Alumno> alumnosGrupo2) 
    {     
        ArrayList<Alumno> alumnosOrdenadosPorNotaMedia = new ArrayList<Alumno>();        
        ArrayList<Alumno> copiaColeccion = new ArrayList(alumnosOrdenadosPorNotaMedia);
        copiaColeccion.addAll(alumnosGrupo1);
        copiaColeccion.addAll(alumnosGrupo2);
        if (copiaColeccion.size() > 0) {
            for (Alumno alumnoSuspenso : copiaColeccion) {
                if(alumnoSuspenso.getNotaLengua() < 5 || alumnoSuspenso.getNotaMatematicas() < 5 || alumnoSuspenso.getNotaIngles() < 5) {
                    copiaColeccion.remove(alumnoSuspenso);
                }
            }

            while(copiaColeccion.size() != 0) {
                Alumno alumnoConMejorNota = copiaColeccion.get(0);
                for(Alumno alumnoActual : copiaColeccion) {
                    if (alumnoActual.getNotaMedia() >= alumnoConMejorNota.getNotaMedia()){
                        alumnoConMejorNota = alumnoActual;
                    }  
                }
                alumnosOrdenadosPorNotaMedia.add(alumnoConMejorNota);
                copiaColeccion.remove(alumnoConMejorNota);
            }
        }
        return alumnosOrdenadosPorNotaMedia;
    }

}

class Alumno
{
    private String nombreCompleto;
    private int notaLengua;
    private int notaMatematicas;
    private int notaIngles;

    public Alumno(String nombreCompleto, int notaLengua, int notaMatematicas, int notaIngles) 
    {
        this.nombreCompleto = nombreCompleto;
        this.notaLengua = notaLengua;
        this.notaMatematicas = notaMatematicas;
        this.notaIngles = notaIngles;
    }

    public String getNombreCompleto()
    {
        return nombreCompleto;
    }

    public int getNotaLengua()
    {
        return notaLengua;
    }

    public int getNotaMatematicas()
    {
        return notaMatematicas;
    }

    public int getNotaIngles()
    {
        return notaIngles;
    }

    public double getNotaMedia()
    {
        return (notaLengua + notaMatematicas + notaIngles)/3;
    }

    public String toString()
    {
        return "Nombre Completo: " + nombreCompleto + "; Nota Media: " + getNotaMedia();
    }
}