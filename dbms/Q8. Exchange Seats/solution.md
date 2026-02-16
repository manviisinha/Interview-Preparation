# 🪑 LeetCode 626 – Exchange Seats

## 📌 Problem Statement

Table: `Seat`

| Column Name | Type |
|------------|------|
| id         | int  |
| student    | varchar |

`id` is the primary key column.
Each row of this table indicates the name and the ID of a student.

Write an SQL query to swap the seat id of every two consecutive students.  
If the number of students is odd, the last student should not be swapped.

Return the result table ordered by `id` in ascending order.

---

## 💡 Approach

We need to swap every pair of consecutive seat IDs:

- If `id` is **odd**, swap with `id + 1` (only if it exists).
- If `id` is **even**, swap with `id - 1`.
- If it is the **last row and odd**, keep it unchanged.

### Logic Breakdown

1. Use a `CASE` statement to determine the new `id`.
2. Check whether the `id` is odd using `id % 2 = 1`.
3. Ensure `id + 1` exists before swapping (to handle odd total rows).
4. For even IDs, simply subtract 1.
5. Order the final result by `id`.

---

## 🛠️ SQL Solution

```sql
SELECT 
    CASE 
        WHEN id % 2 = 1 AND id + 1 IN (SELECT id FROM Seat) THEN id + 1
        WHEN id % 2 = 0 THEN id - 1
        ELSE id
    END AS id,
    student
FROM Seat
ORDER BY id;
