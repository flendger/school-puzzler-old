export function LessonComplexHeaderCell(props) {
    const header = props.header;

    return <th scope="col" className="col-sm-2 text-center min-w275">{header.name}</th>;
}