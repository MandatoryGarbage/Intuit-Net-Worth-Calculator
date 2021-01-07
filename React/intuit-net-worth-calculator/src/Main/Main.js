import './Main.css';
import React from 'react';
import { Currency } from '../domain/Currency';
import { NetWorth } from '../domain/NetWorth';
import { Asset } from '../domain/Asset';
import { Liability } from '../domain/Liability';
import AssetRow from '../AssetRow/AssetRow';
import LiabilityRow from '../LiabilityRow/LiabilityRow';

class Main extends React.Component {

  currencies = [
    new Currency(1, '$', 'CAD'),
    new Currency(2, '$', 'USD'),
    new Currency(3, '', 'GBP')
  ];

  netWorth = new NetWorth(15, [new Asset(1, 'Bank', '10.00'), new Asset(2, 'Savings', 15)], 25, [new Liability(1, 'Credit Card',5, 8), new Liability(2, 'Line of Credit',2, 2)], 10);

  render() {
    return (
      <div class='app'>
        <div>
          <h1>Tracking your Networth</h1>
        </div>
        <div class='row'>
          <div class='fill-remaining-space'></div>
          <div>
            <h3>Select Currency: </h3>
          </div>
          <div>
            <select>
              {this.currencies.map(currency => <option key={currency.currencyId}>{currency.currencyCode}</option>)}
            </select>
          </div>
        </div>
        <div class='row'>
          <h3>Net Worth</h3>
          <div class='fill-remaining-space'></div>
          <h3>{this.netWorth.netWorth}</h3>
        </div>
        <div class='row'>
          <h4>Assets</h4>
          <div class='fill-remaining-space'></div>
        </div>
        <div>
          <table>
            <tr class='header-row'>
              <th colSpan='2'>Cash and Investments</th><td class='line-item-amount'></td>
            </tr>
            {this.netWorth.assets.filter(value => value.category === 1).map(asset => <AssetRow asset={asset}></AssetRow>)}
            <tr class='header-row'>
              <th colSpan='2'>Long Term Assets</th><td class='line-item-amount'></td>
            </tr>
            {this.netWorth.assets.filter(value => value.category === 2).map(asset => <AssetRow asset={asset}></AssetRow>)}
            <tr class='header-row'>
              <th colSpan='2'>Total Assets</th>
              <td>{this.netWorth.totalAssets}</td>
              </tr>
          </table>
        </div>
        <div class='row'>
          <h4>Liabilities</h4>
          <div class='fill-remaining-space'></div>
        </div>
        <div>
          <table>
            <tr class='header-row'>
              <th>Long Term Assets</th>
              <th>Monthly Payment</th>
              <td class='line-item-amount'></td>
            </tr>
            {this.netWorth.liablities.filter(value => value.category === 1).map(liability => <LiabilityRow liability={liability}></LiabilityRow>)}
            <tr class='header-row'>
              <th>Long Term Debt</th>
              <th>Monthly Payment</th>
              <td class='line-item-amount'></td>
            </tr>
            {this.netWorth.liablities.filter(value => value.category === 2).map(liability => <LiabilityRow liability={liability}></LiabilityRow>)}
            <tr class='header-row'>
              <th colSpan='2'>Total Liabilities</th>
              <td>{this.netWorth.totalLiabilities}</td>
              </tr>
          </table>
        </div>
      </div>
    );
  }

}

export default Main;
