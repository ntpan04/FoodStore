
DROP DATABASE FoodStore
Go
CREATE DATABASE FoodStore
Go
USE FoodStore

--Customer--
CREATE TABLE Customer(
	customerID int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	UserName varchar(15),
	FullName varchar(50),
	Password varchar(15),
	Phone char(10)
)



--Orders--
CREATE TABLE Orders(
	orderID int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	PayMethod varchar(15),
	Date_Time date,
	Status varchar(50),
	Total_Price int,
	customerID int FOREIGN KEY REFERENCES Customer(customerID),
	address varchar(500),
	phoneOrder char(10),
	fullNameOrder varchar(50)
)

--Product--
CREATE TABLE Product(
	productID varchar(10) PRIMARY KEY,
	productName varchar(50),
	Status BIT,
	Price int,
	Amount int,
	Image varchar(255),
)

--Admin--
CREATE TABLE Admin(
	adminID varchar(25) PRIMARY KEY,
	Password varchar(20)
)



--Include--
CREATE TABLE Include(
	quantity int,
	orderID int,
	productID varchar(10),
	PRIMARY KEY(orderID, productID),
	FOREIGN KEY(orderID) REFERENCES Orders(orderID) ,
	FOREIGN KEY(productID) REFERENCES Product(productID)
)



INSERT INTO Admin(adminID, Password) VALUES
('#admin','1234')

select * from Customer
select * from Orders
select * from Include
select * from  Product




DELETE FROM Product WHERE productID = 'F01'

 --images/Product/Olong.jpg--
INSERT INTO Product(productID, productName, Status, Price, Amount,Image) VALUES
('F01', 'Beef burger', 1, '15', '100','images/Product/burger_bo.jpg' ),
('F02', 'Chicken burger', 1, '15', '100', 'images/Product/burger_ga.png'),
('F03', 'Shrimp burger', 1, '15', '100','images/Product/burger_tom.jpg' ),
('F04', 'Sandwich', 1, '15', '90','images/Product/Sandwich.png'),
('F05', 'Beef pita', 1, '15', '85','images/Product/Pita.png'),
('F06', 'Hotdog', 1, '15', '80','images/Product/hotdog.png'),

('D01', 'Coca', 1, '10', '50','images/Product/Coca.png'),
('D02', 'Pepsi', 1, '10', '50', 'images/Product/Pepsi.png'),
('D03', 'Lemon Black Tea', 1, '15', '50','images/Product/Hongtrachanh.jpg'),
('D04', 'Twister', 1, '12', '50','images/Product/twister.jpg'),
('D05', 'Milk Tea', 1, '15', '50','images/Product/Trasua.jpg')


UPDATE Product SET Image = 'images/Product/Coca.png' WHERE productID = 'D02'



INSERT INTO Product(productID, productName, Status, Price, Amount) VALUES
('D01', 'Beef burger', 1, '15000', '100') 
select * from Product
select * from Product where productName like '%a%'
select * from Admin
delete Product
delete Customer
delete Include
delete Orders
delete Admin
select * from Customer
Insert into Customer (UserName,Password) values ('kuong','1234'),
('minhieu','1234'),
('kuong','1234')
UPDATE Product SET productName = 'coca', Status = 0, Price = 12000, Amount = 55 WHERE productID = 'B01'

INSERT INTO Orders (PayMethod, Date_Time, Status, Total_Price, customerID)
VALUES
('Credit Card', '2024-07-06 14:30:00', 'Processing', 150, 26),
('PayPal', '2024-07-07 09:00:00', 'Shipped', 250, 25),
('Debit Card', '2024-07-08 16:45:00', 'Delivered', 300, 3, 3),
('Credit Card', '2024-07-09 12:20:00', 'Cancelled', 100, 1, 4),
('Cash', '2024-07-10 11:10:00', 'Processing', 200, 2, 5);

insert into Include (orderID,productID,quantity) values
(7,'F01',2),
(7,'F02',50),
(2,'F05',2),
(2,'F05',3),
(2,'F01',2),
(5,'F01',1),
(6,'F02',2)




SELECT 
    O.orderID,
	O.PayMethod,
	O.Date_Time,
	O.Status,
	P.productName,
    I.quantity,
	C.UserName
FROM 
    Orders O
INNER JOIN 
    Customer C ON O.customerID = C.customerID
INNER JOIN 
    Include I ON O.orderID = I.orderID
INNER JOIN 
    Product P ON P.productID = I.productID
where C.customerID = 1









