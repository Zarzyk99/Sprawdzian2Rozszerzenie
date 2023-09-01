package pl.kurs.clinictest.mocks;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import pl.kurs.clinicapp.models.Visit;
import pl.kurs.clinicapp.repository.IVisitRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class VisitRepositoryMock implements IVisitRepository {
    @Override
    public List<Visit> findByDoctorIdAndVisitDateLessThanEqualOrderByVisitDateDesc(Integer doctorID, LocalDate date) {
        return null;
    }

    @Override
    public List<Visit> findByPatientId(Integer patientId) {
        return null;
    }

    @Override
    public List<Visit> findAll() {
        return null;
    }

    @Override
    public List<Visit> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Visit> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Visit> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Visit visit) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Visit> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Visit> S save(S s) {
        return null;
    }

    @Override
    public <S extends Visit> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Visit> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Visit> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Visit> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }


    @Override
    public void deleteAllInBatch(Iterable<Visit> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Visit getOne(Integer integer) {
        return null;
    }

    @Override
    public Visit getById(Integer integer) {
        return null;
    }

    @Override
    public Visit getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Visit> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Visit> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Visit> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Visit> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Visit> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Visit> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Visit, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
