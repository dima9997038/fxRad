package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Controller {
    @FXML
    public ListView<Isotop> listView1;
    @FXML
    private ComboBox<String> listIsotop;
    @FXML
    private TextField weight;


    public ArrayList<Isotop> list =new ArrayList();
    public ArrayList<Isotop> list_choised =new ArrayList();
    public ObservableList<Isotop> wordsList = FXCollections.observableArrayList();

    public Stage stage;


    public void initialize(){



        Isotop polonium210 = new Isotop("Polonium 210", (float) 138.0, "day",0.0,(float)208.98);
        list.add(polonium210);
        Isotop iodine131=new Isotop("Iodine 131", (float) 8.0, "day",0.0,(float)130.9);
        list.add(iodine131);
        Isotop gadolinium153=new Isotop("Gadolinium 153", (float) 240.0,"day",0.0,(float)157.25);
        list.add(gadolinium153);
        Isotop tritinium=new Isotop("Tritinum H3", (float) 12.3,"year",0.0,(float)3.016);
        list.add(tritinium);
        Isotop fluorine18 = new Isotop("Fluorine 18", (float) 0.92, "hour",0.0,(float)18.0);
        list.add(fluorine18);
        Isotop cobalt60 = new Isotop("Cobalt 60", (float) 5.3, "year",0.0,(float)59.933);
        list.add(cobalt60);
        Isotop strontium90 = new Isotop("Strontium 90", (float) 28.8, "year",0.0,(float)89.907);
        list.add(strontium90);
        Isotop technetium99 = new Isotop("Technetium 99", (float) 6.0, "hour",0.0,(float)98.906);
        list.add(technetium99);
        Isotop xenon135 = new Isotop("Xenon 135", (float) 9.1, "hour",0.0,(float)131.293);
        list.add(xenon135);
        Isotop caesium137 = new Isotop("Caesium 137", (float) 30.2, "year",0.0,(float)136.9);
        list.add(caesium137);
        Isotop radon222 = new Isotop("Radon 222", (float) 3.8, "day",0.0,(float)222.017);
        list.add(radon222);
        Isotop plutonium238 = new Isotop("Plutonium 238", (float) 87.7, "year",0.0,(float)238.049);
        list.add(plutonium238);
        Isotop americium241 = new Isotop("Americium 241", (float) 432, "year",0.0,(float)241.056);
        list.add(americium241);
        Isotop californium252 = new Isotop("Californium 252", (float) 2.64, "year",0.0,(float)251.0796);
        list.add(californium252);
        Isotop caesium134 = new Isotop("Caesium 134", (float) 2.0, "year",0.0,(float)133.9067);
        list.add(caesium134);

        ArrayList <String> nameIsot =new ArrayList<>();

        for(Iterator <Isotop> s = list.iterator(); s.hasNext(); ) {
            String item = s.next().getName();
            nameIsot.add(item);
        }
         ObservableList<String> listNameIsotop= FXCollections.observableList(nameIsot);
        listIsotop.getItems().addAll(listNameIsotop);



//        list_choised.add(polonium210);
//        list_choised.add(iodine131);
//        ObservableList<Isotop> choised_list= FXCollections.observableArrayList(list_choised);
//
//        listView = new ListView<Isotop>(choised_list);
//        ObservableList<String> wordsList = FXCollections.observableArrayList("First word","Second word", "Third word", "Etc.");
//        listView = new ListView<>(wordsList);

    }

    public void Click(ActionEvent actionEvent)  throws Exception{

        String min_interval="year";
        for(Iterator <Isotop> s = wordsList.iterator(); s.hasNext(); ) {
            Isotop nextIsot1=s.next();
            if (nextIsot1.getInterval().equals("day"))
                min_interval="day";
        }
        for(Iterator <Isotop> s = wordsList.iterator(); s.hasNext(); ) {
            Isotop nextIsot1=s.next();
            if (nextIsot1.getInterval().equals("hour"))
                min_interval="hour";
        }
        if (min_interval.equals("day")){
            for(Iterator <Isotop> s = wordsList.iterator(); s.hasNext(); ) {
                Isotop nextIsot1=s.next();
                if (nextIsot1.getInterval().equals("year")){
                    nextIsot1.setInterval("day");
                    nextIsot1.setHalf_life(nextIsot1.getHalf_life()*365);
                }

            }
        }
        if (min_interval.equals("hour")){
            for(Iterator <Isotop> s = wordsList.iterator(); s.hasNext(); ) {
                Isotop nextIsot1=s.next();
                if (nextIsot1.getInterval().equals("year")){
                    nextIsot1.setInterval("hour");
                    nextIsot1.setHalf_life(nextIsot1.getHalf_life()*365*24);
                }
                if (nextIsot1.getInterval().equals("day")){
                    nextIsot1.setInterval("hour");
                    nextIsot1.setHalf_life(nextIsot1.getHalf_life()*24);
                }
            }
        }


        double n=-1;
        double n_start=n;
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);
        Scene scene  = new Scene(lineChart,800,600);
        try {
            n=Integer.parseInt(weight.getText());
        }
        catch (Exception e){
            System.out.println("Not number");

        }
        String output = listIsotop.getSelectionModel().getSelectedItem().toString();
        System.out.println(output);
         Float life=(float)-1.0;
         String interval="";

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("a.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            lineChart.setTitle("Life of Isotop");


            for(Iterator <Isotop> s = wordsList.iterator(); s.hasNext(); ) {
                XYChart.Series series = new XYChart.Series();
                Isotop nextIsot=s.next();
                output=nextIsot.getName();

                life=nextIsot.getHalf_life();
                interval=nextIsot.getInterval();
                n_start=(nextIsot.getKg()* 6.02)/nextIsot.getMol();
                n=n_start;

                series.setName(output);
                xAxis.setLabel("Number of " + interval );

                for (float t = 1; n >n_start/50 ; t=t+1) {
                    series.getData().add(new XYChart.Data(t, n));
                    n=n_start*Math.pow( 2,-1*t/life);
                }
                lineChart.getData().add(series);
            }


            stage = new Stage();
            stage.setScene(new Scene(root1));


            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }


        System.out.println(n);
    }

    public void Add(ActionEvent actionEvent) {
        String output = listIsotop.getSelectionModel().getSelectedItem().toString();

        for(Iterator <Isotop> s = list.iterator(); s.hasNext(); ) {
            Isotop Isot=s.next();
            if (Isot.getName().equals(output)){
                if(!wordsList.contains(Isot))
                {
                    Isot.setKg(Double.parseDouble(weight.getText()));
                    wordsList.add(Isot);
                listView1.getItems().clear();
            listView1.getItems().addAll(wordsList);
                }
            }
        }


    }
}
