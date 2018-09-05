import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.Time;
import java.time.Duration;

import static javax.print.attribute.standard.MediaSizeName.B;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){




       primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.setTitle("SUPER TURBO MEGA MEGA CLICKER");
        primaryStage.setResizable(false);
        primaryStage.show();

        Group groupe= createGroup();
        primaryStage.setScene(new Scene(groupe));
        primaryStage.show();

    }
    public Group createGroup(){
        final int cout[]=new int[1];
        final int ristourne[]=new int[1];
        ristourne[0]=0;
        cout[0]=50;
        final boolean bloque[]=new boolean[2];
        bloque[0]=true;
        final int multiplicateur[]=new int[1];
        multiplicateur[0]=1;
        Label texte = new Label("Nombre de clics :");
        Label clics = new Label("0");
        Button bouton= new Button("Aweille, clique moi dessus");
        Button boostclick= new Button("Puissance pointeur "+multiplicateur[0]);
        Button nipple = new Button("Coût d'amélioration moindre "+ cout[0]);
        Button pinknipple= new Button("Ristourne Bloquée " );
        Button ligma=new Button("Débloquer ristourne 200pts");
        Button ohmygod=new Button("Mode Flamboyant!!!!");

        final int pointageinitial[]=new int [1];
        final int pointagefinal[]=new int[1];

        multiplicateur[0]=1;
        texte.setScaleY(3);
        texte.setTranslateY(10);
        clics.setScaleY(3);
        clics.setTranslateX(100);
        clics.setTranslateY(10);
        bouton.setTranslateY(300);
        bouton.setTranslateX(100);
        bouton.setOnAction(event ->{
            pointageinitial[0]=pointageinitial[0]+multiplicateur[0];
            pointagefinal[0]=pointageinitial[0];
            clics.setText(""+pointagefinal[0]);});

            boostclick.setTranslateY(20);
            boostclick.setTranslateX(200);

            boostclick.setOnAction(event->{
                if(pointagefinal[0]>=cout[0]*multiplicateur[0]){

                pointagefinal[0]=pointagefinal[0]-(multiplicateur[0]*cout[0])+ristourne[0];
                multiplicateur[0]=multiplicateur[0]+1;
                clics.setText(""+pointagefinal[0]);
                boostclick.setText("Puissance pointeur "+multiplicateur[0]);
                pointageinitial[0]=pointagefinal[0];
            }});
        nipple.setTranslateY(60);
        nipple.setTranslateX(200);

        nipple.setOnAction(event->{
            if(pointagefinal[0]>=multiplicateur[0]*cout[0]){
            pointagefinal[0]=pointagefinal[0]-(multiplicateur[0]*cout[0])+ristourne[0];
            cout[0]=cout[0]-5;
            clics.setText(""+pointagefinal[0]);
            nipple.setText("Coût d'amélioration moindre "+ cout[0]);}
            pointageinitial[0]=pointagefinal[0];

        });
        pinknipple.setTranslateY(100);
        pinknipple.setTranslateX(200);
        pinknipple.setOnAction(event -> {
            if(pointagefinal[0]>=cout[0]&&bloque[0]==false)
            {
                ristourne[0]=ristourne[0]+5;
                pointagefinal[0]=pointagefinal[0]-cout[0];
                pointageinitial[0]=pointagefinal[0];
                pinknipple.setText("Ristourne" +ristourne[0]);
            }
        });
        ligma.setTranslateY(140);
        ligma.setTranslateX(200);
        ligma.setOnAction(event -> {
            if(bloque[0]==true&&pointagefinal[0]>200)
            {
                bloque[0]=false;
                pointagefinal[0]=pointagefinal[0]-200;
                pointageinitial[0]=pointagefinal[0];
                ligma.setText("Ristourne Débloquée!!!");
                pinknipple.setText("Ristourne" + ristourne[0]);
            }});
        ohmygod.setTranslateY(180);
        ohmygod.setTranslateX(200);
        ohmygod.setOnAction(event1 -> {
            ohmygod.setTextFill(Color.BLUEVIOLET);
            boostclick.setTextFill(Color.DARKCYAN);
            pinknipple.setTextFill(Color.DARKGOLDENROD);
            nipple.setTextFill(Color.DARKGREEN);
            ligma.setTextFill(Color.BROWN);
            clics.setTextFill(Color.CRIMSON);
            bouton.setTextFill(Color.GREEN);
            texte.setTextFill(Color.INDIANRED);
        });


        return  new Group(texte, clics, bouton,boostclick,nipple,pinknipple,ligma,ohmygod);

    }
}






