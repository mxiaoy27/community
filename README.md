## Springboot

###study

###SQL
```sql
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  id int(11) NOT NULL AUTO_INCREMENT,
  account_id varchar(100),
  user_name varchar(50),
  user_token char(36),
  gmt_create bigint(20),
  gmt_modified bigint(20),
  PRIMARY KEY (`id`) 
) 
```
