import React from 'react';

class LiabilityRow extends React.Component {
    constructor(props) {
        super(props);
        this.state = { value: props.liability.amount.toFixed(2) }
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.setState({ value: event.target.value });
    }

    render() {
        return (
            <tr>
                <td>{this.props.liability.lineItem}</td>
                <td>
                    <div className='row'>
                        <div>{this.props.currency.currencySymbol}</div>
                        <div>{this.props.liability.monthlyPayment.toFixed(2)}</div>
                        <div class='fill-remaining-space'></div>
                    </div>
                </td>
                <td class='line-item-amount'>
                    <div className='row'>
                        <div>{this.props.currency.currencySymbol}</div>
                        <div class='fill-remaining-space'></div>
                        <input value={this.state.value} name={this.props.liability.lineItem} onChange={this.handleChange} pattern='^[0-9]+[.][0-9]{2}$'></input>
                    </div>
                </td>
            </tr>
        );
    }
}

export default LiabilityRow;
