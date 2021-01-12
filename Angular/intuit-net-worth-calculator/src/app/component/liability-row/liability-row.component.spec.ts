import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LiabilityRowComponent } from './liability-row.component';

describe('LiabilityRowComponent', () => {
  let component: LiabilityRowComponent;
  let fixture: ComponentFixture<LiabilityRowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LiabilityRowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LiabilityRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
