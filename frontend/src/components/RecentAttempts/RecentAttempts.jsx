import { useEffect, useState } from "react";
import { getRecentAttempts } from "../../services/api";
import "./RecentAttempts.css"
  

function RecentAttempts() {
  const [attempts, setAttempts] = useState([]);

  useEffect(() => {
    getRecentAttempts(7)
      .then((res) => {
        setAttempts(res.data);
      })
      .catch((err) => console.error(err));
  }, []);

  return (
    <div className="recent-container">
      <h2 className="section-title">Recent Attempts</h2>

      <div className="attempt-list">
        {attempts.map((item, index) => (
          <div key={index} className="attempt-card">
            
           
            <div className="attempt-info">
              <p className="question">{item.question}</p>
              <p className="topic">{item.topic}</p>
            </div>

            
            <div className="attempt-meta">
              <span className={item.solved ? "status success" : "status fail"}>
                {item.solved ? "Solved" : "Not Solved"}
              </span>
              <p className="time">{item.timeTaken} min</p>
            </div>

          </div>
        ))}
      </div>
    </div>
  );
}

export default RecentAttempts;