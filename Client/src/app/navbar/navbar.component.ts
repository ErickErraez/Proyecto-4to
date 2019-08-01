import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  showNav: any;

  constructor() {
    sessionStorage.setItem('showNav', 'true');
  }

  ngOnInit() {

  }

  showNavbar() {
    if (JSON.parse(sessionStorage.getItem('showNav')) === true) {
      return true;
    }
    if (JSON.parse(sessionStorage.getItem('showNav')) === false) {
      return false;
    }
  }

}
