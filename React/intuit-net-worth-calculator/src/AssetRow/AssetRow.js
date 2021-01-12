import React from 'react';
import './AssetRow.css'

class AssetRow extends React.Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.props.onAssetChange(event.target.value, this.props.index, this.props.category);
    }

    render() {
        return (
            <tr>
                <td colSpan='2'>{this.props.lineItem}</td>
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

export default AssetRow;
