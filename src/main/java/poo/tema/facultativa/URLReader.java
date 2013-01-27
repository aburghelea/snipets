package poo.tema.facultativa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Alexandru Burghelea
 * Date: 12/13/12
 * Time: 4:18 PM
 */
public class URLReader {
    /* %s in String este asemanator cu %s din C. String.format("TEMPLATE", parametru1,parametru2, ...)
     * este asemanator cu printf("TEMPLATE", parametru1, parametru 2....)
      */
    private static final String SEARCH_TEMPLATE = "http://services.tvrage.com/feeds/search.php?show=%s";


    public static void main(String[] args) {
        URLReader urlReader = new URLReader();
        List<String> lines = urlReader.start("buff");

        for (String line : lines) {
            System.out.println(line);
        }
    }

    /**
     * Aduce toate liniile din XML-ul TvRage care cauta
     * shourile dupa nume.
     *
     * @param show Numele shoului cautat
     * @return O lista de linii.
     */
    private List<String> start(String show) {
        List<String> lines = null;
        try {
            URL showURL = new URL(String.format(SEARCH_TEMPLATE, show));
            // Se deschide conexiunea de la URL-ul specificat.
            HttpURLConnection connection = (HttpURLConnection) showURL.openConnection();
            lines = readFromConnection(connection);

        } catch (MalformedURLException e) {
            System.err.println("URL prost formatat:  " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Nu s-a putut deschide o conexiune cu linkul dorit");
        }

        return lines;
    }

    /**
     * Intoarce liniile pe care le poate citi de la o conexiune deja stabilita
     *
     * @param connection Conexiunea Http
     * @return Lista de stringuri. Fiecare string reprezinta o linie.
     * @throws IOException daca ne poate optine fluxul de intrare de la conexiune
     */
    private List<String> readFromConnection(HttpURLConnection connection) throws IOException {
        // Se obtine input stream-ul asociat conexiunii
        InputStream urlInputStream = connection.getInputStream();

        InputStreamReader urlInputReader = new InputStreamReader(urlInputStream);
        BufferedReader connectionReader = new BufferedReader(urlInputReader);

        List<String> lines = new LinkedList<String>();
        String line;

        while ((line = connectionReader.readLine()) != null) {
            lines.add(line);
        }

        return lines;
    }
}
