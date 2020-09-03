
import React from 'react';
import ResearchService from '../../services/ResearchService';

class ResearchSubmitComponent extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            file: ''
        }
        this.onFileChange = this.onFileChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    onFileChange(e) {
        // let files = e.target.files || e.dataTransfer.files;
        
        // if (!files.length) {
        //     console.log('no files');
        // }
        // console.log(files);
        // console.log(files[0]);
     
     

        let fileReader = new FileReader();
        fileReader.readAsBinaryString(e.target.files[0]);
        fileReader.onload = (event) => {
            this.setState({
                file: event.target.result
            })
            console.log(event.target.result);
        }



    }
  
    handleClick(e) {
        
        ResearchService.executeSubmit(this.props.match.params.id,'test',this.state.file);
    }

    render() {
        return (
            <div>
                <h1>Research Submit</h1>
                <input type="file" name="file" onChange={this.onFileChange}></input>
                <input type="button" value="submit" onClick={this.handleClick}></input>
            </div>
        )
    }
}

export default ResearchSubmitComponent;