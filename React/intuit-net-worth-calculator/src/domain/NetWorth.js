export class NetWorth {
    netWorth = 0;
    totalAssets = 0;
    totalLiabilities = 0;
    assets = [];
    liablities = [];

    constructor(netWorth, assets, totalAssets, liablities, totalLiabilities) {
        this.netWorth = netWorth;
        this.assets = assets;
        this.totalAssets = totalAssets;
        this.liablities = liablities;
        this.totalLiabilities = totalLiabilities;
    }
}