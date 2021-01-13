import React from 'react';
import './LiabilityRow.css'

class LiabilityRow extends React.Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.props.onLiabilityChange(event.target.value, this.props.index);
    }

    render() {
        return (
            <tr>
                <td>{this.props.lineItem}</td>
                <td>
                    <div className='row'>
                        <div class='currency-symbol'>{this.props.currencySymbol}</div>
                        <div>{this.props.monthlyPayment}</div>
                    </div>
                </td>
                <td className='line-item-amount'>
                    <div className='row'>
                        <div>{this.props.currencySymbol}</div>
                        <div className='fill-remaining-space'></div>
                        <input value={this.props.amount} name={this.props.lineItem} onChange={this.handleChange}></input>
                    </div>
                </td>
            </tr>
        );
    }
}

export default LiabilityRow;
