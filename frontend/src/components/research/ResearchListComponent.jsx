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

    render() {
        let researches = this.state.researches;
        const listItem = researches.map((research) =>
            <li>{research.title}</li>
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