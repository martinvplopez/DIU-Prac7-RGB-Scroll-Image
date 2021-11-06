
package com.mycompany.practica7diu;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import org.opencv.core.Core;
import static org.opencv.core.Core.mean;
import static org.opencv.core.Core.minMaxLoc;
import static org.opencv.core.Core.split;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;

/**
 *
 * @author marti
 */
public class AnalizadorRGB {
    
    public final int AZUL = 0;
    public final int VERDE = 1;
    public final int ROJO = 2;

    private final int[] Componentes = {ROJO, VERDE, AZUL};

    private int maximo[] = new int[3];
    private int minimo[] = new int[3];
    private int promedio[] = new int[3];

    public int[] getMaximo() {
        return maximo;
    }

    public int[] getMinimo() {
        return minimo;
    }

    public int[] getPromedio() {
        return promedio;
    }

    public void calculaEstadisticas(Mat imagenColor, Point esqSupIzda,
            Dimension dimVista) {

        Mat subimagen = new Mat(imagenColor, new Rect(esqSupIzda.x, esqSupIzda.y,
                dimVista.width, dimVista.height));

        ArrayList<Mat> bgr = new ArrayList<>();
        split(subimagen, bgr);
 
        AnalizadorRGB res = new AnalizadorRGB();

        for (int c : res.Componentes) {
            Core.MinMaxLocResult minmax = minMaxLoc(bgr.get(c));
            Scalar prom_scalar = mean(bgr.get(c));

            this.maximo[c] = (int) minmax.maxVal;
            this.minimo[c] = (int) minmax.minVal;
            this.promedio[c] = (int) prom_scalar.val[0];
        }
    }
    
    
}
