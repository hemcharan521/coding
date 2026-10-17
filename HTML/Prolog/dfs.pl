dfs(start, goal, path) :-
    dfs_helper(start, goal, [start], path).

dfs_helper(goal, goal, visited, path) :-
    reverse(visited, path).
    

dfs_helper(current, goal, visited, path) :-
    edge(current, next),
    \+ member(next, visited),
    dfs_helper(next, goal, [next / visited], path).

