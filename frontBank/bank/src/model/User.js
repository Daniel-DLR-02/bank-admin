export class LoginDto {
    constructor(id, name,lastName,userName,password,bankAccounts) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.bankAccounts = bankAccounts;
    }
}

