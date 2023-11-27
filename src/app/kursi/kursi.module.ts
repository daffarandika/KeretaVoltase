import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { KursiComponent } from './kursi.component';



@NgModule({
  declarations: [KursiComponent],
  imports: [
    CommonModule
  ],
  exports: [KursiComponent]
})
export class KursiModule { }
