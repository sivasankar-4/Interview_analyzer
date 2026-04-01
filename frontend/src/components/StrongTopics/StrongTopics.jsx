import { useEffect, useState } from "react";
import { getStrongTopics } from "../../services/api";
import "../../styles/TopicInsights.css";

function StrongTopics() {
  const [strong, setStrong] = useState([]);

  useEffect(() => {
    getStrongTopics(7)
      .then((res) => {
        setStrong(res.data || []);
        console.log(res);
      })
      .catch((err) => console.error(err));
  }, []);

  return (
    <div className="insight-card">
      <h3 className="strong-title">Strong Topics</h3>
      <div className="tags">
        {strong.length === 0 ? (
          <p>NO strong topics</p>
        ) : (
        strong?.map((topic, i) => (
          <span key={i} className="tag strong">
            {topic}
          </span>
        ))
        )}
      </div>
    </div>
  );
}

export default StrongTopics;