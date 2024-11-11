import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Property {

    public static void generateFile() {
        try {
            File file = new File("property.html");
            BufferedWriter bw =new BufferedWriter(new FileWriter(file));

            // HTML Head
            bw.write("<html>\n <head>\n <meta charset=\"UTF-8\" />\n");
            bw.write("<style>\n table { border-collapse: collapse; width: 100%; } \n th, td { border : solid 1px #000; }\n </style>\n");
            bw.write("</head>\n");

            // HTML body
            bw.write("<body>\n <h1>자바 환경정보</h1>\n");
            bw.write("<table>\n <tr>\n <th>키</th>\n <th>값</th>\n </tr>\n");

            for (Object k : System.getProperties().keySet()) {
                String key = k.toString();
                String value = System.getProperty(key);

                bw.write("<tr>\n <td>" + key + "</td>\n <td>" + value + "</td>\n </tr>\n");
            }

            bw.write("</table>\n </body>\n </html>");

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generateFile();
    }
}