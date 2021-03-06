<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div class="top_bar">
        <div class="top_search">
            <form action="/TiendaOnline/FrontController" method="post" class="searchProduct">
                <input name="form" type="hidden" value="readServlet"></input>
                <input name="parameter" type="hidden" value="productShortDescription"></input>
                <input name="lightsearch" type="hidden" value="true"></input>
                <div class="search_text">Buscar Producto:</div>
                <input name="condition" type="text" class="search_input"/>
                <button style='width:55px; height:28px; border-width:0px; background-color:transparent'>
                    <center><img src="/TiendaOnline/images/search.gif"/></center></button>
            </form>
        </div>

        <div class="languages">
            <div class="lang_text">Idiomas:</div>
            <a href="/TiendaOnline/WEB-INF/view/errors/error404.jsp" class="lang"><img src="/TiendaOnline/images/es.gif" alt="" title="" border="0" /></a>      
        </div>

    </div>
    <div id="header">

        <div id="logo">
            <a href="/TiendaOnline/index.jsp"><img src="/TiendaOnline/images/logo.png" alt="" title="" 
                                                   border="0" width="237" height="140" /></a>
        </div>

        <div class="oferte_content">
            <div class="top_divider"><img src="/TiendaOnline/images/header_divider.png" 
                                          alt="" title="" width="1" height="164" /></div>
            <div class="oferta">

                <div class="oferta_content">
                    <img src="/TiendaOnline/images/laptop.png" width="94" height="92" border="0" class="oferta_img" />

                    <div class="oferta_details">
                        <div class="oferta_title">Ordenador en Oferta</div>
                        <div class="oferta_text">
                            Esto parece que de momento funciona de forma decente xD
                        </div>
                        <a href="/TiendaOnline/WEB-INF/view/errors/error404.jsp" class="details">Detalles</a>
                    </div>
                </div>
                <div class="oferta_pagination">

                    <span class="current">1</span>
                    <a href="/TiendaOnline/WEB-INF/view/errors/error404.jsp">2</a>
                    <a href="/TiendaOnline/WEB-INF/view/errors/error404.jsp">3</a>
                    <a href="/TiendaOnline/WEB-INF/view/errors/error404.jsp">4</a>
                    <a href="/TiendaOnline/WEB-INF/view/errors/error404.jsp">5</a>  

                </div>        

            </div>
            <div class="top_divider"><img src="/TiendaOnline/images/header_divider.png" 
                                          alt="" title="" width="1" height="164" /></div>
        </div> <!-- end of oferte_content-->

    </div>
</html>
