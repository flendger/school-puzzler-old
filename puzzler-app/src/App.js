import './App.css';
import './puzzler.css';
import Main from "./components/Main";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {LessonsTable} from "./components/lesson_list/LessonsTable";
import {Lesson} from "./components/lesson/Lesson";
import {AdminMain} from "./components/admin/AdminMain";
import {AdminClassesListForm} from "./components/admin/classes/AdminClassesListForm";
import 'bootstrap/dist/css/bootstrap.min.css';
import {AdminStudentsListForm} from "./components/admin/students/AdminStudentsListForm";
import {Login} from "./components/Login";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path={"/"} element={<Main/>}>
                    <Route path={"login"} element={<Login/>}/>
                    <Route path={"lessons"} element={<LessonsTable/>}/>
                    <Route path={"lessons/:id"} element={<Lesson/>}/>
                    <Route path="*" element={<h1>No page there</h1>}/>
                    <Route path={"admin"} element={<AdminMain/>}>
                        <Route path={"classes"} element={<AdminClassesListForm/>}/>
                        <Route path={"students"} element={<AdminStudentsListForm/>}/>
                    </Route>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
