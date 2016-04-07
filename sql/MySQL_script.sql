CREATE DATABASE `qvantel_recruitment_tracking` /*!40100 DEFAULT CHARACTER SET latin1 */ ;

CREATE TABLE `candidate` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `mobile_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `availability_for_interview` varchar(45) DEFAULT NULL,
  `reason_for_change` text,
  `current_company` varchar(45) DEFAULT NULL,
  `address_line` text,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `zip_code` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `profie_photo` blob,
  `prefer_contact_time` time DEFAULT NULL,
  `industry` varchar(45) DEFAULT NULL,
  `functional_area` varchar(45) DEFAULT NULL,
  `experience_years` float DEFAULT NULL,
  `skill_set` varchar(45) DEFAULT NULL,
  `designation` varchar(45) DEFAULT NULL,
  `current_salary` varchar(45) DEFAULT NULL,
  `preferred_locatioin` varchar(45) DEFAULT NULL,
  `current_location` varchar(45) DEFAULT NULL,
  `expected_salary` varchar(45) DEFAULT NULL,
  `qualification` text,
  `experience_summary` text,
  `projects` text,
  `notice_period` varchar(45) DEFAULT NULL,
  `job_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_JOB_TRANSACTION_JOB_ID` (`job_id`),
  CONSTRAINT `FK_JOB_TRANSACTION_JOB_ID` FOREIGN KEY (`job_id`)
  REFERENCES `job` (`job_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;

CREATE TABLE `job` (
  `job_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `job_title` varchar(45) DEFAULT NULL,
  `designation` varchar(45) DEFAULT NULL,
  `industry` varchar(45) DEFAULT NULL,
  `functional_area` varchar(45) DEFAULT NULL,
  `brief_description` text,
  `detailed_description` text,
  `main_skill` text,
  `qualification_s` varchar(45) DEFAULT NULL,
  `minimum_experience` float DEFAULT NULL,
  `maximum_experience` float DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `last_date` date DEFAULT NULL,
  `recruiter_s` varchar(45) DEFAULT NULL,
  `contact_name` varchar(45) DEFAULT NULL,
  `contact_email` varchar(45) DEFAULT NULL,
  `email_notification` tinyint(4) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `requirement_type` varchar(45) DEFAULT NULL,
  `other_skill` text,
  `number_of_openings` int(11) DEFAULT NULL,
  `job_stage` varchar(45) DEFAULT NULL,
  `make_salary_visible_to_public` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  UNIQUE KEY `id_UNIQUE` (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `employee_code` varchar(45) DEFAULT NULL,
  `job_title` varchar(45) DEFAULT NULL,
  `description` text,
  `user_login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;
