import { useEffect, useState } from "react";
import { getTopicAccuracy } from "../../services/api";
import { Bar } from "react-chartjs-2";
import "./Analytics.css"
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
} from "chart.js";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

function Analytics() {
  const [chartData, setChartData] = useState({});

  useEffect(() => {
    getTopicAccuracy(7).then((res) => {
      const data = res.data;

      const labels = Object.keys(data);
      const values = Object.values(data);

      
      const backgroundColors = values.map((val) => {
        if (val === 100) return "#22c55e"; 
        if (val >= 70) return "#eab308";   
        return "#ef4444";                  
      });

      setChartData({
        labels: labels,
        datasets: [
          {
            label: "Accuracy (%)",
            data: values,
            backgroundColor: backgroundColors,
            borderRadius: 8, 
            barThickness: 60
          }
        ]
      });
    });
  }, []);

  const options = {
    responsive: true,
    plugins: {
      legend: {
        display: false 
      },
      title: {
        display: true,
        text: "Topic Accuracy Analysis",
        font: {
          size: 18
        }
      },
      tooltip: {
        callbacks: {
          label: (context) => `${context.raw.toFixed(2)}%`
        }
      }
    },
    scales: {
      y: {
        beginAtZero: true,
        max: 100,
        ticks: {
          callback: (value) => value + "%"
        },
        grid: {
          color: "#e5e7eb"
        }
      },
      x: {
        grid: {
          display: false
        }
      }
    }
  };

  return (
    <div className="analytics-container">
      <h2 className="analytics-title">Topic Accuracy</h2>

      <div className="chart-card">
        {chartData.labels && <Bar data={chartData} options={options} />}
      </div>
    </div>
  );
}

export default Analytics;