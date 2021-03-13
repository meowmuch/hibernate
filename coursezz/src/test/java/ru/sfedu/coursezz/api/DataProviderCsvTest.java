package ru.sfedu.coursezz.api;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.sfedu.coursezz.utils.Constants;
import ru.sfedu.coursezz.models.*;
import ru.sfedu.coursezz.models.enums.ResultType;
import ru.sfedu.coursezz.utils.Generatos.GeneratorCsv;
import ru.sfedu.coursezz.utils.Result;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

public class DataProviderCsvTest {

    public DataProviderCsv dp = new DataProviderCsv();
    public Logger log = LogManager.getLogger(this.getClass());



    public DataProviderCsvTest() throws IOException {
    }

    private void showMethodName() {
        log.info("\n*** " + Thread.currentThread().getStackTrace()[2].getMethodName() + " ***");
    }

    @Before
    public void prepareDataSources() throws NoSuchMethodException, InvocationTargetException, CsvRequiredFieldEmptyException, IOException, IllegalAccessException, CsvDataTypeMismatchException {
        List<Book> bookList = GeneratorCsv.generateBooks(10);
        dp.insertRecord(bookList, false,  Book.class);
        List<Article> articleList = GeneratorCsv.generateArticles(10);
        dp.insertRecord(articleList, false, Article.class);
        List<Film> filmList = GeneratorCsv.generateFilms(10);
        dp.insertRecord(filmList, false, Film.class);
        List<Client> clientList = GeneratorCsv.generateClients(10, 4);
        dp.insertRecord(clientList, false, Client.class);
        List<Plan> planList = GeneratorCsv.generatePlans(10);
        dp.insertRecord(planList, false, Plan.class);
    }

    @Test
    public void createBook() throws Exception {
        List<Book> bookList = GeneratorCsv.generateBooks(10);
        dp.createBook(bookList, false);
        Result<Book> res = dp.getRecords(Book.class);
        log.info(res.getMessage());
        Assert.assertEquals(bookList.size(), res.getData().size());
    }

    @Test
    public void createArticle() throws Exception {
        List<Article> articleList = GeneratorCsv.generateArticles(10);
        dp.createArticle(articleList, false);
        Result<Article> res = dp.getRecords(Article.class);
        Assert.assertEquals(articleList.size(), res.getData().size());
    }

    @Test
    public void createFilm() throws Exception {
        List<Film> filmList = GeneratorCsv.generateFilms(10);
        dp.createFilm(filmList, false);
        Result<Film> res = dp.getRecords(Film.class);
        Assert.assertEquals(filmList.size(), res.getData().size());
    }

    @Test
    public void createPlan() throws Exception {
        List<Plan> planList = GeneratorCsv.generatePlans(10);
        dp.createPlan(planList, false);
        Result<Plan> res = dp.getRecords(Plan.class);
        Assert.assertEquals(planList.size(), res.getData().size());
    }

    @Test
    public void createClient() throws Exception {
        List<Client> clientList = GeneratorCsv.generateClients(10, 2);
        dp.createClient(clientList, false);
        Result<Client> res = dp.getRecords(Client.class);
        Assert.assertEquals(clientList.size(), res.getData().size());
    }

