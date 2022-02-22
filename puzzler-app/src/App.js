import './App.css';
import './puzzler.css';
import Main from "./components/Main";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {LessonsTable} from "./components/lesson_list/LessonsTable";
import {Lesson} from "./components/lesson/Lesson";
import {AdminMain} from "./components/admin/AdminMain";
import {AdminClasses} from "./components/admin/classes/AdminClasses";
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"} element={<Main/>}>
                    <Route path={"/"} element={<LessonsTable/>}/>
                    <Route path={"lesson/:id"} element={<Lesson/>}/>
                    <Route path="*" element={<h1>No page there</h1>}/>
                    <Route path={"admin"} element={<AdminMain/>}>
                        <Route path={"classes"} element={<AdminClasses/>}/>
                    </Route>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
