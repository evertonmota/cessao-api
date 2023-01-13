package br.gov.ma.cessaoapi.handlers;

import br.gov.ma.cessaoapi.dto.commons.ErrorObject;
import br.gov.ma.cessaoapi.errors.BusinessException;
import br.gov.ma.cessaoapi.errors.NotFoundException;
import br.gov.ma.cessaoapi.errors.UnauthorizedException;
import br.gov.ma.cessaoapi.util.LogMessageUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.validation.ConstraintViolationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ControllerAdvice
public class CessaoExceptionHandler extends RestResponseExceptionHandler {

	private final static Logger logger = LoggerFactory.getLogger(CessaoExceptionHandler.class);

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

        return new ResponseEntity<>(errorList, HttpStatus.NOT_FOUND);
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

        return buildResponseEntity(errorList, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
    
    @ExceptionHandler(value = {BusinessException.class})
    protected ResponseEntity<List<ErrorObject>> handleBusinessException(ConstraintViolationException ex, WebRequest request) {
        String endPoint = ((ServletWebRequest) request).getRequest().getServletPath();
        List<ErrorObject> errorList = new ArrayList<>();

        logger.error(LogMessageUtils.formatServiceErrorLog("Business Exception error", ex.getMessage(), endPoint), ex);

        return buildResponseEntity(errorList, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()) );
    }

    @ExceptionHandler(value = {UnauthorizedException.class})
    protected ResponseEntity<List<ErrorObject>> handleUnauthorizedException(UnauthorizedException ex, WebRequest request) {
        String endPoint = ((ServletWebRequest) request).getRequest().getServletPath();
        List<ErrorObject> errorList = new ArrayList<>();

        logger.error(LogMessageUtils.formatServiceErrorLog("User unauthorized error", ex.getMessage(), endPoint), ex);

        return buildResponseEntity(errorList, ex.getMessage(), HttpStatus.UNAUTHORIZED, String.valueOf(HttpStatus.UNAUTHORIZED.value()));
    }
    
    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<List<ErrorObject>> handleNotFoundException(NotFoundException ex, WebRequest request) {
        String endPoint = ((ServletWebRequest) request).getRequest().getServletPath();
        List<ErrorObject> errorList = new ArrayList<>();

        logger.error(LogMessageUtils.formatServiceErrorLog("", ex.getMessage(), endPoint), ex);

        return buildResponseEntity(errorList, ex.getMessage(), HttpStatus.NOT_FOUND, String.valueOf(HttpStatus.NOT_FOUND.value()));
    }

    @ExceptionHandler(value = {IOException.class})
    protected ResponseEntity<List<ErrorObject>> handleIOException(IOException ex, WebRequest request) {
        String endPoint = ((ServletWebRequest) request).getRequest().getServletPath();
        List<ErrorObject> errorList = new ArrayList<>();

        logger.error(LogMessageUtils.formatServiceErrorLog("", ex.getMessage(), endPoint), ex);

        return buildResponseEntity(errorList, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, String.valueOf(HttpStatus.NOT_FOUND.value()));
    }

    @ExceptionHandler(value = {FileNotFoundException.class})
    protected ResponseEntity<List<ErrorObject>> handleFileNotFoundException(FileNotFoundException ex, WebRequest request) {
        String endPoint = ((ServletWebRequest) request).getRequest().getServletPath();
        List<ErrorObject> errorList = new ArrayList<>();

        logger.error(LogMessageUtils.formatServiceErrorLog("", ex.getMessage(), endPoint), ex);

        return buildResponseEntity(errorList, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, String.valueOf(HttpStatus.NOT_FOUND.value()));
    }

    private ResponseEntity<List<ErrorObject>> buildResponseEntity(List<ErrorObject> errorList, String constraintMessage, HttpStatus httpStatus, String erroCode) {
        if (!StringUtils.isEmpty(constraintMessage) && constraintMessage.contains(";")) {
            String[] parts = constraintMessage.split(";");
            String code = parts[0];
            String message = parts[1].trim();
            ErrorObject errorObject = new ErrorObject(code, message);
            errorList.add(errorObject);
        } else {
            ErrorObject errorObject = new ErrorObject(erroCode, constraintMessage);
            errorList.add(errorObject);
        }

        return new ResponseEntity<>(errorList, httpStatus);
    }
}