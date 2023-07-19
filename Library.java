import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

// details about members are in the readme.text file
import javax.swing.table.DefaultTableModel;
// catalogue class
 class Book{
private String title ;
private String author;
private String isbn ;
private int year ;
private String publisher ;
private float price ;
private int num_pages ;

    public Book(String title,String author,String isbn ,int year ,String publisher ,float price ,int num_pages ){
   this.title=title;
   this.author=author;
   this.isbn=isbn ;
   this.year=year;
   this.publisher=publisher ;
   this.price=price ;
   this.num_pages=num_pages;
    }
    public Object[] getBookInfor(){
        return  new Object[]{
        this.title,this.author,this.isbn,Integer.toString(this.year),this.publisher,Float.toString(this.price),Integer.toString(this.num_pages)
    };
    }
   
}
 
// book class

    // class that allows the text box to accept only ints
 class NumericDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (Character.isDigit(c)) {
                    sb.append(c);
                }
            }
            super.insertString(fb, offset, sb.toString(), attr);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text == null) {
                super.replace(fb, offset, length, text, attrs);
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (Character.isDigit(c)) {
                    sb.append(c);
                }
            }
            super.replace(fb, offset, length, sb.toString(), attrs);
        }
    }
// creating GUI
public class Library extends JFrame implements ActionListener{
private JTable table;
private JScrollPane scrollPane ;
private DefaultTableModel tableModel;
private JLabel headerLabel,label,titleLabel,authorLabel,isbnLabel,yearLabel,publisherLabel,pagesLabel,priceLabel,addBooksHeader2,addBooksHeader1;
private JPanel westDinamicStatisticsPanel,westPanel,tablePanel,footerLabel,westDinamicSearchBookPanel,pagenavs,centerPanel,centerPanelContainer,westDinamicAddBookPanel,westPanelTop;
private JButton selectButton,btn,btnmore,addBookBtn,btndelete,searchBtn,viewBooks,addBook,searchButton;
private JTextField title,author,isbn,year,publisher, searchField,pages,price;
private int[] selectedRows;
    public Library(String libraryName){
// getContentPane().setBackground(Color.GREEN);
//  setTitle("my window");
 setSize(1370, 775);
//  this.library=new Catalogue();
 this.label=new JLabel("Hello world");
 this.btn =new JButton("Button");
 add(label);
  add(btn);
setLayout(new BorderLayout());
this.headerLabel = new JLabel(libraryName);
this.headerLabel.setFont(new Font("Arial", Font.BOLD, 12));
this.headerLabel.setFont(new Font(getName(), 200, 20));
add(headerLabel, BorderLayout.NORTH);


this.footerLabel = new JPanel();
this.footerLabel.setLayout(new BorderLayout());
this.pagenavs=new JPanel();
this.pagenavs.setLayout(new  BorderLayout());
this.btnmore=new JButton("More");

this.btndelete=new JButton("Delete");
this.btndelete.setBorder(new EmptyBorder(0, 0, 20, 0));
this.btndelete.addActionListener(this);
this.pagenavs.add(btndelete,BorderLayout.SOUTH);
this.footerLabel.add(pagenavs, BorderLayout.SOUTH);
this.footerLabel.add(this.btnmore,BorderLayout.NORTH);
add(footerLabel, BorderLayout.EAST);
// Center region
this.centerPanelContainer=new JPanel();
this.centerPanelContainer.setLayout(new BorderLayout());
this.centerPanel = new JPanel( new BorderLayout());
String[] columnNames = {"Title", "Author", "ISBN", "Year", "PUblisher", "Price", "Pages"};
        this.tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
            this.tableModel.addRow(new Book("intro","kalibwanji","kumawa kwawaaa",1996,"hahaha",737,987).getBookInfor());
        this.scrollPane = new JScrollPane(table);
    this.centerPanel.add(scrollPane,BorderLayout.CENTER);
this.centerPanel.setBackground(new Color(255,255,255));
this.centerPanel.setLayout(new GridLayout(1,12));
centerPanelContainer.add(this.centerPanel,BorderLayout.CENTER);
add(centerPanelContainer, BorderLayout.CENTER);

// West region
this.westPanel = new JPanel();
this.westPanel.setLayout(new BorderLayout());
this.westPanelTop=new JPanel();
this.westPanelTop.setLayout(new FlowLayout());
this.addBook= new JButton("Add book");
this.addBook.addActionListener(this);
this.westPanelTop.add(addBook);
this.searchBtn= new JButton("Search book");
this.searchBtn.addActionListener(this);
this.westPanelTop.add(searchBtn);
this.westPanel.add(westPanelTop,BorderLayout.NORTH);

JLabel website=new JLabel("library.mzuni.ac.mw");
website.setHorizontalAlignment(JLabel.CENTER);
this.westPanel.add(website,BorderLayout.SOUTH);

this.westPanel.setBorder(new EmptyBorder(0, 0, 20, 0)); 

// dinamic components on West region 

this.westDinamicSearchBookPanel =new JPanel();
this.westDinamicSearchBookPanel.setLayout(new GridLayout(8,1));

        this.westDinamicSearchBookPanel.setBorder(BorderFactory.createEmptyBorder(
                10, 10, 10, 10));
 this.searchField = new JTextField();
        this.searchButton = new JButton("Search");
        this.searchButton.addActionListener(this);
JLabel searchHeader=new JLabel("SEARCHING BOOKS");
searchHeader.setHorizontalAlignment(JLabel.CENTER);
this.westDinamicSearchBookPanel.add( searchHeader);
this.westDinamicSearchBookPanel.add( searchField);
this.westDinamicSearchBookPanel.add( searchButton);
this.westDinamicStatisticsPanel=new JPanel();
this.westDinamicStatisticsPanel.add( new JLabel("Total books"));
JLabel total=new JLabel(Integer.toString(table.getRowCount()));
total.setHorizontalAlignment(JLabel.RIGHT);
this.westDinamicStatisticsPanel.add(total );

this.westDinamicStatisticsPanel.setLayout(new GridLayout(1,6));
this.westDinamicSearchBookPanel.add(this.westDinamicStatisticsPanel);
this.westDinamicAddBookPanel =new JPanel();
this.westDinamicAddBookPanel.setLayout(new GridLayout(8,4));
// padding and margin of the components
 int topMargin = 10;
        int leftMargin = 10;
        int bottomMargin = 10;
        int rightMargin = 10;
        this.westDinamicAddBookPanel.setBorder(BorderFactory.createEmptyBorder(
                topMargin, leftMargin, bottomMargin, rightMargin));


this.addBooksHeader1=new JLabel("ADDING BOOKS");
this.addBooksHeader1.setHorizontalAlignment(JLabel.CENTER);
this.addBooksHeader2=new JLabel();

this.westDinamicAddBookPanel.add(this.addBooksHeader1);
this.westDinamicAddBookPanel.add(this.addBooksHeader2);

this.title=new JTextField();
this.titleLabel=new JLabel("Title");

this.westDinamicAddBookPanel.add(this.titleLabel);
this.westDinamicAddBookPanel.add(this.title);
this.author=new JTextField();
this.author.setPreferredSize(new Dimension(100, 15));
this.authorLabel=new JLabel("Author");
this.westDinamicAddBookPanel.add(this.authorLabel);
this.westDinamicAddBookPanel.add(this.author);
this.isbn=new JTextField();
this.isbn.setPreferredSize(new Dimension(100, 15));
this.isbnLabel=new JLabel(" ISBN");
this.westDinamicAddBookPanel.add(this.isbnLabel);
this.westDinamicAddBookPanel.add(this.isbn);
this.year=new JTextField();
((AbstractDocument) this.year.getDocument()).setDocumentFilter(new NumericDocumentFilter());
this.year.setPreferredSize(new Dimension(100, 15));
this.yearLabel=new JLabel("Year");

this.westDinamicAddBookPanel.add(this.yearLabel);
this.westDinamicAddBookPanel.add(this.year);
this.publisher=new JTextField();
this.publisher.setPreferredSize(new Dimension(100, 15));
this.publisherLabel=new JLabel("Publisher");
this.westDinamicAddBookPanel.add(this.publisherLabel);
this.westDinamicAddBookPanel.add(this.publisher);
this.price=new JTextField();
this.price.setPreferredSize(new Dimension(100, 15));
this.priceLabel=new JLabel(" Price (MWK)");
this.westDinamicAddBookPanel.add(this.priceLabel);
this.westDinamicAddBookPanel.add(this.price);

this.pages=new JTextField();
((AbstractDocument) this.pages.getDocument()).setDocumentFilter(new NumericDocumentFilter());
this.pages.setPreferredSize(new Dimension(100, 15));
this.pagesLabel=new JLabel(" No. of Pages");
this.westDinamicAddBookPanel.add(this.pagesLabel);
this.westDinamicAddBookPanel.add(this.pages);


this.westPanel.add(westDinamicSearchBookPanel,BorderLayout.CENTER);
add(this.westPanel,BorderLayout.WEST);
this.addBookBtn=new JButton("Submit");
this.addBookBtn.addActionListener(this);
 setVisible(true);
    }
private Vector getBookInfor(Book book) {
        return null;
    }
public void searchBook() {
this.addBook.setEnabled(true);
this.searchBtn.setEnabled(false);
this.westDinamicSearchBookPanel.setVisible(true);
this.addBookBtn.setVisible(false);
this.westDinamicAddBookPanel.setVisible(false);
this.revalidate();
this.repaint();
}
  
public void submitBook(){
if (!this.title.getText().isEmpty() &&!this.author.getText().isEmpty() && !this.isbn.getText().isEmpty()&& ! this.year.getText().isEmpty()&& ! this.publisher.getText().isEmpty()&& !this.price.getText().isEmpty()&& !this.pages.getText().isEmpty() ) {
  
          Book book=  new Book(this.title.getText(),this.author.getText(),this.isbn.getText(),Integer.parseInt(this.year.getText()),this.publisher.getText(),Float.parseFloat(this.price.getText()),Integer.parseInt(this.pages.getText()));
         this.tableModel.addRow(book.getBookInfor());
           
// this.title.setText("");
// this.author.setText("");
// this.isbn.setText("");
// this.year.setText("");
// this.publisher.setText("");
// this.price.setText("");
// this.pages.setText("");
        

// Book book =new Book(this.title.getText(),this.author.getText(),this.isbn.getText(),Integer.parseInt(this.year.getText()),this.publisher.getText(),Float.parseFloat(this.price.getText()),Integer.parseInt(this.pages.getText()));
// if(library.add_book(book)){
JOptionPane.showMessageDialog(this, "You have successfully added a new book to the libary" );
this.title.setText("");
this.author.setText("");
this.isbn.setText("");
this.year.setText("");
this.publisher.setText("");
this.price.setText("");
this.pages.setText("");
        } 
}
// action handler for our buttons
@Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() instanceof JButton){
        if(e.paramString().contains("Add book")){
this.westPanel.add(westDinamicAddBookPanel, BorderLayout.CENTER);
this.westPanel.add(addBookBtn, BorderLayout.SOUTH);
this.westDinamicSearchBookPanel.setVisible(false);
this.addBookBtn.setVisible(true);
this.addBook.setEnabled(false);
this.searchBtn.setEnabled(true);
this.westDinamicAddBookPanel.setVisible(true);
this.revalidate();
        }
      else if(e.paramString().contains("Search book")){
        
this.searchBook();
         }
         else if(e.paramString().contains("Search")){
        
performSearch();
this.revalidate();
this.repaint();
         }
        else if(e.paramString().contains("Submit")){
submitBook();
        
}
        
    else if(e.paramString().contains("Delete")){
        
        int choice = showYesNoDialog(this, "Proceed deleting books?");
            if (choice == JOptionPane.YES_OPTION) {
                this.selectedRows = this.table.getSelectedRows();
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                this.tableModel.removeRow(this.selectedRows[i]);
            } 
                JOptionPane.showMessageDialog(this, "You deleted "+this.selectedRows.length+ " books.");
            } else if (choice == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Deletion canceled");
            }
            this.revalidate();
this.repaint();
        
    }
       }
    }


     private  int showYesNoDialog(JFrame frame, String message) {
        Object[] options = {"Yes", "No"};
        return JOptionPane.showOptionDialog(frame, message, "Yes/No Dialog",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }
    private void performSearch() {
        String searchText = searchField.getText().toLowerCase();

        ArrayList<Integer> matchingRows = new ArrayList<>();

        // Search through each row of the table
        for (int row = 0; row < table.getRowCount(); row++) {
            // Search through each column of the current row
            for (int col = 0; col < table.getColumnCount(); col++) {
                Object cellValue = table.getValueAt(row, col);
                if (cellValue != null && cellValue.toString().toLowerCase().contains(searchText)) {
                    matchingRows.add(row);
                    break; // Break out of inner loop if a match is found in any column
                }
            }
        }

        // Select the matching rows in the table
        this.selectedRows = matchingRows.stream().mapToInt(Integer::intValue).toArray();
        table.getSelectionModel().setSelectionInterval(0, 0); // Deselect all rows
        table.getSelectionModel().setSelectionInterval(this.selectedRows[0], this.selectedRows[this.selectedRows.length - 1]);
    }
    public static void main(String[] args) {
       new Library("MZUZU UNIVERSITY LIBRARY");
       
    }   
}