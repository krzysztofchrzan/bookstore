
async function postData() {
try {
const formEl = document.querySelector(".form");
var firstname=document.getElementById('first-name').value
var lastname=document.getElementById('last-name').value
var email=document.getElementById('email').value
var phoneNumber=document.getElementById('phone-number').value
var dob=document.getElementById('date-of-birth').value
var gender = document.querySelector('input[name="gender"]:checked').value;
var addressLine=document.getElementById('address-line').value			
var state=document.getElementById('state').value
var zipCode=document.getElementById('zip-code').value
var city=document.getElementById('city').value
var country=document.getElementById('country').value
var occupation=document.getElementById('occupation').value
var occupationRole=document.getElementById('occupation-role').value

const formData = new FormData(formEl);
const obj = Object.fromEntries(formData);
console.log(obj);
	
await fetch("http://localhost:3000/customer", {	
	method:'POST',
	headers: {'Accept':'application.json','Content-Type':'application/json'},
            body: JSON.stringify({
                'firstName': firstname,
                'lastName': lastname,
                'email': email,
                'phoneNumber': phoneNumber,
                'dateOfBirth': dob,
                'gender': gender,
                'address': {
                    'addressLine': addressLine,
                    'state': state,
                    'zipCode': zipCode,
                    'city': city,
                    'country': country
                },
                'occupation': occupation,
                'occupationRole': occupationRole
            })
        });
    } catch (error) {
        console.error(error);
    }
}


// Add event listener to the form submit event
document.addEventListener('DOMContentLoaded', () => {
    const formEl = document.querySelector(".form");
    formEl.addEventListener('submit', e => {
        e.preventDefault();
        postData();
    });
});