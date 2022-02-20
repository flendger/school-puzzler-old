import {useParams} from "react-router";
import {useEffect, useState} from "react";
import {LessonTable} from "./LessonTable";
import axios from "axios";

export function Lesson() {
    const params = useParams();
    const [lesson, setLesson] = useState({});

    useEffect(() => {
        function getLesson(id) {
            setLesson({
                "id": 1,
                "name": "Урок 1",
                "title": "Заголовок урока 1",
                "headers": [
                    {"id": 1, "order": 0, "name": "Задание", "valueType": "TASK"},
                    {"id": 2, "order": 1, "name": "М (г/моль)", "valueType": "NUMBER"},
                    {"id": 3, "order": 2, "name": "n (моль)", "valueType": "NUMBER"},
                    {"id": 4, "order": 3, "name": "m (г)", "valueType": "NUMBER"},
                    {"id": 5, "order": 4, "name": "V (л)", "valueType": "NUMBER"},
                    {"id": 6, "order": 5, "name": "N (молекулы)", "valueType": "COMPLEX_NUMBER"}
                ],
                "tasks": [
                    {
                        "id": 1,
                        "name": "Задание 1",
                        "title": "MHJKH",
                        "values": [
                            {
                                "id": 1,
                                "value1": "111",
                                "value2": "10",
                                "value3": "5",
                                "accesable": true,
                                "columnId": 2,
                                "columnOrder": 1,
                                "valueType": "NUMBER"
                            },
                            {
                                "id": 2,
                                "value1": "222",
                                "value2": "10",
                                "value3": "4",
                                "accesable": true,
                                "columnId": 3,
                                "columnOrder": 2,
                                "valueType": "NUMBER"
                            },
                            {
                                "id": 3,
                                "value1": "333",
                                "value2": "10",
                                "value3": "4",
                                "accesable": false,
                                "columnId": 3,
                                "columnOrder": 2,
                                "valueType": "NUMBER"
                            },
                            {
                                "id": 4,
                                "value1": "444",
                                "value2": "10",
                                "value3": "4",
                                "accesable": true,
                                "columnId": 3,
                                "columnOrder": 2,
                                "valueType": "NUMBER"
                            },
                            {
                                "id": 5,
                                "value1": "444",
                                "value2": "10",
                                "value3": "4",
                                "accesable": true,
                                "columnId": 3,
                                "columnOrder": 2,
                                "valueType": "__NUMBER"
                            }
                        ]
                    }
                    ,
                    {
                        "id": 2,
                        "name": "Задание 1",
                        "title": "MHJKH",
                        "values": [
                            {
                                "id": 1,
                                "value1": "111",
                                "value2": "10",
                                "value3": "5",
                                "accesable": true,
                                "columnId": 2,
                                "columnOrder": 1,
                                "valueType": "NUMBER"
                            },
                            {
                                "id": 2,
                                "value1": "222",
                                "value2": "10",
                                "value3": "4",
                                "accesable": true,
                                "columnId": 3,
                                "columnOrder": 2,
                                "valueType": "NUMBER"
                            },
                            {
                                "id": 3,
                                "value1": "333",
                                "value2": "10",
                                "value3": "4",
                                "accesable": true,
                                "columnId": 3,
                                "columnOrder": 2,
                                "valueType": "NUMBER"
                            },
                            {
                                "id": 4,
                                "value1": "444",
                                "value2": "10",
                                "value3": "4",
                                "accesable": true,
                                "columnId": 3,
                                "columnOrder": 2,
                                "valueType": "NUMBER"
                            },
                            {
                                "id": 5,
                                "value1": "444",
                                "value2": "10",
                                "value3": "4",
                                "accesable": false,
                                "columnId": 3,
                                "columnOrder": 2,
                                "valueType": "__NUMBER"
                            }
                        ]
                    }
                ]
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

    return <>
        <h3 className="text-center">Урок № {lesson.id}</h3>
        <h4 className="text-center">{lesson.name}</h4>
        <h5 className="text-center">{lesson.title}</h5>
        <LessonTable lessonData={lesson}/>
    </>;
}