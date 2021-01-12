import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Currency } from 'src/app/domain/currency';
import { NetWorth } from './../../domain/net-worth';

@Injectable({
  providedIn: 'root',
})
export class NetWorthService {
  netWorth: NetWorth = new NetWorth();

  constructor(private http: HttpClient) {}

  public initialize(): Observable<NetWorth> {
    return this.http.get<NetWorth>('/initialize');
  }

  public updateNetWorth(): Observable<NetWorth> {
    const body = JSON.stringify({
      assets: this.netWorth.assets,
      liabilities: this.netWorth.liabiliies,
      currencyCode: this.netWorth.currency.currencyCode,
    });
    return this.http.post<NetWorth>('/netWorth', body);
  }

  public convertNetWorth(convertCurrency: Currency): Observable<NetWorth> {
    const body = JSON.stringify({
      netWorth: this.netWorth,
      convertCurrency: convertCurrency.currencyCode,
    });
    return this.http.post<NetWorth>('/convert', body);
  }
}
