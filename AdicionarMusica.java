import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Musica {
    private String nome;
    private String artista;
    private int duracao;

    public Musica(String nome, String artista, int duracao) {
        this.nome = nome;
        this.artista = artista;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return "Música: " + nome + "\nArtista: " + artista + "\nDuração: " + duracao + " segundos";
    }
}

class GerenciadorMusica {
    private List<Musica> biblioteca;
    private List<Musica> playlist;

    public GerenciadorMusica() {
        biblioteca = new ArrayList<>();
        playlist = new ArrayList<>();
    }

    public void adicionarMusica(String nome, String artista, int duracao) {
        Musica musica = new Musica(nome, artista, duracao);
        biblioteca.add(musica);
        System.out.println("Música adicionada à biblioteca.");
    }

    public void criarPlaylist() {
        Set<Musica> musicasSet = new LinkedHashSet<>(playlist); // Remove duplicações e mantém a ordem
        playlist = new ArrayList<>(musicasSet);
        System.out.println("Playlist criada com sucesso.");
    }

    public void reproduzirPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("A playlist está vazia.");
            return;
        }

        System.out.println("Reproduzindo a playlist:");
        int duracaoTotal = 0;
        for (Musica musica : playlist) {
            System.out.println(musica);
            System.out.println("------------");
            duracaoTotal += musica.getDuracao();
        }

        int minutos = duracaoTotal / 60;
        int segundos = duracaoTotal % 60;
        System.out.printf("Duração total: %d minutos e %d segundos%n", minutos, segundos);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorMusica gerenciador = new GerenciadorMusica();

        boolean executando = true;
        while (executando) {
            System.out.println("==== Gerenciador de Músicas ====");
            System.out.println("1. Adicionar música à biblioteca");
            System.out.println("2. Criar playlist");
            System.out.println("3. Reproduzir playlist");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da música: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o nome do artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Digite o tempo de duração em segundos: ");
                    int duracao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

                    gerenciador.adicionarMusica(nome, artista, duracao);
                    break;
                case 2:
                    gerenciador.criarPlaylist();
                    break;
                case 3:
                    gerenciador.reproduzirPlaylist();
                    break;
                case 0:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        }

        System.out.println("Encerrando o programa...");
        scanner.close();
    }
}
