import {StudentsLessonKeysHeader} from "./StudentsLessonKeysHeader";
import {StudentsLessonKeysRows} from "./StudentsLessonKeysRows";

export function StudentsLessonKeys() {
    return <>
        <table className="table table-dark mt-2">
            <StudentsLessonKeysHeader/>
            <StudentsLessonKeysRows/>
        </table>
    </>;
}