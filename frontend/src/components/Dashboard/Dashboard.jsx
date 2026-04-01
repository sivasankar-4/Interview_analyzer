import { useState , useEffect } from "react";
import { getAccuracy,getAverageTime,getTopTopic } from "../../services/api"
import "../../styles/dashboard.css";
import Card from "../Card/Card";

function Dashboard() {

   const [accuracy, setAccuracy] = useState(0);
   const [avgTime, setAvgTime]  = useState(0);
   const [topTopic, setTopTopic] = useState("");
   const[loading,setLoading] = useState(true);


     useEffect(() => {
    Promise.all([
      getAccuracy(7),
      getAverageTime(7),
      getTopTopic(7)
    ])
      .then(([accRes, timeRes, topicRes]) => {
        setAccuracy(accRes.data);
        setAvgTime(timeRes.data);
        setTopTopic(topicRes.data.topTopic);
      })
      .catch((err) => console.error(err))
      .finally(() => setLoading(false));
  }, []);

      if(loading){
        return <h2>Loading dashboard...</h2>;
      }


return (
    <div className="dashboard">
      <h2 className="title">Dashboard</h2>

      <div className="cards">
        <Card
          title="Accuracy"
          value={`${accuracy.toFixed(2)}%`}
          type="accuracy"
        />

        <Card
          title="Average Time"
          value={`${avgTime.toFixed(2)} min`}
          type="time"
        />

        <Card
          title="Top Topic"
          value={topTopic}
          type="topic"
        />
      </div>
    </div>
  );
}
export default Dashboard;