
import { BrowserRouter as Router,Routes,Route} from "react-router-dom";
import Home from "./pages/Home";
import AnalyticsPage from "./pages/AnalyticsPage";
import MainLayout from "./layouts/MainLayout";


function App() {

   return (
    
      <Router>
      
      <Routes>
         <Route path='/' element={<MainLayout/>}>
         <Route index element = {<Home/>}/>
         <Route path='/analytics' element={<AnalyticsPage/>}/>
         </Route>
      </Routes>
      

      </Router>

    
    
     
   );
}

export default App;
