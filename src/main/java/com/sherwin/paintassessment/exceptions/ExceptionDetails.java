package com.sherwin.paintassessment.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDetails {
	private String message;
	private LocalDateTime localDateTime;
	private String details;
}