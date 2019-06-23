import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Accommodation } from '../model/accommodation.model';

@Injectable({
  providedIn: 'root'
})
export class PictureService {

  constructor(private http : HttpClient){
        
  }
  uploadPictures(fd : FormData){
    return this.http.post('api/pictures/upload',fd).subscribe();
 }
}
