import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BCController implements Initializable {
    @FXML
    public TableColumn <Book,Integer> idcollumn;
    @FXML
    private TableView<Book> tableinfo;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> writerColumn;

    @FXML
    private TableColumn<Book, Integer> pagesColumn;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        idcollumn.setCellValueFactory(cellData->cellData.getValue().idProperty().asObject());
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        writerColumn.setCellValueFactory(cellData -> cellData.getValue().writerProperty());
        pagesColumn.setCellValueFactory(cellData -> cellData.getValue().pagesProperty().asObject());


        // Parse XML and populate TableView
        xmlParser parser = new xmlParser();
        try {
            List<Book> books = parser.parseXML();
            tableinfo.getItems().addAll(books);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
