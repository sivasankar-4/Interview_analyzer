import Analytics from "../components/Analytics/Analytics";
import StrongTopics from "../components/StrongTopics/StrongTopics";
 import WeakTopics from "../components/WeakTopics/WeakTopics";

function AnalyticsPage () {

    return (
        <div>
            <h1 style={{
                marginBottom: "20px"
            }}></h1>
            <Analytics/>

              <h1 style={{
                marginBottom:"30px"
            }}>StrongTopics</h1>
            <StrongTopics />  

             <h1 style={{
                marginBottom:"30px"
            }}>WeakTopics</h1>
            <WeakTopics /> 
        </div>
    )
}

export default AnalyticsPage;