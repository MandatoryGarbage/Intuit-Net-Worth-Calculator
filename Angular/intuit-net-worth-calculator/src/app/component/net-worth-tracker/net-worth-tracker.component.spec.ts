import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NetWorthTrackerComponent } from './net-worth-tracker.component';

describe('NetWorthTrackerComponent', () => {
  let component: NetWorthTrackerComponent;
  let fixture: ComponentFixture<NetWorthTrackerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NetWorthTrackerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NetWorthTrackerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