    @Test
    public void getBooks() throws Exception {
        createBook();
        Assert.assertEquals(dp.getBooks().getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void getArticles() throws Exception {
        createArticle();
        Assert.assertEquals(dp.getArticles().getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void getFilms() throws Exception {
        createFilm();
        Assert.assertEquals(dp.getFilms().getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void getClients() throws Exception {
        createClient();
        Assert.assertEquals(dp.getClients().getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void getPlans() throws Exception {
        createPlan();
        Assert.assertEquals(dp.getPlans().getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void getBookById() throws Exception {
        Book record = GeneratorCsv.generateBooks(1).get(0);
        dp.createBook(Collections.singletonList(record), false);
        Assert.assertEquals(dp.getBookById(record.getId()).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void getArticleById() throws Exception {
        Article record = GeneratorCsv.generateArticles(1).get(0);
        dp.createArticle(Collections.singletonList(record), false);
        Assert.assertEquals(dp.getArticleById(record.getId()).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void getFilmById() throws Exception {
        Film record = GeneratorCsv.generateFilms(1).get(0);
        dp.createFilm(Collections.singletonList(record), false);
        Assert.assertEquals(dp.getFilmById(record.getId()).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void getClientById() throws Exception {
        Client record = GeneratorCsv.generateClients(1, 2).get(0);
        dp.createClient(Collections.singletonList(record), false);
        Assert.assertEquals(dp.getClientById(record.getId()).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void getPlanById() throws Exception {
        Plan record = GeneratorCsv.generatePlans(1).get(0);
        dp.createPlan(Collections.singletonList(record), false);
        Assert.assertEquals(dp.getPlanById(record.getId()).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void deleteBook() throws Exception {
        Book record = GeneratorCsv.generateBooks(1).get(0);
        dp.createBook(Collections.singletonList(record), false);
        Assert.assertEquals(dp.deleteBook(record.getId()).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void deleteArticle() throws Exception {
        Article record = GeneratorCsv.generateArticles(1).get(0);
        dp.createArticle(Collections.singletonList(record), false);
        Assert.assertEquals(dp.deleteArticle(record.getId()).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void deleteFilm() throws Exception {
        Film record = GeneratorCsv.generateFilms(1).get(0);
        dp.createFilm(Collections.singletonList(record), false);
        Assert.assertEquals(dp.deleteFilm(record.getId()).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void deleteClient() throws Exception {
        Client record = GeneratorCsv.generateClients(1, 2).get(0);
        dp.createClient(Collections.singletonList(record), false);
        Assert.assertEquals(dp.deleteClient(record.getId()).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void deletePlan() throws Exception {
        Plan record = GeneratorCsv.generatePlans(1).get(0);
        dp.createPlan(Collections.singletonList(record), false);
        Assert.assertEquals(dp.deletePlan(record.getId()).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void changePlanStatus() throws Exception {
        List<Plan> planList = GeneratorCsv.generatePlans(1);
        dp.insertRecord(planList, false,  Plan.class);
        Plan plan = planList.get(0);
        log.info(plan.getStatus());
        log.info(plan);
        Assert.assertEquals(dp.changePlanStatus(plan.getId(), !plan.getStatus()).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void updateBook() throws Exception {
        Long id = 120L;
        List<Book> bookList = GeneratorCsv.generateBooks(2);
        bookList.get(0).setId(id);
        dp.createBook(bookList, false);
        Book book = bookList.get(0);
        book.setNameOfBook(book.getNameOfBook() + Constants.NEW);
        Assert.assertEquals(dp.updateBook(id, book).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void updateArticle() throws Exception {
        Long id = 120L;
        List<Article> articleList = GeneratorCsv.generateArticles(2);
        articleList.get(0).setId(id);
        dp.createArticle(articleList, false);
        Article article = articleList.get(0);
        article.setTitle(article.getTitle() + Constants.NEW);
        Assert.assertEquals(dp.updateArticle(id, article).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void updateFilm() throws Exception {
        Long id = 120L;
        List<Film> filmList = GeneratorCsv.generateFilms(2);
        filmList.get(0).setId(id);
        dp.createFilm(filmList, false);
        Film film = filmList.get(0);
        film.setNameOfBook(film.getNameOfBook() + Constants.NEW);
        Assert.assertEquals(dp.updateFilm(id, film).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void updateChannel() throws Exception {
        Long id = 120L;
        List<Client> clientList = GeneratorCsv.generateClients(8, 2);
        clientList.get(0).setId(id);
        dp.createClient(clientList, false);
        Client client = clientList.get(0);
        client.setName(client.getName() + Constants.NEW);
        Assert.assertEquals(dp.updateClient(id, client).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void updatePlan() throws Exception {
        Long id = 120L;
        List<Plan> planList = GeneratorCsv.generatePlans(10);
        planList.get(0).setId(id);
        dp.createPlan(planList, false);
        Plan plan = planList.get(0);
        plan.setName(plan.getName() + Constants.NEW);
        Assert.assertEquals(dp.updatePlan(id, plan).getResultType(), ResultType.COMPLETE);
    }

    @Test
    public void fcreateBook() throws Exception {
        List<Book> bookList = GeneratorCsv.generateBooks(10);
        dp.createBook(bookList, false);
        Result<Book> res = dp.getRecords(Book.class);
        log.info(res.getMessage());
        Assert.assertNotEquals(bookList.size(), 0);
    }

    @Test
    public void fcreateArticle() throws Exception {
        List<Article> articleList = GeneratorCsv.generateArticles(10);
        dp.createArticle(articleList, false);
        Result<Article> res = dp.getRecords(Article.class);
        Assert.assertNotEquals(articleList.size(), 0);
    }

    @Test
    public void fcreateFilm() throws Exception {
        List<Film> filmList = GeneratorCsv.generateFilms(10);
        dp.createFilm(filmList, false);
        Result<Film> res = dp.getRecords(Film.class);
        Assert.assertNotEquals(filmList.size(),0);
    }

    @Test
    public void fcreatePlan() throws Exception {
        List<Plan> planList = GeneratorCsv.generatePlans(10);
        dp.createPlan(planList, false);
        Result<Plan> res = dp.getRecords(Plan.class);
        Assert.assertNotEquals(planList.size(), 0);
    }

    @Test
    public void fcreateClient() throws Exception {
        List<Client> clientList = GeneratorCsv.generateClients(10, 2);
        dp.createClient(clientList, false);
        Result<Client> res = dp.getRecords(Client.class);
        Assert.assertNotEquals(clientList.size(), 0);
    }

    @Test
    public void fgetBooks() throws Exception {
        createBook();
        Assert.assertNotEquals(dp.getBooks().getResultType(), ResultType.FAIL);
    }

    @Test
    public void fgetArticles() throws Exception {
        createArticle();
        Assert.assertNotEquals(dp.getArticles().getResultType(), ResultType.FAIL);
    }

    @Test
    public void fgetFilms() throws Exception {
        createFilm();
        Assert.assertNotEquals(dp.getFilms().getResultType(), ResultType.FAIL);
    }

    @Test
    public void fgetClients() throws Exception {
        createClient();
        Assert.assertNotEquals(dp.getClients().getResultType(), ResultType.FAIL);
    }

    @Test
    public void fgetPlans() throws Exception {
        createPlan();
        Assert.assertNotEquals(dp.getPlans().getResultType(), ResultType.FAIL);
    }

    @Test
    public void fgetBookById() throws Exception {
        Book record = GeneratorCsv.generateBooks(1).get(0);
        dp.createBook(Collections.singletonList(record), false);
        Assert.assertNotEquals(dp.getBookById(record.getId()).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fgetArticleById() throws Exception {
        Article record = GeneratorCsv.generateArticles(1).get(0);
        dp.createArticle(Collections.singletonList(record), false);
        Assert.assertNotEquals(dp.getArticleById(record.getId()).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fgetFilmById() throws Exception {
        Film record = GeneratorCsv.generateFilms(1).get(0);
        dp.createFilm(Collections.singletonList(record), false);
        Assert.assertNotEquals(dp.getFilmById(record.getId()).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fgetClientById() throws Exception {
        Client record = GeneratorCsv.generateClients(1, 2).get(0);
        dp.createClient(Collections.singletonList(record), false);
        Assert.assertNotEquals(dp.getClientById(record.getId()).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fgetPlanById() throws Exception {
        Plan record = GeneratorCsv.generatePlans(1).get(0);
        dp.createPlan(Collections.singletonList(record), false);
        Assert.assertNotEquals(dp.getPlanById(record.getId()).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fdeleteBook() throws Exception {
        Book record = GeneratorCsv.generateBooks(1).get(0);
        dp.createBook(Collections.singletonList(record), false);
        Assert.assertNotEquals(dp.deleteBook(record.getId()).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fdeleteArticle() throws Exception {
        Article record = GeneratorCsv.generateArticles(1).get(0);
        dp.createArticle(Collections.singletonList(record), false);
        Assert.assertNotEquals(dp.deleteArticle(record.getId()).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fdeleteFilm() throws Exception {
        Film record = GeneratorCsv.generateFilms(1).get(0);
        dp.createFilm(Collections.singletonList(record), false);
        Assert.assertNotEquals(dp.deleteFilm(record.getId()).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fdeleteClient() throws Exception {
        Client record = GeneratorCsv.generateClients(1, 2).get(0);
        dp.createClient(Collections.singletonList(record), false);
        Assert.assertNotEquals(dp.deleteClient(record.getId()).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fdeletePlan() throws Exception {
        Plan record = GeneratorCsv.generatePlans(1).get(0);
        dp.createPlan(Collections.singletonList(record), false);
        Assert.assertNotEquals(dp.deletePlan(record.getId()).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fchangePlanStatus() throws Exception {
        List<Plan> planList = GeneratorCsv.generatePlans(1);
        dp.insertRecord(planList, false,  Plan.class);
        Plan plan = planList.get(0);
        log.info(plan.getStatus());
        log.info(plan);
        Assert.assertNotEquals(dp.changePlanStatus(plan.getId(), !plan.getStatus()).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fupdateBook() throws Exception {
        Long id = 120L;
        List<Book> bookList = GeneratorCsv.generateBooks(2);
        bookList.get(0).setId(id);
        dp.createBook(bookList, false);
        Book book = bookList.get(0);
        book.setNameOfBook(book.getNameOfBook() + Constants.NEW);
        Assert.assertNotEquals(dp.updateBook(id, book).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fupdateArticle() throws Exception {
        Long id = 120L;
        List<Article> articleList = GeneratorCsv.generateArticles(2);
        articleList.get(0).setId(id);
        dp.createArticle(articleList, false);
        Article article = articleList.get(0);
        article.setTitle(article.getTitle() + Constants.NEW);
        Assert.assertNotEquals(dp.updateArticle(id, article).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fupdateFilm() throws Exception {
        Long id = 120L;
        List<Film> filmList = GeneratorCsv.generateFilms(2);
        filmList.get(0).setId(id);
        dp.createFilm(filmList, false);
        Film film = filmList.get(0);
        film.setNameOfBook(film.getNameOfBook() + Constants.NEW);
        Assert.assertNotEquals(dp.updateFilm(id, film).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fupdateChannel() throws Exception {
        Long id = 120L;
        List<Client> clientList = GeneratorCsv.generateClients(8, 2);
        clientList.get(0).setId(id);
        dp.createClient(clientList, false);
        Client client = clientList.get(0);
        client.setName(client.getName() + Constants.NEW);
        Assert.assertNotEquals(dp.updateClient(id, client).getResultType(), ResultType.FAIL);
    }

    @Test
    public void fupdatePlan() throws Exception {
        Long id = 120L;
        List<Plan> planList = GeneratorCsv.generatePlans(10);
        planList.get(0).setId(id);
        dp.createPlan(planList, false);
        Plan plan = planList.get(0);
        plan.setName(plan.getName() + Constants.NEW);
        Assert.assertNotEquals(dp.updatePlan(id, plan).getResultType(), ResultType.FAIL);
    }

}
