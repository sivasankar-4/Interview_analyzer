import Dashboard from "../components/Dashboard/Dashboard";
//import Analytics from "../components/Analytics/Analytics";
import RecentAttempts from "../components/RecentAttempts/RecentAttempts";



function Home() {

     return (

      <div style={{ padding: "20px" }}>
      <div style={{ marginBottom: "40px" }}>
       <Dashboard />
      </div>
      
        <div style={{ marginBottom: "40px" }}>
        <RecentAttempts />
        </div>


        </div>
     );
}

export default Home;