export class AdditionalServices {
        constructor(
                public id: number, 
                public name: string) 
        { }
}

export class UpdateAdditionalServiceRequest {
        oldName: string;
        newName: string;
}