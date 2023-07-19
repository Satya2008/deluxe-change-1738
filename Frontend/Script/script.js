document
	.getElementById('login-form')
	.addEventListener('submit', function (event) {
		event.preventDefault()
		const username = document.getElementById('username').value
		const password = document.getElementById('password').value
		const role = document.getElementById('role').value

		// Replace the following conditional block with actual authentication logic
		if (username === 'admin' && password === 'admin123' && role === 'ADMIN') {
			alert('Logged in as ADMIN!')
		} else if (
			username === 'customer' &&
			password === 'customer123' &&
			role === 'CUSTOMER'
		) {
			alert('Logged in as Customer!')
		} else if (
			username === 'operator' &&
			password === 'operator123' &&
			role === 'OPERATOR'
		) {
			alert('Logged in as Operator!')
		} else {
			alert('Invalid login credentials or role selection.')
		}
	})
