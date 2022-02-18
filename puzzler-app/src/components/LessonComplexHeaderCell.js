export function LessonComplexHeaderCell(props) {
    const header = props.header;

    return <th scope="col" className="col-sm-1 text-center min-w275">{header.name}</th>;
}