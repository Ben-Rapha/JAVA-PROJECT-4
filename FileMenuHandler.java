
package project4;

/**
 *
 * @author KINGSLEY OTTO
 */
import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.util.Map;
import java.util.TreeMap;



/**
 *
 * @author KINGSLEY OTTO
 */
  public class FileMenuHandler implements ActionListener {
    JFrame jframe;
   public FileMenuHandler (JFrame jf) {
      jframe = jf;
   }
    @Override
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      if (menuName.equals("Open"))
         openFile();
      else if (menuName.equals("Quit"))
         System.exit(0);
   } //ACTION PERFORMED
   
   private void openFile() {
       int status;
       JFileChooser chooser = new JFileChooser();
       status = chooser.showOpenDialog(null);
       readSource(chooser.getSelectedFile());
   }
   
   private void readSource(File chosenFile) {
       TreeMap <Date212, Integer> treeMap = new TreeMap (new DateComparator());
       SortedDateList linkedList1 = new SortedDateList();
     //  UnsortedDateList linkedList2 = new UnsortedDateList();
       String chosenFileName = chosenFile.getName();
       File file;
       Container myContentPane = jframe.getContentPane();
       TextArea LeftSide = new TextArea();
       TextArea RightSide = new TextArea();
       myContentPane.add(LeftSide);
       myContentPane.add(RightSide);
       int count = 0;
       String inStr = "";
       
       Scanner filereader;
       try {
           file = new File(chosenFileName);
           filereader = new Scanner(file);
           
           while (filereader.hasNextLine()) {
               String line = filereader.nextLine();
               StringTokenizer tokens = new StringTokenizer(line, ",");
               while (tokens.hasMoreTokens()){
                    inStr = tokens.nextToken();
                   if (isValidDate(inStr)){                   
                       Date212 date = new Date212(inStr);
                       treeMap.put(date, count);
                       count++;
 
                       linkedList1.add(date);
                      // linkedList2.add(date);
                      
                   }else {
                        // System.out.println(inStr + " is not a date");
                          throw new IllegalDate212Exception (inStr +" is not a date ");
                       }
                    }
              //System.out.println(treeMap);
             }
             filereader.close();
          
        } catch (Exception e){
               System.out.println(  e.getLocalizedMessage());
               } 
       RightSide.append("ADDED DATES (SORTED) " + "\n");
       LeftSide.append("ADDED DATES (UNSORTED) " + "\n");
       LeftSide.append("\n");
       LeftSide.append(linkedList1.toString());
       jframe.setVisible(true);  
        
       for (Map.Entry me : treeMap.entrySet()){
           RightSide.append("\n" + me.getKey().toString());
           //System.out.println(me.getKey());
          
       }
       
        
   }


        
    private static boolean isValidDate(String date) {    //check if dates in txt is valid 
        if (date == null || date.isEmpty() || date.length() != 8)
            return false; //RETURN FALSE IF DATE IS NULL , EMPTY OR LENGTH IS NOT EQUAL TO 8

      
        for (int i = 0; i < date.length(); i++)
            if(!Character.isDigit(date.charAt(i)))
                return false;// RETURN FALSE IF DATE LIST CONTAINS NON DIGIT
       
        return true; //RETURN TRUE IF NO TEST FAILS.
        }// ISVALIDDATE
    }

    

