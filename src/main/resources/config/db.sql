DROP TABLE IF EXISTS Organization;
CREATE TABLE Organization(
id VARCHAR(255) PRIMARY KEY,
name VARCHAR(255),
contactName VARCHAR(255),
contactPhone VARCHAR(255),
contactEmail VARCHAR(255)
);
INSERT INTO Organization(id ,name ,contactName ,contactPhone ,contactEmail) VALUES
('32030','CIBC','ali','777','CIBC@CIBC.com'),
('32032','TD','jo','888','TD@TD.com'),
('32033','RBC','peter','999','RBC@RBC.com');
