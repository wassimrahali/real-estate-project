import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.scss']
})
export class CreatePostComponent {
[x: string]: any;
  showSuccessAlert = false;
  showDangerAlert = false;
  post = {
    title: "Example Post",
    prix: 100000,
    type: "House",
    description: "This is an example post description.",
    lieu: "Example Location",
    typeDeTransaction: "Sale",
    superficie: 150,
    sallesDeBains: 2,
    chambres: 3,
    user_id: 1 // Assuming user_id is a number
  };
  imageFiles: File[] = [];

  constructor(public shared: AuthService) { }

  selectImage(event: any) {
    this.imageFiles = event.target.files;
  }

  Create() {
    const formData = new FormData();
    formData.append('title', this.post.title);
    formData.append('prix', this.post.prix.toString());
    formData.append('type', this.post.type);
    formData.append('description', this.post.description);
    formData.append('lieu', this.post.lieu);
    formData.append('typeDeTransaction', this.post.typeDeTransaction);
    formData.append('superficie', this.post.superficie.toString());
    formData.append('sallesDeBains', this.post.sallesDeBains.toString());
    formData.append('chambres', this.post.chambres.toString());
    formData.append('user_id', this.post.user_id.toString());

    // Reset alert variables
    this.showSuccessAlert = false;
    this.showDangerAlert = false;

    for (let file of this.imageFiles) {
      formData.append('imageFiles', file);
    }

    this.shared.createPost(formData)
      .subscribe(
        res => {
          console.log(res);
          this.showSuccessAlert = true; // Show success alert
          // Optionally, you can reset the form or perform any other actions
        },
        err => {
          console.error(err);
          this.showDangerAlert = true; // Show danger alert
          // Optionally, you can display the error message or perform any other actions
        }
      );
  }
}
