const input = document.getElementById("city");
const card = document.querySelector(".card");
const button = document.getElementById("submit");
const apikey = "ebd18cc0bb84deacb95831f59cf8fdab";

button.addEventListener("click", async (event) => {
  const city = input.value;
  if (city) {
    try {
      const weatherData = await getWeatherData(city);

      displayWeatherInfo(weatherData);
    } catch (error) {
      console.error(error);
      displayError(error);
    }
  } else {
    displayError("enter a city");
  }
});

async function getWeatherData(city) {
  const apiUrl = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apikey}`;

  const response = await fetch(apiUrl);

  if (!response.ok) {
    throw new Error("could not fetch weather data");
  }
  return await response.json();
}

function displayWeatherInfo(data) {
  const {
    name: city,
    main: { temp, humidity },
    weather: [{ description, id }],
  } = data;
  card.textContent = "";
  card.style.display = "flex";

  const cityDisplay = document.createElement("h1");
  const tempDisplay = document.createElement("p");
  const humidityDisplay = document.createElement("p");
  const descDisplay = document.createElement("p");
  const weatherEmoji = document.createElement("p");

  cityDisplay.textContent = city;
  tempDisplay.textContent = `${(temp - 273.15).toFixed(1)}C`;
  humidityDisplay.textContent = `humidity : ${humidity}%`;
  descDisplay.textContent = description;
  weatherEmoji.textContent = getWeatherEmoji(id);

  tempDisplay.classList.add("tempDisplay");
  humidityDisplay.classList.add("humidityDisplay");
  descDisplay.classList.add("descDisplay");
  weatherEmoji.classList.add("weatherEmoji");

  card.appendChild(cityDisplay);
  card.appendChild(tempDisplay);
  card.appendChild(humidityDisplay);
  card.appendChild(descDisplay);
  card.appendChild(weatherEmoji);
}

function getWeatherEmoji(weatherid) {
  switch (true) {
    case weatherid >= 200 && weatherid < 300:
      return "⛈️";

    case weatherid >= 300 && weatherid < 400:
      return "🌧️";

    case weatherid >= 500 && weatherid < 600:
      return "🌧️";

    case weatherid >= 600 && weatherid < 700:
      return "❄️";

    case weatherid >= 700 && weatherid < 800:
      return "🌫️";

    case weatherid === 800:
      return "☀️";

    case weatherid >= 801 && weatherid < 810:
      return "☁️";

    default:
      return "🤡";
  }
}

function displayError(message) {
  const errorDisplay = document.createElement("p");
  errorDisplay.textContent = message;
  errorDisplay.classList.add("errorDisplay");

  card.textContent = "";
  card.style.display = "flex";
  card.appendChild(errorDisplay);
}
