CREATE TABLE `test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(512) DEFAULT NULL COMMENT '名前',
  `created` datetime DEFAULT NULL COMMENT '作成日時',
  `updated` datetime DEFAULT NULL COMMENT '更新日時',
  `deleted` datetime DEFAULT NULL COMMENT '削除日時',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='テスト';