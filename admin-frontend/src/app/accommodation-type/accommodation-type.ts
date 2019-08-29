export class AccommodationType {
    constructor(
        public id: number,
        public name: string
    ) {}
}

export class CreateAccommodationTypeRequest { 
    name: string;
}

export class UpdateAccommodationTypeRequest {
    oldName: string;
    newName: string;
}

export class DeleteAccommodationTypeRequest { 
    name: string;
}

export class CodebookResponse {
    feedback: string;
}