CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(512) DEFAULT NULL COMMENT '氏名',
  `first_name` varchar(256) DEFAULT NULL COMMENT '姓',
  `last_name` varchar(256) DEFAULT NULL COMMENT '名',
  `kana` varchar(512) DEFAULT NULL COMMENT 'ふりがな',
  `first_kana` varchar(256) DEFAULT NULL COMMENT '姓（かな）',
  `last_kana` varchar(256) DEFAULT NULL COMMENT '名（かな）',
  `sex` char(1) DEFAULT NULL COMMENT '性別 : 0:男性\n1:女性',
  `birthday` date DEFAULT NULL COMMENT '誕生日',
  `postal_code` varchar(7) DEFAULT NULL COMMENT '郵便番号',
  `postal_code_front` varchar(3) DEFAULT NULL COMMENT '郵便番号(前3桁)',
  `postal_code_back` varchar(4) DEFAULT NULL COMMENT '郵便番号(後4桁)',
  `address` varchar(536) DEFAULT NULL COMMENT '住所 : 都道府県+市町村+マンション名',
  `state` varchar(24) DEFAULT NULL COMMENT '都道府県',
  `cities` varchar(256) DEFAULT NULL COMMENT '市区町村・番地',
  `apartment_name` varchar(256) DEFAULT NULL COMMENT 'マンション名',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '電話番号',
  `mail_address` varchar(256) DEFAULT NULL COMMENT 'メールアドレス',
  `password` text,
  `memo` text COMMENT 'メモ（変更前の情報・備考） : 備考欄',
  `department_id` bigint(20) NOT NULL COMMENT '所属id',
  `created` datetime DEFAULT NULL COMMENT '作成日時',
  `modified` datetime DEFAULT NULL COMMENT '更新日時',
  `deleted` datetime DEFAULT NULL COMMENT '削除日時',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='ユーザーテーブル';

CREATE TABLE `departments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(512) DEFAULT NULL COMMENT '所属',
  `created` datetime DEFAULT NULL COMMENT '作成日時',
  `modified` datetime DEFAULT NULL COMMENT '更新日時',
  `deleted` datetime DEFAULT NULL COMMENT '削除日時',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='所属テーブル';