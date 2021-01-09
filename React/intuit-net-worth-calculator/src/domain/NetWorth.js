export class NetWorth {
    netWorth = 0;
    currency = {};
    assets = [];
    liablities = [];
    totalAssets = 0;
    totalLiabilities = 0;
   

    constructor(netWorth, currency, assets, totalAssets, liablities, totalLiabilities) {
        this.netWorth = netWorth;
        this.currency = currency;
        this.assets = assets;
        this.totalAssets = totalAssets;
        this.liablities = liablities;
        this.totalLiabilities = totalLiabilities;
    }
}