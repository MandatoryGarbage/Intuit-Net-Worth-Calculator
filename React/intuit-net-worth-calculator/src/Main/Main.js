import './Main.css';
import React from 'react';
import { NetWorth } from '../domain/NetWorth';
import AssetRow from '../AssetRow/AssetRow';
import LiabilityRow from '../LiabilityRow/LiabilityRow';

class Main extends React.Component {

  constructor() {
    super();
    this.state = {
      netWorth: new NetWorth(0, {}, [], [], 0, 0),
      currencies: [],
      selectedCurrency: {}
    }

    this.selectCurrency = this.selectCurrency.bind(this);
  }

  componentDidMount() {
    Promise.all([
      fetch('/currency')
        .then(res => res.json())
        .then(data => this.setState({ currencies: data })),
      fetch('/netWorth')
        .then(res => res.json())
        .then(data => this.setState({ netWorth: data }))
    ]).catch(console.log())
  }

  selectCurrency(event) {
    this.setState({
      selectedCurrency: this.state.currencies[event.target.value]
    });
    fetch('/netWorth', {
      method: 'POST', body: JSON.stringify({
        assets: this.state.netWorth.assets,
        liabilities: this.state.netWorth.liabilities,
        netWorthCurrency: this.state.currencies[event.target.value]
      })
    })
      .then(res => res.json())
      .then(data => this.setState({ netWorth: data }))
  }

  render() {
    return (
      <div className='app'>
        <div>
          <h1>Tracking your Networth</h1>
        </div>
        <div className='row'>
          <div className='fill-remaining-space'></div>
          <div>
            <h3>Select Currency: </h3>
          </div>
          <div>
            <select onChange={this.selectCurrency}>
              {this.state.currencies.map((currency, index) => <option key={currency.currencyCode} value={index}>{currency.currencyCode}</option>)}
            </select>
          </div>
        </div>
        <div className='row'>
          <h3>Net Worth</h3>
          <div className='fill-remaining-space'></div>
          <h3>{this.state.netWorth.netWorth.toFixed(2)}</h3>
        </div>
        <div className='row'>
          <h4>Assets</h4>
          <div className='fill-remaining-space'></div>
        </div>
        <div>
          <table>
            <tr className='header-row'>
              <th colSpan='2'>Cash and Investments</th><td className='line-item-amount'></td>
            </tr>
            {this.state.netWorth.assets.filter(value => value.category === 1).map(asset => <AssetRow asset={asset} currency={this.state.selectedCurrency}></AssetRow>)}
            <tr className='header-row'>
              <th colSpan='2'>Long Term Assets</th><td className='line-item-amount'></td>
            </tr>
            {this.state.netWorth.assets.filter(value => value.category === 2).map(asset => <AssetRow asset={asset} currency={this.state.selectedCurrency}></AssetRow>)}
            <tr className='header-row'>
              <th colSpan='2'>Total Assets</th>
              <td>{this.state.netWorth.totalAssets}</td>
            </tr>
          </table>
        </div>
        <div className='row'>
          <h4>Liabilities</h4>
          <div className='fill-remaining-space'></div>
        </div>
        <div>
          <table>
            <tr className='header-row'>
              <th>Long Term Assets</th>
              <th>Monthly Payment</th>
              <td className='line-item-amount'></td>
            </tr>
            {this.state.netWorth.liablities && this.state.netWorth.liabilities
              .filter(value => value.category === 1)
              .map(liability => <LiabilityRow liability={liability} currency={this.state.selectedCurrency}></LiabilityRow>)}
            <tr className='header-row'>
              <th>Long Term Debt</th>
              <th>Monthly Payment</th>
              <td className='line-item-amount'></td>
            </tr>
            {this.state.netWorth.liabilities && this.state.netWorth.liabilities
              .filter(value => value.category === 2)
              .map(liability => <LiabilityRow liability={liability} currency={this.state.selectedCurrency}></LiabilityRow>)}
            <tr className='header-row'>
              <th colSpan='2'>Total Liabilities</th>
              <td>{this.state.netWorth.totalLiabilities.toFixed(2)}</td>
            </tr>
          </table>
        </div>
      </div>
    );
  }

}

export default Main;
