import './Main.css';
import React from 'react';
import { Currency } from '../domain/Currency';
import { NetWorth } from '../domain/NetWorth';
import { Asset } from '../domain/Asset';
import { Liability } from '../domain/Liability';
import AssetRow from '../AssetRow/AssetRow';

class Main extends React.Component {

  currencies = [
    new Currency(1, '$', 'CAD'),
    new Currency(2, '$', 'USD'),
    new Currency(3, '', 'GBP')
  ];

  netWorth = new NetWorth(15, [new Asset(1, 'Bank', '10.00'), new Asset(2, 'Savings', 15)], 25, [new Liability(1, 'Credit Card', 8), new Liability(2, 'Line of Credit', 2)], 10);

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
        </div>
        <div class='row'>
          <h4>Assets</h4>
          <div class='fill-remaining-space'></div>
        </div>
        <div>
          <table>
            <tr class='header-row'>
              <th>Cash and Investments</th><td class='line-item-amount'></td>
            </tr>
            <AssetRow asset={this.netWorth.assets[0]}></AssetRow>
            <tr class='header-row'>
              <th>Long Term Assets</th><td class='line-item-amount'></td>
            </tr>
          </table>
        </div>
      </div>
    );
  }

}

export default Main;
