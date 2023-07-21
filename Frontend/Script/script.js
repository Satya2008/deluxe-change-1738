document
	.getElementById('login-form')
	.addEventListener('submit', async function (event) {
		event.preventDefault()

		const username = document.getElementById('username').value
		const password = document.getElementById('password').value
		const role = document.getElementById('role').value

		const data = {
			username: username,
			password: password,
			role: role,
		}

		try {
			const response = await fetch('https://example.com/api/login', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify(data),
			})

			if (!response.ok) {
				throw new Error('Login failed.')
			}

			const result = await response.json()
			console.log(result)
		} catch (error) {
			console.error(error)
		}
	})
