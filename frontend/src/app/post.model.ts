// post.model.ts
export interface Post {
  id: number;
  title: string;
  prix: number;
  type: string;
  description: string;
  lieu: string;
  images: string[];
  tempsPub: string; // Assuming it's a string date format, adjust if necessary
  typeDeTransaction: string;
  superficie: number;
  sallesDeBains: number;
  chambres: number;
  user_id: number;
}
