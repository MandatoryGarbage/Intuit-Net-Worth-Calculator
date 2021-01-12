import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NetWorthTrackerComponent } from './component/net-worth-tracker/net-worth-tracker.component';
import { AssetRowComponent } from './component/asset-row/asset-row.component';
import { LiabilityRowComponent } from './component/liability-row/liability-row.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NetWorthTrackerComponent,
    AssetRowComponent,
    LiabilityRowComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
