import React from 'react';
import ResearchService from '../../services/ResearchService';
import { Link } from 'react-router-dom';

class ResearchDetailsComponent extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            research : []
        };
    }

    componentDidMount() {
        ResearchService.getResearchDetails(this.props.match.params.id)
        .then(response => {
            this.setState({research: response.data});
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
        let research = this.state.research;
        
        return (
             <div>
                 <h1>{research.title}</h1>
                 <h2>{research.id}</h2>
                 <p>{research.content}</p>
                 <p>Deadline : {research.deadLine}</p>


                 <Link  to={"/submit/" + research.id}>Submit</Link>
             </div>
        );
    }

}

export default ResearchDetailsComponent;