import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


    public class Book {
        private final SimpleStringProperty title;
        private final SimpleStringProperty writer;
        private final SimpleIntegerProperty pages;
        private final SimpleIntegerProperty id;

        public Book(int id, String title, String writer, int pages) {
            this.title = new SimpleStringProperty(title);
            this.writer = new SimpleStringProperty(writer);
            this.pages = new SimpleIntegerProperty(pages);
            this.id=new SimpleIntegerProperty(id);
        }

        public String getTitle() {
            return title.get();
        }

        public SimpleStringProperty titleProperty() {
            return title;
        }
        public SimpleIntegerProperty idProperty(){
            return id;
        }

        public String getWriter() {
            return writer.get();
        }

        public SimpleStringProperty writerProperty() {
            return writer;
        }

        public int getPages() {
            return pages.get();
        }

        public SimpleIntegerProperty pagesProperty() {
            return pages;
        }
    }


