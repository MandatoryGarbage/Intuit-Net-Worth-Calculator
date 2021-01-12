import { NetWorthService } from './../../service/net-worth/net-worth.service';
import { Asset } from './../../domain/asset';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-asset-row',
  templateUrl: './asset-row.component.html',
  styleUrls: ['./asset-row.component.css']
})
export class AssetRowComponent implements OnInit {

  @Input()
  asset: Asset;

  constructor(public netWorthService: NetWorthService) { }

  ngOnInit() {
  }

}
