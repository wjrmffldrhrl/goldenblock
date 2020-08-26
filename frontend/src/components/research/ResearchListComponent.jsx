import React from 'react';
import ResearchService from '../../services/ResearchService';
class ResearchListComponent extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            researches : []
        };
    }

    componentDidMount() {
        ResearchService.getResearchList()
        .then(response => {
            this.setState({researches: response.data});
        })
        .catch(error => {

        })
    }

    // "id": 37,
    // "title": "save",
    // "content": "hi",
    // "prizeMoney": "5000",
    // "deadLine": "1995-03-27",
    // "status": "ing",
    // "companyName": null

    render() {
        let researches = this.state.researches;
        const listItem = researches.map((research) =>
            <li key={research.id}><a href={'/research/' + research.id}>{research.title}</a></li>
        );


        return(
            <div>
                <h1>Research List</h1>
                <ul>{listItem}</ul>
                
            </div>
        );
    }
}

export default ResearchListComponent;