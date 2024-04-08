import { Component } from '@angular/core';

@Component({
  selector: 'app-real-estate-menu',
  templateUrl: './real-estate-menu.component.html',
  styleUrl: './real-estate-menu.component.scss'
})
export class RealEstateMenuComponent {
menu='Houses'
Houses(){
  this.menu='Houses'
}
SmartHome(){
  this.menu='Smart Home'
}
Apartement(){
  this.menu='Apartement'
}
Office(){
  this.menu='Office'
}
bugalow(){
  this.menu='bugalow'
}
}
