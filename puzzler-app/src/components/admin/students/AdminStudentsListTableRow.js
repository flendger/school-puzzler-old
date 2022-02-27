export function AdminStudentsListTableRow(props) {
    const listData = props.listData;

    return <>
        <td>{listData.name}</td>
        <td>{listData.schoolClass.name}</td>
    </>;
}