import React from 'react';
import './AssetRow.css'

class AssetRow extends React.Component {
    constructor(props) {
        super(props);
        this.state = { value: props.asset.amount }
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.setState({ value: event.target.value });
    }

    render() {
        return (
            <tr>
                <td colSpan='2'>{this.props.asset.lineItem}</td>
                <td class='line-item-amount'>
                    <div class='fill-remaining-space'></div>
                    <input value={this.state.value} name={this.props.asset.lineItem} onChange={this.handleChange} pattern='^[0-9]+[.][0-9]{2}$'></input>
                </td>
            </tr>
        );
    }
}

export default AssetRow;
