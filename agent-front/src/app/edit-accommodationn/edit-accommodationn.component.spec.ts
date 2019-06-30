import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAccommodationnComponent } from './edit-accommodationn.component';

describe('EditAccommodationnComponent', () => {
  let component: EditAccommodationnComponent;
  let fixture: ComponentFixture<EditAccommodationnComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditAccommodationnComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditAccommodationnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
