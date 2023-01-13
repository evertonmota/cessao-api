package br.gov.ma.cessaoapi.handlers;

import br.gov.ma.cessaoapi.dto.commons.ErrorObject;
import br.gov.ma.cessaoapi.util.LogMessageUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(RestResponseExceptionHandler.class);

    @ExceptionHandler(value = {NoResultException.class})
    protected ResponseEntity<Object> handleNoResultException(NoResultException ex, WebRequest request) {
        String endPoint = ((ServletWebRequest) request).getRequest().getServletPath();
        logger.error(LogMessageUtils.formatServiceErrorLog("No Result found for query.", ex.getMessage(), endPoint), ex);

        List<ErrorObject> errorList = Stream.of(new ErrorObject("", ex.getMessage())).collect(Collectors.toList());

        return new ResponseEntity<>(errorList, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {NonUniqueResultException.class})
    protected ResponseEntity<Object> handleNonUniqueResultException(NonUniqueResultException ex, WebRequest request) {
        String endPoint = ((ServletWebRequest) request).getRequest().getServletPath();
        logger.error(LogMessageUtils.formatServiceErrorLog("Multiple results when expecting only one.", ex.getMessage(), endPoint), ex);

        List<ErrorObject> errorList = Stream.of(new ErrorObject("", ex.getMessage())).collect(Collectors.toList());

        return new ResponseEntity<>(errorList, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        String endPoint = ((ServletWebRequest) request).getRequest().getServletPath();
        logger.error(LogMessageUtils.formatServiceErrorLog("Entity not found.", ex.getMessage(), endPoint), ex);

        List<ErrorObject> errorList = Stream.of(new ErrorObject("", ex.getMessage())).collect(Collectors.toList());

        return new ResponseEntity<>(errorList, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    protected ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        String endPoint = ((ServletWebRequest) request).getRequest().getServletPath();
        logger.error(LogMessageUtils.formatServiceErrorLog("Cannot insert duplicated value in database.", ex.getMessage(), endPoint), ex);

        List<ErrorObject> errorList = Stream.of(new ErrorObject("10000","Erro try to insert duplicate values in database")).collect(Collectors.toList());

        return new ResponseEntity<>(errorList, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<List<ErrorObject>> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        String endPoint = ((ServletWebRequest) request).getRequest().getServletPath();
        List<ErrorObject> errorList = new ArrayList<>();

        logger.error(LogMessageUtils.formatServiceErrorLog("Constraint validation error", ex.getMessage(), endPoint), ex);

        return buildResponseEntity(errorList, ex.getMessage());
    }

    private ResponseEntity<List<ErrorObject>> buildResponseEntity(List<ErrorObject> errorList, String constraintMessage) {
        if (!StringUtils.isEmpty(constraintMessage) && constraintMessage.contains(";")) {
            String[] parts = constraintMessage.split(";");
            String code = parts[0];
            String message = parts[1].trim();
            ErrorObject errorObject = new ErrorObject(code, message);
            errorList.add(errorObject);
        } else {
            ErrorObject errorObject = new ErrorObject("99999", constraintMessage);
            errorList.add(errorObject);
        }

        return new ResponseEntity<>(errorList, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
