//preceeded variables with transactions for variables for clarity with no preceedings in the transactions array of objects

import { useState, useEffect } from "react";

import { Chart as ChartJS } from "chart.js/auto";
import { Bar, Doughnut } from "react-chartjs-2";
import { Calendar } from "primereact/calendar";

function track() {
  let today = new Date(); //this variable is used 2-3 times so declared top
  //below belong to dropdown and are false at start
  const [activeSelect, setActiveSelect] = useState(false);
  const [activeMenu, setActiveMenu] = useState(false);

  //below belong to input data we give
  const [expenseType, setExpenseType] = useState("groceries");
  const [transactionAmount, setTransactionAmount] = useState(""); //0 pedithe default 0 vasthundi which looks ugly
  const [transactionDate, setTransactionDate] = useState("");
  //to store multiple transactions
  //update:added locale storage for future use
  //concept of locale storage is we save then retrievd
  //generally locale storage takes and returns strings so we convert both before sending and recieveing
  //but it doesnt turn a string date to normla date so we use map to do it
  //here we use ... operator open it then write date: new date(t.date) here it reads string and returns the exact date for it
  //date() can take multiple things there like pure numbers, the date as string or numbers(2026,02,09)
  //note:the code inside useEffect runs only once means only when page is loaded and also when the dependence elemnt changes which is transaction array here in this case
  const [transactions, setTransactions] = useState(() => {
    const saved = localStorage.getItem("transactions");
    //if it is first tiem saved is empty so empty array
    if (!saved) return [];
    const list = JSON.parse(saved);
    return list.map((t) => ({ ...t, date: new Date(t.date) }));
  });

  useEffect(() => {
    localStorage.setItem("transactions", JSON.stringify(transactions));
  }, [transactions]);

  const categoryTotals = {};
  const dateTotals = [0, 0, 0, 0, 0];
  const categories = [
    "groceries",
    "medical",
    "snacks",
    "electronics",
    "clothes",
    "travel",
  ];
  // below variables to make the calender take date only up to 1 month

  let maxDate = today;
  let minDate = new Date(
    today.getFullYear(),
    today.getMonth() - 1,
    today.getDate(),
  );

  //below lines for fotmob style slides
  const [slideIndex, setSlideIndex] = useState(0);
  //for the dropdown menu
  const toggle = () => {
    setActiveSelect(!activeSelect);

    setActiveMenu(!activeMenu);
  };
  //for dropdown removed caret coz it made me confuse
  const selectOption = (category) => {
    setExpenseType(category);
    setActiveSelect(false);
    setActiveMenu(false);
  };

  function handleTransactionAmountChange(event) {
    setTransactionAmount(event.target.value);
  }

  function handleTransactionsChange() {
    // input validation done below
    //return makes the function stop which in return means the transaction is not added and alert displays the message
    if (!transactionDate) {
      alert("enter the date of transaction");
      return;
    }
    if (!transactionAmount) {
      alert("enter the amount of transaction");
      return;
    }
    // using Number function becuase normal one doesnot count 0.5 which is valid(if dollars) it also rejects negative
    if (Number(transactionAmount) > 0) {
      const newTransaction = {
        date: transactionDate,
        amount: transactionAmount,
        expense: expenseType,
      };
      //unpacking is a must
      setTransactions([...transactions, newTransaction]);
      //after successful submit clearing the form
      setTransactionAmount("");
      setTransactionDate("");
    } else {
      alert("enter a valid number");
      return;
    }
  }

  function handleRemoveTransaction(index) {
    setTransactions((transactions) =>
      transactions.filter((element, i) => i !== index),
    );
  } //here we are using updater function but directly setting the using setTransations alos works but using updater functions is safer so we  update teh array that is last updated and upto date

  function handleRemoveAll() {
    // window.confirm becuase one click everything wipes
    if (window.confirm("delete all transactions?")) {
      setTransactions([]);
    }
  }

  useEffect(() => {
    setTransactions((transactions) =>
      transactions.filter((transaction) => transaction.date >= minDate),
    );
  }, []); //empty [] means runs on page load
  //empty [] becuase if you put transaction there even time that array changes this function runs which changes the transaction which in return runs the effect so like a infinite loop
  function addCategoryTotal(transactions) {
    for (let i = 0; i < transactions.length; i++) {
      let transaction = transactions[i];
      let amount = Number(transaction.amount);
      let expense = transaction.expense;

      if (categoryTotals[expense]) {
        categoryTotals[expense] += amount;
      } else {
        categoryTotals[expense] = amount;
      }
    }
  }
  //dateobject - dateobject = milliseconds that is how js works with dates and that is why the code below works
  function addDateTotal(transactions) {
    let todayDate = new Date();
    todayDate.setHours(0, 0, 0, 0);
    for (let i = 0; i < transactions.length; i++) {
      let transaction = transactions[i];
      let amount = Number(transaction.amount);

      let date = transaction.date;
      const milliSecondsOfDay = 1000 * 60 * 60 * 24;
      const daysAgo = (todayDate - date) / milliSecondsOfDay;
      const bucket = Math.floor(daysAgo / 7);

      if (bucket >= 0 && bucket <= 4) {
        dateTotals[bucket] += amount;
      }
    }
  }

  // slider functions
  function leftSlide() {
    if (slideIndex === 0) {
      setSlideIndex(1);
    } else {
      setSlideIndex(slideIndex - 1);
    }
  }

  function rightSlide() {
    if (slideIndex === 1) {
      setSlideIndex(0);
    } else {
      setSlideIndex(slideIndex + 1);
    }
  }

  const chartTitle = slideIndex === 0 ? "by category" : "by week";

  addCategoryTotal(transactions);
  addDateTotal(transactions);

  //a classname for puure styling
  // value to set what we see
  //onchange to trigger -> set function -> display in microseconds
  //type for type
  //variable for value
  return (
    <>
      <h1>finance money tracker</h1>
      <div className="container">
        <label>enter the date of transaction</label>

        <Calendar
          dateFormat="dd/mm/yy"
          value={transactionDate}
          onChange={(e) => setTransactionDate(e.value)}
          showIcon
          showButtonBar
          minDate={minDate}
          maxDate={maxDate}
        />

        <label>enter the amount</label>

        <input
          type="number"
          inputMode="decimal"
          className="amount"
          value={transactionAmount}
          onChange={handleTransactionAmountChange}
        ></input>

        <label>select the type of expense here</label>
        {/*the dropdown covers both the input tag and the menu*/}

        <div className="dropdown">
          {/*active select onclicked just adds background color to input label
          notice that span is  inside the active select */}
          <div
            className={activeSelect ? "select-clicked" : "select"}
            onClick={toggle}
          >
            <span>{expenseType}</span>
          </div>
          {/*the below ul purely controls the menu the below concept is render lists in bro code*/}
          <ul className={activeMenu ? "menu active" : "menu"}>
            {categories.map((cat) => (
              <li
                key={cat}
                className={cat === expenseType ? "active" : ""}
                onClick={() => selectOption(cat)}
              >
                {cat}
              </li>
            ))}
          </ul>
        </div>

        {/*this thing displays and  vanishes a transaction when you click on the displayed version both from charts and transaciton history*/}

        <button className="submit" onClick={handleTransactionsChange}>
          submit
        </button>
      </div>
      {/*everything below is the bar charts*/}
      <div className={transactions.length > 0 ? "chart-clicked" : "chart"}>
        {/* below we use conditonal rendering among it we use shorter version of ternary opertor
          coz here we only have show or nothing no two things  */}
        <div className="slider">
          <button onClick={leftSlide}>&larr;</button>
          <h2>{chartTitle}</h2>
          <button onClick={rightSlide}>&rarr;</button>
        </div>
        {slideIndex === 0 && (
          <div className="dough">
            <Doughnut
              //two {{}} one lets you write jsx other let you write object
              data={{
                labels: Object.keys(categoryTotals),
                datasets: [
                  {
                    data: Object.values(categoryTotals),
                    backgroundColor: [
                      "#ff6384",
                      "#36a2eb",
                      "#ffce56",
                      "#4bc0c0",
                      "#9966ff",
                      "#ff9f40",
                    ],
                  },
                ],
              }}
            />
          </div>
        )}

        {slideIndex === 1 && (
          <div className="bar">
            <Bar
              data={{
                labels: [
                  "this week",
                  "1 week ago",
                  "2 weeks ago",
                  "3 weeks ago",
                  "4 weeks ago",
                ],
                datasets: [
                  {
                    data: dateTotals,
                    backgroundColor: [
                      "#ff6384",
                      "#36a2eb",
                      "#ffce56",
                      "#4bc0c0",
                      "#9966ff",
                      "#ff9f40",
                    ],
                  },
                ],
              }}
            />
          </div>
        )}
      </div>
      {/* using conditional rendering so it only runs when there are transactions */}
      {transactions.length > 0 && (
        <div className="delete-itemList">
          {/* div for whole delete list */}
          <h2>click on a transaction to delete it</h2>
          <ol className="transaction-list">
            {transactions.map((transaction, index) => (
              //there used to be a div here for each melement but removed and placed the class name in the li itself
              //because it overlapped with numbers given by ul
              //i think iam dumbass becuase why the fuck i need div in first place when li acts as single element and group of elements
              <li
                className="delete-item"
                key={index}
                onClick={() => handleRemoveTransaction(index)}
              >
                {/* for spaces */}
                {transaction.date.toLocaleDateString("en-CA")}
                &nbsp;&nbsp;&nbsp;
                {transaction.amount}
                &nbsp;&nbsp;&nbsp;
                {transaction.expense}
              </li>
            ))}
          </ol>
          <button className="submit delete-all" onClick={handleRemoveAll}>
            delete all
          </button>
        </div>
      )}
    </>
  );
}

export default track;
