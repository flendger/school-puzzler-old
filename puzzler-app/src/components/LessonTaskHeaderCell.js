export function LessonTaskHeaderCell(props) {
    const header = props.header;

    return <th scope="col" className="col-sm-auto text-center">{header.name}</th>;
}