package com.dateTimeExample.Calculator.controllers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryInterface extends JpaRepository<History, Long>{

}
