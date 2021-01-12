import { Asset } from './asset';
import { Currency } from './currency';
import { Liability } from './liability';

export class NetWorth {
    netWorth: number = 0;
    assets: Asset[] = [];
    liabiliies: Liability[] = [];
    currency: Currency = new Currency();
}
