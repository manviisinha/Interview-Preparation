# 184. Department Highest Salary

## Intuition

We are given two tables:

### Employee
Contains:
- Employee name
- Salary
- Department ID

### Department
Contains:
- Department ID
- Department name

Our goal is to **find employees who earn the highest salary in their respective departments**.

Important:

- Multiple employees can share the highest salary → include all of them.

---

## Approach

Step-by-step:

1. First, find the **maximum salary in each department**.
2. Then match employees whose salary equals that maximum.
3. Join with the `Department` table to get the department name.

## 💻 SQL Query

```sql
SELECT 
  d.name AS Department,
  e.name AS Employee,
  e.salary AS Salary
FROM Employee e
JOIN Department d
  ON e.departmentId = d.id
JOIN (
  SELECT departmentId, MAX(salary) AS max_salary
  FROM Employee
  GROUP BY departmentId
) m
ON e.departmentId = m.departmentId
AND e.salary = m.max_salary;
```

## Complexity Analysis

### Time Complexity: O(N)
- One pass for GROUP BY

- One join with Employee

- One join with Department

- Efficient for large datasets.

### Space Complexity: O(D)
- Subquery stores max salary per department

  
