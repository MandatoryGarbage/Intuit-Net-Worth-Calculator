import React from 'react';

class LiabilityRow extends React.Component {
    constructor(props) {
        super(props);
        this.state = { value: props.liability.amount }
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.setState({ value: event.target.value });
    }

    render() {
        return (
            <tr>
                <td>{this.props.liability.lineItem}</td>
                <td>{this.props.liability.monthlyPayment}</td>
                <td class='line-item-amount'>
                    <input value={this.state.value} name={this.props.liability.lineItem} onChange={this.handleChange} pattern='^[0-9]+[.][0-9]{2}$'></input>
                </td>
            </tr>
        );
    }
}

export default LiabilityRow;
