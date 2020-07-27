import React from 'react';

class App extends React.Component {
  
  
  constructor(props){
    super(props);
    this.state = {
        springboot: null,
    };
  }

  componentDidMount(){
      fetch("/react/test")
      .then(res => res.json())
      .then(
          (result) => {
              this.setState({
                springboot: result.springboot,
                  
              });
          },

         
      )
  }

  render(){
      const {springboot} = this.state;

      
      return (
          

          <div>
            <h1>
              Learn React
            </h1>
            {springboot}
          </div>
      );
  }

 
}

export default App;
