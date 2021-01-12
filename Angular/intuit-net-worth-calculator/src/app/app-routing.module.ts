import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NetWorthTrackerComponent } from './component/net-worth-tracker/net-worth-tracker.component';

const routes: Routes = [
  { path: '', component: NetWorthTrackerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
