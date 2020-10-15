package com.qa.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No Solution  with this ID exists")
public class SolutionNotFoundException extends EntityNotFoundException {
}
