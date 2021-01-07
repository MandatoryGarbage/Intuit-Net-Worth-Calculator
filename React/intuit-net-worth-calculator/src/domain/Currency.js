export class Currency {
    currencyId = 0;
    currencySymbol = '';
    currencyCode = '';

    constructor(currencyId, currencySymbol, currencyCode) {
        this.currencyId = currencyId;
        this.currencySymbol = currencySymbol;
        this.currencyCode = currencyCode;
    }
}