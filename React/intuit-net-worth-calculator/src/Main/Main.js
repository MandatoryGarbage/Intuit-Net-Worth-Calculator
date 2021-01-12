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
    this.handleAssetChange = this.handleAssetChange.bind(this);
    this.handleLiabilityChange = this.handleLiabilityChange.bind(this);
  }

  componentDidMount() {
    Promise.all([
      fetch('/currency')
        .then(res => res.json())
        .then(data => this.setState({ currencies: data })),
      fetch('/initialize')
        .then(res => res.json())
        .then(data => this.setState({
          netWorth: data.netWorth,
          assets: data.assets,
          liabilities: data.liabilities,
          totalAssets: data.totalAssets,
          totalLiabilities: data.totalLiabilities,
          currencyCode: data.currency.currencyCode,
          currencySymbol: data.currency.currencySymbol
        }))
    ]).catch(console.log())
  }

  selectCurrency(event) {
    fetch('/convert', {
      method: 'post',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        assets: this.state.assets,
        liabilities: this.state.liabilities,
        originalCurrencyCode: this.state.currencyCode,
        convertCurrencyCode: event.target.value
      })
    }).then(res => res.json())
      .then(data => this.setState({
        netWorth: data.netWorth,
        assets: data.assets,
        liabilities: data.liabilities,
        totalAssets: data.totalAssets,
        totalLiabilities: data.totalLiabilities,
        currencyCode: data.currency.currencyCode,
        currencySymbol: data.currency.currencySymbol
      }))
  }

  updateNetWorth() {
    fetch('/netWorth', {
      method: 'post',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        assets: this.state.assets,
        liabilities: this.state.liabilities,
        currencyCode: this.state.currencyCode
      })
    }).then(res => res.json())
      .then(data => this.setState({
        netWorth: data.netWorth,
        assets: data.assets,
        liabilities: data.liabilities,
        totalAssets: data.totalAssets,
        totalLiabilities: data.totalLiabilities,
        currencyCode: data.currency.currencyCode,
        currencySymbol: data.currency.currencySymbol
      }))
  }

  selectCurrencyFetch(convertCurrencyCode) {
    fetch('/convert', {
      method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify({
        assets: this.state.assets,
        liabilities: this.state.liablities,
        originalCurrencyCode: this.state.currencyCode,
        convertCurrencyCode: convertCurrencyCode
      })
    })
      .then(res => res.json())
      .then(data => this.setState({ netWorth: data }))
  }

  handleAssetChange(value, index) {
    let assets = [...this.state.assets];
    assets[index].amount = value;
    this.setState({ assets: assets }, this.updateNetWorth)
  }

  handleLiabilityChange(value, index) {
    let liabilities = [...this.state.liabilities];
    liabilities[index].amount = value;
    this.setState({ liabilities: liabilities }, this.updateNetWorth)
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
            <select onChange={this.selectCurrency} value={this.state.currencyCode}>
              {this.state.currencies.map((currency) => <option key={currency.currencyCode} value={currency.currencyCode}>{currency.currencyCode}</option>)}
            </select>
          </div>
        </div>
        <div className='row'>
          <h3>Net Worth</h3>
          <div className='fill-remaining-space'></div>
          <h3>{this.state.selectedCurrency.currencySymbol}{this.state.netWorth}</h3>
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
            {this.state.assets && this.state.assets.filter(value => value.category === 1).map((asset, index) =>
              <AssetRow lineItem={asset.lineItem} currencySymbol={this.state.currencySymbol} amount={asset.amount} onAssetChange={this.handleAssetChange} index={index}></AssetRow>)}
            <tr className='header-row'>
              <th colSpan='2'>Long Term Assets</th><td className='line-item-amount'></td>
            </tr>
            {this.state.assets && this.state.assets.filter(value => value.category === 2).map((asset, index) =>
              <AssetRow lineItem={asset.lineItem} currencySymbol={this.state.currencySymbol} amount={asset.amount} onAssetChange={this.handleAssetChange} index={index + 9}></AssetRow>)}
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
            {this.state.liabilities && this.state.liabilities.filter(value => value.category === 1).map((liability, index) =>
              <LiabilityRow lineItem={liability.lineItem} currencySymbol={this.state.currencySymbol} amount={liability.amount} monthlyPayment={liability.monthlyPayment} onLiabilityChange={this.handleLiabilityChange} index={index}></LiabilityRow>)}
            <tr className='header-row'>
              <th>Long Term Debt</th>
              <th>Monthly Payment</th>
              <td className='line-item-amount'></td>
            </tr>
            {this.state.liabilities && this.state.liabilities.filter(value => value.category === 2).map((liability, index) =>
              <LiabilityRow lineItem={liability.lineItem} currencySymbol={this.state.currencySymbol} amount={liability.amount} monthlyPayment={liability.monthlyPayment} onLiabilityChange={this.handleLiabilityChange} index={index + 2}></LiabilityRow>)}
            <tr className='header-row'>
              <th colSpan='2'>Total Liabilities</th>
              <td> <div className='row'>
                <div>{this.state.selectedCurrency.currencySymbol}</div>
                <div className='fill-remaining-space'></div>
                <div>{this.state.totalLiabilities}</div>
              </div>
              </td>
            </tr>
          </table>
        </div>
      </div>
    );
  }

}

export default Main;
