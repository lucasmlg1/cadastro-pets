package br.com.github.lucasmlg1.cadastro_pets.exception;



import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.core.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResposta handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getFieldErrors();
        List<ErroCampo> collect = fieldErrors.stream().map(fe -> new ErroCampo(fe.getField(), fe.getDefaultMessage())).collect(Collectors.toList());
        return new ErroResposta(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação",collect);
    }

    @ExceptionHandler(EmailJaCadastradoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErroResposta handleEmailJaCadastrado(EmailJaCadastradoException e) {
        return ErroResposta.respostaConflito(e.getMessage());
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResposta handleJsonInvalido(HttpMessageNotReadableException e) {
        return ErroResposta.respostaRequisicaoInvalida("Corpo da requisição inválido ou com valores não aceitos");
    }

    @ExceptionHandler(PropertyReferenceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResposta handleCampoInexistente(PropertyReferenceException e){
        return ErroResposta.respostaRequisicaoInvalida("Erro de campo inexistente! " + e.getPropertyName());
    }

    @ExceptionHandler(AdotanteNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroResposta handleAdotanteNaoEncontrado(AdotanteNaoEncontradoException e){
        return ErroResposta.respostaNotFound(e.getMessage());
    }

    @ExceptionHandler(AdotanteComPetsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErroResposta handleAdotanteComPets(AdotanteComPetsException e) {
        return ErroResposta.respostaConflito(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResposta handleTipoInvalido(MethodArgumentTypeMismatchException e) {
        return ErroResposta.respostaRequisicaoInvalida("Parâmetro inválido: " + e.getName());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErroResposta handleViolacaoDados(DataIntegrityViolationException e){
        return ErroResposta.respostaConflito("Violação de integridade dos dados " + e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErroResposta handleMetodoNaoPermitido(HttpRequestMethodNotSupportedException e) {
        return new ErroResposta(405, "Método HTTP não permitido para esta rota", List.of());
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroResposta handleRotaInexistente(NoResourceFoundException e) {
        return new ErroResposta(404, "Recurso não encontrado", List.of());
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErroResposta handleErroInterno(Exception e) {
        log.error("Erro inesperado", e);
        return new ErroResposta(500, "Erro interno do servidor", List.of());
    }

    @ExceptionHandler(PetNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroResposta handlePetNaoEncontrado(PetNaoEncontradoException e){
        return new ErroResposta(HttpStatus.NOT_FOUND.value(), e.getMessage(), List.of());
    }
}
