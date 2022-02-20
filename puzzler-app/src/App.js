import './App.css';
import './puzzler.css';
import Main from "./components/Main";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {LessonsTable} from "./components/LessonsTable";
import {Lesson} from "./components/Lesson";
import {AdminMain} from "./components/admin/AdminMain";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"} element={<Main/>}>
                    <Route path={"/"} element={<LessonsTable/>}/>
                    <Route path={"lesson/:id"} element={<Lesson/>}/>
                    <Route path="*" element={<h1>No page there</h1>}/>
                    <Route path={"/admin"} element={<AdminMain/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
