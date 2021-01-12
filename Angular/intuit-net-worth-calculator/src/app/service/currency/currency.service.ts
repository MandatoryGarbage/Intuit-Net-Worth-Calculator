import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Currency } from 'src/app/domain/currency';

@Injectable({
  providedIn: 'root'
})
export class CurrencyService {

  currencies: Currency[] = [];
  selectedCurrency: Currency = new Currency();

  constructor(private http: HttpClient) {}

  public listCurrencies(): Observable<Currency[]> {
    return this.http.get<Currency[]>('/currency');
  }

}
