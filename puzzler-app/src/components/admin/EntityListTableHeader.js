export function EntityListTableHeader(props) {
    return <thead>
    <tr>
        <th scope="col" className="col-sm-1 text-center">ID</th>
        {props.entityListHeader}
        <th scope="col" className="col-sm-2 text-center"/>
    </tr>
    </thead>;
}