import react, { useState } from "react";

function toDoList() {
  const [tasks, setTasks] = useState([]);
  const [newTask, setnewTask] = useState("");

  function handleTask(event) {
    setnewTask(event.target.value);
  }
  function addTask() {
    if (newTask.trim() !== "") {
      setTasks((t) => [...t, newTask]);
      setnewTask("");
    }
  }

  function deleteTask(index) {
    const Update = tasks.filter((element, i) => index != i);
    setTasks(Update);
  }

  function moveUp(index) {
    if (index > 0) {
      const update = [...tasks];
      [update[index], update[index - 1]] = [update[index - 1], update[index]];
      setTasks(update);
    }
  }

  function moveDown(index) {
    if (index < tasks.length - 1) {
      const update = [...tasks];
      [update[index], update[index + 1]] = [update[index + 1], update[index]];
      setTasks(update);
    }
  }

  return (
    <>
      <div className="to-do-list">
        <h1>to-do-list</h1>
        <div>
          <input
            value={newTask}
            placeholder="enter a task"
            onChange={handleTask}
            type="text"
          ></input>
          <button className="add-button" onClick={addTask}>
            add
          </button>
        </div>

        <div>
          <ol>
            {tasks.map((element, index) => (
              <>
                <li key={index}>
                  <span className="text">{element}</span>

                  <button
                    className="delete-button"
                    onClick={() => deleteTask(index)}
                  >
                    delete
                  </button>

                  <button className="move-button" onClick={() => moveUp(index)}>
                    👆
                  </button>

                  <button
                    className="move-button"
                    onClick={() => moveDown(index)}
                  >
                    👇
                  </button>
                </li>
              </>
            ))}
          </ol>
        </div>
      </div>
    </>
  );
}

export default toDoList;
