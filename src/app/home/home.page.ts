import { Component } from '@angular/core';
import { AlertController } from '@ionic/angular';

import { Kursi } from '../data/kursi';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  constructor(
    private alertController: AlertController,
  ) {}

  kursi: Kursi = {
    nomer: 3,
    namaPenumpang: "andi"
  } as Kursi;

  async kursiClicked(nomer: number) {
    const alert = await this.alertController.create({
      header: String(nomer),
      cssClass: 'app-alert',
    })
    await alert.present();
  }

}
