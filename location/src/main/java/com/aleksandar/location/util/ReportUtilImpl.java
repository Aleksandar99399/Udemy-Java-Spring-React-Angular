package com.aleksandar.location.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Component
public class ReportUtilImpl implements ReportUtil {
    @Override
    public void generatePieChart(String path, List<Object[]> data) {
        DefaultPieDataset dataset = new DefaultPieDataset();

        for (Object[] object : data) {
            dataset.setValue(object[0].toString(),new Double(object[1].toString()));
        }

        JFreeChart chart = ChartFactory.createPieChart3D("Location Type Report", dataset,true,true,true);
        try {
            ChartUtilities.saveChartAsJPEG(new File(path+"/pieChart.jpeg"),chart,300,300);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
