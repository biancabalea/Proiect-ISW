import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-post-book',
  templateUrl: './post-book.component.html',
  styleUrl: './post-book.component.scss'
})
export class PostBookComponent {

  postBookForm!: FormGroup;
	isSpinning: boolean = false;
	selectedFile: File | null| undefined;
	imagePreview: string | ArrayBuffer | null | undefined;
	listOfOption: Array<{ label: string; value: string}> = [];
	listOfAuthors = ["Ian Sommerville","Ion Stancu","Frank Netter"];
	listOfSubject = ["Engineering","Economy","Anatomy"];
	listOfRating = ["4","4,5","5"];
	listOfLanguage = ["English","Romanian"];
  validateForm: any;

  constructor(private fb: FormBuilder){}
	
	ngOnInit(){
		this.postBookForm = this.fb.group({
			name:[null, Validators.required],
			author:[null, Validators.required],
			subject :[null, Validators.required],
			rating:[null, Validators.required],
			language:[null, Validators.required],
			price:[null, Validators.required],
			description:[null, Validators.required],
			year:[null, Validators.required],
	})
	}

  postBook(){
		console.log(this.postBookForm.value);
    const formData: FormData = new FormData();
    if (this.selectedFile){
		  formData.append('img', this.selectedFile);
    }
		formData.append('author', this.validateForm.get('author').value);
		formData.append('name', this.validateForm.get('name').value);
		formData.append('subject', this.validateForm.get('subject').value);
		formData.append('rating', this.validateForm.get('rating').value);
		formData.append('year', this.validateForm.get('year').value);
		formData.append('language', this.validateForm.get('language').value);
		formData.append('description', this.validateForm.get('description').value);
		formData.append('price', this.validateForm.get('price').value);
		console.log(formData);
  }

  onFileSelected(event: any){
    this.selectedFile = event.target.files[0];
    this.previewImage();
  }

  previewImage(){
    if(this.selectedFile){
		  const reader = new FileReader();
		  reader.onload = () => {
		  this.imagePreview = reader.result;
		  }
		  reader.readAsDataURL(this.selectedFile);
    }
	}

}
