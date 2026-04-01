

function Card({ title, value, type }) {
  const getColor = () => {
    if (type === "accuracy") return "blue";
    if (type === "time") return "green";
    return "purple";
  };

  return (
    <div className={`card ${getColor()}`}>
      <h3>{title}</h3>
      <p>{value}</p>
    </div>
  );
}

export default Card;