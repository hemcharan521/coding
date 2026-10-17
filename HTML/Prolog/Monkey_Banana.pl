/* ------------------------------
   Monkey and Banana Problem
   ------------------------------ */

/* Possible locations */
place(atdoor).
place(window).
place(middle).

/* State: state(MonkeyPos, MonkeyStatus, BoxPos, HasBanana) */

goal(state(_, _, _, yes)).

initial_state(state(atdoor, onfloor, window, no)).

/* ------------------------------
   Actions
   ------------------------------ */

/* Monkey walks */
move(
    state(P1, onfloor, Box, H),
    walk(P1, P2),
    state(P2, onfloor, Box, H)
) :-
    place(P2),
    P1 \= P2.

/* Monkey pushes box */
move(
    state(P, onfloor, P, H),
    push(P, P2),
    state(P2, onfloor, P2, H)
) :-
    place(P2),
    P \= P2.

/* Monkey climbs box */
move(
    state(P, onfloor, P, H),
    climb,
    state(P, onbox, P, H)
).

/* Monkey grabs banana */
move(
    state(middle, onbox, middle, no),
    grab,
    state(middle, onbox, middle, yes)
).

/* ------------------------------
   Solver with visited states
   ------------------------------ */

solve(State, _, []) :-
    goal(State).

solve(State, Visited, [Action | Rest]) :-
    move(State, Action, NewState),
    \+ member(NewState, Visited),
    solve(NewState, [NewState | Visited], Rest).
/*Query*/
monkey_banana(Steps):-
  initial_state(State),
  solve(State,[State],Steps).   