package sample;

import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Click
{
    public void Glow(MouseEvent mouseEvent) {  Glow G = new Glow(0.75);((ImageView) mouseEvent.getSource()).setEffect(G); }
    public void RemoveGlow(MouseEvent mouseEvent) { InnerShadow IS = new InnerShadow();((ImageView) mouseEvent.getSource()).setEffect(IS);}
}
