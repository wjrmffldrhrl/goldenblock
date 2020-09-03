import React from 'react';
import ResearchService from '../../services/ResearchService';

class ResearchCreateComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            title: '',
            content: '',
            deadLine: '',
            prizeMoney: '',
        }
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(e) {
        this.setState(
            {
                [e.target.name]
                  :e.target.value
            }
        )

    }

    handleSubmit(e) {
        
        console.log(this.state.title, this.state.content, this.state.deadLine, this.state.prizeMoney);

        ResearchService.executeResearchRegister(
            this.state.title, this.state.content, this.state.deadLine, this.state.prizeMoney
        ).then(response => {
            this.props.history.push(`/research/` + response.data);
        }).catch(error => {

        });
        
        e.preventDefault();
    }
    render() {
        return (
            <div>
                <h1>Research Create</h1>
                <form>
                    <label>
                        Title: 
                        <input type="text" name="title" value={this.state.title} 
                            onChange={this.handleChange}/>
                    </label>
                    <label>
                        Content: 
                        <input type="text" name="content" value={this.state.content} 
                            onChange={this.handleChange}/>
                    </label>
                    <label>
                        Prize Money: 
                        <input type="number" name="prizeMoney" value={this.state.prizeMoney} 
                            onChange={this.handleChange}/>
                    </label>
                    <label>
                        Deadline: 
                        <input type="date" name="deadLine" value={this.state.deadLine} 
                            onChange={this.handleChange}/>
                    </label>
                    <input type="button" value="Submit" onClick={this.handleSubmit}/>
                    
                </form>
            </div>
        )
    }
}

export default ResearchCreateComponent;