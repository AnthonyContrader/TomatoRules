import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { ActivityDTO } from 'src/dto/activitydto';
import { CategoryDTO } from 'src/dto/categorydto';


/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  user: UserDTO;
  activity: ActivityDTO;
  category: CategoryDTO;

  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.activity = JSON.parse(localStorage.getItem('currentActivity'));
    this.category = JSON.parse(localStorage.getItem('currentCategory'));
  }

}
