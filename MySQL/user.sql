CREATE USER 'myprsnrec'@'localhost' IDENTIFIED BY 'myprsnrec';
GRANT ALL PRIVILEGES ON * . * TO 'myprsnrec'@'localhost';
ALTER USER 'myprsnrec'@'localhost' IDENTIFIED WITH mysql_native_password BY 'myprsnrec';