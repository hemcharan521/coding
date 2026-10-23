//preceeded variables with transactions for variables for clarity with no preceedings in the transactions array of objects

import { useState } from "react";

import { Chart as ChartJS } from "chart.js/auto";
import { Bar, Doughnut, Line } from "react-chartjs-2";

import { Calendar } from "primereact/calendar";

function track() {
  //below belong to dropdown and are false at start
  const [activeSelect, setActiveSelect] = useState(false);
  const [activeMenu, setActiveMenu] = useState(false);
  const [activeChart, setActiveChart] = useState(false);
  //below belong to input data we give
  const [expenseType, setExpenseType] = useState("groceries");
  const [transactionAmount, setTransactionAmount] = useState(0);
  const [transactionDate, setTransactionDate] = useState("");
  //to store multiple transactions
  const [transactions, setTransactions] = useState([]);
  const categoryTotals = {};
  const dateTotals = {};
  const categories = [
    "groceries",
    "medical",
    "snacks",
    "electronics",
    "clothes",
    "travel",
  ];
  //for the dropdown menu
  const toggle = () => {
    setActiveSelect(!activeSelect);

    setActiveMenu(!activeMenu);
  };

  const selectOption = (category) => {
    setExpenseType(category);
    setActiveSelect(false);

    setActiveMenu(false);
  };

  function handleTransactionAmountChange(event) {
    setTransactionAmount(event.target.value);
  }
  function handleTransactionDate(event) {
    setTransactionDate(event.target.value);
  }

  function handleTransactionsChange() {
    if (!transactionDate) return;
    console.log("clicked");
    const newTransaction = {
      date: transactionDate.toLocaleDateString("en-CA"),
      amount: transactionAmount,
      expense: expenseType,
    };
    //unpacking is a must
    setTransactions([...transactions, newTransaction]);
  }

  function handleRemoveTransaction(index) {
    setTransactions((transactions) =>
      transactions.filter((element, i) => i !== index),
    );
  } //here we are using updater function but directly setting the using setTransations alos works but using updater functions is safer so we  update teh array that is last updated and upto date

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

  function addDateTotal(transactions) {
    for (let i = 0; i < transactions.length; i++) {
      let transaction = transactions[i];
      let amount = Number(transaction.amount);
      let expense = transaction.expense;
      let date = transaction.date;

      if (dateTotals[date]) {
        dateTotals[date] += amount;
      } else {
        dateTotals[date] = amount;
      }
    }
  }

  function handleCharts() {
    setActiveChart(!activeChart);
  }

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

        {/* <input
          className="transactionDate"
          value={transactionDate}
          onChange={handleTransactionDate}
          type="date"
          placeholder="enter the date of transaction here"
        ></input> */}

        <Calendar
          dateFormat="dd/mm/yy"
          value={transactionDate}
          onChange={(e) => setTransactionDate(e.value)}
          showIcom
          showButtonBar
        />

        <label>enter the amount</label>

        <input
          type="text"
          inputmode="numeric"
          className="amount"
          value={transactionAmount}
          onChange={handleTransactionAmountChange}
          placeholder="enter the transaciton amount here"
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
        <ul>
          {transactions.map((transaction, index) => (
            <li key={index} onClick={() => handleRemoveTransaction(index)}>
              {transaction.date} {transaction.amount} {transaction.expense}
            </li>
          ))}
        </ul>

        <button className="submit" onClick={handleTransactionsChange}>
          submit
        </button>

        <button className="show" onClick={handleCharts}>
          show
        </button>
      </div>
      {/*everything below is the bar charts*/}
      <div className={activeChart ? "chart-clicked" : "chart"}>
        <Doughnut
          data={{
            labels: Object.keys(categoryTotals),
            datasets: [
              {
                label: "transaction history",
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
      <div className={activeChart ? "chart-clicked" : "chart"}>
        <Bar
          data={{
            labels: Object.keys(dateTotals),
            datasets: [
              {
                label: "transaction history",
                data: Object.values(dateTotals),
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
    </>
  );
}

export default track;
