import React from 'react';
import './AssetRow.css'

class AssetRow extends React.Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.props.onAssetChange(event, this.props.index);
    }

    render() {
        return (
            <tr>
                <td colSpan='2'>{this.props.asset.lineItem}</td>
                <td className='line-item-amount'>
                    <div className='row'>
                    <div>{this.props.currency.currencySymbol}</div>
                    <div className='fill-remaining-space'></div>
                    <input value={this.props.asset.amount.toFixed(2)} name={this.props.asset.lineItem} onChange={this.handleChange}></input>
                    </div>
                </td>
            </tr>
        );
    }
}

export default AssetRow;
