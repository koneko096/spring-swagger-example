ALTER TABLE employees RENAME TO citizens;

ALTER TABLE citizens ADD COLUMN birthday DATE DEFAULT current_date;
