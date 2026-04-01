import { useEffect, useState } from "react";
import { getWeakTopics } from "../../services/api";
import "../../styles/TopicInsights.css";

function WeakTopics() {
  const [weak, setWeak] = useState([]);

  useEffect(() => {
    getWeakTopics(7)
      .then((res) => {
        setWeak(res.data || []);
      })
      .catch((err) => console.error(err));
  }, []);

  return (
    <div className="insight-card">
      <h3 className="weak-title">Needs Improvement</h3>
      <div className="tags">
        {weak.map((topic, i) => (
          <span key={i} className="tag weak">
            {topic}
          </span>
        ))}
      </div>
    </div>
  );
}

export default WeakTopics;