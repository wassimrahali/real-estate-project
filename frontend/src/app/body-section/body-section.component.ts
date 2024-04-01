import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-body-section',
  templateUrl: './body-section.component.html',
  styleUrl: './body-section.component.scss'
})
export class BodySectionComponent {
  post:any
  constructor(public shered:AuthService) { }
  Posts=[{image:"https://img.freepik.com/photos-gratuite/beau-village_1368-6250.jpg?size=626&ext=jpg",title:'house1',desc:'un grande maison avec 3 chambre'},{image:"https://img.freepik.com/photos-gratuite/villa-luxe-piscine-design-contemporain-spectaculaire-art-numerique-immobilier-maison-maison-propriete-ge_1258-150749.jpg?w=900&t=st=1711860757~exp=1711861357~hmac=31db40b01ae74eee55b172e191334b28b33d260800efd670e953466c0b01c71b",title:"house2",desc:'un petit maison avec un chambre'},{image:"https://img.freepik.com/photos-premium/maison-moderne-dans-parc-maison-moderne-matin-maison-moderne-dans-ville_980226-5801.jpg?w=1060",title:'house3',desc:'un grande maison avec 3 chambre'},{image:"https://img.freepik.com/photos-premium/bel-exterieur-maison-luxe-nouvellement-construite_100800-12332.jpg?w=900",title:"house4",desc:'un grande maison avec 4 chambre'},{image:"https://img.freepik.com/photos-gratuite/rendu-3d-du-modele-maison_23-2150799681.jpg?size=626&ext=jpg&ga=GA1.1.1514145434.1711860521&semt=sph",title:"house4",desc:'un grande maison avec 4 chambre'},{image:"https://img.freepik.com/photos-premium/image-exterieure-nouvelle-maison-moderne-grandes-fenetres-jardin-dans-zone-rurale-sous-beau-ciel-generative-ai_438099-14197.jpg?w=1060",title:"house4",desc:'un grande maison avec 4 chambre'},{image:"https://img.freepik.com/photos-gratuite/beau-village_1368-6250.jpg?size=626&ext=jpg",title:'house1',desc:'un grande maison avec 3 chambre'},{image:"https://img.freepik.com/photos-gratuite/villa-luxe-piscine-design-contemporain-spectaculaire-art-numerique-immobilier-maison-maison-propriete-ge_1258-150749.jpg?w=900&t=st=1711860757~exp=1711861357~hmac=31db40b01ae74eee55b172e191334b28b33d260800efd670e953466c0b01c71b",title:"house2",desc:'un petit maison avec un chambre'},{image:"https://img.freepik.com/photos-premium/maison-moderne-dans-parc-maison-moderne-matin-maison-moderne-dans-ville_980226-5801.jpg?w=1060",title:'house3',desc:'un grande maison avec 3 chambre'},{image:"https://img.freepik.com/photos-premium/bel-exterieur-maison-luxe-nouvellement-construite_100800-12332.jpg?w=900",title:"house4",desc:'un grande maison avec 4 chambre'},{image:"https://img.freepik.com/photos-gratuite/rendu-3d-du-modele-maison_23-2150799681.jpg?size=626&ext=jpg&ga=GA1.1.1514145434.1711860521&semt=sph",title:"house4",desc:'un grande maison avec 4 chambre'},{image:"https://img.freepik.com/photos-premium/image-exterieure-nouvelle-maison-moderne-grandes-fenetres-jardin-dans-zone-rurale-sous-beau-ciel-generative-ai_438099-14197.jpg?w=1060",title:"house4",desc:'un grande maison avec 4 chambre'}]
  ngOnInit():void{
    this.shered['getAllPost']().subscribe(
      (      res: any)=>{
        console.log(res)
        this.post=res
      },
      (      err: any)=>{
        console.log(err)
      }
    )
  }
}
