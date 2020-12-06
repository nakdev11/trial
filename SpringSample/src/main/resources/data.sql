insert into employee (employee_id, employee_name, age)
values(1, '山田太郎', 30);

insert into m_user (user_id, password, user_name, birthday, age, role)
values ('test@test.com', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', 'テストユーザー１', '1900-01-01', 28, 'ROLE_ADMIN');

insert into m_user (user_id, password, user_name, birthday, age, role)
values ('test2@test.com', '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa', 'テストユーザー２', '1900-01-01', 20, 'ROLE_GENERAL');
