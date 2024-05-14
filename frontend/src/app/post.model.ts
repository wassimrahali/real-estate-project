export interface Post {
content: any;
  title: string;
  prix: number;
  type: string;
  description: string;
  lieu: string;
  typeDeTransaction: string;
  superficie: number;
  sallesDeBains: number;
  chambres: number;
  user_id: number;
  images: string[]; // Add an array of image URLs
}
