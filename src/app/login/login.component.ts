import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDTO: LoginDTO;
  userDTO: UserDTO;
  users: UserDTO[];

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
  }

  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.service.login(this.loginDTO).subscribe((user) => {

      if (user != null) {
        localStorage.setItem('currentUser', JSON.stringify(user));

        switch (user.usertype.toString()) {
          case 'ADMIN': {
            this.router.navigate(['/admin-dashboard']);
            break;
          }
          case 'USER': {
            this.router.navigate(['/admin-dashboard']);
            break;
          }
          default:
            this.router.navigate(['/login']);
        }
      }
      else {
        alert ("Invalid Username or Password");
      }
    });
  }
  signup(f: NgForm): void {
    this.userDTO = new UserDTO();
    this.userDTO.username = f.value.username;
    this.userDTO.password = f.value.password;

    var existinguser = false;

    this.loginDTO = new LoginDTO(f.value.username, f.value.password);
    this.service.getAll().subscribe(users => this.users = users);
    var i;
    for (i = 0; i < this.users.length; i++) { 
      var uniquename = this.users[i].username;
      if (uniquename == this.userDTO.username) {
          existinguser=true;
          break;
      }
    } 

    this.service.login(this.loginDTO).subscribe((user) => {

      if (existinguser == true) {
        alert ("Username Already Exists");
        localStorage.setItem('currentUser', JSON.stringify(user));
      }
      else {
        if (this.userDTO.username=="") {
          alert ("You Must Insert Username");
        }
        else {
          this.userDTO.usertype = 1;
            this.service.insert(this.userDTO).subscribe();
          alert ("User Created");
        }
      }
    });
  }
}