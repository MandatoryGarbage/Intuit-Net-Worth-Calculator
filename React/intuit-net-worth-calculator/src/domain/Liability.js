export class Liability {
    category = 0;
    lineItem = '';
    monthlyPayment = 0
    amount = 0;

    constructor(category, lineItem, monthlyPayment, amount) {
        this.category = category;
        this.lineItem = lineItem;
        this.monthlyPayment = monthlyPayment;
        this.amount = amount;
    }
}