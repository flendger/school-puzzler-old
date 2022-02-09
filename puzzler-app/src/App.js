import './App.css';
import Main from "./components/Main";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {LessonTable} from "./components/LessonTable";
import {Lesson} from "./components/Lesson";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"} element={<Main/>}>
                    <Route path={"/"} element={<LessonTable/>}/>
                    <Route path={"lesson/:id"} element={<Lesson/>}/>
                    <Route path="*" element={<h1>No page there</h1>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
