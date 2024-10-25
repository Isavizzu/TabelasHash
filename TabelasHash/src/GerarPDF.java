import java.awt.*;
import java.awt.print.*;
import javax.swing.*;

public class GerarPDF implements Printable {
    private String text;
    private String[] textSeparate;

    public GerarPDF(String report){
        this.text = report;
        SeparateText();
    }

    public void SeparateText(){
        String[] divided = text.split("\n");
        textSeparate = divided;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        int y = 50;

        for(int i = 0; i < textSeparate.length - 1; i++){
            g.drawString(textSeparate[i], 50, y);
            y += 20;
        }
        return PAGE_EXISTS;
    }

    
}
