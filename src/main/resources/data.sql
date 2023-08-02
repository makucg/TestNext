-- fist bank
INSERT INTO bank (id, name, created_at, created_by, code, address) VALUES (1, 'First Bank', '2020-01-01 00:00:00', 'root', '123', '123 Main St, New York, NY 10001');

-- second bank
INSERT INTO bank (id, name, created_at, created_by, code, address) VALUES (2, 'Second Bank', '2020-01-01 00:00:00', 'root', '321', '321 Main St, New York, NY 10001');

-- first account
INSERT INTO account (id, account_number, name, last_name, balance, created_at, created_by, bank_id) VALUES (1, '123456789', 'John', 'Doe', 1000, '2020-01-01 00:00:00', 'root', 1);
INSERT INTO card (id, card_number, account_id, created_at, created_by, pin, card_type, activated, withdrawal_limit, available_credit, credit_limit) VALUES (1, '123456789', 1, '2020-01-01 00:00:00', 'root', '1234', 0, true, 1000, 1000, 1000);

-- second account
INSERT INTO account (id, account_number, name, last_name, balance, created_at, created_by, bank_id) VALUES (2, '987654321', 'Jane', 'Doe', 1000, '2020-01-01 00:00:00', 'root', 2);
INSERT INTO card (id, card_number, account_id, created_at, created_by, pin, card_type, activated, withdrawal_limit, available_credit, credit_limit) VALUES (2, '987654321', 2, '2020-01-01 00:00:00', 'root', '4321', 1, true, 1000, 1000, 1000);
