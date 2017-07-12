
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Yhdistin {
    
    public WritableImage vaalein(final ArrayList<Image> kuvat) {
        int leveys = (int) kuvat.get(0).getWidth();
        int korkeus = (int) kuvat.get(0).getHeight();
        
        WritableImage kuva = new WritableImage(leveys, korkeus);
        PixelWriter kuvanKirjoittaja = kuva.getPixelWriter();
        
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                
                ArrayList<Color> varitPikselissa = kuvienVaritPikselissa(kuvat, x, y);
                double vaaleinPunainen = 0.0;
                double vaaleinVihrea = 0.0;
                double vaaleinSininen = 0.0;
                
                for (int i = 0; i < varitPikselissa.size(); i++) {
                    Color vari = varitPikselissa.get(i);
                    
                    if (vari.getRed() > vaaleinPunainen) {
                        vaaleinPunainen = vari.getRed();
                    }
                    
                    if (vari.getGreen() > vaaleinVihrea) {
                        vaaleinVihrea = vari.getGreen();
                    }
                    
                    if (vari.getBlue() > vaaleinSininen) {
                        vaaleinSininen = vari.getBlue();
                    }
                }
                
                kuvanKirjoittaja.setColor(x, y, Color.color(vaaleinPunainen, vaaleinVihrea, vaaleinSininen));
            }
        }
        
        return kuva;
    }
    
    public WritableImage tummin(final ArrayList<Image> kuvat) {
        int leveys = (int) kuvat.get(0).getWidth();
        int korkeus = (int) kuvat.get(0).getHeight();
        
        WritableImage kuva = new WritableImage(leveys, korkeus);
        PixelWriter kuvanKirjoittaja = kuva.getPixelWriter();
        
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                
                ArrayList<Color> varitPikselissa = kuvienVaritPikselissa(kuvat, x, y);
                double tumminPunainen = 255.0;
                double tumminVihrea = 255.0;
                double tumminSininen = 255.0;
                
                for (int i = 0; i < varitPikselissa.size(); i++) {
                    Color vari = varitPikselissa.get(i);
                    
                    if (vari.getRed() < tumminPunainen) {
                        tumminPunainen = vari.getRed();
                    }
                    
                    if (vari.getGreen() < tumminVihrea) {
                        tumminVihrea = vari.getGreen();
                    }
                    
                    if (vari.getBlue() < tumminSininen) {
                        tumminSininen = vari.getBlue();
                    }
                }
                
                kuvanKirjoittaja.setColor(x, y, Color.color(tumminPunainen, tumminVihrea, tumminSininen));
            }
        }
        
        return kuva;

    }
    
    public WritableImage mediaani(final ArrayList<Image> kuvat) {
    	
        int leveys = (int) kuvat.get(0).getWidth();
        int korkeus = (int) kuvat.get(0).getHeight();
        
        WritableImage kuva = new WritableImage(leveys, korkeus);
        PixelWriter kuvanKirjoittaja = kuva.getPixelWriter();
        
        for (int y = 0; y < korkeus; y++) {
        	
            for (int x = 0; x < leveys; x++) {
                
                ArrayList<Color> varitPikselissa = kuvienVaritPikselissa(kuvat, x, y);
                
                ArrayList<Double> mediaaniPunaiset = new ArrayList<Double>();
                ArrayList<Double> mediaaniSiniset = new ArrayList<Double>();
                ArrayList<Double> mediaaniVihreat = new ArrayList<Double>();
                
                double mediaaniPunainen = 0;
                double mediaaniVihrea = 0;
                double mediaaniSininen = 0;
                
                for (int i = 0; i < varitPikselissa.size(); i++) {
                    Color vari = varitPikselissa.get(i);
                    
                    mediaaniPunaiset.add(vari.getRed());
                    mediaaniSiniset.add(vari.getBlue());
                    mediaaniVihreat.add(vari.getGreen());
                }
                
                Collections.sort(mediaaniPunaiset);
                Collections.sort(mediaaniSiniset);
                Collections.sort(mediaaniVihreat);
                
                mediaaniPunainen = mediaaniPunaiset.get(mediaaniPunaiset.size() / 2);
                mediaaniSininen = mediaaniSiniset.get(mediaaniSiniset.size() / 2);
                mediaaniVihrea = mediaaniVihreat.get(mediaaniVihreat.size() / 2);
                
                kuvanKirjoittaja.setColor(x, y, Color.color(mediaaniPunainen, mediaaniVihrea, mediaaniSininen));
                
            }
            
        }
        return kuva;

    }
    
    public ArrayList<Color> kuvienVaritPikselissa(ArrayList<Image> kuvat, int x, int y) {
        return kuvat.stream().map(k -> k.getPixelReader().getColor(x, y)).collect(Collectors.toCollection(ArrayList::new));
    }
    
}
