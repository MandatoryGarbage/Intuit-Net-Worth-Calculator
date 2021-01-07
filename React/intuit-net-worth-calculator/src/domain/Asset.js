export class Asset {
    category = 0;
    lineItem = '';
    amount = 0;

    constructor(category, lineItem, amount) {
        this.category = category;
        this.lineItem = lineItem;
        this.amount = amount;
    }
}