import {useParams} from "react-router";
import {useEffect, useState} from "react";
import axios from "axios";

export function Lesson() {
    const params = useParams();
    const [lesson, setLesson] = useState({});

    useEffect(() => {
        function getLesson(id) {
            setLesson({
                id: 1,
                name: "Урок 1",
                title: "Заголовок урока 1",
                subjectName: "Химия"
            });
            // axios.get('/api/v1/lessons/' + id)
            //     .then(response => {
            //         console.log(response.data);
            //         setLesson(response.data);
            //     })
            //     .catch(error => {
            //         alert(error);
            //     })
        }

        getLesson(params.id);
    }, [params.id]);

    return <h1>Lesson {lesson.name}</h1>;
}