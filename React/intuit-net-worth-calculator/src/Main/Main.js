import './Main.css';
import React from 'react';
import AssetRow from '../AssetRow/AssetRow';
import LiabilityRow from '../LiabilityRow/LiabilityRow';

class Main extends React.Component {

  constructor() {
    super();
    this.state = {
      netWorth: 0,
      assets: [],
      liablities: [],
      totalAssets: 0,
      totalLiabilities: 0,
      currencies: [],
      selectedCurrency: {}
    }

    this.selectCurrency = this.selectCurrency.bind(this);
  }

  componentDidMount() {
    Promise.all([
      fetch('/currency')
        .then(res => res.json())
        .then(data => this.setState({ currencies: data, selectedCurrency: data[0] })),
      fetch('/initialize')
        .then(res => res.json())
        .then(data => this.setState({
          netWorth: data.netWorth,
          assets: data.assets,
          liabilities: data.liabilities,
          totalAssets: data.totalAssets,
          totalLiabilities: data.totalLiabilities
        }))
    ]).catch(console.log())
  }

  selectCurrency(event) {
    this.setState({
      selectedCurrency: event.target.value
    }, this.selectCurrencyFetch);
  }

  updateNetWorth() {
    fetch('/netWorth', {
      method: 'post',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        assets: this.state.netWorth.assets,
        liabilities: this.state.netWorth.liablities,
        currencyCode: this.state.selectedCurrency.currencyCode
      })
    }).then(res => res.json())
      .then(data => this.setState({ netWorth: data }))
  }

  selectCurrencyFetch() {
    console.log(this.state.selectedCurrency.currencyCode);
    console.log(this.state.selectedCurrency.currencySymbol);
    // fetch('/convert', {
    //   method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify({
    //     assets: this.state.netWorth.assets,
    //     liabilities: this.state.netWorth.liablities,
    //     originalCurrencyCode: "CAD",
    //     convertCurrencyCode: "SEK"
    //   })
    // })
    //   .then(res => res.json())
    //   .then(data => this.setState({ netWorth: data }))
  }

  handleAssetChange(event, index) {
    console.log(event.target.value);
    console.log(index);
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
            <select onChange={this.selectCurrency} value={this.state.selectedCurrency}>
              {this.state.currencies.map((currency, index) => <option key={currency.currencyCode} value={currency}>{currency.currencyCode}</option>)}
            </select>
          </div>
        </div>
        <div className='row'>
          <h3>Net Worth</h3>
          <div className='fill-remaining-space'></div>
          <h3>{this.state.selectedCurrency.currencySymbol}{this.state.netWorth.toFixed(2)}</h3>
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
            {this.state.assets.filter(value => value.category === 1).map((asset, index) =>
              <AssetRow asset={asset} currency={this.state.selectedCurrency} onAssetChange={this.handleAssetChange} index={index}></AssetRow>)}
            <tr className='header-row'>
              <th colSpan='2'>Long Term Assets</th><td className='line-item-amount'></td>
            </tr>
            {this.state.assets.filter(value => value.category === 2).map((asset, index) =>
              <AssetRow asset={asset} currency={this.state.selectedCurrency} onAssetChange={this.handleAssetChange} index={index}></AssetRow>)}
            <tr className='header-row'>
              <th colSpan='2'>Total Assets</th>
              <td>
                <div className='row'>
                  <div>{this.state.selectedCurrency.currencySymbol}</div>
                  <div className='fill-remaining-space'></div>
                  <div>{this.state.totalAssets}</div>
                </div>
              </td>
            </tr>
          </table>
        </div>
        {/* <div className='row'>
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
            {this.state.netWorth.liabilities && this.state.netWorth.liabilities
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
              <td> <div className='row'>
                <div>{this.state.selectedCurrency.currencySymbol}</div>
                <div className='fill-remaining-space'></div>
                <div>{this.state.netWorth.totalLiabilities.toFixed(2)}</div>
              </div></td>
            </tr>
          </table>
        </div> */}
      </div>
    );
  }

}

export default Main;
