import React from 'react';

class CurrencySelector extends React.Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
       this.props.onCurrencyChange(event);
    }

    render() {
        return (
            <div>
            <select onChange={this.handleChange} value={this.props.selectedCurrency}>
              {this.props.currencies.map((currency) => <option key={currency.currencyCode} value={currency.currencyCode}>{currency.currencyCode}</option>)}
            </select>
          </div>
        );
    }
}

export default CurrencySelector;