import { NetWorthService } from './../../service/net-worth/net-worth.service';
import { CurrencyService } from './../../service/currency/currency.service';
import { Component, OnInit } from '@angular/core';
import { Currency } from 'src/app/domain/currency';
import { NetWorth } from 'src/app/domain/net-worth';

@Component({
  selector: 'app-net-worth-tracker',
  templateUrl: './net-worth-tracker.component.html',
  styleUrls: ['./net-worth-tracker.component.css'],
})
export class NetWorthTrackerComponent implements OnInit {
  constructor(
    public currencyService: CurrencyService,
    public netWorthService: NetWorthService
  ) {}

  ngOnInit() {
    this.currencyService.listCurrencies().subscribe((data: Currency[]) => {
      this.currencyService.currencies = data.sort((a, b) =>
        a.currencyCode.localeCompare(b.currencyCode)
      );
      this.currencyService.selectedCurrency = this.currencyService.currencies[0];
    });
    this.netWorthService.initialize().subscribe((data: NetWorth) => {
      this.netWorthService.netWorth = data;
    });
  }
}
