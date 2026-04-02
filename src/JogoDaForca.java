import java.io.InputStream;
import java.util.*;

public class JogoDaForca {

    private List<String[]> palavras = new ArrayList<>();

    private String palavraSorteada;
    private String dica;

    private char[] letrasDescobertas;
    private int acertos;
    private int erros;
    private final int MAX_ERROS = 6;

    private List<String> historico = new ArrayList<>();
    private boolean historicoSalvo = false;

    public JogoDaForca() {
        carregarArquivo();
    }

    private void carregarArquivo() {
        try {
            InputStream stream = getClass().getResourceAsStream("/dados/palavras.csv");

            if (stream == null) {
                throw new RuntimeException("Arquivo de palavras nao encontrado!");
            }

            Scanner scanner = new Scanner(stream);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                palavras.add(linha.split(";"));
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void iniciar() {
        Random random = new Random();
        int i = random.nextInt(palavras.size());

        String[] linha = palavras.get(i);

        palavraSorteada = linha[0].toUpperCase();
        dica = linha.length > 1 ? linha[1] : "Sem dica";

        erros = 0;
        acertos = 0;
        historicoSalvo = false;

        letrasDescobertas = new char[palavraSorteada.length()];
        Arrays.fill(letrasDescobertas, '*');
    }

    public String getPalavra() {
        return new String(letrasDescobertas);
    }

    // Retorna a palavra completa
    public String getPalavraCompleta() {
        return palavraSorteada;
    }

    public String getDica() {
        return dica;
    }

    public ArrayList<Integer> getOcorrencias(String letra) throws Exception {

        if (letra == null || letra.length() != 1) {
            throw new Exception("Digite apenas uma letra!");
        }

        char l = letra.toUpperCase().charAt(0);
        ArrayList<Integer> posicoes = new ArrayList<>();

        for (int i = 0; i < palavraSorteada.length(); i++) {
            if (palavraSorteada.charAt(i) == l) {
                posicoes.add(i + 1);

                if (letrasDescobertas[i] == '*') {
                    letrasDescobertas[i] = l;
                    acertos++;
                }
            }
        }

        if (posicoes.isEmpty()) {
            erros++;
        }

        return posicoes;
    }

    public boolean terminou() {
        return erros >= MAX_ERROS || acertos == palavraSorteada.length();
    }

    public String getResultado() {
        if (!terminou()) return "em andamento";

        String resultado = (acertos == palavraSorteada.length()) ? "venceu" : "perdeu";

        if (!historicoSalvo) {
            historico.add(palavraSorteada + " - " + resultado);
            historicoSalvo = true;
        }

        return resultado;
    }

    public int getAcertos() {
        return acertos;
    }

    public int getCodigoPenalidade() {
        return erros;
    }

    public String getNomePenalidade() {
        String[] nomes = {
                "Sem penalidade",
                "Perdeu cabeca",
                "Perdeu tronco",
                "Perdeu primeiro braco",
                "Perdeu segundo braco",
                "Perdeu primeira perna",
                "Perdeu segunda perna" 
                
        };

        return nomes[erros];
    }

    public ArrayList<String> getResultados() {
        return new ArrayList<>(historico);
    }
}