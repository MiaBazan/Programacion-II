import java.util.ArrayList;
import java.util.Scanner;

public class SistemaVotacion {
    public static void main(String[] args) {
        Eleccion eleccion = new Eleccion();

        eleccion.registrarCandidato(new Candidato("Ana Garcia", "Partido A"));
        eleccion.registrarCandidato(new Candidato("Luis Perez", "Partido B"));
        eleccion.registrarCandidato(new Candidato("Marta Ruiz", "Partido C"));

        Votante[] censo = {
                new Votante("V-001"), new Votante("V-002"), new Votante("V-003"),
                new Votante("V-004"), new Votante("V-005"), new Votante("V-006")
        };

        System.out.println("--- Inicio de Jornada Electoral ---");
        for (Votante v : censo) {
            eleccion.emitirVoto(v);
        }

        eleccion.mostrarResultados();
    }
}

class Candidato {
    String nombre;
    String partido;
    int votos;

    public Candidato(String nombre, String partido) {
        this.nombre = nombre;
        this.partido = partido;
        this.votos = 0;
    }
}

class Votante {
    String idVotante;
    boolean yaVoto;

    public Votante(String idVotante) {
        this.idVotante = idVotante;
        this.yaVoto = false;
    }
}

class Eleccion {
    ArrayList<Candidato> candidatos = new ArrayList<>();
    int votosEnBlanco = 0;

    public void registrarCandidato(Candidato c) {
        candidatos.add(c);
    }

    public void emitirVoto(Votante votante) {
        Scanner sc = new Scanner(System.in);
        int seleccion;

        if (votante.yaVoto) {
            System.out.println("El votante " + votante.idVotante + " ya voto.");
            return;
        }

        do {
            System.out.println("\n--- BOLETA ELECTORAL ---");
            for (int i = 0; i < candidatos.size(); i++) {
                Candidato c = candidatos.get(i);
                System.out.println((i + 1) + ". " + c.nombre + " (" + c.partido + ")");
            }
            System.out.println((candidatos.size() + 1) + ". Voto en Blanco");

            System.out.print("Votante " + votante.idVotante + ", elija (1-" + (candidatos.size() + 1) + "): ");
            seleccion = sc.nextInt();
        } while (seleccion < 1 || seleccion > candidatos.size() + 1);

        if (seleccion == candidatos.size() + 1) {
            votosEnBlanco++;
            System.out.println("Voto en blanco registrado.");
        } else {
            candidatos.get(seleccion - 1).votos++;
            System.out.println("Voto registrado.");
        }
        votante.yaVoto = true;
    }

    public void mostrarResultados() {
        System.out.println("\n--- RESULTADOS FINALES ---");
        int maxVotos = -1;

        for (Candidato c : candidatos) {
            System.out.println(c.nombre + ": " + c.votos + " votos");
            if (c.votos > maxVotos) {
                maxVotos = c.votos;
            }
        }
        System.out.println("Votos en Blanco: " + votosEnBlanco);

        ArrayList<Candidato> ganadores = new ArrayList<>();
        for (Candidato c : candidatos) {
            if (c.votos == maxVotos && maxVotos > 0) {
                ganadores.add(c);
            }
        }

        if (ganadores.isEmpty()) {
            System.out.println("\nNo hay ganador. Todos los votos fueron en blanco o no hubo votos.");
        } else if (ganadores.size() == 1) {
            System.out.println("\nGANADOR: " + ganadores.get(0).nombre + " con " + maxVotos + " votos.");
        } else if (ganadores.size() == candidatos.size()) {
            System.out.println("\nEMPATE TOTAL: Todos los candidatos tienen " + maxVotos + " votos.");
        } else {
            System.out.print("\nEMPATE ENTRE: ");
            for (int i = 0; i < ganadores.size(); i++) {
                System.out.print(ganadores.get(i).nombre + (i == ganadores.size() - 1 ? "" : ", "));
            }
            System.out.println(" con " + maxVotos + " votos cada uno.");
        }
    }
}