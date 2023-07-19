function registerCustomer() {
	const firstName = document.getElementById('firstName').value
	const lastName = document.getElementById('lastName').value
	const email = document.getElementById('email').value
	const mobile = document.getElementById('mobile').value
	const city = document.getElementById('city').value

	const customerData = {
		firstName: firstName,
		lastName: lastName,
		email: email,
		mobile: mobile,
		city: city,
	}

	// Replace 'your_api_endpoint' with the actual API endpoint to register the customer
	fetch('your_api_endpoint', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(customerData),
	})
		.then((response) => response.json())
		.then((data) => {
			// Handle the response from the server if needed
			console.log(data)
			alert('Customer registered successfully!')
		})
		.catch((error) => {
			console.error('Error:', error)
			alert('Failed to register customer!')
		})
}
