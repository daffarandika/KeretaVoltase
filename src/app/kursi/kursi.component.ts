import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Kursi } from '../data/kursi';

@Component({
  selector: 'kursi',
  templateUrl: './kursi.component.html',
  styleUrls: ['./kursi.component.scss'],
})
export class KursiComponent  implements OnInit {

  @Input() kursi: Kursi = {
    nomer: -1,
    namaPenumpang: undefined
  } as Kursi;
  @Output() kursiClicked = new EventEmitter<number>();

  getKursiByNomer() {
    this.kursiClicked.emit(this.kursi.nomer)
  }

  constructor() { }

  ngOnInit() {}

}
