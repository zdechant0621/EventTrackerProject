document.addEventListener('DOMContentLoaded', function () {
    const cityTableBody = document.getElementById('cityTableBody');
    const cityFormContainer = document.getElementById('cityFormContainer');
    const updateCityFormContainer = document.getElementById('updateCityFormContainer');
    const deleteCityBtn = document.getElementById('deleteCityBtn');

    fetchCities();

    createCityForm(cityFormContainer);
    createUpdateCityForm(updateCityFormContainer);

    cityFormContainer.addEventListener('submit', function (event) {
        event.preventDefault();
        createCity();
    });

    updateCityFormContainer.addEventListener('submit', function (event) {
        event.preventDefault();
        updateCity();
    });

    cityTableBody.addEventListener('click', function (event) {
        if (event.target.tagName === 'TD') {
            const cityId = event.target.parentElement.dataset.id;
            displayDetailView(cityId);
        }
    });

    deleteCityBtn.addEventListener('click', function () {
        const cityId = document.getElementById('detailView').dataset.id;
        deleteCity(cityId);
    });
});

function createCityForm(container) {
    const cityForm = document.createElement('form');
    cityForm.id = 'cityForm';

    createAndAppendInput(cityForm, 'City Name', 'text', 'cityName', true);
    createAndAppendInput(cityForm, 'State/Country', 'text', 'stateCountry', true);
    createAndAppendTextarea(cityForm, 'Description', 'description', true);
    createAndAppendInput(cityForm, 'Arrival Date', 'date', 'arrivalDate', false);
    createAndAppendInput(cityForm, 'Departure Date', 'date', 'departureDate', false);
    createAndAppendCheckbox(cityForm, 'Shot Glass Bought', 'shotGlassBought');
    createAndAppendCheckbox(cityForm, 'Enabled', 'enabled');

    const submitButton = document.createElement('button');
    submitButton.type = 'submit';
    submitButton.textContent = 'Create City';
    cityForm.appendChild(submitButton);

    container.appendChild(cityForm);
}

function createUpdateCityForm(container) {
    const updateCityForm = document.createElement('form');
    updateCityForm.id = 'updateCityForm';

    createAndAppendInput(updateCityForm, 'City Name', 'text', 'updateCityName', true);
    createAndAppendInput(updateCityForm, 'State/Country', 'text', 'updateStateCountry', true);
    createAndAppendTextarea(updateCityForm, 'Description', 'updateDescription', true);
    createAndAppendInput(updateCityForm, 'Arrival Date', 'date', 'updateArrivalDate', false);
    createAndAppendInput(updateCityForm, 'Departure Date', 'date', 'updateDepartureDate', false);
    createAndAppendCheckbox(updateCityForm, 'Shot Glass Bought', 'updateShotGlassBought');
    createAndAppendCheckbox(updateCityForm, 'Enabled', 'updateEnabled');

    const submitButton = document.createElement('button');
    submitButton.type = 'submit';
    submitButton.textContent = 'Update City';
    updateCityForm.appendChild(submitButton);

    container.appendChild(updateCityForm);
}

function createAndAppendInput(form, label, type, id, required) {
    const labelElement = document.createElement('label');
    labelElement.textContent = label + ':';
    form.appendChild(labelElement);

    const inputElement = document.createElement('input');
    inputElement.type = type;
    inputElement.id = id;
    if (required) {
        inputElement.required = true;
    }

    form.appendChild(inputElement);
}

function createAndAppendTextarea(form, label, id, required) {
    const labelElement = document.createElement('label');
    labelElement.textContent = label + ':';
    form.appendChild(labelElement);

    const textareaElement = document.createElement('textarea');
    textareaElement.id = id;
    if (required) {
        textareaElement.required = true;
    }

    form.appendChild(textareaElement);
}

function createAndAppendCheckbox(form, label, id) {
    const checkboxElement = document.createElement('input');
    checkboxElement.type = 'checkbox';
    checkboxElement.id = id;

    const labelElement = document.createElement('label');
    labelElement.textContent = label + ':';
    labelElement.appendChild(checkboxElement);

    form.appendChild(labelElement);
}

function fetchCities() {
	fetch('/api/cities')
		.then(response => {
			if (response.ok) {
				return response.json();
			} else {
				throw new Error('Failed to fetch cities');
			}
		})
		.then(cities => {
			updateCityTable(cities);
		})
		.catch(error => {
			console.error(error);
		});
}

function createCity() {
	const cityForm = document.getElementById('cityForm');
	const cityName = document.getElementById('cityName').value;

	const stateCountry = document.getElementById('stateCountry').value;
	const description = document.getElementById('description').value;
	const arrivalDate = document.getElementById('arrivalDate').value;
	const departureDate = document.getElementById('departureDate').value;
	const shotGlassBought = document.getElementById('shotGlassBought').checked;
	const enabled = document.getElementById('enabled').checked;

	const cityData = {
		city: cityName,
		stateCountry: stateCountry,
		description: description,
		arrivalDate: arrivalDate,
		departureDate: departureDate,
		shotGlassBought: shotGlassBought,
		enabled: enabled
	};

	fetch('/api/cities', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(cityData)
	})
		.then(response => {
			if (response.ok || response.status === 201) {
				return response.json();
			} else {
				throw new Error('Failed to create city');
			}
		})
		.then(newCity => {
			fetchCities();
			cityForm.reset();
		})
		.catch(error => {
			console.error(error);
		});
}

function displayDetailView(cityId) {
	const detailView = document.getElementById('detailView');

	const xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState === XMLHttpRequest.DONE) {
			if (xhr.status === 200) {
				const city = JSON.parse(xhr.responseText);
				fillUpdateForm(city);
				detailView.dataset.id = city.id;
				detailView.style.display = 'block';
			} else {
				console.error('Failed to fetch city details');
			}
		}
	};

	xhr.open('GET', `/api/cities/${cityId}`, true);
	xhr.send();
}

function updateCity() {
	const updateCityForm = document.getElementById('updateCityForm');
	const cityId = document.getElementById('detailView').dataset.id;

	const updatedCityData = {
	};

	fetch(`/api/cities/${cityId}`, {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(updatedCityData)
	})
		.then(response => {
			if (response.ok) {
				fetchCities();
				document.getElementById('detailView').style.display = 'none';
			} else {
				throw new Error('Failed to update city');
			}
		})
		.catch(error => {
			console.error(error);
		});
}

function deleteCity(cityId) {
	fetch(`/api/cities/${cityId}`, {
		method: 'DELETE'
	})
		.then(response => {
			if (response.ok) {
				fetchCities();
				document.getElementById('detailView').style.display = 'none';
			} else {
				throw new Error('Failed to delete city');
			}
		})
		.catch(error => {
			console.error(error);
		});
}

function updateCityTable(cities) {
	const cityTableBody = document.getElementById('cityTableBody');
	cityTableBody.innerHTML = '';
	cities.forEach(function(city) {
		const row = cityTableBody.insertRow();
		row.dataset.id = city.id;

		const properties = [
			'id', 'city', 'stateCountry', 'description',
			'arrivalDate', 'departureDate', 'shotGlassBought', 'enabled'
		];

		properties.forEach(function(prop) {
			const cell = row.insertCell();
			cell.textContent = city[prop];
		});
	});
}