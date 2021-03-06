package webactions.crud;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Comment;
import model.Product;
import model.Sale;
import model.User;
import persistence.*;
import webactions.MyCoolServlet;

public class CreateServlet extends MyCoolServlet {

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDAO persistenceManagerUser = PersistenceFactory.getUserDAO(persistenceMechanism);
        SaleDAO persistenceManagerSale = PersistenceFactory.getSaleDAO(persistenceMechanism);
        ProductDAO persistenceManagerProduct = PersistenceFactory.getProductDAO(persistenceMechanism);
        CommentDAO persistenceManagerComment = PersistenceFactory.getCommentDAO(persistenceMechanism);
        HttpSession session = request.getSession();
        String type = request.getParameter("type");

        if (type == null) {
            goToURL(errorForm, request, response);
        } else {
            switch (type) {
                case "user":
                    User user = generateUserFromRequest(request);
                    if (user != null && persistenceManagerUser.newUser(user)) {
                        session.setAttribute("admin", false);
                        request.setAttribute("user", user);
                        request.setAttribute("message", "Usuario creado con éxito");
                        goToURL(successForm, request, response);
                    } else {
                        Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE,
                                "Fallo al Crear el Nuevo Usuario");
                        goToURL(errorForm, request, response);
                    }
                    break;
                case "sale":
                    Sale sale = generateSaleFromRequest(request);
                    if (sale != null && persistenceManagerSale.newSale(sale)) {
                        session.setAttribute("sale", sale);
                        goToURL(confirmationSale, request, response);
                    } else {
                        Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE,
                                "Fallo al Crear la Nueva Venta");
                        goToURL(errorForm, request, response);
                    }
                    break;
                case "product":
                    Product product = generateProductFromRequest(request);
                    if (product != null && persistenceManagerProduct.newProduct(product)) {
                        session.setAttribute("product", product);
                        HashMap<String, Product> productList = new HashMap<>();
                        if (session.getAttribute("productList") == null) {
                            session.setAttribute("productList", productList);
                        }
                        productList = (HashMap<String, Product>) session.getAttribute("productList");
                        productList.put(product.getProductID(), product);
                        session.setAttribute("productList", productList);
                        request.setAttribute("message", "Producto creado con éxito");
                        goToURL(successForm, request, response);
                    } else {
                        Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE,
                                "Fallo al Crear el Nuevo Producto");
                        goToURL(errorForm, request, response);
                    }
                    break;
                case "comment":
                    Comment comment = generateCommentFromRequest(request);
                    if (comment != null && persistenceManagerComment.newComment(comment)) {
                        session.setAttribute("comment", comment);
                        session.setAttribute("message", "Comentario añadido con éxito");
                        goToURL(successForm, request, response);
                    } else {
                        Logger.getLogger(CreateServlet.class.getName()).log(Level.SEVERE,
                                "Fallo al Crear el Nuevo Comentario");
                        goToURL(errorForm, request, response);
                    }
                    break;
                default:
                    goToURL(errorForm, request, response);
                    break;
            }
        }
    }

    User generateUserFromRequest(HttpServletRequest request) {
        User user;
        String userName = request.getParameter("userName");
        String userSurnames = request.getParameter("userSurnames");
        String userAdress = request.getParameter("userAdress");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        user = new User(userName, userSurnames, userAdress, userEmail, userPassword);
        boolean validate = validateUser(user);
        if (!validate) {
            return null;
        }
        return user;
    }

    Sale generateSaleFromRequest(HttpServletRequest request) {
        Sale sale = new Sale();
        return sale;
    }

    Product generateProductFromRequest(HttpServletRequest request) {
        Product product;
        String productID = "";
        String productPrice = request.getParameter("productPrice");
        String productShortDescription = request.getParameter("productShortDescription");
        String productLongDescription = request.getParameter("productLongDescription");
        String productStock = request.getParameter("productStock");
        String productImageURL = request.getParameter("productImageURL");
        product = new Product(productID, Double.parseDouble(productPrice), productShortDescription,
                productLongDescription, Integer.parseInt(productStock), productImageURL);
        product.setProductID(product.generateProductID());
        boolean validate = validateProduct(product);
        if (!validate) {
            return null;
        }
        return product;
    }

    Comment generateCommentFromRequest(HttpServletRequest request) {
        Comment comment;
        HttpSession session = request.getSession();
        String commentID = "";
        Date date = new Date();
        String commentDate = date.toString();
        String commentProductID = request.getParameter("commentProductID");
        User user = (User) session.getAttribute("user");
        String commentContent = request.getParameter("commentContent");
        comment = new Comment(commentID, commentDate, commentProductID, user.getUserEmail(), commentContent);
        comment.setCommentID(comment.generateCommentID());
        boolean validate = validateComment(comment);
        if (!validate) {
            return null;
        }
        return comment;
    }

    private boolean validateUser(User user) {
        ValidationMethods validation = new ValidationMethods(user);
        return validation.validateUser();
    }

    private boolean validateProduct(Product product) {
        ValidationMethods validation = new ValidationMethods(product);
        return validation.validateProduct();
    }

    private boolean validateComment(Comment comment) {
        ValidationMethods validation = new ValidationMethods(comment);
        return validation.validateComment();
    }
}
