/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.50-log : Database - smart_canteen
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`smart_canteen` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `smart_canteen`;

/*Table structure for table `daytime` */

DROP TABLE IF EXISTS `daytime`;

CREATE TABLE `daytime` (
  `one` int(11) NOT NULL COMMENT '1:00 ~ 2:00',
  `two` int(11) NOT NULL COMMENT '2:00 ~ 3:00',
  `three` int(11) NOT NULL COMMENT '3:00 ~ 4:00',
  `four` int(11) NOT NULL COMMENT '4:00 ~ 5:00',
  `five` int(11) NOT NULL COMMENT '5:00 ~ 6:00',
  `six` int(11) NOT NULL COMMENT '6:00 ~ 7:00',
  `seven` int(11) NOT NULL COMMENT '7:00 ~ 8:00',
  `eight` int(11) NOT NULL COMMENT '8:00 ~ 9:00',
  `nine` int(11) NOT NULL COMMENT '9:00 ~ 10:00',
  `ten` int(11) NOT NULL COMMENT '10:00 ~ 11:00',
  `eleven` int(11) NOT NULL COMMENT '11:00 ~ 12:00',
  `twelve` int(11) NOT NULL COMMENT '12:00 ~ 13:00',
  `thirteen` int(11) NOT NULL COMMENT '13:00 ~ 14:00',
  `fourteen` int(11) NOT NULL COMMENT '14:00 ~ 15:00',
  `fifteen` int(11) NOT NULL COMMENT '15:00 ~ 16:00',
  `sixteen` int(11) NOT NULL COMMENT '16:00 ~ 17:00',
  `seventeen` int(11) NOT NULL COMMENT '17:00 ~ 18:00',
  `eighteen` int(11) NOT NULL COMMENT '18:00 ~ 19:00',
  `nineteen` int(11) NOT NULL COMMENT '19:00 ~ 20:00',
  `twenty` int(11) NOT NULL COMMENT '20:00 ~ 21:00',
  `twenty_one` int(11) NOT NULL COMMENT '21:00 ~ 22:00',
  `twenty_two` int(11) NOT NULL COMMENT '22:00 ~ 23:00',
  `twenty_three` int(11) NOT NULL COMMENT '23:00 ~ 24:00',
  `zero` int(11) NOT NULL COMMENT '0:00 ~ 1:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `daytime` */

insert  into `daytime`(`one`,`two`,`three`,`four`,`five`,`six`,`seven`,`eight`,`nine`,`ten`,`eleven`,`twelve`,`thirteen`,`fourteen`,`fifteen`,`sixteen`,`seventeen`,`eighteen`,`nineteen`,`twenty`,`twenty_one`,`twenty_two`,`twenty_three`,`zero`) values (0,0,1,0,2,0,3,3,12,10,6,3,0,0,0,0,8,0,6,0,0,4,0,3);

/*Table structure for table `dish` */

DROP TABLE IF EXISTS `dish`;

CREATE TABLE `dish` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜品编号',
  `dishName` varchar(15) NOT NULL COMMENT '菜品名',
  `price` int(11) NOT NULL COMMENT '菜品价格',
  `typeId` int(11) NOT NULL COMMENT '菜品类型',
  `sales` int(11) NOT NULL DEFAULT '0' COMMENT '销量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `dish` */

insert  into `dish`(`id`,`dishName`,`price`,`typeId`,`sales`) values (1,'坛子肉',7,1,21),(2,'回锅肉',6,1,6),(3,'荔枝肉',5,1,4),(4,'东坡肉',7,1,4),(5,'生焗牛小排',10,2,0),(6,'藤椒牛肉',8,2,0),(7,'火焰牛肉',9,2,0),(8,'手抓羊肉',11,3,0),(9,'羊肉泡馍',10,3,0),(10,'孜然羊肉',11,3,0),(11,'葱爆羊肉',12,3,12),(12,'香辣梭子蟹',10,4,6),(13,'小管鱿鱼煲',15,4,4),(14,'凉拌花甲',5,4,0),(15,'油闷大虾',7,4,6),(16,'千叶豆腐',3,5,0),(17,'如意香干',2,5,21),(18,'腐竹',2,5,0),(19,'香辣孜然豆腐',2,5,0),(20,'上海青',2,6,0),(21,'小白菜',2,6,20),(22,'空心菜',2,6,0),(23,'莴笋',2,6,0),(24,'大白菜',2,6,0),(25,'太阳蒸蛋',3,7,0),(26,'茶叶蛋',2,7,0),(27,'可乐鸡蛋',3,7,0),(28,'蛋羹',3,7,0),(29,'米饭',1,8,0),(30,'馒头',1,8,0),(31,'面条',2,8,0),(32,'米粉',2,8,0),(33,'炒鱿鱼丝',8,1,0);

/*Table structure for table `dish_type` */

DROP TABLE IF EXISTS `dish_type`;

CREATE TABLE `dish_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(10) NOT NULL COMMENT '类型名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `dish_type` */

insert  into `dish_type`(`id`,`name`) values (1,'猪肉类'),(2,'牛肉类'),(3,'羊肉类'),(4,'水产类'),(5,'豆制品类'),(6,'蔬菜类'),(7,'鸡蛋类'),(8,'主食类');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `orderId` varchar(40) NOT NULL COMMENT '订单编号',
  `userId` int(11) NOT NULL COMMENT '用户编号',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `total` int(11) NOT NULL COMMENT '订单总价',
  `createTime` datetime NOT NULL COMMENT '下单时间',
  `finishTime` datetime DEFAULT NULL COMMENT '配餐完成时间',
  `seatNumber` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

/*Data for the table `order` */

insert  into `order`(`id`,`orderId`,`userId`,`username`,`total`,`createTime`,`finishTime`,`seatNumber`) values (34,'2023010911240022004912',23,'ldx',18,'2023-01-09 11:24:01','2023-01-09 12:05:08',13),(35,'2023010911283299010300',23,'ldx',23,'2023-01-09 11:28:32','2023-01-09 12:08:36',15),(36,'2023010911291869440627',23,'ldx',51,'2023-01-09 11:29:19','2023-01-09 12:09:12',15),(37,'2023010911375063873906',26,'lhz',16,'2023-01-09 11:37:50','2023-01-09 12:11:11',16),(38,'2023010911412028157569',26,'lhz',21,'2023-01-09 11:41:20',NULL,18),(39,'2023010911485356058276',23,'ldx',23,'2023-01-09 11:48:53',NULL,21),(40,'2023010912514527523351',23,'ldx',23,'2023-01-09 12:51:46',NULL,22),(41,'2023010912555443923875',23,'ldx',23,'2023-01-09 12:55:54',NULL,32),(42,'2023010912564098016325',23,'ldx',51,'2023-01-09 12:56:40',NULL,123),(43,'2023010917445008304743',23,'ldx',23,'2023-01-09 17:44:51',NULL,21);

/*Table structure for table `shop_cart` */

DROP TABLE IF EXISTS `shop_cart`;

CREATE TABLE `shop_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车编号',
  `orderId` varchar(40) NOT NULL COMMENT '订单编号',
  `dishName` varchar(20) NOT NULL COMMENT '菜品名',
  `amount` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=239 DEFAULT CHARSET=utf8;

/*Data for the table `shop_cart` */

insert  into `shop_cart`(`id`,`orderId`,`dishName`,`amount`) values (193,'2023010911240022004912','坛子肉',1),(194,'2023010911240022004912','荔枝肉',1),(195,'2023010911240022004912','如意香干',2),(196,'2023010911240022004912','小白菜',1),(197,'2023010911283299010300','东坡肉',1),(198,'2023010911283299010300','如意香干',1),(199,'2023010911283299010300','小白菜',1),(200,'2023010911283299010300','葱爆羊肉',1),(201,'2023010911291869440627','坛子肉',1),(202,'2023010911291869440627','回锅肉',1),(203,'2023010911291869440627','荔枝肉',1),(204,'2023010911291869440627','东坡肉',1),(205,'2023010911291869440627','香辣梭子蟹',1),(206,'2023010911291869440627','如意香干',1),(207,'2023010911291869440627','小白菜',1),(208,'2023010911291869440627','葱爆羊肉',1),(209,'2023010911375063873906','荔枝肉',1),(210,'2023010911375063873906','东坡肉',1),(211,'2023010911375063873906','如意香干',1),(212,'2023010911375063873906','小白菜',1),(213,'2023010911412028157569','坛子肉',1),(214,'2023010911412028157569','香辣梭子蟹',1),(215,'2023010911412028157569','如意香干',2),(216,'2023010911485356058276','坛子肉',1),(217,'2023010911485356058276','如意香干',1),(218,'2023010911485356058276','小白菜',1),(219,'2023010911485356058276','葱爆羊肉',1),(220,'2023010912514527523351','坛子肉',1),(221,'2023010912514527523351','如意香干',1),(222,'2023010912514527523351','小白菜',1),(223,'2023010912514527523351','葱爆羊肉',1),(224,'2023010912555443923875','坛子肉',1),(225,'2023010912555443923875','如意香干',1),(226,'2023010912555443923875','小白菜',1),(227,'2023010912555443923875','葱爆羊肉',1),(228,'2023010912564098016325','坛子肉',1),(229,'2023010912564098016325','回锅肉',1),(230,'2023010912564098016325','荔枝肉',1),(231,'2023010912564098016325','东坡肉',1),(232,'2023010912564098016325','香辣梭子蟹',1),(233,'2023010912564098016325','如意香干',1),(234,'2023010912564098016325','小白菜',1),(235,'2023010912564098016325','葱爆羊肉',1),(236,'2023010917445008304743','坛子肉',1),(237,'2023010917445008304743','回锅肉',1),(238,'2023010917445008304743','葱爆羊肉',1);

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '工作人员编号',
  `staffName` varchar(20) NOT NULL COMMENT '工作人员姓名',
  `sex` char(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `staffAccount` varchar(20) NOT NULL COMMENT '账号',
  `password` varchar(16) NOT NULL COMMENT '密码',
  `workload` int(11) NOT NULL DEFAULT '0' COMMENT '工作量',
  `income` int(11) NOT NULL DEFAULT '0' COMMENT '收入',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `staff` */

insert  into `staff`(`id`,`staffName`,`sex`,`age`,`staffAccount`,`password`,`workload`,`income`) values (13,'ldx','男',21,'Altria Pendragon','36420',102,1020),(14,'lhz','女',20,'虎牙摆大烂','123456',103,1030),(15,'lzq','男',21,'独寂Toto','123456789',200,2000),(16,'llc','男',21,'Boyd觅荷','987654321',201,2010);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `sex` char(1) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `password` varchar(16) NOT NULL COMMENT '密码',
  `balance` int(11) NOT NULL DEFAULT '0' COMMENT '账户余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`sex`,`age`,`nickname`,`password`,`balance`) values (5,'llc','女',0,'gfh','123123',0),(6,'fgd','男',0,'gfhfg','1545',0),(7,'dfgd','女',0,'fgjf','1231',0),(8,'dfgdg','男',0,'dfgd','45645',0),(9,'sdfs','男',0,'werwer','4564',0),(10,'qweqw','女',0,'bmbhnm','785678',0),(11,'dsfsdf','男',0,'bnmmnbm','78978',0),(12,'sdfd','男',0,'1234','78678',0),(13,'rtyrt','男',0,'yuiuyi','hjkhj',0),(14,'vcn','男',0,'sdfsdf','bnmb',0),(15,'qweqw','女',0,'ret','445',0),(21,'lzh','男',30,'哈哈','36420',0),(23,'ldx','男',21,'Altria Pendragon','36420',441),(26,'lhz','男',20,'waibi','123123',98);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
