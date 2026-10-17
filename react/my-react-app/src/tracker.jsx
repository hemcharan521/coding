//preceeded variables with transactions for variables for clarity with no preceedings in the transactions array of objects

import { useState } from "react";

import { Chart as ChartJS } from "chart.js/auto";
import { Bar, Doughnut, Line } from "react-chartjs-2";

function track() {
  const [activeSelect, setActiveSelect] = useState(false);
  const [activeCaret, setActiveCaret] = useState(false);
  const [activeMenu, setActiveMenu] = useState(false);
  const [expenseType, setExpenseType] = useState("groceries");
  const [transactionAmount, setTransactionAmount] = useState(0);
  const [transactionDate, setTransactionDate] = useState("");

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

  const toggle = () => {
    setActiveSelect(!activeSelect);
    setActiveCaret(!activeCaret);
    setActiveMenu(!activeMenu);
  };

  const selectOption = (category) => {
    setExpenseType(category);
    setActiveSelect(false);
    setActiveCaret(false);
    setActiveMenu(false);
  };

  function handleTransactionAmountChange(event) {
    setTransactionAmount(event.target.value);
  }
  function handleTransactionDate(event) {
    setTransactionDate(event.target.value);
  }

  function handleTransactionsChange() {
    console.log("clicked");
    const newTransaction = {
      date: transactionDate,
      amount: transactionAmount,
      expense: expenseType,
    };

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

  addCategoryTotal(transactions);
  addDateTotal(transactions);
  return (
    <>
      <div className="container">
        <label>enter the date of transaction</label>
        <input
          className="transactionDate"
          value={transactionDate}
          onChange={handleTransactionDate}
          type="date"
          placeholder="enter the date of transaction here"
        ></input>
        <label>enter the amount</label>
        <input
          type="number"
          className="amount"
          value={transactionAmount}
          onChange={handleTransactionAmountChange}
          placeholder="enter the transaciton amount here"
        ></input>

        <label>select the type of expense here</label>
        <div className="dropdown">
          <div
            className={activeSelect ? "select-clicked" : "select"}
            onClick={toggle}
          >
            <span>{expenseType}</span>
            <div className={activeCaret ? "caret-rotate" : "caret"}></div>
          </div>
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

        <p>the type of expense is : {expenseType}</p>
        <p>the amount is : {transactionAmount}</p>
        <p>the date of transaction is : {transactionDate}</p>
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
      </div>

      <div className="chart">
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

      <div className="chart">
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
