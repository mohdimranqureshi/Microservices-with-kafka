package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Mail;

public interface MailRepository extends CrudRepository<Mail, Long> {

}
