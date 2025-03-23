package ProSale.controller;

import ProSale.AppLaunch;
import ProSale.model.order.Order;
import ProSale.model.order.OrderItem;
import ProSale.model.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.util.Pair;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import ProSale.model.product.*;

public class ThongKeController implements Initializable {
    @FXML
    ComboBox<String> comboboxTieuChi;
    @FXML
    LineChart lineChartDoanhThu;
    @FXML
    Button btnTatCa, btnBanPhan, btnGhe, btnGuong, btnTuGiay, btnTuDauGiuong;

    List<Order> listOrder;

    public void setTatCaOrder() {
        listOrder = new ArrayList<>(AppLaunch.server.getOrderList());
    }
    public void setBanPhanOrder(){
        listOrder = new ArrayList<>();
        for(Order order : AppLaunch.server.getOrderList()){
            Product product = AppLaunch.server.getProductMap().get(order.getOrderID());
            if (product instanceof BanPhan)
                    listOrder.add(order);
        }
    }

    public void setGheOrder(){
        listOrder = new ArrayList<>();
        for(Order order : AppLaunch.server.getOrderList()){
            Product product = AppLaunch.server.getProductMap().get(order.getOrderID());
            if (product instanceof Ghe)
                listOrder.add(order);
        }
    }

    public void setGuongOrder(){
        listOrder = new ArrayList<>();
        for(Order order : AppLaunch.server.getOrderList()){
            Product product = AppLaunch.server.getProductMap().get(order.getOrderID());
            if (product instanceof Guong)
                listOrder.add(order);
        }
    }

    public void setTuGiayOrder(){
        listOrder = new ArrayList<>();
        for(Order order : AppLaunch.server.getOrderList()){
            Product product = AppLaunch.server.getProductMap().get(order.getOrderID());
            if (product instanceof TuGiay)
                listOrder.add(order);
        }
    }

    public void setTuDauGiuongOrder(){
        listOrder = new ArrayList<>();
        for(Order order : AppLaunch.server.getOrderList()){
            Product product = AppLaunch.server.getProductMap().get(order.getOrderID());
            if (product instanceof TuDauGiuong)
                listOrder.add(order);
        }
    }

    public void btnTatCaOnAction(ActionEvent actionEvent) {
        setTatCaOrder();
        series.setName("Doanh thu tất cả " + comboboxTieuChi.getValue());
        if (comboboxTieuChi.getValue().equals("1 tuần qua"))
            setLineChartDoanhThuOneWeek();
        else if (comboboxTieuChi.getValue().equals("1 tháng qua"))
            setLineChartDoanhThuOneMonth();
    }
    public void btnBanPhanOnAction(ActionEvent actionEvent) {
        series.setName("Doanh thu bàn phấn " + comboboxTieuChi.getValue());
        setBanPhanOrder();
        if (comboboxTieuChi.getValue().equals("1 tuần qua"))
            setLineChartDoanhThuOneWeek();
        else if (comboboxTieuChi.getValue().equals("1 tháng qua"))
            setLineChartDoanhThuOneMonth();
    }
    public void btnGheOnAction(ActionEvent actionEvent) {
        series.setName("Doanh thu ghế " + comboboxTieuChi.getValue());
        setGheOrder();
        if (comboboxTieuChi.getValue().equals("1 tuần qua"))
            setLineChartDoanhThuOneWeek();
        else if (comboboxTieuChi.getValue().equals("1 tháng qua"))
            setLineChartDoanhThuOneMonth();
    }
    public void btnGuongOnAction(ActionEvent actionEvent) {
        series.setName("Doanh thu gương" + comboboxTieuChi.getValue());
        setGuongOrder();
        if (comboboxTieuChi.getValue().equals("1 tuần qua"))
            setLineChartDoanhThuOneWeek();
        else if (comboboxTieuChi.getValue().equals("1 tháng qua"))
            setLineChartDoanhThuOneMonth();
    }
    public void btnTuGiayOnAction(ActionEvent actionEvent) {
        series.setName("Doanh thu tủ giày" + comboboxTieuChi.getValue());
        setTuGiayOrder();
        if (comboboxTieuChi.getValue().equals("1 tuần qua"))
            setLineChartDoanhThuOneWeek();
        else if (comboboxTieuChi.getValue().equals("1 tháng qua"))
            setLineChartDoanhThuOneMonth();
    }
    public void btnTuDauGiuongOnAction(ActionEvent actionEvent) {
        series.setName("Doanh thu tủ đầu giường " + comboboxTieuChi.getValue());
        setTuDauGiuongOrder();
        if (comboboxTieuChi.getValue().equals("1 tuần qua"))
            setLineChartDoanhThuOneWeek();
        else if (comboboxTieuChi.getValue().equals("1 tháng qua"))
            setLineChartDoanhThuOneMonth();
    }


    public void comboboxTieuChiOnAction(ActionEvent event) {
        String tieuChi = comboboxTieuChi.getValue();
//        if (tieuChi.equals("1 tuần qua")) setLineChartDoanhThuOneWeek();
//        else if (tieuChi.equals("1 tháng qua")) setLineChartDoanhThuOneMonth();
    }



    XYChart.Series<String, Number> series = new XYChart.Series<>();
    public void setLineChartDoanhThuOneWeek(){
        series.getData().clear();
//        lineChartDoanhThu.getData().clear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
        Map<String,Integer> map = new HashMap<>();
        LocalDate today = LocalDate.now();
        LocalDate oneWeekAgo = LocalDate.now().minusDays(6);
        for(int i = 6; i >= 0; i--)
        {
            LocalDate date = today.minusDays(i);
            String dateString = date.format(formatter);
            map.put(dateString, 0);
        }
        for(Order order : listOrder){
            LocalDate date = order.getOrderDate().toLocalDate();
            String dateString = date.format(formatter);
            if (map.containsKey(dateString)){
                map.put(dateString, map.get(dateString) + order.getTotalPrice());
            }
        }
//        for(Map.Entry<String,Integer> entry : map.entrySet()){
//            series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
            for(int i = 6; i >= 0; i--)
            {
                LocalDate date = today.minusDays(i);
                String dateString = date.format(formatter);
                series.getData().add(new XYChart.Data<>(dateString, map.get(dateString)));
            }
            lineChartDoanhThu.getData().addAll(series);
        }

    public void setLineChartDoanhThuOneMonth(){
        series.getData().clear();
//        lineChartDoanhThu.getData().clear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
        Map<String,Integer> map = new HashMap<>();
        LocalDate today = LocalDate.now();
        LocalDate oneMonthAgo = LocalDate.now().minusDays(30);
        for(int i = 30; i >= 0; i--)
        {
            LocalDate date = today.minusDays(i);
            String dateString = date.format(formatter);
            map.put(dateString, 0);
        }
        for(Order order : listOrder){
            LocalDate date = order.getOrderDate().toLocalDate();
            String dateString = date.format(formatter);
            if (map.containsKey(dateString)){
                map.put(dateString, map.get(dateString) + order.getTotalPrice());
            }
        }

        for(int i = 30; i >= 0; i--)
        {
            LocalDate date = today.minusDays(i);
            String dateString = date.format(formatter);
            series.getData().add(new XYChart.Data<>(dateString, map.get(dateString)));
        }
        lineChartDoanhThu.getData().addAll(series);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboboxTieuChi.getItems().add("1 tuần qua");
        comboboxTieuChi.getItems().add("1 tháng qua");
        comboboxTieuChi.getItems().add("1 năm qua");
        comboboxTieuChi.setValue(comboboxTieuChi.getItems().get(0));
    }
}
