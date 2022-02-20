export function LessonHeaderCell(props) {
    const header = props.header;

    return <th scope="col" className="col-sm-1 text-center min-w125">{header.name}</th>;
}