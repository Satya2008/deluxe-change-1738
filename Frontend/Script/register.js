const handleSubmit = (event) => {
	event.preventDefault()

	const registrationForm = document.getElementById('registrationForm')

	const firstName = registrationForm.elements.firstName.value
	const lastName = registrationForm.elements.lastName.value
	const email = registrationForm.elements.email.value
	const mobile = registrationForm.elements.mobile.value
	const city = registrationForm.elements.city.value

	const data = {
		firstName,
		lastName,
		email,
		mobile,
		city,
	}

	fetch('https://example.com/api/register', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(data),
	})
		.then((response) => response.json())
		.then((responseData) => {
			console.log('Response from API:', responseData)
		})
		.catch((error) => {
			console.error('Error:', error)
		})
}

const submitButton = document.querySelector('button[type="submit"]')
submitButton.addEventListener('click', handleSubmit)
